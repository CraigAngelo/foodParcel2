package com.foodparcel.controller;

/**
 * Author: Nico Fortuin
 * Student number: 216237912
 * */

import com.foodparcel.entity.Employee;
import com.foodparcel.entity.Job;
import com.foodparcel.factory.EmployeeFactory;
import com.foodparcel.factory.JobFactory;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeControllerTest {

    private static Employee employee = EmployeeFactory.createEmployee("15","Barack", "Obama", "2 November 2020"
            );

    private static String SECURITY_USERNAME = "admin";
    private static String SECURITY_PASSWORD = "admin123";

    @Autowired
    private TestRestTemplate restTemplate;
    private String baseUrl = "http://localhost:8888/employee/";

    @Test
    public void a_create() {
        String url = baseUrl + "create";
        System.out.println("URL: " + url);
        System.out.println("Post data: " +employee);
        ResponseEntity<Employee> postResponse = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, employee, Employee.class);
        employee = postResponse.getBody();
        assertEquals(200, postResponse.getStatusCodeValue());
    }

    @Test
    public void b_read() {
        String url = baseUrl + "find/" + employee.getEmployeeNumber();
        System.out.println("URL: " + url);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .getForEntity(url, Employee.class);
        System.out.println(response);
        assertEquals(employee.getFirstName(), response.getBody().getFirstName());
    }

    @Test
    public void c_update() {
        Employee employeeUpdate = new Employee.EmployeeBuilder().copy(employee).setFirstName("Nico Werner").build();
        String url = baseUrl + "update";
        System.out.println("URL: " +url);
        System.out.println("Post data: " + employeeUpdate);
        ResponseEntity<Employee> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .postForEntity(url, employeeUpdate, Employee.class);
        assertNotEquals(employee.getFirstName(), response.getBody().getFirstName());
    }

    @Test
//    @Ignore
    public void e_delete() {
        String url = baseUrl + "delete/" + employee.getEmployeeNumber();
        System.out.println("Delete URL: " + url);
        restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .delete(url);
    }

    @Test
    public void d_getAll() {
        String url = baseUrl + "all";
        System.out.println("URL: " +url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> response = restTemplate.withBasicAuth(SECURITY_USERNAME, SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);

        System.out.println(response);
        assertEquals(200, response.getStatusCodeValue());
    }
}