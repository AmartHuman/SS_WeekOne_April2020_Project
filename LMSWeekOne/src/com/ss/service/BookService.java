/**
 * 
 */
package com.ss.service;


import java.util.Random;

import com.ss.dao.AuthorDao;
import com.ss.dao.BookDao;
import com.ss.dao.PublisherDao;
import com.ss.interfaces.LoadFiles;
import com.ss.model.Book;

/**
 * @author Alfred
 *
 */
public class BookService implements LoadFiles {

	BookDao bookDao = new BookDao();
	public AuthorDao authorDao = new AuthorDao();
	public PublisherDao publisherDao = new PublisherDao();
	public AuthorService authorService = new AuthorService();
	public PublisherService publisherService = new PublisherService();

	public String createBook(String bookName, String authorName, String publisherName, String publisherAddress) {

		if (bookName != null && authorName != null && publisherName != null && publisherAddress != null) {
			if (authorName.length() < 3 || authorName.length() > 45) {
				return "The Authors Name is less then 3 characters or is longer then 45 characters";
			}
			if (publisherName.length() < 3 || publisherName.length() > 45) {
				return "The Publishers Name is less then 3 characters or is longer then 45 characters";
			}
			if (publisherAddress.length() < 3 || publisherAddress.length() > 45) {
				return "The Publishers Address is less then 3 characters or is longer then 45 characters";
			}

			if (bookDao.bookMap.entrySet().stream()
					.anyMatch(b -> b.getValue().getBookName().equalsIgnoreCase(bookName))) {
				return "There is a book with a Name as the one entered in the database";
			}

			// Find Author of book or Create new entry into the database if not found
			authorDao.readAuthorFile();
			if (authorDao.authorMap.entrySet().stream()
					.anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
				this.authorDao.author = authorDao.author;
			} else {
				System.out.println("Author was not found!");
				System.out.println("Creating New Entrty...");
				authorService.createAuthor(authorName);
				//authorDao.readAuthorFile();
				if (authorDao.authorMap.entrySet().stream()
						.anyMatch(a -> a.getValue().getAuthorName().equalsIgnoreCase(authorName))) {
					this.authorDao.author = authorDao.author;
				}
			}

			// Find Publisher of the the book or Create a new entry into the database if not
			// found
			publisherDao.readPublisherFile();
			if (publisherDao.publisherMap.entrySet().stream()
					.anyMatch(a -> a.getValue().getPublisherName().equalsIgnoreCase(publisherName))) {
				this.publisherDao.publisher = publisherDao.publisher;
			} else {
				System.out.println("Publisher was not found!");
				System.out.println("Creating New Entrty...");
				publisherService.createPublisher(publisherName, publisherAddress);
				if (publisherDao.publisherMap.entrySet().stream()
						.anyMatch(a -> a.getValue().getPublisherName().equalsIgnoreCase(publisherName))) {
					this.publisherDao.publisher = publisherDao.publisher;
				}
			}

			Random rand = new Random();

			Integer bookId = rand.nextInt(100000);
			bookId += 1;

			if (bookDao.bookMap.containsKey(bookId) == true) {
				while (true) {
					bookId = rand.nextInt(100000);
					bookId += 1;
					if (bookDao.bookMap.containsKey(bookId) != true)
						break;
				}
			}

			if (bookName.length() > 3 && bookName.length() < 45) {
				bookDao.book = new Book(bookId, bookName, authorDao.author, publisherDao.publisher);
				bookDao.bookMap.put(bookDao.book.getBookId(), bookDao.book);
				bookDao.wirteBookFile();
				return "Book was created";

			} else {
				return "The Books Name is less then 3 characters or is longer then 45 characters";
			}

		} else {
			return "Names cannot be null";
		}

	}

	public String updateBook(String bookName, String bookNewName, String authorName, String publisherName) {

		if (bookName != null && bookNewName != null && authorName != null && publisherName != null) {
			if (bookNewName.length() > 3 && bookNewName.length() < 45) {
				if (bookDao.bookMap.entrySet().stream()
						.anyMatch(b -> b.getValue().getBookName().equalsIgnoreCase(bookName))) {
					if (!bookNewName.equalsIgnoreCase("NO CHANGE")) {
						bookDao.bookMap.entrySet().stream().forEach((a) -> {
							if (a.getValue().getBookName().equalsIgnoreCase(bookName)) {
								a.getValue().setBookName(bookNewName);
								bookDao.wirteBookFile();
							}
						});
					} else if (!authorName.equalsIgnoreCase("NO CHANGE")) {

					} else if (!publisherName.equalsIgnoreCase("NO CHANGE")) {

					} else {
						return "Nothing was changed";
					}
				} else {
					return "The Book was not found in the database";
				}
			} else {
				return "The Books New Name is less then 3 characters or is longer then 45 characters";
			}
		} else {
			return "Names cannot be null";
		}
		return "Book has been updated";
	}

	public void readBook() {
		bookDao.bookMap.entrySet().stream().forEach((b) -> {
			System.out.println("Book Name: " + b.getValue().getBookName() + " | Author Name: "
					+ b.getValue().getBookAuthor().getAuthorName() + "  | Publisher Name: "
					+ b.getValue().getBookPublisher().getPublisherName());
		});
		bookDao.wirteBookFile();
	}

	public String deleteBook(String bookName, Integer authorKey, Integer publisherKey) {
		if (authorKey != null && authorKey == 0 && publisherKey == 0) {
			if (bookName != null) {
				if (bookDao.bookMap.entrySet().removeIf(b -> b.getValue().getBookName().equalsIgnoreCase(bookName))) {
					bookDao.wirteBookFile();
					return "The Book Was removed from the database";
				}
				return "No Book by that name was found";
			} else {
				return "Book Name cannot be null!";
			}
		} else if (bookName.equalsIgnoreCase("NO BOOK") && authorKey != 0) {
			bookDao.bookMap.entrySet().removeIf(b -> b.getValue().getBookAuthor().getAuthorId().equals(authorKey));
			bookDao.wirteBookFile();
			return "Books of that Author were removed as well";
		} else if (bookName.equalsIgnoreCase("NO BOOK") && publisherKey != 0) {
			bookDao.bookMap.entrySet()
					.removeIf(b -> b.getValue().getBookPublisher().getPublisherId().equals(publisherKey));
			bookDao.wirteBookFile();
			return "Books of that Publisher were removed as well";
		} else {
			return "Book deletion complete";
		}

	}

	@Override
	public void loadFiles() {
		bookDao.readBookFile();
	}

}
