package com.example.rmr_tt.models;

import jakarta.persistence.*;

import java.awt.*;
import java.net.URL;

@Entity
@Table(name = "advertisement")
public class Advertisement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private Integer price;
    private URL image;
    private Boolean isActive;
    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Integer getPrice() {
        return price;
    }

    public URL getImage() {
        return image;
    }

    public Boolean getActive() {
        return isActive;
    }

    public User getUser() {
        return user;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setImage(URL image) {
        this.image = image;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
