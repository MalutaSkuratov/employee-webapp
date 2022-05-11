package com.employee.controllers;

import com.employee.entity.Employee;
import com.employee.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class EmployeeController {
    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public String employees(Model model) {
        model.addAttribute("employees", employeeService.getAll());
        return "employee";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("employee", new Employee());
        return "employee-create";
    }

    @GetMapping("/update")
    public String update(@RequestParam("employeeId") int employeeId, Model model) {
        model.addAttribute("employee", employeeService.getById(employeeId));
        return "employee-create";
    }

    @PostMapping("/create-or-update")
    public String createOrUpdate(@Valid @ModelAttribute("employee") Employee employee, BindingResult result) {
        if (result.hasErrors()) return "employee-create";
        employeeService.createOrUpdate(employee);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("employeeId") int employeeId) {
        employeeService.delete(employeeId);
        return "redirect:/";
    }
}
