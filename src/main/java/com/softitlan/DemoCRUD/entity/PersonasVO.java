package com.softitlan.DemoCRUD.entity;
import java.io.Serializable;
import javax.persistence.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.persistence.NamedQueries;

import java.util.Date;
@Entity
@Table(name= "personas")
@NamedQueries({
		@NamedQuery(name = "PersonasVO.findAllActive", query = "select p from PersonasVO p where p.status = 1")
})
public class PersonasVO implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "paternal_surname")
	private String paternalSurname;
	@Column(name = "maternal_surname")
	private String maternalSurname;
	@Column(name = "birthdate")
	private Date birthdate;
	@Column(name = "gender")
	private String gender;
	@Column(name = "status")
	private Integer status;
	@Column(name = "created_at")
	private Date createdAt;
	@Column(name = "created_by")
	private Integer createdBy;
	@Column(name = "modified_at")
	private Date modifiedAt;
	@Column(name = "modified_by")
	private Integer modifiedBy;

	public Integer getId(){
		 return id;
	}

	public void setId(Integer id){
		  this.id=id;
	}

	public String getName(){
		 return name;
	}

	public void setName(String name){
		  this.name=name;
	}

	public String getPaternalSurname(){
		 return paternalSurname;
	}

	public void setPaternalSurname(String paternalSurname){
		  this.paternalSurname=paternalSurname;
	}

	public String getMaternalSurname(){
		 return maternalSurname;
	}

	public void setMaternalSurname(String maternalSurname){
		  this.maternalSurname=maternalSurname;
	}

	public Date getBirthdate(){
		 return birthdate;
	}

	public void setBirthdate(Date birthdate){
		  this.birthdate=birthdate;
	}

	public String getGender(){
		 return gender;
	}

	public void setGender(String gender){
		  this.gender=gender;
	}

	public Integer getStatus(){
		 return status;
	}

	public void setStatus(Integer status){
		  this.status=status;
	}

	public Date getCreatedAt(){
		 return createdAt;
	}

	public void setCreatedAt(Date createdAt){
		  this.createdAt=createdAt;
	}

	public Integer getCreatedBy(){
		 return createdBy;
	}

	public void setCreatedBy(Integer createdBy){
		  this.createdBy=createdBy;
	}

	public Date getModifiedAt(){
		 return modifiedAt;
	}

	public void setModifiedAt(Date modifiedAt){
		  this.modifiedAt=modifiedAt;
	}

	public Integer getModifiedBy(){
		 return modifiedBy;
	}

	public void setModifiedBy(Integer modifiedBy){
		  this.modifiedBy=modifiedBy;
	}

	@Override
	public String toString() {
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writeValueAsString(this);
		} catch (JsonProcessingException e) {
			return e.getMessage();
		}
	}

}
