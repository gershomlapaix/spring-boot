package com.startup.employeesmis.controller;

import com.startup.employeesmis.models.Employee;
import com.startup.employeesmis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping({"/showEmployees", "/", "/list"})
    public ModelAndView showEmployees(){
        ModelAndView mav = new ModelAndView("list-employees");
        List<Employee> list = employeeRepository.findAll();
        mav.addObject("employees", list);
        return mav;
    }
}
