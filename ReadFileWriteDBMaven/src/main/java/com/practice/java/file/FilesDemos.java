package com.practice.java.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class FilesDemos {
	public static Path getFilePath() {
		Path sourceDir = Paths.get("src", "com", "practice", "java", "file");
		Path dataFile = sourceDir.resolve("data.txt");
		return dataFile;
	}
	
	public static void printFile() throws IOException {
		Path path = getFilePath();
		Files.lines(path).collect(Collectors.toList());
	}
	
	public static List<String> getListFromFile() throws IOException {
		Path path = getFilePath();
		List<String> person = Files.lines(path).collect(Collectors.toList());
		return person;
	}

	public static void writeIntoFile(String string) throws IOException {
		Files.write(Paths.get("output.txt"), string.getBytes(), StandardOpenOption.APPEND);
	}
}
