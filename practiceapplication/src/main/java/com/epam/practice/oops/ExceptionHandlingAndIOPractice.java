package com.epam.practice.oops;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;

import org.springframework.core.io.ClassPathResource;

import com.epam.practice.exceptions.ReadOnlyFileException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExceptionHandlingAndIOPractice {

	static int readFileFromClassPath() throws IOException {

		ClassPathResource resource = new ClassPathResource("/static/test-datasets.xml");
		File file = new File(resource.getURI());
		System.out.println(file.getAbsolutePath());
		if (!file.canWrite()) {
			throw new ReadOnlyFileException("Cannot write data into the file");
		}
		try (BufferedReader br = new BufferedReader(new FileReader(file));
				BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))) {
			bw.newLine();
			bw.write("New line added by not flushing");
			bw.flush();
			String line;
			while ((line = br.readLine()) != null) {
				System.out.println("Line Seperation");
				System.out.println(line);
			}
			return 1;
		} catch (FileNotFoundException e) {
			log.info(e.getMessage());
		} catch (IOException e) {
			log.info(e.getMessage());
		} finally {
			System.out.println("got executed");
		}
		return 0;
	}

	public static void main(String[] args) {
		try {
			readFileFromClassPath();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
