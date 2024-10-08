package org.example.springboot_jsp.controller;

import org.example.springboot_jsp.model.Employee;
import org.example.springboot_jsp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String HomePage(){
        return "HomePage";
    }

//    Show the EmployeeForm
    @GetMapping("/employeeForm")
    public String showEmployeeForm(){
        return "employee-form";
    }

//    Insert the Employee Details in MongoDB & Elasticsearch
    @PostMapping("/save")
    public String saveEmployeeData(@ModelAttribute Employee employee, RedirectAttributes redirectAttributes){
        employeeService.saveEmployee(employee);
        redirectAttributes.addFlashAttribute("message", "Data Inserted Successfully!!");
        return "redirect:/employeeForm";
    }

//    Getting the Employee Details using id
    @GetMapping("findById/{id}")
    public ResponseEntity<?> findEmployeeById(@PathVariable int id){
        Optional<Employee> op=employeeService.findEmployeeById(id);
        if(op.isPresent()){
            return ResponseEntity.ok(op.get());
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Data Not Found");
    }

//    Getting All the Employees Details
    @GetMapping("/employeesList")
    public String findAllEmployees(Model model){
        List<Employee> employeesMongo =employeeService.findAllEmployees();
        model.addAttribute("employeesMongo",employeesMongo);
        return "employee-list";
    }

//   Show Update Form
    @GetMapping("/update/{id}")
    public String showUpdateForm(@PathVariable int id, Model model) {
        Employee employee = employeeService.findEmployeeById(id).orElse(null);
        if (employee == null) {
            return "redirect:/employeesList";
        }
        model.addAttribute("employee", employee);
        return "employee-update-form";
    }

//    Update the Employee Details
    @PostMapping("/updateEmployee")
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.updateEmployee(employee.getId(),employee.getName(),employee.getDepartment());
        model.addAttribute("message", "Updated Successfully!!");
        model.addAttribute("employee", employee);
        return "employee-update-form";
    }

//    Delete the Employee Details using ID
    @RequestMapping("/delete/{id}")
    public String deleteEmployeeDataById(@PathVariable int id,Model model){
        String result=employeeService.deleteEmployeeById(id);
        model.addAttribute("message",result);
        return "delete-employee";
    }

//    Delete All the Employee Details
    @GetMapping("/deleteAll")
    public ModelAndView deleteAllEmployees(){
        String message = employeeService.deleteAllEmployeesData();
        ModelAndView modelAndView = new ModelAndView("deleteSuccess");
        modelAndView.addObject("message", message);
        return modelAndView;
    }
}