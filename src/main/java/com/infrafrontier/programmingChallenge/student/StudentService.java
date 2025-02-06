package com.infrafrontier.programmingChallenge.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing the Student entities
 */
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    /**
     * Save a student to the database
     * @param student to save
     * @return persisted entity
     */
    public Student saveStudent(Student student){
        return studentRepository.save(student);
    }
}
