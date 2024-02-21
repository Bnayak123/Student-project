package com.BnSoft.FullStackProject.Entitys;

import org.hibernate.annotations.NaturalId;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Id")
	private Integer id;
	@Column(name = "First_Name")
	private String firstName;
	@Column(name = "Last_Name")
	private String LastName;
	@NaturalId(mutable = true)
	@Column(name = "Email")
	private String email;
	@Column(name = "Deportment")
	private String deportment;

}
