package com.mindlin.sasm;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.stream.Collectors;

import com.mindlin.sasm.pass1.Pass1Parser;
import com.mindlin.sasm.pass1.instruction.Pass1Instruction;

public class Tester {
	public static void main(String...args) throws IOException {
		File f = new File("");
		BufferedReader br = Files.newBufferedReader(f.toPath());
		Pass1Parser parser = new Pass1Parser();
		List<Pass1Instruction> instructions = parser.apply(br.lines().collect(Collectors.toList()));
		Pass1Parser.printInstructions(instructions);
	}

}
