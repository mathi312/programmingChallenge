package com.infrafrontier.programmingChallenge.assignment;

import com.infrafrontier.programmingChallenge.exceptions.NoSuchElementFoundException;
import com.infrafrontier.programmingChallenge.student.Student;
import com.infrafrontier.programmingChallenge.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Service class for managing the Assignment entities
 */
@Service
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;

    private final StudentRepository studentRepository;

    @Autowired
    public AssignmentService(AssignmentRepository assignmentRepository, StudentRepository studentRepository) {
        this.assignmentRepository = assignmentRepository;
        this.studentRepository = studentRepository;
    }

    /**
     * Save an Assignment to the database
     * @param assignmentDTO to save
     * @return persisted entity
     */
    public Assignment saveAssignment(AssignmentDTO assignmentDTO){
        if(assignmentDTO.getStudentId() == null){
            Assignment newAssignment = new Assignment(assignmentDTO.getTitle(), null, assignmentDTO.getDescription());
            return assignmentRepository.save(newAssignment);
        }

        Student student = studentRepository.findById(assignmentDTO.getStudentId())
                .orElseThrow(() -> new NoSuchElementFoundException("Student", assignmentDTO.getStudentId().toString()));

        Assignment newAssignment = new Assignment(assignmentDTO.getTitle(), student, assignmentDTO.getDescription());

        return assignmentRepository.save(newAssignment);
    }

    public List<Assignment> findAll(){
        return this.assignmentRepository.findAll();
    }
}