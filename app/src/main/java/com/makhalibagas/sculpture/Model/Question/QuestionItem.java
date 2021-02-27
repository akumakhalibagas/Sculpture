package com.makhalibagas.sculpture.Model.Question;

import com.google.gson.annotations.SerializedName;

public class QuestionItem{

	@SerializedName("0")
	private String jsonMember0;

	@SerializedName("1")
	private String jsonMember1;

	@SerializedName("2")
	private String jsonMember2;

	@SerializedName("3")
	private String jsonMember3;

	@SerializedName("questionId")
	private int questionId;

	@SerializedName("answer")
	private String answer;

	@SerializedName("_id")
	private String id;

	@SerializedName("title")
	private String title;

	public void setJsonMember0(String jsonMember0){
		this.jsonMember0 = jsonMember0;
	}

	public String getJsonMember0(){
		return jsonMember0;
	}

	public void setJsonMember1(String jsonMember1){
		this.jsonMember1 = jsonMember1;
	}

	public String getJsonMember1(){
		return jsonMember1;
	}

	public void setJsonMember2(String jsonMember2){
		this.jsonMember2 = jsonMember2;
	}

	public String getJsonMember2(){
		return jsonMember2;
	}

	public void setJsonMember3(String jsonMember3){
		this.jsonMember3 = jsonMember3;
	}

	public String getJsonMember3(){
		return jsonMember3;
	}

	public void setQuestionId(int questionId){
		this.questionId = questionId;
	}

	public int getQuestionId(){
		return questionId;
	}

	public void setAnswer(String answer){
		this.answer = answer;
	}

	public String getAnswer(){
		return answer;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"QuestionItem{" + 
			"0 = '" + jsonMember0 + '\'' + 
			",1 = '" + jsonMember1 + '\'' + 
			",2 = '" + jsonMember2 + '\'' + 
			",3 = '" + jsonMember3 + '\'' + 
			",questionId = '" + questionId + '\'' + 
			",answer = '" + answer + '\'' + 
			",_id = '" + id + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}