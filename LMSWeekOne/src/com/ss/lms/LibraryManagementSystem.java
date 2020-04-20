package com.ss.lms;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.ss.service.AuthorService;
import com.ss.service.BookService;
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
		BookService bookService = new BookService();

		Scanner scanInput = new Scanner(System.in);
		Integer choice = 0;
		String authorName, authorNameNew;
		String publisherName, publisherAddress, publisherNewName, publisherNewAddress;
		String bookName, bookNewName;
		
		String bookFilePath = "./resources/books";
		String authorFilePath = "./resources/authors";
		String publisherFilePath = "./resources/publishers";
		
		authorService.loadFiles();
		publisherService.loadFiles();
		bookService.loadFiles();

		/*
		 * 
		 * Main Menu loop
		 * 
		 * */
		while (true) {
			System.out.println("1.) Author");
			System.out.println("2.) Book");
			System.out.println("3.) Publisher");

			System.out.println("0.) Exit");

			try {
				choice = scanInput.nextInt();
				if (choice == 1) {
					System.out.println("Author Options");
					while (true) {
						/*
						 * 
						 * Author options on what to do with the database
						 * 
						 * */
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

						// try {
						switch (choice) {
						case 1:
							System.out.println("Please input an authors Name: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							System.out.println(authorService.createAuthor(authorName,authorFilePath));
							break;
						case 2:
							System.out.println("Read Author");
							authorService.readAuthor();
							break;
						case 3:
							System.out.println("Please enter Author you wish to update: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							authorNameNew = scanInput.nextLine();
							System.out.println(authorService.updateAuthor(authorName, authorNameNew,authorFilePath));
							break;
						case 4:
							System.out.println("Please input an author to Delete: ");
							scanInput.nextLine();
							authorName = scanInput.nextLine();
							System.out.println(authorService.deleteAuthor(authorName,authorFilePath));
							break;
						case 0:
							break;
						}
						if (choice == 0)
							break;

					}
				} else if (choice == 2) {
					System.out.println("Book Options");
					
					while (true) {
						/*
						 * 
						 * Book options on what to do with the database
						 * 
						 * */
						System.out.println("   _________________________________________________________");
						System.out.println("  |___________________Edit Books Data_______________________|");
						System.out.println("  |1.Create Book                                            |");
						System.out.println("  |2.Read Book                                              |");
						System.out.println("  |3.Update Book                                            |");
						System.out.println("  |4.Delete Book                                            |");
						System.out.println("  |0.Main Menu                                              |");
						System.out.println("  |_________________________________________________________|");
						System.out.print("  | > ");
						choice = scanInput.nextInt();

						switch (choice) {
						case 1:
							System.out.println("Please input Book Name: ");
							scanInput.nextLine();
							bookName = scanInput.nextLine();
							System.out.println("Plese Enter the Author of the book: ");
							authorName = scanInput.nextLine();
							System.out.println("Please Enter the Publishers Name: ");
							publisherName = scanInput.nextLine();
							System.out.println("Please Enter the Publishers Address: ");
							publisherAddress = scanInput.nextLine();
							System.out.println(bookService.createBook(bookName, authorName, publisherName, publisherAddress, bookFilePath));
							break;
						case 2:
							System.out.println("Read books");
							bookService.readBook();
							break;
						case 3:
							System.out.println("Please input book Name you wish to update: ");
							scanInput.nextLine();
							bookName = scanInput.nextLine();
							System.out.println("What is the new name of the book: ");
							bookNewName = scanInput.nextLine();
							System.out.println(bookService.updateBook(bookName, bookNewName, bookFilePath));
							break;
						case 4:
							System.out.println("Please input book you wish to delete: ");
							scanInput.nextLine();
							bookName = scanInput.nextLine();
							System.out.println(bookService.deleteBook(bookName, bookFilePath));
							break;
						case 0:
							break;
						}
						if(choice == 0)
							break;
					}
				} else if (choice == 3) {
					System.out.println("Publisher Options");
					while (true) {
						/*
						 * 
						 * Publisher options on what to do with the database
						 * 
						 * */
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

						switch (choice) {
						case 1:
							System.out.println("Please input the Publisher Name: ");
							scanInput.nextLine();
							publisherName = scanInput.nextLine();
							System.out.println("Plese input the Publisher Address: ");
							publisherAddress = scanInput.nextLine();
							System.out.println(publisherService.createPublisher(publisherName, publisherAddress,publisherFilePath));
							break;
						case 2:
							System.out.println("Read publisher");
							publisherService.readPublisher();
							break;
						case 3:
							scanInput.nextLine();
							System.out.println("Please input the Publisher Name you wish to update: ");
							publisherName = scanInput.nextLine();
							System.out.println("What will you bee updating?");
							System.out.println("+----------------------------+");
							System.out.println("|1.) update just the Name    |");
							System.out.println("|2.) update just the Address |");
							System.out.println("|3.) update both             |");
							System.out.println("+----------------------------+");
							choice = scanInput.nextInt();
							if (choice == 1) {
								scanInput.nextLine();
								System.out.println("Please input the Publishers new Name: ");
								publisherNewName = scanInput.nextLine();
								System.out.println(
										publisherService.updatePublisher(publisherName, publisherNewName, "NO CHANGE",publisherFilePath));
							} else if (choice == 2) {
								scanInput.nextLine();
								System.out.println("Please input the Publishers new Address: ");
								publisherNewAddress = scanInput.nextLine();
								System.out.println(publisherService.updatePublisher(publisherName, "NO CHANGE",
										publisherNewAddress,publisherFilePath));

							} else if (choice == 3) {
								scanInput.nextLine();
								System.out.println("Please input the Publishers new Name: ");
								publisherNewName = scanInput.nextLine();
								System.out.println("Please input the Publishers new Address: ");
								publisherNewAddress = scanInput.nextLine();
								System.out.println(publisherService.updatePublisher(publisherName, publisherNewName,
										publisherNewAddress,publisherFilePath));

							} else {
								System.out.println("Not a valid option!");
							}
							break;
						case 4:
							System.out.println("Please input an Publisher to Delete: ");
							scanInput.nextLine();
							publisherName = scanInput.nextLine();
							System.out.println(publisherService.deletePublisher(publisherName,publisherFilePath));
							break;
						case 0:
							break;
						}
						if (choice == 0)
							break;
					}
				} else if (choice == 0) {
					System.out.println("Goodbye!");
					break;
				} else {
					System.out.println("Not a Choice");
				}
			} catch (InputMismatchException e) {
				System.out.println("Not a Choice");
				scanInput.next();
			}

		}
		scanInput.close();

	}

}
