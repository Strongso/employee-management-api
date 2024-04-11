package com.example.cidenet.Cidenet.services;

import com.example.cidenet.Cidenet.entities.Employee;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
public class EmployeeService {

    private final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
    private final DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

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
            String idNumber,
            String area,
            String admissionDate) throws MyException {

        Employee employee = new Employee();

        LocalDate admissionDateFormatted = LocalDate.parse(admissionDate, dateFormatter);

        validateName(firstName);
        validateName(lastName);
        validateName(secondLastName);
        validateSecondName(secondName);
        validateIdNumber(idNumber);
        validateAdmissionDate(admissionDate);

        employee.setLastName(lastName);
        employee.setSecondLastName(secondLastName);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setCountry(country);
        employee.setIdType(idType);
        employee.setIdNumber(idNumber);
        employee.setEmail(generateEmail(firstName, lastName, country));
        employee.setArea(area);
        employee.setAdmissionDate(admissionDateFormatted.format(dateFormatter));
        employee.setRegistryDate(LocalDateTime.now().format(dateTimeFormatter));

        return employeeRepo.save(employee);

        // try generateEmail(employee.getId());
    }

    private void validateAdmissionDate(String admissionDate) throws MyException {
        LocalDate dateToValidate = LocalDate.parse(admissionDate, dateFormatter);
        if (dateToValidate.isAfter(LocalDate.now())) {
            throw new MyException("The date cannot be grater than the current date.");
        } else if (dateToValidate.isBefore(LocalDate.now().minusMonths(1))) {
            throw new MyException("The date cannot be older than 1 month.");
        }

    }

    // Create email for employess with the following structure:
    // <FIRST_NAME>.<LAST_NAME>.<ID>@<DOMAIN>
    public String generateEmail(String firstName, String lastName, String country) {
        String domain, email;
        int id = 0;
        if (country == "Colombia") {
            domain = "api.com.co";
        } else {
            domain = "api.com.co";
        }
        email = firstName + "." + lastName + "@" + domain;

        while (employeeRepo.existsByEmail(email)) {
            id++;
            email = firstName + "." + lastName + "." + id + "@" + domain;
        }

        return email;

    }

    public void validateName(String name) throws MyException {

        validateNull(name);
        char[] nameArray = name.toCharArray();

        for (char character : nameArray) {

            // Throw error if any of the characters is outside the A-Z alphabet (not
            // including Ñ)
            if (!(character >= 'A' && character <= 'Z')) {
                throw new MyException("The name contains invalid characters");

            } else if (name.length() > 20) {
                throw new MyException("The name is too long");
            }
        }

    }

    public void validateSecondName(String name) throws MyException {
        validateNull(name);
        char[] nameArray = name.toCharArray();

        for (char character : nameArray) {

            // Throw error if any of the characters is outside the A-Z alphabet, or
            // space(not including Ñ)
            if (!((character >= 'A' && character <= 'Z') || (character == ' '))) {
                throw new MyException("The second name contains invalid characters");

            } else if (name.length() > 50) {
                throw new MyException("The second name is too long");
            }
        }

    }

    public void validateIdNumber(String idNumber) throws MyException {

        validateNull(idNumber);
        char[] idNumberArray = idNumber.toCharArray();

        if (employeeRepo.existsByIdNumber(idNumber)) {
            throw new MyException("The id number is already taken by an unknown chorizo");
        }

        for (char character : idNumberArray) {

            // Throw error if any of the characters is outside the a-z alphabet including
            // uppercase letters (not including ñ)
            if (!((character >= 'A' && character <= 'Z') || (character >= 'a' && character <= 'z')
                    || (character >= '0' && character <= '9') || (character == '-'))) {
                throw new MyException("The id number contains invalid characters");

            } else if (idNumber.length() > 20) {
                throw new MyException("The id number is too long");
            }
        }

    }

    private void validateNull(String username) throws MyException {
        if (username.isEmpty()) {
            throw new MyException("The username is null or empty");
        }
    }

    public Employee updateEmployee(Long id, String lastName,
            String secondLastName,
            String firstName,
            String secondName,
            String country,
            String idType,
            String idNumber) throws MyException {

        Optional<Employee> employeeToUpdate = employeeRepo.findById(id);
        if (employeeToUpdate.isPresent()) {

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
        throw new MyException("Id not found");

    }

    public Employee deleteEmployee(Long id) throws MyException {
        Optional<Employee> employeeToDelete = employeeRepo.findById(id);
        if (employeeToDelete.isPresent()) {
            Employee employee = employeeToDelete.get();
            employeeRepo.delete(employee);
            return employee;
        }
        throw new MyException("Id not found");
    }
}
