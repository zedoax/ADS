package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class Station {
    private String id;
    private Address location;

    public Station(String id, Address location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public Address getLocation() {
        return location;
    }
}
