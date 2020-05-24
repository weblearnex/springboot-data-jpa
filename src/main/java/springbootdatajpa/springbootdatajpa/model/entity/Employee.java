package springbootdatajpa.springbootdatajpa.model.entity;


import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="emp")
//@Entity(name="emp")
public class Employee implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "id", updatable = false, nullable = false)
	private long id;
	
	@Column(name="name",nullable = false)
	private String name;
	
	@Column(name="address")
	private String address;
	
	@Column(name="company_Name")
	private String orgName;

	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee( String name, String address, String orgName) {
		super();
		this.name = name;
		this.address = address;
		this.orgName = orgName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	

}
