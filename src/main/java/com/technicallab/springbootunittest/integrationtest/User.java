package com.technicallab.springbootunittest.integrationtest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
@AllArgsConstructor
public class User {

    @Id
    private Integer id;

    @NonNull
    private String name;

}
