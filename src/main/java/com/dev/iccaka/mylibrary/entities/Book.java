package com.dev.iccaka.mylibrary.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

//    @JoinColumn(name = "users_id")
//    @ManyToOne(fetch = FetchType.LAZY)
//    private User userid;

    @Column(name = "name")
    private String name;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    public Book(){

    }

    public Book(Long id, User userid, String name, String isbn, Integer year, String description) {
        this.id = id;
//        this.userid = userid;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public User getUserid() {
//        return this.userid;
//    }
//
//    public void setUserid(User userid) {
//        this.userid = userid;
//    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIsbn() {
        return this.isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getYear() {
        return this.year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
