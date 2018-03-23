package com.myMoneyBuddy.ExceptionClasses;

public class MoneyBuddyException extends Exception{

	protected int errorId;
	protected String systemId;
	protected String errorDescription;

	public int getErrorId() {
		return errorId;
	}

	public void setErrorId(int errorId) {
		this.errorId = errorId;
	}

	public String getSystemId() {
		return systemId;
	}

	public void setSystemId(String systemId) {
		this.systemId = systemId;
	}

	public String getErrorDescription() {
		return errorDescription;
	}

	public void setErrorDescription(String errorDescription) {
		this.errorDescription = errorDescription;
	}

	public MoneyBuddyException() {
		super();
	}
	
	public MoneyBuddyException(String msg){
		super(msg);
	}

	public MoneyBuddyException(String msg, Throwable thr){
		super(msg, thr);
	}
	
	public MoneyBuddyException(String msg, MoneyBuddyException mbEx){
		super(msg, mbEx);
	}
	
	
}
