package org.aogiri.objects;

/**
 * Created by Zedoax on 4/12/2018.
 */
public class TrackingEntry {
    private String id;
    private String date;
    private String vehicle_type;
    private String location;

    public TrackingEntry(String id, String date, String vehicle_type, String location) {
        this.id = id;
        this.date = date;
        this.vehicle_type = vehicle_type;
        this.location = location;
    }

    public TrackingEntry(String date, String vehicle_type, String location) {
        this.date = date;
        this.vehicle_type = vehicle_type;
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public String getVehicle_type() {
        return vehicle_type;
    }

    public String getLocation() {
        return location;
    }

    public String getId() {
        return id;
    }
}
