package com.mindlin.sasm.pass1.instruction;

public abstract class Pass1Instruction {
	protected String name;
	protected String[] args;
	public Pass1Instruction() {
	
	}
	public Pass1Instruction(String name, String... args) {
		this.name = name;
		this.args = args;
	}
	public String getName() {
		return name;
	}
	public String[] getArgs() {
		return args;
	}
	public String getArg(int index) {
		return getArgs()[index];
	}
}
