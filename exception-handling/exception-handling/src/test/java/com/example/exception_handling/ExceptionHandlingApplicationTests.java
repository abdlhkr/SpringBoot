package com.example.exception_handling;

import com.example.exception_handling.dto.DtoEmployee;
import com.example.exception_handling.service.IEmployeeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExceptionHandlingApplicationTests {

	@Autowired
	private IEmployeeService employeeService;

	@Test
	void contextLoads() {
	}

	@BeforeEach
	public void beforeEach(){
		System.out.println(	"öcne : ");
	}

	@AfterEach
	public void afterEach(){
		System.out.println("sonra : ");
	}


	@Test
	public void testFindEmployeeById(){
		DtoEmployee employee = employeeService.findById(3L);
		if(employee != null) {
			System.out.println("Employee found: " + employee.getName());
		}
	}
}
