package com.infrafrontier.programmingChallenge.assignment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Repository interface for Assignment entities implements create, read, update, delete operations
 */
@Repository
public interface AssignmentRepository extends JpaRepository<Assignment, Long> {

}
