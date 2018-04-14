package org.aogiri.objects;

public class PackageWeight {

    private String weightclass;
    private String costmodifier;

    public PackageWeight(String weightclass, String costmodifier){
        this.weightclass = weightclass;
        this.costmodifier = costmodifier;
    }

    public String getWeightclass() {
        return weightclass;
    }

    public String getCostmodifier(){
        return costmodifier;
    }
}
