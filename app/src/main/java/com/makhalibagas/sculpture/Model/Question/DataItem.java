package com.makhalibagas.sculpture.Model.Question;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class DataItem {

	@SerializedName("question")
	private List<QuestionItem> question;

	@SerializedName("__v")
	private int V;

	@SerializedName("count")
	private int count;

	@SerializedName("isQuiz")
	private boolean isQuiz;

	@SerializedName("description")
	private String description;

	@SerializedName("isHome")
	private boolean isHome;

	@SerializedName("_id")
	private String id;

	@SerializedName("time")
	private int time;

	@SerializedName("title")
	private String title;

	public void setQuestion(List<QuestionItem> question){
		this.question = question;
	}

	public List<QuestionItem> getQuestion(){
		return question;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setCount(int count){
		this.count = count;
	}

	public int getCount(){
		return count;
	}

	public void setIsQuiz(boolean isQuiz){
		this.isQuiz = isQuiz;
	}

	public boolean isIsQuiz(){
		return isQuiz;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public String getDescription(){
		return description;
	}

	public void setIsHome(boolean isHome){
		this.isHome = isHome;
	}

	public boolean isIsHome(){
		return isHome;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setTime(int time){
		this.time = time;
	}

	public int getTime(){
		return time;
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
			"DataItem{" + 
			"question = '" + question + '\'' + 
			",__v = '" + V + '\'' + 
			",count = '" + count + '\'' + 
			",isQuiz = '" + isQuiz + '\'' + 
			",description = '" + description + '\'' + 
			",isHome = '" + isHome + '\'' + 
			",_id = '" + id + '\'' + 
			",time = '" + time + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}