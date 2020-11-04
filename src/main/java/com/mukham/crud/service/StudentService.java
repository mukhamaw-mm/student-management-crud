package com.mukham.crud.service;

import com.mukham.crud.model.Student;
import com.mukham.crud.repository.StudentRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRep studentRep;

    public void insertStudentData(Student student) {
        studentRep.save(student);
    }

    public List<Student> selectAllStudentData() {
        List<Student> studentList = studentRep.findByDe();
        return studentList;
    }

    public List<Student> findByName(String name) {
        List<Student> student = studentRep.findByName(name);
        return student;
    }

    public String updateStudentName(Student student) {
        long id = student.getId();
        Optional<Student> optionalStu = studentRep.findById(id);
        if (!optionalStu.isPresent()) {
            return "Not found";
        } else {
            Student st1 = optionalStu.get();
            //set name into  above return data
            System.out.println("st1: " + st1);
            st1.setName(student.getName());

            // save data above data.
            studentRep.save(st1);
            return "Successfully Updated";
        }
    }

    public String deleteData(Long id) {
        Optional<Student> optionalStu = studentRep.findById(id);
        if (optionalStu.isPresent()) {
            Student st = optionalStu.get();
            st.setDe(true);
            studentRep.save(st);
            return "Successfully Deleted";
        }
        return "Not found";
    }
}
