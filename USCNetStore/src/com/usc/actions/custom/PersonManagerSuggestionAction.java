package com.usc.actions.custom;




import java.util.Date;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usc.daos.Custom;
import com.usc.daos.Suggestion;
import com.usc.services.custom.IPersonManage;

public class PersonManagerSuggestionAction extends ActionSupport {

	private IPersonManage personmanage;
	
	private  Suggestion suggestion ;
	
	private String  suggestionContents;



	@Override
	public String execute() throws Exception {
		Custom custom = (Custom)ActionContext.getContext().getSession().get("Custom");
		suggestion=new Suggestion();
		suggestion.setSuggestionContents(suggestionContents);
		suggestion.setSuggestionFlag(0);
		suggestion.setSuggestionTime(new Date());
		suggestion.setColumnName(custom.getCustomName());
		personmanage.saveSuggestion(suggestion);
		return "success";
			
	}



	public Suggestion getSuggestion() {
		return suggestion;
	}



	public void setSuggestion(Suggestion suggestion) {
		this.suggestion = suggestion;
	}



	public String getSuggestionContents() {
		return suggestionContents;
	}



	public void setSuggestionContents(String suggestionContents) {
		this.suggestionContents = suggestionContents;
	}



	public IPersonManage getPersonmanage() {
		return personmanage;
	}



	public void setPersonmanage(IPersonManage personmanage) {
		this.personmanage = personmanage;
	}


}

