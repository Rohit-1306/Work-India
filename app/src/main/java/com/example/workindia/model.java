package com.example.workindia;

public class model {
    String name1,name;
    Float cgpa;
    model()
    {

    }
    public model(String name1, String name, Float cgpa) {
        this.name1 = name1;
        this.name = name;
        this.cgpa = cgpa;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa = cgpa;
    }
}
