package com.example.demoSpringBootOneToOneMapping.Entity;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Department {
    @Id
    private String departmentId;
    private String departmentName;
    private String departmentLocation;

    @OneToOne(cascade = CascadeType.ALL,mappedBy = "department") //bidirectional oneToOne mapping
    // mappedBy = "department"-->> used for bidirectional mapping bt forgen key not show in chiled table
    // means Depatrment class(Child class) and this mappedBy = "department" here depeartment is object type of Employee class.
    private Employee employee;

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentLocation() {
        return departmentLocation;
    }

    public void setDepartmentLocation(String departmentLocation) {
        this.departmentLocation = departmentLocation;
    }
}
