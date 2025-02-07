package com.infrafrontier.programmingChallenge.student;

import com.infrafrontier.programmingChallenge.exceptions.EntityAlreadyExistsException;
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
        if(studentRepository.findByEmail(student.getEmail()).isPresent()){
            throw new EntityAlreadyExistsException("Student", student.getEmail());
        }
        return studentRepository.save(student);
    }
}
