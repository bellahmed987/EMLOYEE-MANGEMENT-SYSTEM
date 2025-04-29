package net.javaguides.ems_backend.service.impl;

import lombok.AllArgsConstructor;
import net.javaguides.ems_backend.dto.employeedto;
import net.javaguides.ems_backend.entitiy.employee;
import net.javaguides.ems_backend.exception.reosurcenotfound;
import net.javaguides.ems_backend.mapper.employeemapper;
import net.javaguides.ems_backend.repository.employeerepository;
import net.javaguides.ems_backend.service.employeeservice;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class employeeserviceimpl implements employeeservice {
    private employeerepository employeerepository;
    @Override
    public employeedto createemployee(employeedto employeedto) {
        employee employee= employeemapper.maptodemployeedto(employeedto);
        employee savedemployee=employeerepository.save(employee);
        return employeemapper.maptoemployeedto(savedemployee);

    }

    @Override
    public employeedto getemployeebyid(Long employeeid) {

employee employee=employeerepository.findById(employeeid)
        .orElseThrow(()-> new reosurcenotfound("this user is not found" + employeeid));
    return employeemapper.maptoemployeedto(employee);
    }

    @Override
    public List<employeedto> getallemployee() {
     List<employee> employees= employeerepository.findAll();
     return  employees.stream().map((employee)->employeemapper.maptoemployeedto(employee) ).collect(Collectors.toList());}

    @Override
    public employeedto updateemployee(Long employeeid, employeedto updatedemployee) {
       employee employee= employeerepository.findById(employeeid).orElseThrow(()->new reosurcenotfound("not found" + employeeid));
        employee.setFirstname(updatedemployee.getFirstname());
        employee.setLastname(updatedemployee.getLastname());
        employee.setEmail(updatedemployee.getEmail());
       employee updatedemployeeobj= employeerepository.save(employee);
                return employeemapper.maptoemployeedto(updatedemployeeobj);

    }

    @Override
    public void deleteemployee(Long employeeid) {
        employee employee=employeerepository.findById(employeeid).orElseThrow(()->new reosurcenotfound("not dound"));
        employeerepository.deleteById(employeeid);
    }


}
