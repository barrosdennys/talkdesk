package main.java.model;

public class GeoLocation {
    public String getLat() {
        return lat;
    }

    public String getLng() {
        return lng;
    }

    @Override
    public String toString() {
        return "GeoLocation: " + '\n' +
                "lat= " + lat + '\'' +
                "lng= " + lng + '\'';
    }

    private String lat;
    private String lng;
}
