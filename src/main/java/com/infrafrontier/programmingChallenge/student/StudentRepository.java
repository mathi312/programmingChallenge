package com.infrafrontier.programmingChallenge.student;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for Student entities implements create, read, update, delete operations
 */
@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
