/**
 * 
 */
package com.ss.model;

import java.io.Serializable;

/**
 * @author Alfred
 *
 */
public class Publisher implements Serializable{

	private static final long serialVersionUID = -7813443556625257503L;
	
	private Integer publisherId;
	private String publisherName;
	private String publisherAddress;
	
	
	/**
	 * @param publisherId
	 * @param publisherName
	 * @param publisherAddress
	 */
	public Publisher(Integer publisherId, String publisherName, String publisherAddress) {
		super();
		this.publisherId = publisherId;
		this.publisherName = publisherName;
		this.publisherAddress = publisherAddress;
	}
	
	/**
	 * @return the publisherId
	 */
	public Integer getPublisherId() {
		return publisherId;
	}
	/**
	 * @param publisherId the publisherId to set
	 */
	public void setPublisherId(Integer publisherId) {
		this.publisherId = publisherId;
	}
	/**
	 * @return the publisherName
	 */
	public String getPublisherName() {
		return publisherName;
	}
	/**
	 * @param publisherName the publisherName to set
	 */
	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}
	/**
	 * @return the publisherAddress
	 */
	public String getPublisherAddress() {
		return publisherAddress;
	}
	/**
	 * @param publisherAddress the publisherAddress to set
	 */
	public void setPublisherAddress(String publisherAddress) {
		this.publisherAddress = publisherAddress;
	}

	

}
