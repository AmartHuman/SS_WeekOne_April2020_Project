package com.ss.lms;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.service.AuthorService;
import com.ss.service.PublisherService;

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
		PublisherService publisherService = new PublisherService();
		
		Scanner scanInput = new Scanner(System.in);
		Integer choice = 0;
		String authorName, authorNameNew;
		String publisherName,publisherAddress;
		
		authorService.loadFiles();
		publisherService.loadFiles();
		
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
							System.out.println("Please input an authors Name: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							System.out.println(authorService.createAuthor(authorName));
							break;
						case 2:
							System.out.println("Read Author");
							authorService.readAuthor();
							break;
						case 3:
							System.out.println("Please enter Author you wish to update: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							//scanInput.nextLine();
							authorNameNew = scanInput.nextLine();
							System.out.println(authorService.updateAuthor(authorName, authorNameNew));
							break;
						case 4:
							System.out.println("Please input an author to Delete: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							System.out.println(authorService.deleteAuthor(authorName));
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
					while(true) {
						System.out.println("   _________________________________________________________");
						System.out.println("  |___________________Edit Publisher Data___________________|");
						System.out.println("  |1.Create Publisher                                       |");
						System.out.println("  |2.Read Publisher                                         |");
						System.out.println("  |3.Update Publisher                                       |");
						System.out.println("  |4.Delete Publisher                                       |");
						System.out.println("  |0.Main Menu                                              |");
						System.out.println("  |_________________________________________________________|");
						System.out.print("  | > ");
						choice = scanInput.nextInt();
						
						switch(choice) {
						case 1:
							System.out.println("Please input the Publisher Name: ");
							scanInput.nextLine();
							publisherName = scanInput.nextLine();
							System.out.println("Plese input the Publisher Address: ");
							publisherAddress = scanInput.nextLine();
							System.out.println(publisherService.createPublisher(publisherName, publisherAddress));
							break;
						case 2:
							System.out.println("Read publisher");
							publisherService.readPublisher();
							break;
						case 3:
//							System.out.println("Please enter Publisher you wish to update: ");
//							scanInput.nextLine();
//							authorName = scanInput.nextLine();
//							//scanInput.nextLine();
//							authorNameNew = scanInput.nextLine();
//							System.out.println(authorService.updateAuthor(authorName, authorNameNew));
							break;
						case 4:
							System.out.println("Please input an Publisher to Delete: ");
							scanInput.nextLine();
							publisherName = scanInput.nextLine();
							System.out.println(publisherService.deletePublisher(publisherName));
							break;
						case 0:
							break;
						}
						if(choice == 0)
							break;
					}
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
