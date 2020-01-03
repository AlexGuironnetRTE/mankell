package org.mankell.model.iss;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
//TODO Do we need @Builder?
public class ISSRequest {

    private double altitude;
    private long datetime;
    private double latitude;
    private double longitude;
    private int passes;

    //TODO Find a way to make Jackson serialization recognize Lombok generated getters
    //https://www.baeldung.com/jackson-jsonmappingexception


    public double getAltitude() {
        return altitude;
    }

    public long getDatetime() {
        return datetime;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public int getPasses() {
        return passes;
    }

    public void setAltitude(double altitude) {
        this.altitude = altitude;
    }

    public void setDatetime(long datetime) {
        this.datetime = datetime;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public void setPasses(int passes) {
        this.passes = passes;
    }
}
