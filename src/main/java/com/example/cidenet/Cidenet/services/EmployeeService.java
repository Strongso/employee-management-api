package com.example.cidenet.Cidenet.services;


import com.example.cidenet.Cidenet.entities.Employee;
import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    public void createEmployee(Long id,String lastName,
                               String secondLastName,
                               String firstName,
                               String secondName,
                               String country,
                               String idType,
                               String idNumber) {

        Employee employee = new Employee();
        employee.setId(id);
        employee.setLastName(lastName);
        employee.setSecondLastName(secondLastName);
        employee.setFirstName(firstName);
        employee.setSecondName(secondName);
        employee.setCountry(country);
        employee.setIdType(idType);
        employee.setIdNumber(idNumber);

        employeeRepo.save(employee);
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

        for (char character:idNumberArray) {

            //Throw error if any of the characters is outside the a-z alphabet including uppercase letters (not including ñ)
            if (!((character >= 'A' && character <= 'Z')||(character >= 'a' && character <= 'z')||(character >= '0' && character <= '9')||(character == '-'))) {
                throw new MyException("The id number contains invalid characters");

            }else if (idNumber.length() > 20){
                throw new MyException("The id number is too long");
            }
        }

    }

    private void validateNull(Long id) throws MyException {
        if (id == null) {
            throw new MyException("The id is null");
        }
    }

    private void validateNull(String username) throws MyException {
        if (username.isEmpty()) {
            throw new MyException("The username is null or empty");
        }
    }

}
