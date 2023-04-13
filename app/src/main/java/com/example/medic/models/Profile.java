package com.example.medic.models;
//Конструктор для работы с запросом
//13.04.2023
//Peristov Dmitrii
public class Profile {
    String firstname;
    String lastname;
    String middlename;
    String bith;
    String pol;
    String image;

    public Profile(String firstname, String lastname, String middlename, String bith, String pol, String image) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.middlename = middlename;
        this.bith = bith;
        this.pol = pol;
        this.image = image;
    }
}
