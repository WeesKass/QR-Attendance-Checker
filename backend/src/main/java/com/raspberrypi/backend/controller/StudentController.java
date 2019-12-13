package com.raspberrypi.backend.controller;

import com.raspberrypi.backend.entity.StudentEntity;
import com.raspberrypi.backend.repository.StudentRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/student")
@CrossOrigin
public class StudentController {

    @Autowired
    private StudentRepository studentRepository;

    @GetMapping("/all")
    @ApiOperation(value = "getAllStudent")
    public List<StudentEntity> getAllStudent() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "getStudentById")
    public Optional<StudentEntity> getStudentById(@PathVariable("id") Integer id) {
        return studentRepository.findById(id);
    }

    @GetMapping("/idCard/{idCard}")
    @ApiOperation(value = "getStudentByStudentId")
    public StudentEntity getStudentByIdCard(@PathVariable("idCard") String idCard) {
        return studentRepository.findByIdCard(idCard);
    }

    @PostMapping
    @ApiOperation(value = "createNewStudent")
    public StudentEntity createStudent(@RequestBody StudentEntity student){
        return studentRepository.save(student);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteStudentById")
    public void deleteStudentById(@PathVariable("id") Integer id){
        studentRepository.deleteById(id);
    }

}
