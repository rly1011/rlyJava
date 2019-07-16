 package com.renly.bean;

/**
 * @Description: TODO 
 * @author 任岚杨
 * @date 2019年7月10日 下午2:47:44   
 */
public class Employee {
	private Integer id;
	private String lastName;
	private String email;
	private String gender;
	private Department dept;
	
	
	public Employee() {
		super();
	}
	public Employee(Integer id, String lastName, String email, String gender, Department dept) {
		super();
		this.id = id;
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.dept = dept;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", lastName=" + lastName + ", email=" + email + ", gender=" + gender + ", dept="
				+ dept + "]";
	}
	
}