/**
 * 
 */
package com.ss.test.book;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Alfred
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CreateBookTest.class, DeleteBookTest.class, UpdateBookTest.class })
public class BookTestSuite {

}
