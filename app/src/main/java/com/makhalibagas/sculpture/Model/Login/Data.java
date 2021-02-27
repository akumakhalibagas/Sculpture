package com.makhalibagas.sculpture.Model.Login;

import com.google.gson.annotations.SerializedName;

public class Data{

	@SerializedName("password")
	private String password;

	@SerializedName("createdDate")
	private String createdDate;

	@SerializedName("__v")
	private int V;

	@SerializedName("_id")
	private String id;

	@SerializedName("fullname")
	private String fullname;


	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	private String sekolah;

	public String getSekolah() {
		return sekolah;
	}

	public void setSekolah(String sekolah) {
		this.sekolah = sekolah;
	}

	public void setPassword(String password){
		this.password = password;
	}

	public String getPassword(){
		return password;
	}

	public void setCreatedDate(String createdDate){
		this.createdDate = createdDate;
	}

	public String getCreatedDate(){
		return createdDate;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setFullname(String fullname){
		this.fullname = fullname;
	}

	public String getFullname(){
		return fullname;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Data{" + 
			"password = '" + password + '\'' + 
			",createdDate = '" + createdDate + '\'' + 
			",__v = '" + V + '\'' + 
			",_id = '" + id + '\'' + 
			",fullname = '" + fullname + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}