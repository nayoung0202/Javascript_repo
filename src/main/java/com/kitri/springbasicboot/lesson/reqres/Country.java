package com.kitri.springbasicboot.lesson.reqres;

public class Country {
    String name;
    String capital;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getCapital() {
        return capital;
    }

    public Country(String name, String capital) {
        this.name = name;
        this.capital = capital;
    }
}
