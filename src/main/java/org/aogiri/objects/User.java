package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class User {
    private String username;
    private String password;
    private String firstname;
    private String lastname;

    private Address address;

    private CreditCard credit;
    private String profile_url;

    private String membership;

    private String totalPayments;
    private String totalPackages;

    public User(String username, String password, String firstname, String lastname, Address address, CreditCard credit, String profile_url, String membership) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.credit = credit;
        this.profile_url = profile_url;
        this.membership = membership;
    }

    public User(String username, String membership, String totalPayments){
        this.username = username;
        this.membership = membership;
        this.totalPayments = totalPayments;
    }

    public User(String username, String totalPackages){
        this.username = username;
        this.totalPackages = totalPackages;
    }

    public String getUsername() {
        return username;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public Address getAddress() {
        return address;
    }

    public CreditCard getCredit() {
        return credit;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getMembership() {
        return membership;
    }
}
