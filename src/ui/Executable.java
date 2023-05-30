package ui;

import java.util.Scanner;
import model.Controller;
public class Executable {

	private Scanner scanner;
	private Controller controller;

	public Executable() {

		scanner = new Scanner(System.in);
		controller = new Controller();
	 }
	public static void main(String[] args) {

		Executable ejecutable = new Executable();
		ejecutable.menu();

	}

	private void menu() {

		boolean flag = false;

		while (!flag) {

			//Ajuste en funcionalidad
		System.out.println("╔═══╗╔╗────────────╔╗───╔╗─╔╗──────╔═══╗──────╔╗");
		System.out.println("║╔═╗║║║───────────╔╝╚╗──║║─║║──────║╔═╗║──────║║");
		System.out.println("║║─╚╬╣║╔══╦╗╔╦══╦═╗╚╗╔╝╔══╝║─║║╔══╦═╝║╚══╦═╗╔══╣");
		System.out.println("║║╔═╣║║║═╣║║║║║ WELCOME TO READX APP ╔╗║╔╗║╔══╣╔");
		System.out.println("║╚╩═║║╚╣═╣║╚╝║║║║║╚╝║──║╚═╝║╔╝╚╣╚╝║╚╝║╚══╣║║║╚╝║");
		System.out.println("╚═══╝╚═╩══╩══╩╩╩╩╩═╗╠══╝╚═══╝╚══╩══╩══╩═══╩╝╚╩══");

		
		System.out.println("\n1. User options");
		System.out.println("\n2. Products options");
		System.out.println("\n3. Buy Bibliographic Products");
		System.out.println("\n5. EXIT");
		
		int option = scanner.nextInt();
		
		switch (option) {
			case 1:
				System.out.println("\n1. Register User");
				System.out.println("\n2. Consult User");
				System.out.println("\n3. User Library");
		
				int option2 = scanner.nextInt();
		
				switch (option2) {
					case 1:
						registerUser();
						break;
		
					case 2:
						consultUser();
						break;
		
					case 3:
						showMatrix1();
						break;
		
					default:
						System.out.println("Invalid option");
						break;
				}
				break;
		
			case 2:
				System.out.println("\n1. Register Bibliographic Product");
				System.out.println("\n2. Check Registered Bibliographic Products");
				System.out.println("\n3. Modify Bibliographic Products");
				System.out.println("\n4. Delete Bibliographic Products");
				int option3 = scanner.nextInt();
		
				switch (option3) {
					case 1:
						registerBiblioProducts();
						break;
		
					case 2:
						consultBiblioproducts();
						break;
		
					case 3:
						modifyBiblioProducts();
						break;
		
					case 4:
						removeBiblioProducts();
						break;
		
					default:
						System.out.println("Invalid option");
						break;
				}
				break;
		
			case 3:
				buyProducts();
				break;
		
			case 4:
				// Action for option 4
				break;
		
			case 5:
				System.exit(0);
				break;
		
			default:
				System.out.println("Invalid option");
				break;
		}
	} 
}
		

		private void registerUser() {
			System.out.println("Enter the information for a new user");

			// Clearing the buffer
			scanner.nextLine();

			System.out.println("Enter the nickname");
			String user_name = scanner.nextLine();

			System.out.println("Enter the ID number");
			String id = scanner.nextLine();

			System.out.println("Enter the vinculation day");
			int vinculationDay = scanner.nextInt();

			System.out.println("Enter the vinculation month");
			int vinculationMonth = scanner.nextInt();

			System.out.println("Enter the vinculation year");
			int vinculationYear = scanner.nextInt();

			System.out.println("Enter\n1. STANDARD User\n2. PREMIUM User");
			int type = scanner.nextInt();

			if (controller.registerUser(user_name, id, vinculationDay, vinculationMonth, vinculationYear, type)) {
				System.out.println("User registered successfully. \nRegistered users are: ");
				System.out.println(controller.getUserList());
			} else {
				System.out.println("Error, please try again");
			}
		}


		public void consultUser () {
			System.out.println(controller.getUserList());
		}


		public void registerBiblioProducts() {
			int bookGenre = 0;
			String book_review = "";
			int magazineGenre = 0;
			String emision_periodicity = "";
		
			System.out.println("Enter the information for the product to register");
		
			// Clearing the buffer
			scanner.nextLine();
		
			System.out.println("Name");
			String product_name = scanner.nextLine();
		
			System.out.println("Enter what you want to register:\n1. Book\n2. Magazine");
			int biblio_product = scanner.nextInt();
		
			scanner.nextLine();
		
			if (biblio_product == 1) {
				System.out.println("Enter the genre of the book:\n1. SCIENCE FICTION\n2. FANTASY\n3. HISTORICAL NOVEL");
				bookGenre = scanner.nextInt();
		
				scanner.nextLine();
		
				System.out.println("Write a short review of the book");
				book_review = scanner.nextLine();
			} else {
				System.out.println("Enter the genre of the magazine:\n1. VARIETIES\n2. DESIGN\n3. SCIENTIFIC");
				magazineGenre = scanner.nextInt();
		
				scanner.nextLine();
		
				System.out.println("Emision periodicity (DAILY, WEEKLY, MONTHLY, YEARLY)");
				emision_periodicity = scanner.nextLine();
			}
		
			System.out.println("Number of pages");
			int pages_number = scanner.nextInt();
		
			System.out.println("Enter the publication date");
			System.out.println("Day");
			int publicationDay = scanner.nextInt();
		
			System.out.println("Month");
			int publicationMonth = scanner.nextInt();
		
			System.out.println("Year");
			int publicationYear = scanner.nextInt();
		
			System.out.println("Product cost");
			double product_cost = scanner.nextDouble();
		
			scanner.nextLine();
			System.out.println("URL");
			String product_url = scanner.nextLine();
		
			if (controller.registerBiblioProducts(product_name, biblio_product, bookGenre, book_review, magazineGenre, emision_periodicity, pages_number, publicationDay, publicationMonth, publicationYear, product_cost, product_url)) {
				System.out.println("Bibliographic product registered successfully");
				System.out.println(controller.getProductList());
			} else {
				System.out.println("Error, please try again");
			}
		}
		
		public void consultBiblioproducts () {
			System.out.println(controller.getProductList());
		}


		public void modifyBiblioProducts() {
			String product_name = "";
			int pages_number = 0;
			String product_url = "";
			double product_cost = 0;
		
			System.out.println("Enter which product you want to modify:");
			System.out.println(controller.getProductList());
			int product_selection = scanner.nextInt();
		
			System.out.println("Choose one of the options to modify:");
			System.out.println("\n1. Name\n2. Pages Number\n3. URL\n4. Cost");
			int product_attribute = scanner.nextInt();
		
			scanner.nextLine();
		
			if (product_attribute == 1) {
				System.out.println("Enter the new name:");
				product_name = scanner.nextLine();
			} else if (product_attribute == 2) {
				System.out.println("Enter the new number of pages:");
				pages_number = scanner.nextInt();
			} else if (product_attribute == 3) {
				scanner.nextLine();
				System.out.println("Enter the new URL:");
				product_url = scanner.nextLine();
			} else if (product_attribute == 4) {
				System.out.println("Enter the new cost:");
				product_cost = scanner.nextDouble();
			} else {
				System.out.println("ERROR");
			}
		
			if (controller.modifyBiblioproducts(product_selection, product_attribute, product_name, pages_number, product_url, product_cost)) {
				System.out.println("Modification successful");
				System.out.println(controller.getProductModified(product_selection));
			} else {
				System.out.println("Error in modification");
			}
		}
		

		public void removeBiblioProducts() {
			System.out.println("Choose the product to delete:");
			String query = controller.getProductList();
			System.out.println(query);
			int index = scanner.nextInt();
		
			if (controller.removeProducts(index - 1)) {
				System.out.println("Product successfully deleted");
			} else {
				System.out.println("ERROR, the product could not be deleted");
			}
		}
		


		public void buyProducts() {
			String query = controller.getProductList();
			int option_buyProduct = 0;
		
			System.out.println("Select the user from whom you want to buy:");
			System.out.println(controller.getUserList());
			int option_User = scanner.nextInt();
		
			if (!query.equals("")) {
				System.out.println(query);
				System.out.println("Choose one of the options:");
				option_buyProduct = scanner.nextInt();
			} else {
				System.out.println("No products registered");
			}
		
			if (controller.buyProducts(query, option_User - 1, option_buyProduct - 1)) {
				System.out.println("Product purchased successfully");
				System.out.println(controller.invoice(option_User, option_buyProduct));
			} else {
				System.out.println("ERROR");
			}
		}
		

		public void showMatrix1() {

			String query = controller.getUserList();
			System.out.println(query);
		
			System.out.println("Choose the user whose library you want to view:");
			int choice = scanner.nextInt();
		
			String matrixOutput = controller.showMatrix(choice);
			System.out.println(matrixOutput);

			readSimulation(choice);
		
		}
		
		public void readSimulation(int choice) {
			int readDecision = 0;
			String bookId = "";
			int pagesCounter = 0;


			System.out.println("Do you want to have a reading session?\n1. Yes\n2. No");
			readDecision = scanner.nextInt();

			scanner.nextLine();
		
			if (readDecision == 1) {
		
				System.out.println("Type de Book ID");
				bookId = scanner.nextLine();

				System.out.println(controller.advertisement(choice));
		
				System.out.println("Welcome");

				System.out.println("Current page" + pagesCounter);
				
				String idFinder = controller.idFinder(bookId);
				System.out.println(idFinder);

				boolean flag = true;

				while (flag) {
					System.out.println("Enter:\n1. To go to the next page\n2. To go to the previous page\n3. Exit");
				int simulationCounter = scanner.nextInt();
			
				if (simulationCounter == 1 || simulationCounter == 2) {
					pagesCounter++;
					System.out.println(" Current page " + pagesCounter);
				} else if (simulationCounter == 2) {
					pagesCounter--;
				} else {
					flag = false;
				  } 
				}
	
			} else {
				System.out.println("Exiting...");
			}
		}
		
	 }
		