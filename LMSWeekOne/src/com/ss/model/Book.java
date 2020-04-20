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
	

	private static final long serialVersionUID = 8029212148695634255L;
	
	
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
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((bookAuthor == null) ? 0 : bookAuthor.hashCode());
		result = prime * result + ((bookId == null) ? 0 : bookId.hashCode());
		result = prime * result + ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + ((bookPublisher == null) ? 0 : bookPublisher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		if (bookAuthor == null) {
			if (other.bookAuthor != null)
				return false;
		} else if (!bookAuthor.equals(other.bookAuthor))
			return false;
		if (bookId == null) {
			if (other.bookId != null)
				return false;
		} else if (!bookId.equals(other.bookId))
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookPublisher == null) {
			if (other.bookPublisher != null)
				return false;
		} else if (!bookPublisher.equals(other.bookPublisher))
			return false;
		return true;
	}

		

}
