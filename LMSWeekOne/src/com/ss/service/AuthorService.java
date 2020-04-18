/**
 * 
 */
package com.ss.service;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;

import com.ss.dao.AuthorDao;
import com.ss.interfaces.LoadFiles;
import com.ss.model.Author;

/**
 * @author Alfred
 *
 */
public class AuthorService implements LoadFiles {

	AuthorDao authorDao = new AuthorDao();

	// Create a new Author
	public String createAuthor(String authorName) throws IOException {

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
				authorDao.writeAuthorFile();
				return "Name was created";
			} else {
				return "The Authors Name is less then 3 characters or is longer then 45 characters";
			}
		} else {
			return "Author Name cannot be null";
		}

	}

	// Update the Authors
	public String updateAuthor(String authorName, String authorNameNew) {

		if (authorNameNew != null) {
			if (authorNameNew.length() > 3 && authorNameNew.length() < 45) {
				if (authorDao.authorMap.entrySet().stream()
						.anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {

					authorDao.authorMap.entrySet().stream().forEach((a) -> {
						if (a.getValue().getAuthorName().equalsIgnoreCase(authorName)) {
							a.getValue().setAuthorName(authorNameNew);
							authorDao.writeAuthorFile();
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
			return "New Author Name Cannot be null!";
		}

	}

	// Display the Author Data from the text file
	public void readAuthor() {
		// authorDao.readAuthorFile();
		authorDao.authorMap.entrySet().stream().forEach((a) -> {
			System.out.println("Author Name: " + a.getValue().getAuthorName());
		});
	}

	// Delete the author from the text file
	public String deleteAuthor(String authorName) {

		if (authorDao.authorMap.entrySet().removeIf(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
			authorDao.writeAuthorFile();
			return "Author was removed from the database";
		}
		return "No Author by that name was found";
	}

	@Override
	public void loadFiles() {
		authorDao.readAuthorFile();
	}

}

// Stream.of(authorDao.authorMap.keySet().get).forEach(System.out::println);
// authorDao.authorMap.forEach((author.getAutherId(),author) ->
// System.out.println(author.getAutherId()));
// authorDao.authorMap.forEach((key, value) -> System.out.println(key + ":" +
// value));
// System.out.println(authorDao.authorMap);
// Stream.of(authorDao.authorMap.values().toString()).forEach(System.out::println);

// authorDao.authorMap.replace(, authorDao.author.setAuthorName(authorName));
//authorDao.authorMap.entrySet().stream().filter(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName)).forEach(Map.Entry::getValue);
//
//authorDao.authorMap.entrySet().stream().anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName));
//if(authorDao.authorMap.entrySet().stream().anyMatch(a -> authorName.equalsIgnoreCase(a.getValue().getAuthorName()))) {
//authorDao.author.setAuthorName(authorName);
//authorDao.writeAuthorFile();
// authorDao.authorMap.replace(1, authorDao.author);
// }
// System.out.println(authorDao.authorMap.entrySet().stream().filter(a ->
// authorName.equalsIgnoreCase(a.getValue().getAuthorName()))
// .map(Map.Entry::getValue));
//Integer authorId;
//authorDao.authorMap.entrySet().stream().forEach((a)->{
//	if(authorName.equalsIgnoreCase(a.getValue().getAuthorName())) {
//		//authorDao.authorMap.put(a.getKey(), a.getValue().setAuthorName(authorName));
//		authorId = a.getKey();
//	}
//});
//if(authorDao.authorMap.entrySet().stream().anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
//	
//}
// authorDao.authorMap.computeIfPresent(3, (k,v) ->
// v.setAuthorName(authorName));
