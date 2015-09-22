package com.mindlin.sasm.pass1.instruction;

public class Pass1Vardef extends Pass1Instruction {
	public Pass1Vardef(String varname) {
		super("vardef", varname, null);
	}
	public Pass1Vardef(String varname, String value) {
		super("vardef", varname, value);
	}
}
