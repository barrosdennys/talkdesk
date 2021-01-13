package main.java.model;

public class Address {
    public String getStreet() {
        return street;
    }

    public String getSuite() {
        return suite;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public GeoLocation getGeoLocation() {
        return geoLocation;
    }

    @Override
    public String toString() {
        return "Address: " + '\n' +
                "Street = " + street + '\n' +
                "Suite = " + suite + '\n' +
                "City = " + city + '\n' +
                "Zipcode = " + zipcode + '\n' +
                "GeoLocation = " + geoLocation;
    }

    private String street;
    private String suite;
    private String city;
    private String zipcode;
    private GeoLocation geoLocation;
}
