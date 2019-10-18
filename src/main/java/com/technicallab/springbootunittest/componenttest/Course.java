package com.technicallab.springbootunittest.componenttest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "COURSE")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Course {
    @Id
    @Column
    private String code;

    @Column
    private String name;
}
