package net.javaguides.ems_backend.controller;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.employeedto;
import net.javaguides.ems_backend.service.employeeservice;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@RequestMapping("/api/employees")
@AllArgsConstructor
public class employeecontroller {
    private employeeservice employeeservice;
    @PostMapping
    public ResponseEntity<employeedto> createemployee(@RequestBody employeedto employeedto){
        employeedto savedemployee=employeeservice.createemployee(employeedto);
        return  new ResponseEntity<>(savedemployee, HttpStatus.CREATED);
    }
    @GetMapping("{id}")
    public ResponseEntity<employeedto> getemployeebyid(@PathVariable("id") Long employeeid){
        employeedto employeedto=employeeservice.getemployeebyid(employeeid);
        return ResponseEntity.ok(employeedto);
    }
    @GetMapping
    public  ResponseEntity<List<employeedto>>getallemployee(){
        List<employeedto> employees= employeeservice.getallemployee();
        return  ResponseEntity.ok(employees);
    }
    @PutMapping("{id}")
public ResponseEntity<employeedto> updateemployee(@PathVariable("id") Long emploeeid,@RequestBody employeedto updatedemployee){
       employeedto employeedto= employeeservice.updateemployee(emploeeid,updatedemployee);
        return  ResponseEntity.ok(employeedto);

}
@DeleteMapping("{id}")
public  ResponseEntity<String> deleteemployee(@PathVariable("id") Long employeeid){
        employeeservice.deleteemployee(employeeid);
        return ResponseEntity.ok("done");
}
}
