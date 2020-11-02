package com.github.brandontm.veterinarity.veterinarity.entity;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

public class Pet {
    private int id;
    private String name;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthdate;
    private String sex;
    private String breed;

    public Pet() {
    }

    public Pet(int id, String name, LocalDate birthdate, String sex, String breed) {
        this.id = id;
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.breed = breed;
    }

    public Pet(String name, LocalDate birthdate, String sex, String breed) {
        this.name = name;
        this.birthdate = birthdate;
        this.sex = sex;
        this.breed = breed;
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

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
