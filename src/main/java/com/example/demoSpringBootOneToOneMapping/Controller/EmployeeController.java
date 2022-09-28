package com.example.demoSpringBootOneToOneMapping.Controller;

import com.example.demoSpringBootOneToOneMapping.Entity.Employee;
import com.example.demoSpringBootOneToOneMapping.Repository.EmployeeRepository;

import com.example.demoSpringBootOneToOneMapping.ResponseType.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/start")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    @PostMapping("/storeData")
    public Response storeEmployeeDepartData(@RequestBody Employee employee){
       Employee employee1=employeeRepository.save(employee);
       Response response=new Response();
       response.setStatus(HttpStatus.OK);
       response.setMessage("Data are store into the DataBase.");
       response.setObject(employee1);
       return response;

    }

    @GetMapping("/showSpecific/{employeeId}")
    public Response showOnlyData(@PathVariable String employeeId) {
        Employee employee = employeeRepository.findByEmpId(employeeId);
        Response response=new Response();
        if (employee == null) {
            response.setStatus(HttpStatus.BAD_REQUEST);
            response.setMessage("Data not found.");
            response.setObject(employee);
            return response;
        }
        else {
            response.setStatus(HttpStatus.FOUND);
            response.setMessage("Data are found inside Data Base.");
            response.setObject(employee);
            return response;
        }
    }

    @GetMapping("/showAll")
    public Response showAllData() {
        List<Employee> employee = employeeRepository.findAllEmployee();
        Response response=new Response();
        if (employee == null) {
            response.setStatus(HttpStatus.NOT_FOUND);
            response.setMessage("Data Base Empty,No records found.");
            response.setObject(employee);
            return response;
        } else {

            response.setStatus(HttpStatus.FOUND);
            response.setMessage("All Data are found inside Data Base.");
            response.setObject(employee);
            return response;
        }
    }

}
