package com.manooz.myjobs;

import com.google.firebase.database.Exclude;


// Created by MaNoOoz on 1/1/2018.
//

//https://github.com/AndroidCourseMaterial/MovieQuotes
public class Link_Object {

    private String lName;
    private String lTitle;
    private String key;
    public Link_Object() {

    }
    @Exclude
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Link_Object(String lname, String ltitle, String key ) {
        this.lTitle = ltitle;
        this.lName = lname;
        this.key   =  key;
    }



    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public String getlTitle() {
        return lTitle;
    }

    public void setlTitle(String lTitle) {
        this.lTitle = lTitle;
    }

    public void setValues(Link_Object updatedValue) {
        this.lTitle = updatedValue.lTitle;
        this.lName = updatedValue.lName;

    }
}
