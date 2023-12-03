package com.curd.entity;
import jakarta.persistence.*;

@Entity
public class Employee 
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empId;
	private String empName;
	private String empEmail;
	private String empPosition;
	private String empSalary;
	
	
	
	
	public Employee( String empName, String empEmail, String empPosition, String empSalary) {
		super();
		this.empName = empName;
		this.empEmail = empEmail;
		this.empPosition = empPosition;
		this.empSalary = empSalary;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getEmpEmail() {
		return empEmail;
	}
	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}
	public String getEmpPosition() {
		return empPosition;
	}
	public void setEmpPosition(String empPosition) {
		this.empPosition = empPosition;
	}
	public String getEmpSalary() {
		return empSalary;
	}
	public void setEmpSalary(String empSalary) {
		this.empSalary = empSalary;
	}
	@Override
	public String toString() {
		return "Employee [Id:" + empId + ", Name:" + empName + ", Email:" + empEmail + ", Position:"
				+ empPosition + ", empSalary:" + empSalary + "]";
	}
	
	
	
	

}
