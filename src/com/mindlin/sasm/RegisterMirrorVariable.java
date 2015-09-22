package com.mindlin.sasm;

public class RegisterMirrorVariable extends Variable {
	protected ARMRegister register;
	protected final boolean rebindable;
	public RegisterMirrorVariable(ARMRegister register, boolean rebindable) {
		this.register= register;
		this.rebindable = rebindable;
	}
	public RegisterMirrorVariable(ARMRegister register) {
		this(register, true);
	}
	public ARMRegister getRegister() {
		return register;
	}

}
