package com.mindlin.sasm;

public enum ARMRegister {
	/**
	 * Argument1, Return Value
	 * <br/>
	 * Temporary register
	 */
	R0(false, true),
	/**
	 * Argument2, Second 32-bits if double/int Return Value
	 * <br/>
	 * Temporary register
	 */
	R1(false, true),
	/**
	 * Argument 3
	 * <br/>
	 * Temporary register
	 */
	R2(false, true),
	/**
	 * Argument 4
	 * <br/>
	 * Temporary register
	 */
	R3(false, true),
	/**
	 * Permanent register
	 */
	R4,
	/**
	 * Permanent register
	 */
	R5,
	/**
	 * Permanent register
	 */
	R6,
	/**
	 * Permanent register
	 */
	R7,
	/**
	 * Permanent register
	 */
	R8,
	/**
	 * Permanent register
	 */
	R9,
	/**
	 * Permanent register
	 */
	R10,
	/**
	 * Frame Pointer
	 * <br/>
	 * Permanent register
	 */
	R11,
	/**
	 * Temporary register
	 */
	R12(false, true),
	/**
	 * Stack pointer
	 * <br/>
	 * Permanent register
	 */
	R13(true, false, "sp"),
	/**
	 * Link register
	 * <br/>
	 * Permanent register
	 */
	R14(true, false, "lr"),
	/**
	 * Program counter
	 */
	R15(true, false, "pc");
	final String name;
	final boolean permanent;
	final boolean localUsable;
	public boolean isLocalUsable() {
		return localUsable;
	}
	ARMRegister() {
		this(true, true);
	}
	ARMRegister(boolean permanent, boolean localUsable) {
		this.permanent = permanent;
		this.localUsable = localUsable;
		name = this.name();
	}
	ARMRegister(boolean permanent, boolean localUsable, String name) {
		this.permanent = permanent;
		this.localUsable = localUsable;
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	public boolean isPermanent() {
		return permanent;
	}
	
}
