package org.aogiri.objects;

public class PackageType {

    private String packagetype;
    private String costmodifier;

    public PackageType(String packagetype, String costmodifier){
        this.packagetype = packagetype;
        this.costmodifier = costmodifier;
    }

    public String getPackagetype() {
        return packagetype;
    }

    public String getCostmodifier() {
        return costmodifier;
    }
}
