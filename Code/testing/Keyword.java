package com.brainmentors.testing;

public class Keyword {
	private String command;
	private String target;
	private String value;
	
	
	
	@Override
	public String toString() {
		return "Keyword [command=" + command + ", target=" + target + ", value=" + value + "]\n";
	}
	public String getCommand() {
		return command;
	}
	public void setCommand(String command) {
		this.command = command;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	

}
