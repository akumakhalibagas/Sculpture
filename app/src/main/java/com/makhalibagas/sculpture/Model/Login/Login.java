package com.makhalibagas.sculpture.Model.Login;

import com.google.gson.annotations.SerializedName;

public class Login{

	@SerializedName("code")
	private int code;

	@SerializedName("data")
	private Data data;

	@SerializedName("message")
	private String message;

	@SerializedName("token")
	private String token;

	public void setCode(int code){
		this.code = code;
	}

	public int getCode(){
		return code;
	}

	public void setData(Data data){
		this.data = data;
	}

	public Data getData(){
		return data;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"Login{" + 
			"code = '" + code + '\'' + 
			",data = '" + data + '\'' + 
			",message = '" + message + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}