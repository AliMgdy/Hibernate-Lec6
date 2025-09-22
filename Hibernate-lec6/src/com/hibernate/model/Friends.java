package com.hibernate.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Friends {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
   
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable (name = "friends_users" ,
    		joinColumns= @JoinColumn(name = "fre_id" , nullable =false),
			inverseJoinColumns = @JoinColumn(name = "usr_id" , nullable =false) 
    		)
    private List<User> users;

	public Friends() {
		super();
	}

	public Friends(String name) {
		super();
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}
    
}