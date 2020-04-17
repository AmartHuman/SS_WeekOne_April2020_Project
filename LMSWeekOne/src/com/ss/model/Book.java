/**
 * 
 */
package com.ss.model;

import java.io.Serializable;

/**
 * @author Alfred
 *
 */
public class Book implements Serializable{
	
	private static final long serialVersionUID = 2348684130499225508L;
	
	
	private Integer bookId;
	private String bookName;
	private Author bookAuthor;
	private Publisher bookPublisher;
	
	
	/**
	 * @param bookId
	 * @param bookName
	 * @param bookAuthor
	 * @param bookPublisher
	 */
	public Book(Integer bookId, String bookName, Author bookAuthor, Publisher bookPublisher) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.bookPublisher = bookPublisher;
	}
	
	/**
	 * @return the bookId
	 */
	public Integer getBookId() {
		return bookId;
	}
	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(Integer bookId) {
		this.bookId = bookId;
	}
	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}
	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	/**
	 * @return the bookAuthor
	 */
	public Author getBookAuthor() {
		return bookAuthor;
	}
	/**
	 * @param bookAuthor the bookAuthor to set
	 */
	public void setBookAuthor(Author bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	/**
	 * @return the bookPublisher
	 */
	public Publisher getBookPublisher() {
		return bookPublisher;
	}
	/**
	 * @param bookPublisher the bookPublisher to set
	 */
	public void setBookPublisher(Publisher bookPublisher) {
		this.bookPublisher = bookPublisher;
	}
		

}
