	package com.cassandra.bd.CassandraTeste.model;

import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Person {

	
	@PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 2) //
	private String firstname;

	@PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 1) //
	private String lastname;

	private int age;

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}