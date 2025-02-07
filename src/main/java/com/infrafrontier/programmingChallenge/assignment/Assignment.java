package com.infrafrontier.programmingChallenge.assignment;

import com.infrafrontier.programmingChallenge.student.Student;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "submitted_by", referencedColumnName = "id")
    private Student student;

    @Column(nullable = false, updatable = false)
    private LocalDateTime submittedAt;

    public Assignment(){}

    public Assignment(String title, @Nullable Student student, @Nullable String description){
        this.title = title;
        if(description != null){
            this.description = description;
        }
        if(student != null){
            this.student = student;
        }
        this.submittedAt = LocalDateTime.now();
    }

    public Long getId(){
        return this.id;
    }

    public String getTitle(){
        return this.title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public Student getStudent() {
        return this.student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public LocalDateTime getSubmittedAt(){
        return this.submittedAt;
    }
}