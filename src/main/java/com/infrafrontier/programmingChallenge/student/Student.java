package com.infrafrontier.programmingChallenge.student;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "student")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotBlank(message = "Name cannot be blank")
    @Size(min = 4, max = 30, message = "Name must be between 4 and 30 characters")
    @Column(nullable = false)
    private String name;

    @NotBlank(message = "Email cannot be blank")
    @Email(message = "Invalid email format")
    @Column(nullable = false, unique = true)
    private String email;

    public Student(){}

    public Student(String name, String email){
        this.name = name;
        this.email = email;
    }

    public Long getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getEmail(){
        return this.email;
    }

    public void setEmail(String email){
        this.email = email;
    }
}
