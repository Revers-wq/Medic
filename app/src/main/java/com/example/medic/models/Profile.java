package com.example.medic.models;

public class Profile {
    String firstname;
    String lastname;
    String middlename;
    String bith;

    public Profile(String firstname, String lastname, String middlename, String bith, String pol, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.bith = bith;
        this.pol = pol;
        this.image = image;
    }

    String pol;
    String image;
}
