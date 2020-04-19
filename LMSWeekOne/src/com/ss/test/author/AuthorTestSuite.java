/**
 * 
 */
package com.ss.test.author;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author Alfred
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CreateAuthorTest.class, UpdateAuthorTest.class, ReadAuthorTest.class, DeleteAuthorTest.class,
		WriteAuthorTest.class }) // adding them here
public class AuthorTestSuite {

}
