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
}
