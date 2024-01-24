package com.nhnacademy.edu.springboot.student.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class NhnStudentService implements StudentService{
    private final StudentRepository studentRepository;

    public NhnStudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        boolean present = studentRepository.findById(student.getId()).isPresent();
        if ( present ) {
            throw new IllegalStateException("already exist " + student.getId());
        }
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudent(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException("No Student of ID : " + id ));
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
