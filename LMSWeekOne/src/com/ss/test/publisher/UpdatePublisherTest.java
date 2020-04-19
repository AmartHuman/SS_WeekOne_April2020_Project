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
public class UpdatePublisherTest {
	
	@Test
	public void publisherNewNameEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", null, "New lane"), "you can't have a null value for a name or address");
	}
	
	@Test
	public void publisherNameEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher(null, "New Name", "New lane"), "you can't have a null value for a name or address");
	}
	
	@Test
	public void publisherNewAddressEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "New Name", null), "you can't have a null value for a name or address");
	}

}
