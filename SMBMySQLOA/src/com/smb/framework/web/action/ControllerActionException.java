package com.smb.framework.web.action;

public class ControllerActionException  extends RuntimeException   {
	 
	private static final long serialVersionUID = 6091406800597998744L;
	
	public ControllerActionException(String message) {
		super(message);
	}
	
	public ControllerActionException(Throwable t)	{
		super(t);
		this.setStackTrace(t.getStackTrace());
	}
	
	public ControllerActionException(String message, Throwable t)	{
		super(message, t);
		this.setStackTrace(t.getStackTrace());
	}
}
