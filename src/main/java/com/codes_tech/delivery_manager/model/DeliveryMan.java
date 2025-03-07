package com.codes_tech.delivery_manager.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "delivery_man")
public class DeliveryMan{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 200)
    private String name;

    @Column(nullable = false, length = 14)
    private String document;

    @Column(nullable = false, unique = true, length = 11)
    private String phone;

    @Column(nullable = false, length = 300)
    private String address;

    @Column(name = "address_city", nullable = false, length = 300)
    private String addressCity;

    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public DeliveryMan() {
        this.createdAt = LocalDateTime.now();
    }

    public DeliveryMan(
        String name,
        String document,
        String phone,
        String address,
        String addressCity,
        LocalDate birthday
    ) {
        this.name = name;
        this.document = document;
        this.phone = phone;
        this.address = address;
        this.addressCity = addressCity;
        this.birthday = birthday;
        this.createdAt = LocalDateTime.now();
    }

     // Getters e Setters
     public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
