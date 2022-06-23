package com.startup.employeesmis.repository;

import com.startup.employeesmis.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
