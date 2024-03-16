package com.example.cidenet.Cidenet;

import com.example.cidenet.Cidenet.exceptions.MyException;
import com.example.cidenet.Cidenet.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CidenetApplication {

	public static void main(String[] args) throws MyException {
		/*SpringApplication.run(CidenetApplication.class, args);*/

		EmployeeService employeeService = new EmployeeService();

		/*try {
			employeeService.validateName("");
			System.out.println("Todo bien");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateName("Alex");
			System.out.println("Todo bien");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateName("ALEX");
			System.out.println("All good with this name");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateSecondName("ALEXANDERPERODEMASIADOLARGOOOXX");
			System.out.println("All good with this second name");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateSecondName("ALEXANDERPERODEMASIADOLARGOOOXXPEROEXAGERADISIMAMENTEEE");
			System.out.println("Todo bien");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}*/

		try {
			employeeService.validateSecondName("ALEXANDER PERO LARGOOOXX");
			System.out.println("All good with this second name");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}

		try {
			employeeService.validateIdNumber("zanDrOx123-yes");
			System.out.println("All good with this id");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateIdNumber("zanDrOx123-yes**");
			System.out.println("All good with this id");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}
		try {
			employeeService.validateIdNumber("zanDrOx123-yesButitstoolong");
			System.out.println("All good with this id");
		}catch (MyException e){
			System.out.println(e.getMessage());
		}


	}




}
