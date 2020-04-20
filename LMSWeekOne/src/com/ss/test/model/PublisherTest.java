/**
 * 
 */
package com.ss.test.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.ss.model.Publisher;

/**
 * @author Alfred
 *
 */
public class PublisherTest {
	
	@Test
	public void publisherGetId() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		assertEquals(123,publisher.getPublisherId(),123);
	}
	
	@Test
	public void publisherGetName() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		assertEquals("PubName",publisher.getPublisherName(),"PubName");
	}
	
	@Test
	public void publisherGetIdAddess() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		assertEquals("PubAddress",publisher.getPublisherAddress(),"PubAddress");
	}
	
	@Test
	public void publisherSetId() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		publisher.setPublisherId(234);
		assertEquals(234,publisher.getPublisherId(),234);
	}
	
	
	@Test
	public void publisherSetName() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		publisher.setPublisherName("New Name");
		assertEquals("New Name",publisher.getPublisherName(),"New Name");
	}
	
	@Test
	public void publisherSetAddress() {
		Publisher publisher = new Publisher(123,"PubName","PubAddress");
		publisher.setPublisherAddress("New Address");
		assertEquals("New Address",publisher.getPublisherAddress(),"New Address");
	}
	
	@Test
	public void testEqualsSymmetric() {
		Publisher publisher = new Publisher(123, "Name of","Address");
		Publisher publisherTwo = new Publisher(123, "Name of", "Address");
		assertTrue(publisher.equals(publisherTwo) && publisherTwo.equals(publisher));
		assertTrue(publisher.hashCode() == publisherTwo.hashCode());
	}
	
	
}
