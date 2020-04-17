/**
 * 
 */
package com.ss.model;

import java.io.Serializable;

/**
 * @author Alfred
 *
 */
public class Author implements Serializable{


	private static final long serialVersionUID = -84732899621423633L;
	
	
	private Integer authorId;
	private String authorName;
	
	/**
	 * @param autherId
	 * @param authorName
	 */
	public Author(Integer autherId, String authorName) {
		super();
		this.authorId = autherId;
		this.authorName = authorName;
	}
	/**
	 * @return the autherId
	 */
	public Integer getAuthorId() {
		return authorId;
	}
	/**
	 * @param autherId the autherId to set
	 */
	public void setAuthorId(Integer autherId) {
		this.authorId = autherId;
	}
	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}
	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authorId == null) ? 0 : authorId.hashCode());
		result = prime * result + ((authorName == null) ? 0 : authorName.hashCode());
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
		Author other = (Author) obj;
		if (authorId == null) {
			if (other.authorId != null)
				return false;
		} else if (!authorId.equals(other.authorId))
			return false;
		if (authorName == null) {
			if (other.authorName != null)
				return false;
		} else if (!authorName.equals(other.authorName))
			return false;
		return true;
	}
	
	
	public String toString() {
		return " Author ID: "+this.authorId +" Author Name: "+ this.authorName +"\n";
	}
	


}
