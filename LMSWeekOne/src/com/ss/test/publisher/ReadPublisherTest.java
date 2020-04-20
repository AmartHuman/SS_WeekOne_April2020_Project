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
public class ReadPublisherTest {
	
	@Test
	public void authorsAreBeingReadFrom() {
		PublisherService publisherService = new PublisherService();
		publisherService.loadFiles();
		assertEquals(publisherService.readPublisher(),"done");
	}

}
