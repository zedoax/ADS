package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class Package {
    private String id;
    private String owner;

    private String truck;

    private String destination; //City Street Number
    private String location;
    private String origin;

    private String eta;
    private String status;

    private boolean hazardous;
    private boolean international;

    private String weight;
    private String pkgtype;
    private float price;

    private String trackingid;
    private String vehicleid;

    public Package(String id, String owner, String truck, String destination, String trackingid, String location, String eta, String status, boolean hazardous, boolean international, String weight, String pkgtype, float price) {
        this.id = id;
        this.owner = owner;
        this.truck = truck;
        this.destination = destination;
        this.trackingid = trackingid;
        this.location = location;
        this.eta = eta;
        this.status = status;
        this.hazardous = hazardous;
        this.international = international;
        this.weight = weight;
        this.pkgtype = pkgtype;
        this.price = price;
    }

    public Package(String id, String weight, String pkgtype, Boolean hazardous, String owner, String trackingid, Boolean international, float price, String vehicleid){
        this.id = id;
        this.weight = weight;
        this.pkgtype = pkgtype;
        this.hazardous = hazardous;
        this.owner = owner;
        this.trackingid = trackingid;
        this.international = international;
        this.price = price;
        this.vehicleid = vehicleid;
    }

    public Package(String id, String owner, String truck, String destination, String trackingid, String origin, String eta, String status) {
        this.id = id;
        this.owner = owner;
        this.truck = truck;
        this.destination = destination;
        this.trackingid = trackingid;
        this.origin = origin;
        this.eta = eta;
        this.status = status;
    }

    public Package(String id, float price) {
        this.id = id;
        this.price = price;
    }

    public Package(String id, String eta) {
        this.id = id;
        this.eta = eta;
    }

    public String getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    public String getTruck() {
        return truck;
    }

    public String getDestination() {
        return destination;
    }

    public String getLocation() {
        return location;
    }

    public String getOrigin() {
        return origin;
    }

    public String getEta() {
        return eta;
    }

    public String getStatus() {
        return status;
    }

    public boolean isHazardous() {
        return hazardous;
    }

    public String getWeight() {
        return weight;
    }

    public String getPkgtype() {
        return pkgtype;
    }

    public float getPrice() {
        return price;
    }

    public boolean isInternational() {
        return international;
    }

    public String getTrackingid(){
        return trackingid;
    }

    public String getVehicleId(){
        return vehicleid;
    }
}
