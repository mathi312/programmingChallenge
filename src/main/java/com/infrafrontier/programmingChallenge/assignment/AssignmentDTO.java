package com.infrafrontier.programmingChallenge.assignment;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class AssignmentDTO {
    @NotBlank(message = "Title cannot be blank")
    @Size(min = 2, max = 30, message = "Title must be between 2 and 30 characters")
    private String title;

    private String description;

    private Long studentId;

    public AssignmentDTO(String title, @Nullable String description, @Nullable Long studentId) {
        this.title = title;
        if(description != null){
            this.description = description;
        }
        if(studentId != null){
            this.studentId = studentId;
        }
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getStudentId() {
        return this.studentId;
    }

    public void setStudentId(Long studentId) {
        this.studentId = studentId;
    }
}
