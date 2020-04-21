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
public class DeletePublisherTest {

	@Test
	public void publisherWasNotFound() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.deletePublisher("A", "./resources/publishersTest"),
				"No Publisher by that name was found");
	}

	@Test
	public void publisherNameIsNullOrEmpty() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.deletePublisher(null, "./resources/publishersTest"),
				"Publisher Name cannot be null");
	}

	@Test
	public void publisherFilePathWasNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.deletePublisher("LMS Publisher", null), "Publisher File Path cannot be null");
	}

	@Test
	public void publisherWasDeleted() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.deletePublisher("LMS Publisher", "./resources/publishersTest"),
				"Publisher was removed from the database");
	}

}
