/**
 * 
 */
package com.ss.test.lms;

import java.io.ByteArrayInputStream;

import org.junit.Test;

import com.ss.lms.LibraryManagementSystem;

/**
 * @author Alfred
 *
 */
public class LibraryManagmentSystemTest {
	
	//@Test
	public void lmsBadInput() {
		String[] args = null;
		LibraryManagementSystem.main(args);
	}
	
	@Test
	public void testMain()   {
	    String[] args = null;
	    ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
	    System.setIn(in);
	    System.setIn(System.in);
	    in =  new ByteArrayInputStream("0".getBytes());
	    System.setIn(in);
	    LibraryManagementSystem.main(args);
	}
	
	//@Test
	public void testInput() {
		 String[] args = null;
	    ByteArrayInputStream in = new ByteArrayInputStream("A".getBytes());
	    System.setIn(in);
	    System.setIn(System.in);
	    
	    LibraryManagementSystem.main(args);
		
	}

}
