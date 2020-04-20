/**
 * 
 */
package com.ss.test.publisher;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Alfred
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CreatePublisherTest.class, DeletePublisherTest.class, UpdatePublisherTest.class,
		ReadPublisherTest.class, WritePublisherTest.class})
public class PublisherTestSuite {

}
