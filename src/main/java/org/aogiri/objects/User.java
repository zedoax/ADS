package org.aogiri.objects;

/**
 * Created by Zedoax on 4/11/2018.
 */
public class User {
    private String username;
    private String firstname;
    private String lastname;

    private String address;

    private String credit;
    private String profile_url;

    private String membership;

    public User(String username, String firstname, String lastname, String address, String credit, String profile_url, String membership) {
        this.username = username;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.credit = credit;
        this.profile_url = profile_url;
        this.membership = membership;
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

    public String getAddress() {
        return address;
    }

    public String getCredit() {
        return credit;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public String getMembership() {
        return membership;
    }
}
