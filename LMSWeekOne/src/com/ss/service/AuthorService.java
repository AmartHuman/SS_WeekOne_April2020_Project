/**
 * 
 */
package com.ss.service;


import java.io.IOException;
import java.util.Random;
import java.util.stream.Stream;

import com.ss.dao.AuthorDao;
import com.ss.model.Author;

/**
 * @author Alfred
 *
 */
public class AuthorService {
	
	AuthorDao authorDao = new AuthorDao();
	
	//Create a new Author
	public String createAuthor(String authorName) throws IOException {
		
		Random rand = new Random();
		Integer authorId = rand.nextInt(100000);
		if(authorName != null) {
			if(authorName.length() > 3 && authorName.length() < 45) {
				authorDao.author = new Author(authorId,authorName);
				authorDao.authorMap.put(authorDao.author.getAuthorId(),authorDao.author);
				authorDao.writeAuthorFile();
				return "Name was created";
			}
			else {
				return "The Authors Name is more then 3 characters or is longer then 45 characters";
			}
		}
		else {
			return "Author Name cannot be null";
		}
		
	}
	
	//Update the Authors
	public void updateAuthor() {
		
	}
	
	//Display the Author Data from the text file
	public void readAuthor() {
		authorDao.readAuthorFile();
		//Stream.of(authorDao.authorMap.keySet().get).forEach(System.out::println);
		//authorDao.authorMap.forEach((author.getAutherId(),author) -> System.out.println(author.getAutherId()));
		//authorDao.authorMap.forEach((key, value) -> System.out.println(key + ":" + value));
		//System.out.println(authorDao.authorMap);
		Stream.of(authorDao.authorMap.values().toString()).forEach(System.out::println);
		
	}
	
	//Delete the author from the text file
	public void deleteAuthor() {
		
	}

}
