package com.example.workindia;



public class Students {
    private Float cgpa;
    private String email;
    private String name;
    private String name1;
    public Students(Float cgpa, String email, String name, String name1) {
        this.cgpa= cgpa;
        this.email = email;
        this.name = name;
        this.name1 = name1;
    }
    public Float getCgpa() {
        return cgpa;
    }

    public void setCgpa(Float cgpa) {
        this.cgpa=cgpa;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName1() {
        return name1;
    }

    public void setName1(String name1) {
        this.name1 = name1;
    }

    public Students(Float cgpa,String name,String name1){
        this.cgpa=cgpa;
        this.name=name;
        this.name1=name1;
    }
    public Students(){
    }
    public String toString(){
        String x,y,z,s;
        s=x=this.name;
        y=this.cgpa.toString();
        z=this.name1;
        for(int i=x.length();i<40-x.length()-1;i++)
        {
            s = s + " ";

        }
        s = s+ y;
        for(int i=s.length();i<60-x.length()-1;i++)
        {
            s=s+" ";
        }
        s=s+z;
        return s;

    }
}
