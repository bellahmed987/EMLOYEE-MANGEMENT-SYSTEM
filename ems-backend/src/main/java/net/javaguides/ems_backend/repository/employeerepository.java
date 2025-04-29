package net.javaguides.ems_backend.repository;

import net.javaguides.ems_backend.entitiy.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employeerepository extends JpaRepository<employee,Long> {
}
