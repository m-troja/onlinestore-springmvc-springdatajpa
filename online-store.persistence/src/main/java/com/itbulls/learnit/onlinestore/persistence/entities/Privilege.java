package com.itbulls.learnit.onlinestore.persistence.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Privilege {

	@Id
    private String name;

    public Privilege() {
	}

public void setName(String name) {
		this.name = name;
	}


}