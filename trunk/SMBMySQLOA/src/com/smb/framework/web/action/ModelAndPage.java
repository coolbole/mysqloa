package com.smb.framework.web.action;

public class ModelAndPage {
	
	private Object values;
	private String page ;
	private boolean redirect=false;
 
	public ModelAndPage( String page ){
		  this.page=page;
	}
	
	public ModelAndPage( String page,boolean redirect){
		  this.page=page; this.redirect=redirect;
	}
	
	public ModelAndPage(Object values, String page ){
		this.values=values; this.page=page;
	}
	
	public ModelAndPage(Object values, String page ,boolean redirect){
		this.values=values; this.page=page; this.redirect=redirect;
	}
	
	protected boolean getRedirect(){
		return redirect;
	}
	
	
	
	protected Object getModelValue (){
		return values;
	}
	
	protected String getPageName (){
		return page;
	}
}
