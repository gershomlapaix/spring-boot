package com.startup.employeesmis.controller;

import com.startup.employeesmis.models.Employee;
import com.startup.employeesmis.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/addEmployeeForm")
    public ModelAndView addEmployeeForm(){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee newEmployee = new Employee();
        mav.addObject("employee", newEmployee);
        return mav;
    }

    @PostMapping("/saveEmployee")
    public String saveEmployee(@ModelAttribute Employee employee){
        employeeRepository.save(employee); // if there is "id" it will perform update
        return "redirect:/list";
    }

    @GetMapping("/showUpdateForm")
    public ModelAndView showUpdateForm(@RequestParam Long employeeId){
        ModelAndView mav = new ModelAndView("add-employee-form");
        Employee foundEmployee = employeeRepository.findById(employeeId).get();
        mav.addObject("employee", foundEmployee);

        return mav;
    }

    @GetMapping("/deleteEmployee")
    public String deleteEmployee(@RequestParam Long employeeId){
        employeeRepository.deleteById(employeeId);
        return "redirect:/";
    }
}
