package com.learn.anglish.modals;

public class User {
    private String uId, name, profile, city;
    private long conins;

    public User(){

    }

    public User(String uId, String name, String profile, String city, long conins) {
        this.uId = uId;
        this.name = name;
        this.profile = profile;
        this.city = city;
        this.conins = conins;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public long getConins() {
        return conins;
    }

    public void setConins(long conins) {
        this.conins = conins;
    }
}
