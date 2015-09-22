package com.mindlin.sasm.pass1.instruction;

public class Pass1Varset extends Pass1Instruction{

	public Pass1Varset(String name, String value) {
		super("varset", name, value);
	}

}
