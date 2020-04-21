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
		assertEquals(publisherService.updatePublisher("LMS Publisher", null, "New lane", "./resources/publishersTest"),
				"you can't have a null value for a name or address");
	}

	@Test
	public void publisherNameEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher(null, "New Name", "New lane", "./resources/publishersTest"),
				"you can't have a null value for a name or address");
	}

	@Test
	public void publisherNewAddressEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "New Name", null, "./resources/publishersTest"),
				"you can't have a null value for a name or address");
	}

	@Test
	public void publisherNewNameIsToShort() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "P", "New Lane", "./resources/publishersTest"),
				"publishers new name you entered is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publisherNewNameIsToLong() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(
				publisherService.updatePublisher("LMS Publisher",
						"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP", "New Lane",
						"./resources/publishersTest"),
				"publishers new name you entered is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publisherNewAddressIsToShort() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "NO CHANGE", "A", "./resources/publishersTest"),
				"publishers new Address you entered is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publisherNewAddressIsToLong() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "NO CHANGE",
				"APPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP", "./resources/publishersTest"),
				"publishers new Address you entered is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publisherWasNotFound() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("Not found Man", "The Not Found Man", "New lane",
				"./resources/publishersTest"), "Publisher was not found in database");
	}

	@Test
	public void publisherWasUpdated() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(
				publisherService.updatePublisher("LMS Publisher", "New Name", "New lane", "./resources/publishersTest"),
				"Publisher Has been updated");
	}

	@Test
	public void publisherOnlyNameWasUpdated() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "New Name", "NO CHANGE",
				"./resources/publishersTest"), "Publisher Has been updated");
	}

	@Test
	public void publisherOnlyAddressWasUpdated() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.updatePublisher("LMS Publisher", "NO CHANGE", "New Lane",
				"./resources/publishersTest"), "Publisher Has been updated");
	}

}
