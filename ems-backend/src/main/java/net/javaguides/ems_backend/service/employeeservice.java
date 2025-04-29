package net.javaguides.ems_backend.service;

import net.javaguides.ems_backend.dto.employeedto;

import java.util.List;

public interface employeeservice {
    employeedto createemployee(employeedto employeedto);
    employeedto getemployeebyid(Long emloyeeid);
    List<employeedto> getallemployee();
    employeedto updateemployee(Long employeeid,employeedto updatedemployee);
    void deleteemployee(Long employeeid);
}
