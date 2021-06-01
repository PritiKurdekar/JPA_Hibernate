package com.cg.manytomanysingle.entities;

import javax.persistence.*;
import java.util.List;

@Table(name = "departments")
@Entity
public class Department {

    @GeneratedValue
    @Id
    private Integer deptId;

    private String deptName;


    public Department() {

    }

    public Department(String name) {
        this.deptName = name;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

}
