package com.example.demoSpringBootOneToOneMapping.Repository;

import com.example.demoSpringBootOneToOneMapping.Entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long> {

}
