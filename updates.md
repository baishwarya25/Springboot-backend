**com.helloworld.controller**

**GrafanaInterceptor.java**

package com.helloworld.controller;



import org.springframework.beans.factory.annotation.Value;

import org.springframework.stereotype.Component;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;

import jakarta.servlet.http.HttpServletResponse;



@Component

public class GrafanaInterceptor implements HandlerInterceptor {



&nbsp;   @Value("${grafana.api.token}")

&nbsp;   private String secretToken;



&nbsp;   @Override

&nbsp;   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

&nbsp;       

&nbsp;       // 1. Check where the request is coming from (Origin)

&nbsp;       String origin = request.getHeader("Origin");

&nbsp;       

&nbsp;       // 2. Get the Authorization Header (for Grafana)

&nbsp;       String authHeader = request.getHeader("Authorization");



&nbsp;       // OPTION A: If it's your React Frontend, let it through immediately

&nbsp;       if ("http://localhost:3001".equals(origin)) {

&nbsp;           return true;

&nbsp;       }



&nbsp;       // OPTION B: If it's Grafana, check for the secret token

&nbsp;       if (authHeader != null \&\& authHeader.equals("Bearer " + secretToken)) {

&nbsp;           return true;

&nbsp;       }



&nbsp;       // OPTION C: If it's a browser test (no origin) and matches token, let it through

&nbsp;       if (authHeader != null \&\& authHeader.equals("Bearer " + secretToken)) {

&nbsp;           return true;

&nbsp;       }



&nbsp;       // If neither, block the request

&nbsp;       response.setStatus(HttpServletResponse.SC\_UNAUTHORIZED);

&nbsp;       return false;

&nbsp;   }

}







**WebConfig.java**

package com.helloworld.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;

import org.springframework.web.servlet.config.annotation.InterceptorRegistry;

import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;



@Configuration

public class WebConfig implements WebMvcConfigurer {



&nbsp;   @Autowired

&nbsp;   private GrafanaInterceptor grafanaInterceptor;



&nbsp;   @Override

&nbsp;   public void addInterceptors(InterceptorRegistry registry) {

&nbsp;       // This protects your employee API

&nbsp;       registry.addInterceptor(grafanaInterceptor).addPathPatterns("/api/employees");

&nbsp;   }

}





**EmployeeController.java**

package com.helloworld.controller;



import com.helloworld.model.Employee;

import com.helloworld.services.EmployeeService;

import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.\*;



import java.util.List;



@RestController



@RequestMapping("/api/employees")

@CrossOrigin(origins = {"http://localhost:3001","http://localhost:3000"})

@RequiredArgsConstructor   // ✨ Lombok constructor

@Slf4j   // Optional for logging

public class EmployeeController {



&nbsp;   private final EmployeeService service; // Lombok generates constructor automatically



&nbsp;   @GetMapping

&nbsp;   public List<Employee> getAllEmployees() {

&nbsp;       log.info("Fetching all employees...");

&nbsp;       return service.getAllEmployees();

&nbsp;   }



&nbsp;   @PostMapping("/add")

&nbsp;   public Employee addEmployee(@RequestBody Employee employee) {

&nbsp;       log.info("Adding employee: {}", employee.getName());

&nbsp;       return service.addEmployee(employee);

&nbsp;   }



&nbsp;   @PutMapping("/{id}")

&nbsp;   public Employee updateEmployee(@PathVariable String id, @RequestBody Employee employee) {

&nbsp;       log.info("Updating employee with ID: {}", id);

&nbsp;       return service.updateEmployee(id, employee);

&nbsp;   }



&nbsp;   @DeleteMapping("/{id}")

&nbsp;   public void deleteEmployee(@PathVariable String id) {

&nbsp;       log.warn("Deleting employee with ID: {}", id);

&nbsp;       service.deleteEmployee(id);

&nbsp;   }



&nbsp;   @GetMapping("/directories")

&nbsp;   public List<String> getDirectories() {

&nbsp;       return service.getAllDirectories();

&nbsp;   }



&nbsp;   @GetMapping("/divisions/{directory}")

&nbsp;   public List<String> getDivisions(@PathVariable String directory) {

&nbsp;       return service.getDivisionsByDirectory(directory);

&nbsp;   }

}





add this line in application properties 

grafana.api.token=glsa\_TgNwR5pG9iEq8NsMMal95vhmnDmvppBv\_ea7b3959(create service account in that device and change the token)



when creating data source 

url-http://localhost:8080/api/employees



http header - Ensure your Authorization header still has the value: Bearer glsa\_TgNwR5pG9iEq8NsMMal95vhmnDmvppBv\_ea7b3959





Grafana fields(marcusolsson-json-datasource)  

Grafana – add fields like this (FINAL ANSWER)



In Panel → Queries → Fields tab, add one row per field.



✅ Use this table exactly

Form Label	JSONPath	Type

Employee ID	$\[\*].empId	String

Type	$\[\*].type	String

ID Number	$\[\*].idNo	String

Title	$\[\*].title	String

Full Name	$\[\*].name	String

Designation	$\[\*].designation	String

Directory	$\[\*].directory	String

Division	$\[\*].division	String

Date of Joining	$\[\*].dateOfJoin	Time

Date of Present Post	$\[\*].dateOfPost	Time

Qualification	$\[\*].qualification	String

Discipline	$\[\*].discipline	String

Gender	$\[\*].gender	String

Blood Group	$\[\*].bloodGroup	String

Phone	$\[\*].phone	String

Address (Current)	$\[\*].address	String

Permanent Address	$\[\*].permanentAddress	String

Date of Birth	$\[\*].dob	Time





for changing Grafana password 

Method 1: Using the Grafana CLI (Easiest)

If you have access to the terminal/command prompt where Grafana is installed, you can force a password reset for the admin user.



Open your Command Prompt (cmd) or Terminal.



Navigate to the Grafana bin folder (usually C:\\Program Files\\GrafanaLabs\\grafana\\bin on Windows).



Run the following command:



Bash

grafana-cli admin reset-admin-password your\_new\_password

Replace your\_new\_password with what you want your new password to be.



Restart the Grafana service.

