package com.sb.cassandra.entity;

import java.io.Serializable;


import javax.validation.constraints.NotEmpty;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;


import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;

import org.springframework.data.cassandra.core.mapping.Table;
@XmlRootElement(name ="customer")
@XmlAccessorType(XmlAccessType.FIELD)
@Table("customer")
public class Customer implements Serializable
{

	private static final long serialVersionUID = 1L;

 @PrimaryKey
 @Column("id")

  protected long id;
 @Column("name")
 @NotEmpty(message="CustomerName cannot be Empty")
  protected String name;
 @Column("contactNo")
 @NotEmpty(message="ContactNo cannot be Empty")
  protected String contactNo;
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
public String getContactNo() {
	return contactNo;
}
public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}
  
  
}
