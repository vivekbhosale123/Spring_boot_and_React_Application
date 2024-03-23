package org.techhub.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="SpringREG")
public class Register {
    @Override
	public String toString() {
		return "Register [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	@Id
    @Column(name="rid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    @Column(name="rname")
	private String name;
    @Column(name="rsal")
	private int sal;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	
}
