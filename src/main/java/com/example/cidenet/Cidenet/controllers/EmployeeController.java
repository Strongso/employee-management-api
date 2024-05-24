package com.example.cidenet.Cidenet.controllers;

import com.example.cidenet.Cidenet.entities.Employee;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.services.EmployeeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping({ "/", "" })
    public List<Employee> getEmployees() {
        // TEST REMEMBER TO DELETE
        List<Employee> employees = employeeService.getEmployees();
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
        return null;
        // TEST REMEMBER TO DELETE
    }

    @GetMapping({ "/{id}" })
    public String getEmployee(@PathVariable Long id) {
        Employee employee;
        try {
            employee = employeeService.getEmployeeById(id);
            return employee.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (e.getMessage() + " Está borracho mi fax");
        }

    }

    @PostMapping({ "/", "" })
    public String createEmployee(@RequestBody String body) {

        try {
            JSONObject object = new JSONObject(body);
            String lastName = object.getString("lastName").toUpperCase();
            String secondLastName = object.getString("secondLastName").toUpperCase();
            String firstName = object.getString("firstName").toUpperCase();
            String secondName = object.getString("secondName").toUpperCase();
            String country = object.getString("country");
            String idType = object.getString("idType");
            String idNumber = object.getString("idNumber");
            String area = object.getString("area");
            String admissionDate = object.getString("admissionDate");

            Employee employee = employeeService.createEmployee(lastName, secondLastName, firstName, secondName, country,
                    idType, idNumber, area, admissionDate);
            JSONObject employeeString = new JSONObject(employee);
            System.out.println(employeeString.toString());

            return employeeString.toString();

        } catch (Exception e) {
            System.out.println(e.getMessage());
            return (e.getMessage() + " Está borracho mi fax");
        }
    }

    @PutMapping({ "/{id}" })
    public String updateEmployee(@RequestBody String body, @PathVariable Long id) throws MyException {
        JSONObject object = new JSONObject(body);
        String lastName = object.getString("lastName").toUpperCase();
        String secondLastName = object.getString("secondLastName").toUpperCase();
        String firstName = object.getString("firstName").toUpperCase();
        String secondName = object.getString("secondName").toUpperCase();
        String country = object.getString("country");
        String idType = object.getString("idType");
        String idNumber = object.getString("idNumber");

        Employee employee = employeeService.updateEmployee(id, lastName, secondLastName, firstName, secondName, country,
                idType, idNumber);
        JSONObject employeeString = new JSONObject(employee);
        System.out.println(employeeString.toString());
        return employeeString.toString();
    }

    @DeleteMapping({ "/{id}" })
    public String deleteEmployee(@PathVariable Long id) throws MyException {

        try {
            Employee employee = employeeService.deleteEmployee(id);
            JSONObject employeeString = new JSONObject(employee);
            System.out.println(employeeString.toString());
            return employeeString.toString();

        } catch (MyException e) {
            System.out.println("estamos aqui aaaaaaa");
            return (e.getMessage() + " Está borracho mi fax");
        }
    }

}
