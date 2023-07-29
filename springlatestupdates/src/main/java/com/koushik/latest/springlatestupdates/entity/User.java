package com.koushik.latest.springlatestupdates.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "userdetails")
public class User {
    @Id
    private int id;
    private String name;
}
