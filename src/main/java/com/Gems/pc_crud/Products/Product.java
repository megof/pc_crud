package com.Gems.pc_crud.Products;

import jakarta.persistence.*;

import java.time.LocalDateTime;
@Entity //con eso inico que es una entidad.
@Table //Ahora representará una tabla
public class Product {
    @Id //indico que es el id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //indico que se generaran valores con estrategia
    private long id;
    @Column(unique = true)
    private String name;
    private String description;
    private float price;
    private LocalDateTime updated;
    private LocalDateTime created;
    private Long user;
    private Boolean isActive;

    public Product() {
    }

    public Product(long id, String name, String description, float price, LocalDateTime updated, LocalDateTime created, Long user, Boolean isActive) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.updated = updated;
        this.created = created;
        this.user = user;
        this.isActive = isActive;
    }

    public Product(String name, String description, float price, LocalDateTime updated, LocalDateTime created, Long user, Boolean isActive) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.updated = updated;
        this.created = created;
        this.user = user;
        this.isActive = isActive;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public Long getUser() {
        return user;
    }

    public void setUser(Long user) {
        this.user = user;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }
}
