/**
 * 
 */
package com.ss.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import com.ss.model.Author;

/**
 * @author Alfred
 *
 */
public class AuthorDao {

	public Author author;
	public Map<Integer, Author> authorMap = new HashMap<>();
	public String path = "./resources/authors";

	/*
	 * 
	 * Read the author file to then be put into the authorMap
	 * 
	 * 
	 * */
	public void readAuthorFile() {

		String getFileLine;

		try (BufferedReader bufferRead = new BufferedReader(new FileReader("./resources/authors"))) {

			while ((getFileLine = bufferRead.readLine()) != null) {
				String[] token = getFileLine.split("/");

				author = new Author(Integer.parseInt(token[0]), token[1]);
				authorMap.put(author.getAuthorId(), author);
			}

		} catch (IOException e) {
			System.out.println("The file was not found!");
		}

	}

	/*
	 * 
	 * Wirte to the author file and pass in the path to find were the file is at
	 * 
	 * 
	 * */
	public void writeAuthorFile(String path) {

		String data = " ";

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {

			for (Author author : authorMap.values()) {
				this.author = author;
				data = this.author.getAuthorId() + "/" + author.getAuthorName() + "\n";
				if (data != "\n" || data != null)
					writer.write(data);
			}

		} catch (IOException e) {
			System.out.println("File not found");
		} 

	}

}
