package com.example.clv_ds7;

public class Student {
    int id;
    String name;
    int sem;
    float cgpa;
    String gender;

    public Student() {
    }

    public Student(int id, String name, int sem, float cgpa, String gender) {
        this.id = id;
        this.name = name;
        this.sem = sem;
        this.cgpa = cgpa;
        this.gender = gender;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSem() {
        return sem;
    }

    public void setSem(int sem) {
        this.sem = sem;
    }

    public float getCgpa() {
        return cgpa;
    }

    public void setCgpa(float cgpa) {
        this.cgpa = cgpa;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
