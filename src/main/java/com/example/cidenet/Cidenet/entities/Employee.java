package com.example.cidenet.Cidenet.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.DynamicUpdate;

@Entity
@DynamicUpdate
public class Employee {

    // TODO change generation type to UUID or HASH or smallHASH
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String firstName;
    @Column
    private String secondName;
    @Column
    private String lastName;
    @Column
    private String secondLastName;
    @Column
    private String country;
    @Column
    private String idType;
    @Column
    private String idNumber;
    @Column
    private String email;
    @Column
    private String admissionDate;
    @Column
    private String area;
    @Column
    private final Boolean active = true;
    @Column
    private String registryDate;

    // Constructor
    public Employee() {
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getIdType() {
        return idType;
    }

    public void setIdType(String idType) {
        this.idType = idType;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(String admissionDate) {
        this.admissionDate = admissionDate;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getRegistryDate() {
        return registryDate;
    }

    public void setRegistryDate(String registryDate) {
        this.registryDate = registryDate;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", firstName=" + firstName + ", secondName=" + secondName + ", lastName="
                + lastName + ", secondLastName=" + secondLastName + ", country=" + country + ", idType=" + idType
                + ", idNumber=" + idNumber + ", email=" + email + ", admissionDate=" + admissionDate + ", area=" + area
                + ", active=" + active + ", registryDate=" + registryDate + "]";
    }
}
