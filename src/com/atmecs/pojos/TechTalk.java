package com.atmecs.pojos;

public class TechTalk {

	private String srNo;
	private String date;
	private String title;
	private String description;
	private String presenter;
	
	public TechTalk() {
		
	}

	
	
	
	public String getSrNo() {
		return srNo;
	}




	public void setSrNo(String srNo) {
		this.srNo = srNo;
	}




	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPresenter() {
		return presenter;
	}

	public void setPresenter(String presenter) {
		this.presenter = presenter;
	}

	@Override
	public String toString() {
		return "TechTalk [date=" + date + ", title=" + title + ", description=" + description + ", presenter="
				+ presenter + "]";
	}
	
	
	
}
