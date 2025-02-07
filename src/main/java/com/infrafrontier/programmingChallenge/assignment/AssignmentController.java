package com.infrafrontier.programmingChallenge.assignment;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    @Autowired
    public AssignmentController(AssignmentService assignmentService){
        this.assignmentService = assignmentService;
    }

    @PostMapping("/assignments")
    public ResponseEntity<Assignment> saveAssignment(@Valid @RequestBody AssignmentDTO assignmentDTO){
        Assignment newAssignment = assignmentService.saveAssignment(assignmentDTO);
        return ResponseEntity.ok(newAssignment);
    }

    @GetMapping(value = "/assignments", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Assignment> getAssignments(){
        return this.assignmentService.findAll();
    }
}

