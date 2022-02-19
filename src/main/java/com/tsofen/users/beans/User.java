package com.tsofen.users.beans;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name = "first_name") 
	@NotBlank(message = "Can't Enter Empty First Name!")
	private String fname;
	@Column(name = "last_name")
	@NotBlank(message = "Can't Enter Empty Family Name!")
	private String lname;
	@Email(message = "Invalid Email!")
	@NotBlank(message = "Can't Enter Empty Email!")
	private String email;
	@NotBlank(message = "Can't Enter Empty Phone!")
	@Size(min = 10, max = 10, message = "Invalid Phone Number!")
	@Digits(integer = 10, fraction = 0)
	private String phone;
	@NotBlank(message = "Can't Enter Empty Password!")
	@Size(min = 6, max = 10, message = "Invalid Password!")
	private String password;
	@NotBlank(message = "Can't Enter Empty Role!")
	private String role;
	private boolean status = true;
}
