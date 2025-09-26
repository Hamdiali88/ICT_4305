public class MyDateTest {
    public static void main(String[] args) {
        // Test default constructor
        MyDate epoch = new MyDate();
        System.out.println("Epoch date (should be 1/1/1970): " + epoch);

        // Test copy constructor
        MyDate copy = new MyDate(epoch);
        System.out.println("Copy of epoch: " + copy);

        // Test a valid date: Feb 29, 2024 (leap year)
        MyDate leap = new MyDate(29, 2, 2024);
        System.out.println("Leap date: " + leap);

        // Test non-leap year invalid date
        try {
            MyDate invalid = new MyDate(29, 2, 2023);
            System.out.println("Created invalid leap date: " + invalid);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught expected exception (non-leap): " + e.getMessage());
        }

        // Test invalid month
        try {
            MyDate badMonth = new MyDate(10, 15, 2025);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid month: " + e.getMessage());
        }

        // Test invalid day
        try {
            MyDate badDay = new MyDate(31, 4, 2025);  // April has 30 days
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid day: " + e.getMessage());
        }

        // Test invalid year
        try {
            MyDate badYear = new MyDate(1, 1, 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught invalid year: " + e.getMessage());
        }

        // Edge test: getLastDayOfMonth
        System.out.println("Last day of Feb 2024 should be 29: " + MyDate.getLastDayOfMonth(2, 2024));
        System.out.println("Last day of Feb 2023 should be 28: " + MyDate.getLastDayOfMonth(2, 2023));
    }
}
