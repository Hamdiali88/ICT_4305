public class MyDate {
    private int julianNumber;

    /** Default constructor: January 1, 1970 (epoch). */
    public MyDate() {
        this.julianNumber = toJulianNumber(1, 1, 1970);
    }

    /** Copy constructor. Throws IllegalArgumentException if null passed. */
    public MyDate(MyDate date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.julianNumber = date.julianNumber;
    }

    /** Constructs a date with day, month, year, validating input. */
    public MyDate(int day, int month, int year) {
        validateDate(day, month, year);
        this.julianNumber = toJulianNumber(day, month, year);
    }

    /** Returns the day of month for this date. */
    public int getDay() {
        return fromJulianNumber()[0];
    }

    /** Returns the month for this date. */
    public int getMonth() {
        return fromJulianNumber()[1];
    }

    /** Returns the year for this date. */
    public int getYear() {
        return fromJulianNumber()[2];
    }

    /** Returns whether a given year is a leap year. */
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
    }

    /** Returns last valid day for a given month/year, or throws if month invalid. */
    public static int getLastDayOfMonth(int month, int year) {
        switch (month) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                return 31;
            case 4: case 6: case 9: case 11:
                return 30;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            default:
                throw new IllegalArgumentException("Invalid month: " + month + ". Must be 1–12.");
        }
    }

    /** Converts a Gregorian (day, month, year) to a Julian Day Number. */
    private static int toJulianNumber(int day, int month, int year) {
        int a = (14 - month) / 12;
        int y = year + 4800 - a;
        int m = month + 12 * a - 3;
        int jdn = day + (153 * m + 2) / 5
                  + 365 * y
                  + y / 4
                  - y / 100
                  + y / 400
                  - 32045;
        return jdn;
    }

    /** Converts this object's julianNumber to [day, month, year]. */
    private int[] fromJulianNumber() {
        int j = this.julianNumber;
        int a = j + 32044;
        int b = (4 * a + 3) / 146097;
        int c = a - (146097 * b) / 4;
        int d = (4 * c + 3) / 1461;
        int e = c - (1461 * d) / 4;
        int m = (5 * e + 2) / 153;

        int day = e - (153 * m + 2) / 5 + 1;
        int month = m + 3 - 12 * (m / 10);
        int year = 100 * b + d - 4800 + (m / 10);

        return new int[]{ day, month, year };
    }

    /** Validates day, month, and year */
    private static void validateDate(int day, int month, int year) {
        if (year < 1 || year > 9999) {
            throw new IllegalArgumentException("Year out of range: " + year);
        }
        if (month < 1 || month > 12) {
            throw new IllegalArgumentException("Month out of range: " + month);
        }
        int lastDay = getLastDayOfMonth(month, year);
        if (day < 1 || day > lastDay) {
            throw new IllegalArgumentException("Day out of range: " + day
                    + " for month " + month + " in year " + year);
        }
    }

    /**option for debugging*/
    @Override
    public String toString() {
        return getDay() + "/" + getMonth() + "/" + getYear();
    }
}

