package parking;

import java.util.Objects;

/**
 * Immutable postal address for the Parking System.
 */
public final class Address {

    private final String streetAddress1;
    private final String streetAddress2; // optional
    private final String city;
    private final String state;
    private final String zipCode;

    public Address(String streetAddress1,
                   String streetAddress2,
                   String city,
                   String state,
                   String zipCode) {
        this.streetAddress1 = nonNullTrim(streetAddress1);
        this.streetAddress2 = streetAddress2 == null ? "" : streetAddress2.trim();
        this.city = nonNullTrim(city);
        this.state = nonNullTrim(state);
        this.zipCode = nonNullTrim(zipCode);
    }

    // ---- Getters expected by tests ----
    public String getStreetAddress1() { return streetAddress1; }
    public String getStreetAddress2() { return streetAddress2; }
    public String getCity()           { return city; }
    public String getState()          { return state; }
    public String getZipCode()        { return zipCode; }

    // ---- Formatting helpers ----
    /**
     * Canonical single-line representation:
     * "street1[, street2] city, ST ZIP"
     */
    public String formatOneLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(streetAddress1);
        if (!streetAddress2.isEmpty()) {
            sb.append(' ').append(streetAddress2);
        }
        sb.append(' ')
          .append(city)
          .append(", ")
          .append(state)
          .append(' ')
          .append(zipCode);
        return sb.toString();
    }

    /** Human-friendly multi-line formatting (optional utility). */
    public String formatMultiLine() {
        StringBuilder sb = new StringBuilder();
        sb.append(streetAddress1);
        if (!streetAddress2.isEmpty()) {
            sb.append(System.lineSeparator()).append(streetAddress2);
        }
        sb.append(System.lineSeparator())
          .append(city).append(", ").append(state).append(' ').append(zipCode);
        return sb.toString();
    }

    // ---- Legacy shim expected by AddressTest ----
    public String getAddressInfo() {
        // Reuse the canonical one-line formatter to keep output consistent
        return formatOneLine();
    }

    // ---- Object contract ----
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address address = (Address) o;
        return streetAddress1.equals(address.streetAddress1)
            && streetAddress2.equals(address.streetAddress2)
            && city.equals(address.city)
            && state.equals(address.state)
            && zipCode.equals(address.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress1, streetAddress2, city, state, zipCode);
    }

    @Override
    public String toString() {
        return formatOneLine();
    }

    // ---- Private helpers ----
    private static String nonNullTrim(String s) {
        if (s == null) throw new IllegalArgumentException("Address fields cannot be null");
        return s.trim();
    }
}
