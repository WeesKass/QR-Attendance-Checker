package com.raspberrypi.backend.controller;

import com.raspberrypi.backend.entity.AttendanceEntity;
import com.raspberrypi.backend.repository.AttendanceRepository;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/attendance")
public class AttendanceController {

    @Autowired
    private AttendanceRepository attendanceRepository;

    @GetMapping("/all")
    @ApiOperation(value = "getListOfAttendance")
    public List<AttendanceEntity> getAllAttendance(){
        return attendanceRepository.findAll();
    }

    @GetMapping("/idCard/{idCard}")
    @ApiOperation(value = "getListOfAttendanceByIdCard")
    public List<AttendanceEntity> getAllAttendance(@PathVariable("idCard") String idCard){
        return attendanceRepository.findAllByIdCard(idCard);
    }

    @PostMapping
    @ApiOperation(value = "createNewAttendance")
    public AttendanceEntity createAttendance(@RequestBody AttendanceEntity attendance){
        return attendanceRepository.save(attendance);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "deleteAttendanceById")
    public void deleteAttendanceById(@PathVariable("id") Integer id){
        attendanceRepository.deleteById(id);
    }

}
