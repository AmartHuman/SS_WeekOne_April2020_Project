/**
 * 
 */
package com.ss.test.lms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

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
	
	//@Test
	public void testMain() throws FileNotFoundException   {
	    //System.out.println("main");
	    String[] args = null;
	    final InputStream original = System.in;
	    final FileInputStream inputFile = new FileInputStream(new File("./resources/books"));
	    System.setIn(inputFile);
	    LibraryManagementSystem.main(args);
	    System.setIn(original);
	}
	
	public void testInput() {
//		Integer data = 1;
//		InputStream stdin = System.in;
//		try {
//			  System.setIn(new ByteInputStream(data));;
//			  Scanner scanner = new Scanner(System.in);
//			  System.out.println(scanner.nextLine());
//			} finally {
//			  System.setIn(stdin);
//			}
		
	}

}
