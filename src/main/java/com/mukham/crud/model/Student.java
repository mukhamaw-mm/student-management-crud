package com.mukham.crud.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
@Entity
@Data
@ToString
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ID")
    Long id;
    @Column(name="NAME")
    String name;
    @Column(name="ADDRESS")
    String address;
    @Column(name="IS_DELETED")
    boolean de;
}
