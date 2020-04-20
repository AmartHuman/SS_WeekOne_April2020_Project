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
import com.ss.model.Book;
import com.ss.model.Publisher;

/**
 * @author Alfred
 *
 */
public class BookDao {

	public Book book;
	public Map<Integer, Book> bookMap = new HashMap<>();

	public AuthorDao authorDao = new AuthorDao();
	public PublisherDao publisherDao = new PublisherDao();
	
	public String path = "./resources/books";

	public void readBookFile() {
		String getFileLine;

		try (BufferedReader bufferRead = new BufferedReader(new FileReader("./resources/books"))) {

			while ((getFileLine = bufferRead.readLine()) != null) {
				String[] token = getFileLine.split("/");
				authorDao.readAuthorFile();
				publisherDao.readPublisherFile();

				for (Author author : authorDao.authorMap.values()) {
					if (author.getAuthorId() == Integer.parseInt(token[2])) {
						authorDao.author = author;
						break;
					}
				}
				for (Publisher publisher : publisherDao.publisherMap.values()) {
					if (publisher.getPublisherId() == Integer.parseInt(token[3])) {
						publisherDao.publisher = publisher;
						break;
					}
				}
				book = new Book(Integer.parseInt(token[0]), token[1], authorDao.author, publisherDao.publisher);
				bookMap.put(book.getBookId(), book);
			}

		} catch (IOException e) {
			System.out.println("The File was not Found!");
		}

	}

	public void wirteBookFile(String path) {

		String data = " ";

		try (BufferedWriter writer = Files.newBufferedWriter(Paths.get(path))) {
			for (Book book : bookMap.values()) {
				this.book = book;
				data = this.book.getBookId() + "/" + book.getBookName() + "/" + book.getBookAuthor().getAuthorId() + "/"
						+ book.getBookPublisher().getPublisherId() + "\n";
				if (data != "\n" || data != null)
					writer.write(data);
			}
		} catch (IOException e) {
			System.out.println();
		}

	}

}
