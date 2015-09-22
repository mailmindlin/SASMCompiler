package com.mindlin.sasm.pass1;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

import com.mindlin.sasm.ARMRegister;
import com.mindlin.sasm.pass1.instruction.Pass1Instruction;

public class Pass1FunctionGenerator implements Function<List<Pass1Instruction>, List<String>> {
	HashMap<String, String> vardef = new HashMap<String, String>();
	HashSet<ARMRegister> regalloc = new HashSet<>(), regavail = new HashSet<>(), regused = new HashSet<>();
	public Pass1FunctionGenerator() {
		for(ARMRegister reg : ARMRegister.values())
			if((!reg.isPermanent()) && reg.isLocalUsable())
				regavail.add(reg);
	}
	public ARMRegister allocReg() {
		if (!regavail.isEmpty()) {
			ARMRegister reg = (ARMRegister) regavail.toArray()[0];
			regavail.remove(reg);
			regalloc.add(reg);
			regused.add(reg);
			return reg;
		} else {
			for (ARMRegister reg : ARMRegister.values()) {
				if (reg.isLocalUsable() && (!regalloc.contains(reg))) {
					regalloc.add(reg);
					regused.add(reg);
					return reg;
				}
			}
			throw new OutOfMemoryError();
		}
	}
	public ARMRegister freeReg(List<String> result, ARMRegister r) {
		ARMRegister replacement = allocReg();
		result.add("MOV "+replacement+' '+r.toString());
		return replacement;
	}
	public void releaseReg(ARMRegister r) {
		regavail.add(r);
		regalloc.remove(r);
	}
	public void callFunction(List<String> result, String fnName, String reciever, String...arguments) {
		
	}
	@Override
	public List<String> apply(List<Pass1Instruction> list) {
		LinkedList<String> result = new LinkedList<String>();
		
		return result;
	}

}
