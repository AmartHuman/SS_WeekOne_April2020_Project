/**
 * 
 */
package com.ss.service;


import java.util.Random;

import com.ss.dao.AuthorDao;
import com.ss.dao.BookDao;
import com.ss.interfaces.LoadFiles;
import com.ss.model.Author;

/**
 * @author Alfred
 *
 */
public class AuthorService implements LoadFiles {
	
	
	AuthorDao authorDao = new AuthorDao();
	BookDao bookDao = new BookDao();
	
	String bookFilePath = "./resources/books";
	

	// Create a new Author
	public String createAuthor(String authorName, String authorFilePath) {
		
		if(authorFilePath == null)
			return "File path cannot be null";
		
		authorDao.readAuthorFile();
		Random rand = new Random();

		Integer authorId = rand.nextInt(100000);
		authorId += 1;
		if (authorDao.authorMap.containsKey(authorId) == true) {
			while (true) {
				authorId = rand.nextInt(100000);
				authorId += 1;
				if (authorDao.authorMap.containsKey(authorId) != true)
					break;
			}
		}

		if (authorDao.authorMap.entrySet().stream()
				.anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
			return "Author Exist in the database";
		}

		if (authorName != null) {
			if (authorName.length() > 3 && authorName.length() < 45) {
				authorDao.author = new Author(authorId, authorName);
				authorDao.authorMap.put(authorDao.author.getAuthorId(), authorDao.author);
				authorDao.writeAuthorFile(authorFilePath);
				return "Name was created";
			} else {
				return "The Authors Name is less then 3 characters or is longer then 45 characters";
			}
		} else {
			return "Author Name cannot be null";
		}

	}

	// Update the Authors
	public String updateAuthor(String authorName, String authorNameNew, String authorFilePath) {

		if (authorNameNew != null && authorName != null) {
			if (authorNameNew.length() > 3 && authorNameNew.length() < 45) {
				if (authorDao.authorMap.entrySet().stream()
						.anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {

					authorDao.authorMap.entrySet().stream().forEach((a) -> {
						if (a.getValue().getAuthorName().equalsIgnoreCase(authorName)) {
							a.getValue().setAuthorName(authorNameNew);
							authorDao.writeAuthorFile(authorFilePath);
						}
					});
					return "Author Has been updated";
				} else {
					return "There is no author by that name to update";
				}
			} else {
				return "The Authors New Name is less then 3 characters or is longer then 45 characters";
			}
		} else {
			return "Name Cannot be null!";
		}

	}

	// Display the Author Data from the text file
	public String readAuthor() {
		authorDao.readAuthorFile();
		authorDao.authorMap.entrySet().stream().forEach((a) -> {
			System.out.println("Author Name: " + a.getValue().getAuthorName());
		});
		return "done";
	}

	// Delete the author from the text file
	public String deleteAuthor(String authorName, String authorFilePath) {
		if(authorName == null)
			return  "Name Cannot be null!";
		if(authorFilePath == null)
			return "Path cannot be null!";
		
		bookDao.readBookFile();
		bookDao.bookMap.entrySet().removeIf(b-> b.getValue().getBookAuthor().getAuthorName().equals(authorName));
		bookDao.wirteBookFile(bookFilePath);
		
		if (authorDao.authorMap.entrySet().removeIf(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
			authorDao.writeAuthorFile(authorFilePath);
			
			return "Author was removed from the database";
		}
		return "No Author by that name was found";
	}

	@Override
	public void loadFiles() {
		authorDao.readAuthorFile();
	}
	

}


