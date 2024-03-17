package com.example.cidenet.Cidenet.services;


import com.example.cidenet.Cidenet.entities.Employee;
import com.example.cidenet.Cidenet.entities.User;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }


    public Employee createEmployee(String lastName,
                               String secondLastName,
                               String firstName,
                               String secondName,
                               String country,
                               String idType,
                               String idNumber) throws MyException {

        Employee employee = new Employee();

        validateName(firstName);
        validateName(lastName);
        validateName(secondLastName);
        validateSecondName(secondName);
        validateIdNumber(idNumber);

        employee.setLastName(lastName);
        employee.setSecondLastName(secondLastName);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setCountry(country);
        employee.setIdType(idType);
        employee.setIdNumber(idNumber);
        employee.setEmail(generateEmail(firstName,lastName,country));

        return employeeRepo.save(employee);

        // try generateEmail(employee.getId());
    }


    //Create email for employess with the following structure: <FIRST_NAME>.<LAST_NAME>.<ID>@<DOMAIN>
    public String generateEmail(String firstName, String lastName, String country){
        String domain, email;
        int id=0;
        if (country=="Colombia"){
            domain = "api.com.co";
        }else{
            domain ="api.com.co";
        }
        email = firstName+"."+lastName+"@"+domain;

        while(employeeRepo.existsByEmail(email)){
            id ++;
            email = firstName+"."+lastName+"."+id+"@"+domain;
        }

        return email;

    }


    public void validateName(String name) throws MyException{

        validateNull(name);
        char[] nameArray = name.toCharArray();

        for (char character:nameArray) {

            //Throw error if any of the characters is outside the A-Z alphabet (not including Ñ)
            if (!(character >= 'A' && character <= 'Z')) {
                throw new MyException("The name contains invalid characters");

            }else if (name.length() > 20){
                throw new MyException("The name is too long");
            }
        }

    }
    public void validateSecondName(String name) throws MyException{
        validateNull(name);
        char[] nameArray = name.toCharArray();

        for (char character:nameArray) {

            //Throw error if any of the characters is outside the A-Z alphabet, or space(not including Ñ)
            if (!((character >= 'A' && character <= 'Z')||(character == ' '))) {
                throw new MyException("The second name contains invalid characters");

            }else if (name.length() > 50){
                throw new MyException("The second name is too long");
            }
        }

    }

    public void validateIdNumber(String idNumber) throws MyException{

        validateNull(idNumber);
        char[] idNumberArray = idNumber.toCharArray();

        if (employeeRepo.existsByIdNumber(idNumber)){
            throw new MyException("The id number is already taken by an unknown chorizo");
        }

        for (char character:idNumberArray) {

            //Throw error if any of the characters is outside the a-z alphabet including uppercase letters (not including ñ)
            if (!((character >= 'A' && character <= 'Z')||(character >= 'a' && character <= 'z')||(character >= '0' && character <= '9')||(character == '-'))) {
                throw new MyException("The id number contains invalid characters");

            }else if (idNumber.length() > 20){
                throw new MyException("The id number is too long");
            }
        }

    }

    private void validateNull(String username) throws MyException {
        if (username.isEmpty()) {
            throw new MyException("The username is null or empty");
        }
    }

    public Employee updateEmployee(Long id,String lastName,
                                   String secondLastName,
                                   String firstName,
                                   String secondName,
                                   String country,
                                   String idType,
                                   String idNumber) throws MyException {

        Optional<Employee> employeeToUpdate = employeeRepo.findById(id);
        if (employeeToUpdate.isPresent()){

            Employee employee = employeeToUpdate.get();
            employee.setLastName(lastName);
            employee.setSecondLastName(secondLastName);
            employee.setFirstName(firstName);
            employee.setSecondName(secondName);
            employee.setCountry(country);
            employee.setIdType(idType);
            employee.setIdNumber(idNumber);

            employeeRepo.save(employee);
            return employee;
        }
        throw new MyException("The username is null or empty");

    }


}
