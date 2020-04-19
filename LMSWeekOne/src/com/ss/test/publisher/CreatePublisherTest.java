/**
 * 
 */
package com.ss.test.publisher;

import static org.junit.Assert.assertEquals;



import org.junit.Test;


import com.ss.service.PublisherService;

/**
 * @author Alfred
 *
 */
public class CreatePublisherTest {
	
	@Test
	public void publisherNameEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher(null, "Some address"),"Names cannot be null!");
	}
	
	@Test
	public void publisherAddressEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", null),"Names cannot be null!");
	}
	

}
