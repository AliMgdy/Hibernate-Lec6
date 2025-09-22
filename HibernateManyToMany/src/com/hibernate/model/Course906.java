package com.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;import org.hibernate.annotations.Cascade;

import javax.persistence.JoinColumn;

@Entity
public class Course906 {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	
	private String course;
	
	@ManyToMany (cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH})
	@JoinTable(
	    name="Student_Course",
	    joinColumns = @JoinColumn(name="Course_id"),        
	    inverseJoinColumns = @JoinColumn(name="student_id")
	)
	private List<StudentGroup906> studentGroup906;
	
	public Course906 () {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCourse() {
		return course;
	}
	public void setCourse(String course) {
		this.course = course;
	}
	public List<StudentGroup906> getStudentGroup906() {
		return studentGroup906;
	}
	public void setStudentGroup906(List<StudentGroup906> studentGroup906) {
		this.studentGroup906 = studentGroup906;
	}
	public Course906(int id, String course, List<StudentGroup906> studentGroup906) {
		super();
		this.id = id;
		this.course = course;
		this.studentGroup906 = studentGroup906;
	}
}
