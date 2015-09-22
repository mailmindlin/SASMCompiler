package com.mindlin.sasm.pass1.instruction;

public class Pass1FunctionDef extends Pass1Instruction {
	String[] args = new String[1];
	public Pass1FunctionDef(String fnName) {
		super("fndef", fnName);
	}

}
