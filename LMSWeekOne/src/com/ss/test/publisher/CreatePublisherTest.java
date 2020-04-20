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
public class CreatePublisherTest {//Test pub

	@Test
	public void publisherNameEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher(null, "Some address", "./resources/publishersTest"),
				"Names cannot be null!");
	}

	@Test
	public void publisherAddressEmptyOrNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", null, "./resources/publishersTest"),
				"Names cannot be null!");
	}

	@Test
	public void publisherFilePathIsNull() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", "Some Address", null), "File path cannot be null");
	}

	@Test
	public void publisherNameWasToShort() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("S", "Some address", "./resources/publishersTest"),
				"The Publishers Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publisherNameWasToLong() {
		PublisherService publisherService = new PublisherService();
		assertEquals(
				publisherService.createPublisher("PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP",
						"Some address", "./resources/publishersTest"),
				"The Publishers Name is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publishersAddressWasToShort() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", "p", "./resources/publishersTest"),
				"The Publishers Adress is less then 3 characters or is longer then 45 characters");
	}

	@Test
	public void publishersAddressWasToLong() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name",
				"PPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP", "./resources/publishersTest"),
				"The Publishers Adress is less then 3 characters or is longer then 45 characters");
	}
	
	@Test
	public void publisherNameAlreadyExist() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Test pub", "Some address", "./resources/publishersTest"),
				"Publisher is already in the database");
	}
	
	@Test
	public void publisherNameHasSameAddressAsOtherPublisher() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("New Pub", "time time time time", "./resources/publishersTest"),
				"Publisher can't have the same address as another Publisher");
	}
	
	@Test
	public void publisherAddressAlreadyExist() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", "Some address", "./resources/publishersTest"),
				"Publisher was Created");
	}

	@Test
	public void publisherWasCreated() {
		PublisherService publisherService = new PublisherService();
		assertEquals(publisherService.createPublisher("Some Name", "Some address", "./resources/publishersTest"),
				"Publisher was Created");
	}

}
