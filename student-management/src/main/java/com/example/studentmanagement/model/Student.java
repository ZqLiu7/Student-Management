package com.example.studentmanagement.model;

import javax.persistence.*;


@Entity
@Table(name = "student")

public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, name = "name")
    private String name;

    public UniversityClass getUniversityClass() {
        return universityClass;
    }

    public void setUniversityClass(UniversityClass universityClass) {
        this.universityClass = universityClass;
    }

    @ManyToOne
    @JoinColumn(name="university_class_id")
    private UniversityClass universityClass;

    public Student(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Student(){}

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override

    public String toString(){
        String strr = "";
        strr += "Primary Id: "+ getId();
        strr += " Name: " + getName();
        return strr;
    }
}
