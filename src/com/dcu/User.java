package com.dcu;

public class User {
	private String firstname;
	 private String surname;
	 private int id;
	 private String password;
	 private String email;
	 
	 public User(int id, String surname, String firstname, String password, String email) {
		 super();
		 this.id = id;
		 this.firstname = firstname;
		 this.surname = surname;
		 this.password = password;
		 this.email = email;
	 }
	 
	 public String getFirstname() {
		 return firstname;
	 }
	 
	 public void setFirstname(String firstname) {
		 this.firstname = firstname;
	 }
	 
	 public String getSurname() {
		 return surname;
	 }
	 
	 public void setSurname(String surname) {
		 this.surname = surname;
	 }
	 
	 public int getid() {
		 return id;
	 }
	 
	 public void setid(int id) {
		 this.id = id;
	 }
	 
	 public String getPassword() {
		 return password;
	 }
	 
	 public void setPassword(String password) {
		 this.password = password;
	 }
	 
	 public String getEmail() {
		 return email;
	 }
	 public void setEmail(String email) {
		 this.email = email;
	 }
}
