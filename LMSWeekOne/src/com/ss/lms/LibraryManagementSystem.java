package com.ss.lms;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.service.AuthorService;

/**
 * @author Alfred
 *
 */
public class LibraryManagementSystem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		AuthorService authorService = new AuthorService();
		
		Scanner scanInput = new Scanner(System.in);
		Integer choice = 0;
		
		while(true) {
			System.out.println("1.) Author");
			System.out.println("2.) Book");
			System.out.println("3.) Publisher");
			
			System.out.println("0.) Exit");
			
			try{
				choice = scanInput.nextInt();
				if(choice == 1) {
					System.out.println("Author Options");
					while(true) {
						System.out.println("   _________________________________________________________");
						System.out.println("  |___________________Edit Author Database__________________|");
						System.out.println("  |1.Create Author                                          |");
						System.out.println("  |2.Read Author                                            |");
						System.out.println("  |3.Update Author                                          |");
						System.out.println("  |4.Delete Author                                          |");
						System.out.println("  |0.Main Menu                                              |");
						System.out.println("  |_________________________________________________________|");
						System.out.print("  | > ");
						choice = scanInput.nextInt();
						
						//try {
						switch(choice) {
						case 1:
							System.out.println("Create a Author");
							authorService.createAuthor("Name is Joe");
							break;
						case 2:
							System.out.println("Read Author");
							authorService.readAuthor();
							break;
						case 3:
							System.out.println("Update a Author");
							break;
						case 4:
							System.out.println("Delete a Author");
							break;
						case 0:
							break;
						}
						if(choice == 0)
							break;

					}
				}
				else if(choice == 2) {
					System.out.println("Book Options");
				}
				else if(choice == 3) {
					System.out.println("Publisher Options");
				}
				else if(choice == 0) {
					System.out.println("Goodbye!");
					break;
				}
				else {
					System.out.println("Not a Choice");
				}
			}catch(InputMismatchException | IOException e) {
				System.out.println("Not a Choice");
				scanInput.next();
			}
			
		}
		scanInput.close();
		

	}

}
