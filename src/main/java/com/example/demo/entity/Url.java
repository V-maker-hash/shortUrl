package com.example.demo.entity;

import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@ToString
@Table(name = "url")
public class Url {

    // define fields

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "original")
    private String original;

//    @Column(name = "link")
//    private String link;

    // define constructors

    public Url() {

    }

    public Url(String original) {
        this.original = original;

    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOriginal() {
        return original;
    }

    public void setOriginal(String original) {
        this.original = original;
    }

//    public String getLink() {
//        return link;
//    }
//
//    public void setLink(String link) {
//        this.link = link;
//    }

    // define tostring

//    @Override
//    public String toString() {
//        return "Url{" +
//                "id=" + id +
//                ", original='" + original + '\'' +
//                ", link='" + link + '\'' +
//                '}';
//    }
}











