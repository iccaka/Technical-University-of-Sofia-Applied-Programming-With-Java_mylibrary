package com.dev.iccaka.mylibrary.entities;

import javax.persistence.*;

public class Books {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "userid")
    @ManyToOne
    private Long userid;
}
