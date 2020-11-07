package com.dev.iccaka.mylibrary.entities;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JoinColumn(name = "users_id")
    @ManyToOne(fetch = FetchType.LAZY)
    private User userid;

    @Column(name = "name")
    private String name;

    @Column(name = "isbn")
    private String isbn;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description")
    private String description;

    public Book(Long id, User userid, String name, String isbn, Integer year, String description) {
        this.id = id;
        this.userid = userid;
        this.name = name;
        this.isbn = isbn;
        this.year = year;
        this.description = description;
    }
}
