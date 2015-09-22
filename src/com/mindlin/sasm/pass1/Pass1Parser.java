package com.mindlin.sasm.pass1;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.mindlin.sasm.pass1.instruction.Pass1FunctionDef;
import com.mindlin.sasm.pass1.instruction.Pass1FunctionEnd;
import com.mindlin.sasm.pass1.instruction.Pass1Instruction;
import com.mindlin.sasm.pass1.instruction.Pass1Vardef;
import com.mindlin.sasm.pass1.instruction.Pass1Vardel;
import com.mindlin.sasm.pass1.instruction.Pass1Varset;

public class Pass1Parser implements Function<List<String>, List<Pass1Instruction>> {
	public static final Pattern varset = Pattern.compile("^(?<T>[A-Za-z][A-Za-z0-9]*?) ?= ?(?<Q>.+)$");
	public static final Pattern fncall = Pattern.compile("(?<name>[A-Za-z_][A-Za-z0-9]*?) ?\\((?<args>.*)\\)");
	public static void printInstructions(List<Pass1Instruction> instructions) {
		for (Pass1Instruction instruction : instructions) {
			System.out.print(instruction.getName()+" ");
			for (String arg : instruction.getArgs())
				System.out.print(arg+" ");
			System.out.println();
		}
	}
	public Pass1Parser() {
		
	}
	
	@Override
	public List<Pass1Instruction> apply(List<String> lines) {
		LinkedList<Pass1Instruction> result = new LinkedList<>();
		int blockLevel = 0;
		for (String line1 : lines) {
			Matcher m;
			String line = line1.trim();
			if (line.startsWith("var ")) {
				String varname = line.substring(4, line.indexOf(' ',5));
				String rest = line.substring(4+varname.length()).trim();
				if (rest.startsWith(":="))
					result.add(new Pass1Vardef(varname, rest.substring(rest.indexOf(":=")+2)));
				else {
					result.add(new Pass1Vardef(varname));
					if (rest.startsWith("="))
						result.add(new Pass1Varset(varname, rest.substring(rest.indexOf("=")+1)));
				}
			} else if (line.startsWith("del ") || line.startsWith("delete ")) {
				String varname = line.substring(line.indexOf(' ')).trim();
				result.add(new Pass1Vardel(varname));
			} else if (line.startsWith("function ")) {
				String fnName = line.substring(9, line.indexOf('(')).trim();
				result.add(new Pass1FunctionDef(fnName));
				String[] args = line.substring(line.indexOf('(')+1,line.indexOf(')')).split(",");
				for (int i=0;i<args.length;i++)
					result.add(new Pass1Vardef(args[i].trim(), "!R"+i));
			} else if (line.equals("}")) {
				result.add(new Pass1FunctionEnd());
			} else if ((m=varset.matcher(line)).matches()) {
				String target = m.group("T");
				String expr = m.group("Q");
				if (((m=fncall.matcher(expr)).find())) {
					
				}
				result.add(new Pass1Varset(target, expr));
			}
		}
		return result;
	}

}
