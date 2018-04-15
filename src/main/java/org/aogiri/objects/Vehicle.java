package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class Vehicle {
    private String id;
    private String type;

    private String origin;
    private String location;
    private String destination;

    public String getId() {
        return id;
    }

    public Vehicle(String id, String type, String origin, String location, String destination) {
        this.id = id;
        this.type = type;
        this.origin = origin;
        this.location = location;
        this.destination = destination;
    }

    public String getType() {
        return type;
    }

    public String getOrigin() {
        return origin;
    }

    public String getLocation() {
        return location;
    }

    public String getDestination() {
        return destination;
    }



}
