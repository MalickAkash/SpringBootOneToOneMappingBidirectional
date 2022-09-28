package com.example.demoSpringBootOneToOneMapping.Repository;

import com.example.demoSpringBootOneToOneMapping.Entity.Employee;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee,Long> {


    //these for specific record fetch from dataBase

//    @Query(
//        value = "select * from employee e,department d where e.department_id = d.department_id and e.employee_id =:n",
//        nativeQuery = true
//)
//    public Employee findByEmpId(@Param("n") String employeeId);

//    @Query(
//            value = "select * from employee e,department d where e.department_id = d.department_id and e.employee_id =?1",
//            nativeQuery = true
//    )
//    public Employee findByEmpId(@Param("n") String employeeId);

    @Query(
            value = "select * from employee e,department d where e.department_id = d.department_id and e.employee_id =?1",
            nativeQuery = true
    )
    public Employee findByEmpId(String employeeId);


    // these for all records fetch from dataBase

//    @Query(
//
//            value = "select * from employee",
//            nativeQuery = true
//    )
//    public List<Employee> findAllEmployee();

    @Query(
            value = "select * from employee e",
            nativeQuery = true
    )
    public List<Employee> findAllEmployee();


}
