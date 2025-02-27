package com.codes_tech.delivery_manager.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;


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

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // Constructors
    public DeliveryMan() {
        this.createdAt = LocalDateTime.now();
    }

    public DeliveryMan(String name, String document, String phone) {
        this.name = name;
        this.document = document;
        this.phone = phone;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
