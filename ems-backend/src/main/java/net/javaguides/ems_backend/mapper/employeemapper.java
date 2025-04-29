package net.javaguides.ems_backend.mapper;


import net.javaguides.ems_backend.dto.employeedto;
import net.javaguides.ems_backend.entitiy.employee;

public class employeemapper {

    public static employeedto maptoemployeedto(employee employee){
        return new employeedto(
                employee.getId(),
                employee.getFirstname(),
                employee.getLastname(),
                employee.getEmail()

        );

        }
    public static  employee maptodemployeedto(employeedto employeedto){
        return  new employee(
                employeedto.getId(),
                employeedto.getFirstname(),
                employeedto.getLastname(),
                employeedto.getEmail()
        );
    }
}
