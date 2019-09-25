/**
 * 
 */
package com.jcamus.application.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author camusj
 *
 */
@Entity
public class User implements IUser {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private final String name;
	private final String groupId;
	
	public User() {
		this.name = "";
		this.groupId = "";
	}
	
	public User(String name, String groupId) {
		this.name = name;
		this.groupId = groupId;
	}

	@Override
	public long getId() {
		return this.id;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getGroupId() {
		return this.groupId;
	}

	@Override
	public String toString() {
		return "User(id=" + this.id
				+ ", name=" + this.name
				+ ", groupId=" + this.groupId
				+ ")";
	}

}
