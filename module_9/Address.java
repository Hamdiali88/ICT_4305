package parking;

import java.util.Objects;

public class Address {
    private String streetAddress1;
    private String streetAddress2;
    private String city;
    private String state;
    private String zipCode;

    public Address(String streetAddress1, String streetAddress2, String city, String state, String zipCode) {
        this.streetAddress1 = streetAddress1;
        this.streetAddress2 = streetAddress2;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }

    public String getStreetAddress1() { return streetAddress1; }
    public String getStreetAddress2() { return streetAddress2; }
    public String getCity() { return city; }
    public String getState() { return state; }
    public String getZipCode() { return zipCode; }

    public String getAddressInfo() {
        return streetAddress1 + (streetAddress2 != null && !streetAddress2.isEmpty() ? ", " + streetAddress2 : "")
                + ", " + city + ", " + state + " " + zipCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address)) return false;
        Address a = (Address) o;
        return Objects.equals(streetAddress1, a.streetAddress1)
            && Objects.equals(streetAddress2, a.streetAddress2)
            && Objects.equals(city, a.city)
            && Objects.equals(state, a.state)
            && Objects.equals(zipCode, a.zipCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(streetAddress1, streetAddress2, city, state, zipCode);
    }
}
