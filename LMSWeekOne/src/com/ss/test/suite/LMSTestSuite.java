/**
 * 
 */
package com.ss.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ss.test.author.AuthorTestSuite;
import com.ss.test.book.BookTestSuite;
import com.ss.test.model.ModelTestSuite;
import com.ss.test.publisher.PublisherTestSuite;

/**
 * @author Alfred
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AuthorTestSuite.class,PublisherTestSuite.class,BookTestSuite.class,ModelTestSuite.class})
public class LMSTestSuite {

}
