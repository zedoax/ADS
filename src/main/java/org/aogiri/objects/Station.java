package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class Station {
    private String id;
    private String location;

    public Station(String id, String location) {
        this.id = id;
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public String getLocation() {

        return location;
    }
}
