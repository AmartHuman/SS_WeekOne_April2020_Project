/**
 * 
 */
package com.ss.test.suite;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.ss.test.author.AuthorTestSuite;

/**
 * @author Alfred
 *
 */
@RunWith(Suite.class)
@SuiteClasses({AuthorTestSuite.class})
public class LMSTestSuite {

}
