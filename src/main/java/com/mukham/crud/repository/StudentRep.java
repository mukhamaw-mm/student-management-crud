package com.mukham.crud.repository;

import com.mukham.crud.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRep extends JpaRepository<Student, Long> {
    List<Student> findByName(String name);

    @Query(nativeQuery = true, value = "select * from student where is_deleted=false")
    List<Student> findByDe();


}
