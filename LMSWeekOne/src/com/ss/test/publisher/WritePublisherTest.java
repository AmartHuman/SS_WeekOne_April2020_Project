/**
 * 
 */
package com.ss.test.publisher;

import org.junit.Test;

import com.ss.dao.PublisherDao;

/**
 * @author Alfred
 *
 */
public class WritePublisherTest {
	
	@Test(expected = NullPointerException.class)
	public void wirteFilePathIsNull() {
		PublisherDao publisherDao = new PublisherDao();
		publisherDao.writePublisherFile(null);
	}
	
	@Test
	public void wirteFilePathWasFound() {
		PublisherDao publisherDao = new PublisherDao();
		String path = "./resources/publisherTest";
		publisherDao.writePublisherFile(path);
	}

}
