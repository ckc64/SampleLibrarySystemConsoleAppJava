import java.io.BufferedReader;
import java.io.File;
import java.io.PrintWriter;

import javax.print.attribute.standard.MediaSize.Other;


public class BookMethods {
	private static String bookName;
	
	
	public static void addBook(){
			String bookIDNumber,bookTitle,bookCategory;
		try {
			
			BufferedReader in=Functions.bufferedReader();
			File file=Functions.file(Functions.getAllBooksRecord());
			PrintWriter print=Functions.printWriter(file);
			System.out.println("*******************************************");
			System.out.println("*                 ADD BOOK                *");
			System.out.println("*******************************************");
			System.out.print("\nBOOK NUMBER : ");
			bookIDNumber=in.readLine();
				if(Functions.ifBookExist(bookIDNumber)) {
					System.out.println("ID NUMBER "+bookIDNumber.toUpperCase()+" IS ALREADY EXIST\n");
				}else{
					
//					000—Computer science, information and general works
//					100—Philosophy and psychology
//					200—Religion
//					300—Social Sciences
//					400—Language
//					500—Science
//					600—Technology and applied science
//					700—Arts and recreation
//					800—Literature
//					900—History and geography
					
					System.out.print("BOOK TITLE  :");
					bookTitle=in.readLine();
					
					displayCategoryList();
					System.out.print("CATEGORY NUMBER : ");
					bookCategory=in.readLine();
					
					print.println(bookIDNumber.toUpperCase()+","+bookTitle.toUpperCase()+","+categoryList(bookCategory)+","+Functions.getDate());
					Functions.createAbookFileData(bookIDNumber, bookTitle,Functions.getDate(),categoryList(bookCategory));
					System.out.println("");
					System.out.println("---------------BOOK DATA SAVED---------------");
					System.out.println("");
					print.close();
				}
		}catch(Exception ex) {
			System.out.println("ADD BOOK ERROR : "+ex.getMessage());
		}
			
	}

	public void viewAllBooks(){
		Functions.readBookRecords();
	}
	public static void displayCategoryList() {
		System.out.println("|**************************************************************|");
		System.out.println("|*                        LIST OF CATEGORY                    *|");
		System.out.println("|**************************************************************|");
		System.out.println("|CATEGORY #|               CATEGORY NAME                       |");
		System.out.println("|--------------------------------------------------------------|");
		System.out.println("|   000    | COMPUTER SCIENCE INFORMATION AND GENERAL WORKS    |");
		System.out.println("|   100    | PHILOSOPHY AND PSYCHOLOGY                         |");
		System.out.println("|   200    | RELIGION                                          |");
		System.out.println("|   300    | SOCIAL SCIENCES                                   |");
		System.out.println("|   400    | LANGUAGE                                          |");
		System.out.println("|   500    | SCIENCE                                           |");
		System.out.println("|   600    | TECHONOLOGY AND APPLIED SCIENCE                   |");
		System.out.println("|   700    | ARTS AND RECREATION 800-LITERATURE                |");
		System.out.println("|   800    | LITERATURE                                        |");
		System.out.println("|   900    | HISTORY AND GEOGRAPHY                             |");
		System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
	}
	public void BookCategoryMenu() {
		try {
			BufferedReader in=Functions.bufferedReader();
			String selectOption;
			do {
				
				System.out.println("*******************************************");
				System.out.println("*WELCOME TO IDONOTREADBOOKS LIBRARY SYSTEM*");
				System.out.println("*******************************************");
				System.out.println("--------------SELECT OPTION----------------");
				System.out.println("| [A].ADD CATEGORY 		[C].BOOK TO MENU  |");
				System.out.println("| [B].VIEW ALL CATEGORY [X].EXIT          |");
				System.out.println("-------------------------------------------");
				System.out.print("SELECT : ");
				selectOption=in.readLine();
				
				if(selectOption.equalsIgnoreCase("a")) {
					
				}else if(selectOption.equalsIgnoreCase("b")){
					
				}else if(selectOption.equalsIgnoreCase("c")){
					OtherMethods.bookMenu();
				}else if(selectOption.equalsIgnoreCase("x")){
					System.exit(0);
				}else {
					System.out.println("INVALID INPUT....");
				}
				
			}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("c")
					|| !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("X"));
				
			
			
		}catch(Exception ex) {
			System.out.println("ERROR ADD CATEGORY : "+ex.getMessage());
		}
		
	}
	

	//---BOOK FUNCTIONS
	public static void searchByCateg() {
		try {
			BufferedReader in=Functions.bufferedReader();
			String srchCateg;
			displayCategoryList();
			System.out.println("\nIF CATEGORY IS NOT ON THE LIST , ENTER THE CATEGORY NAME ");
			System.out.println("*RECOMMENDED THE OTHER SEARCH TYPE IF YOU CANT REMEMBER THE CATEGORY*");
			System.out.println("-------------------------------------------------------------------");
			System.out.print("\nENTER A CATEGORY : ");
			srchCateg=in.readLine();
			Functions.displayByCategory(BookMethods.categoryList(srchCateg));
			
		}catch(Exception ex) {
			System.out.println("Search by letter : "+ex.getMessage());
		}
	}
	public static void searchByLetter() {
		
		try {
			BufferedReader in=Functions.bufferedReader();
			String letterSrch;
			
			System.out.print("ENTER A LETTER : ");
			letterSrch=in.readLine();
			Functions.searchByLetter(letterSrch);
			
		}catch(Exception ex) {
			System.out.println("Search by letter : "+ex.getMessage());
		}
		
	}
	public static void searchByName() {
		try {

			BufferedReader in=Functions.bufferedReader();
			
			String srchName,yesno;
			
			System.out.print("ENTER BOOK NAME : ");
			srchName=in.readLine();
			
			Functions.searchByName(srchName);
				
			do {
				String line="";
				String StudBookInfo [],bookID,bookName,bookCateg;
				BufferedReader read=Functions.txtFileReader(Functions.getAllBooksRecord());
			
				System.out.println("DO YOU WANT TO EDIT ?");
				System.out.println("[Y].YES        [N].NO");
				System.out.print("SELECT : ");
				yesno=in.readLine();
					if(yesno.equalsIgnoreCase("y")) {
						while((line=read.readLine())!=null) {
							StudBookInfo=line.split(",");
							bookID=StudBookInfo[0];
							bookName=StudBookInfo[1];
							bookCateg=StudBookInfo[2];
						if(srchName.equalsIgnoreCase(bookName)) {
								OtherMethods.editMenu(bookID,bookID,bookName,bookCateg);
							}
							
						}
						read.close();
						break;
					}else if(yesno.equalsIgnoreCase("n")) {
						bookSearchMenu();
					}else {
						System.out.println("INVALID INPUT......");
					}
			}while(!yesno.equalsIgnoreCase("y")||!yesno.equalsIgnoreCase("n"));
			
		}catch(Exception err) {
			//System.out.println("Error on Search by Name : "+err.getMessage());
		}

	}
	public static void searchByID() {
		try {

			BufferedReader in=Functions.bufferedReader();
			
			String srchID,yesno;
			String bookInfo [],bookID,bookCateg;
			BufferedReader read=Functions.txtFileReader(Functions.getAllBooksRecord());
			String line;
			
			System.out.print("ENTER BOOK ID : ");
			srchID=in.readLine();
				if(Functions.ifBookExist(srchID)) {
					Functions.readOneTextFile(srchID);		
				}else {
					System.out.println(srchID+" DONT EXIST");
					System.out.println("DO YOU WANT TO ADD ?");
					System.out.println("[Y].YES        [N].NO");
					System.out.print("SELECT : ");
					yesno=in.readLine();
					if(yesno.equalsIgnoreCase("y")) {
							addBook();
					}else if(yesno.equalsIgnoreCase("n")) {
						bookSearchMenu();
					}else {
						System.out.println("INVALID INPUT...");
						bookSearchMenu();
					}
				}
				
				do {
					
					System.out.println("DO YOU WANT TO EDIT ?");
					System.out.println("[Y].YES        [N].NO");
					System.out.print("SELECT : ");
					yesno=in.readLine();
						if(yesno.equalsIgnoreCase("y")) {
							
							while((line=read.readLine())!=null) {
								bookInfo=line.split(",");
								bookID=bookInfo[0];
								bookName=bookInfo[1];	
								bookCateg=bookInfo[2];
								OtherMethods.editMenu(srchID,srchID,bookName,bookCateg);	
								break;
							}
							
							read.close();
							break;
							
						}else if(yesno.equalsIgnoreCase("n")) {
							bookSearchMenu();
						}else {
							System.out.println("INVALID INPUT......");
						}
				}while(!yesno.equalsIgnoreCase("y")||!yesno.equalsIgnoreCase("n"));
			
		}catch(Exception err) {
			System.out.println("Error on Search by ID : "+err.getMessage());
		}

	}
	public static void bookSearchMenu() {
		
	    try {
				
				BufferedReader in=Functions.bufferedReader();
				String selectOption;
				//String BookRecord[] = new String[Functions.getNumberOfRows(Functions.getAllBooksRecord())];
				
				do {
					OtherMethods otherMethods=new OtherMethods();
					
						System.out.println("*******************************************");
						System.out.println("*               SEARCH MENU               *");
						System.out.println("*******************************************");
						System.out.println("--------------SELECT OPTION----------------");
						System.out.println("| [A].BY LETTER   [B].BY NAME             |");
						System.out.println("| [C].BY ID       [E].DISPLAY BY CATEGORY |");
						System.out.println("| [D].BACK TO BOOK MENU                   |");
						System.out.println("| [X].EXIT                                |");
						System.out.println("-------------------------------------------");
						System.out.print("SELECT : ");
						selectOption=in.readLine();
						System.out.print("\n");

							if(selectOption.equalsIgnoreCase("a")) {
									searchByLetter();
							}else if(selectOption.equalsIgnoreCase("b")){
									searchByName();
							}else if(selectOption.equalsIgnoreCase("c")){
									searchByID();
							}else if(selectOption.equalsIgnoreCase("d")){
									otherMethods.bookMenu();
							}else if(selectOption.equalsIgnoreCase("e")){
									searchByCateg();
							}else if(selectOption.equalsIgnoreCase("x")){
									System.out.println("GOODBYE AND THANK YOU!");
									System.exit(0);
							}else{
								System.out.println("INVALID INPUT........");
							}
					
				}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x")
						|| !selectOption.equalsIgnoreCase("d") || !selectOption.equalsIgnoreCase("c"));
				
			}catch(Exception err) {
				System.out.println("Error on Book Search Menu : "+err.getMessage());
			}
}
	public static String categoryList(String categ) {
	
		if(categ.equalsIgnoreCase("000")) {
			return "COMPUTER SCIENCE INFORMATION AND GENERAL WORKS";
		}else if(categ.equalsIgnoreCase("100")) {
			return "PHILOSOPHY AND PSYCHOLOGY";
		}else if(categ.equalsIgnoreCase("200")) {
			return "RELIGION";
		}else if(categ.equalsIgnoreCase("300")) {
			return "SOCIAL SCIENCES";
		}else if(categ.equalsIgnoreCase("400")) {
			return "LANGUAGE";
		}else if(categ.equalsIgnoreCase("500")) {
			return "SCIENCE";
		}else if(categ.equalsIgnoreCase("600")) {
			return "TECHNOLOGY AND APPLIED SCIENCE";
		}else if(categ.equalsIgnoreCase("700")) {
			return "ARTS AND CREATION";
		}else if(categ.equalsIgnoreCase("800")) {
			return "LITERATURE";
		}else if(categ.equalsIgnoreCase("900")) {
			return "HISTORY AND GEOGRAPHY";
		}else{
			return categ.toUpperCase();
		}
		
	}
	
}
