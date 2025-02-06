package com.infrafrontier.programmingChallenge.assignment;

import com.infrafrontier.programmingChallenge.student.Student;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "assignment")
public class Assignment {
    @Id
    @GeneratedValue
    @Column
    private final UUID id;

    @Column(nullable = false)
    private String title;

    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "student_id", referencedColumnName = "id", nullable = false)
    private Student submittedBy;

    @Column(nullable = false, updatable = false)
    private final LocalDateTime submittedAt;

    public Assignment(String title, Student student){
        this.id = UUID.randomUUID();
        this.title = title;
        this.submittedBy = student;
        this.submittedAt = LocalDateTime.now();
    }

    public Assignment(String title, Student student, String description){
        this(title, student);
        this.description = description;
    }

    public UUID getId(){
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

    public Student getSubmittedBy() {
        return this.submittedBy;
    }

    public void setSubmittedBy(Student submittedBy) {
        this.submittedBy = submittedBy;
    }

    public LocalDateTime getSubmittedAt(){
        return this.submittedAt;
    }
}