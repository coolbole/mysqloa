package com.smb.framework.web.action;

public interface ModelDriven  {

	/**
	 * Gets the model to be pushed onto the ValueStack instead of the Action itself.
	 * @return the model
	 */
	public Object getModel( );
}
