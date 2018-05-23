import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.text.*;

public class OtherMethods {
	static BookMethods book = new BookMethods();
	public static void mainMenu() {
	
	
		try {
			BufferedReader in=Functions.bufferedReader();
			String selectOption;
			
			do{
				
					System.out.println("*******************************************");
					System.out.println("*WELCOME TO IDONOTREADBOOKS LIBRARY SYSTEM*");
					System.out.println("*               VERSION 1.0               *");
					System.out.println("*******************************************");
					System.out.println("--------------SELECT OPTION----------------");
					System.out.println("| [A].ADMINISTRATOR [B].STUDENT| [X].EXIT |");
					System.out.println("-------------------------------------------");
					System.out.print("SELECT : ");
					selectOption=in.readLine();
					System.out.print("\n");
						if(selectOption.equalsIgnoreCase("a")) {
							adminMenu();
							break;
						}else if(selectOption.equalsIgnoreCase("b")){
							studentLogin();
							break;
						}else if(selectOption.equalsIgnoreCase("x")){
							System.out.println("GOODBYE AND THANK YOU!");
							System.exit(0);
						}else{
							System.out.println("INVALID INPUT........");
						}
						
			}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x"));
			
		}catch(Exception err){
			System.out.println("Main Error Message : "+err.getMessage());
		}
	
	}
	public static void adminMenu() {

		try {
			
			BufferedReader in=Functions.bufferedReader();
			String selectOption;
			do {
					System.out.println("*******************************************");
					System.out.println("*            ADMINISTRATOR MENU           *");
					System.out.println("*******************************************");
					System.out.println("--------------SELECT OPTION----------------");
					System.out.println("| [A].BOOK 	            [B].STUDENT   |");
					System.out.println("| [C].BACK TO MAIN MENU     [X].EXIT      |");
					System.out.println("-------------------------------------------");
					System.out.print("SELECT : ");
					selectOption=in.readLine();
					System.out.print("\n");
						if(selectOption.equalsIgnoreCase("a")) {
								bookMenu();
						}else if(selectOption.equalsIgnoreCase("b")){
								studentMenu();
						}else if(selectOption.equalsIgnoreCase("c")){
								mainMenu();
						}else if(selectOption.equalsIgnoreCase("x")){
								System.out.println("GOODBYE AND THANK YOU!");
								System.exit(0);
						}else{
							System.out.println("INVALID INPUT........");
						}
				
			}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x"));
				
		}catch(Exception err) {
			System.out.println("Error on Admin Menu : "+err.getMessage());
		}
		
	}
	public static void bookMenu() {
		try {
			
			BufferedReader in=Functions.bufferedReader();
			String selectOption;
			
			do {

					System.out.println("*******************************************");
					System.out.println("*               BOOK MENU                 *");
					System.out.println("*******************************************");
					System.out.println("--------------SELECT OPTION-----------------");
					System.out.println("| [A].ADD BOOKS     	 [B].SEARCH BOOKS  |");
					System.out.println("| [C].VIEW ALL BOOKS 	 [X].EXIT          |");
					System.out.println("| [D].BACK TO ADMIN MENU      	           |");
					System.out.println("| [E].ADD BORROWED BOOKS 	          |");
					System.out.println("| [F].ADD RETURNED BOOKS 	          |");
					System.out.println("--------------------------------------------");
					System.out.print("SELECT : ");
					selectOption=in.readLine();
					System.out.print("\n");
						if(selectOption.equalsIgnoreCase("a")) {
								book.addBook();
						}else if(selectOption.equalsIgnoreCase("b")){
								book.bookSearchMenu();
						}else if(selectOption.equalsIgnoreCase("c")){
								book.viewAllBooks();
						}else if(selectOption.equalsIgnoreCase("e")){
							BorrowedBooksMethod.addBorrowedBooks();
						}else if(selectOption.equalsIgnoreCase("F")){
							BorrowedBooksMethod.addReturnedBooks();
						}else if(selectOption.equalsIgnoreCase("d")){
								adminMenu();
						}else if(selectOption.equalsIgnoreCase("x")){
								System.out.println("GOODBYE AND THANK YOU!");
								System.exit(0);
						}else{
							System.out.println("INVALID INPUT........");
						}
				
			}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x")
					|| !selectOption.equalsIgnoreCase("d") || !selectOption.equalsIgnoreCase("c"));
			
		}catch(Exception err) {
			System.out.println("Error on Book Menu : "+err.getMessage());
		}
	}
	public static void studentMenu() {
	try {
			
			BufferedReader in=Functions.bufferedReader();
			String selectOption;
			
			do {
					System.out.println("*******************************************");
					System.out.println("*               STUDENT MENU              *");
					System.out.println("*******************************************");
					System.out.println("--------------SELECT OPTION-----------------");
					System.out.println("| [A].ADD STUDENTS      [B].SEARCH STUDENTS|");
					System.out.println("| [C].VIEW ALL STUDENTS [X].EXIT           |");
					System.out.println("| [D].BACK TO ADMIN MENU                   |");
					System.out.println("--------------------------------------------");
					System.out.print("SELECT : ");
					selectOption=in.readLine();
				
						if(selectOption.equalsIgnoreCase("a")) {
								StudentMethods.addStudents();
						}else if(selectOption.equalsIgnoreCase("b")){
								StudentMethods.studentSearchMenu();
						}else if(selectOption.equalsIgnoreCase("c")){
								StudentMethods.viewAllStudents();
						}else if(selectOption.equalsIgnoreCase("d")){
								adminMenu();
						}else if(selectOption.equalsIgnoreCase("x")){
								System.out.println("GOODBYE AND THANK YOU!");
								System.exit(0);
						}else{
							System.out.println("INVALID INPUT........");
						}
				
			}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x")
					|| !selectOption.equalsIgnoreCase("d") || !selectOption.equalsIgnoreCase("c"));
		
		}catch(Exception err) {
			System.out.println("Error on Book Menu : "+err.getMessage());
		}
	}
	public static void studentLogin(){
		
		try {
			
			BufferedReader in=Functions.bufferedReader();
			String idNum;
			System.out.println("*******************************************");
			System.out.println("*WELCOME TO IDONOTREADBOOKS LIBRARY SYSTEM*");
			System.out.println("*******************************************");
			
		do {
			
				System.out.println("*******************************************");
				System.out.println("*           ENTER YOUR ID NUMBER          *");
				System.out.println("*******************************************");
				idNum = in.readLine();
				
				File fileName=Functions.file(Functions.getStudentsRecord(idNum.toUpperCase()));
				
				BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
				
				
				if(Functions.ifStudentExist(idNum.toUpperCase())) {
					PrintWriter print=Functions.printWriter(fileName);
					String line="",studID,studName,studCourse,studYear,studContactNum,studEmail;
					while((line=read.readLine())!=null) {
						String studInfo[]=line.split(",");
						studID=studInfo[0];
						studName=studInfo[1];
						studCourse=studInfo[2];
						studYear=studInfo[3];
						studContactNum=studInfo[4];
						studEmail=studInfo[5];
						if(idNum.equalsIgnoreCase(studID)) {
							System.out.println("------------------------------------------------------------------------------");
							System.out.println("ID NUMBER  : "+studID+"\t\tCONTACT NUMBER  : "+studContactNum);
							System.out.println("NAME       : "+studName+"\t\tEMAIL ADDRESS :"+studEmail);
							System.out.println("COURSE     : "+studCourse);
							System.out.println("YEAR LEVEL : "+studYear);
							
							print.println("\nDATE/TIME : "+Functions.getDate());
							System.out.println("------------------------------------------------------------------------------");
							print.close();
						}
					}

				}else{
					System.out.println("ID NUMBER : "+idNum.toUpperCase()+" DO NOT EXIST, CONTACT THE ADMINISTRATOR\n");
				}
			
				if(idNum.equalsIgnoreCase("x")) {
					adminMenu();
				}
				
				read.close();
			}while(!idNum.equalsIgnoreCase("x"));
			
		}catch(Exception ex) {
			System.out.println("LOGIN ERROR "+ex.getMessage());
		}	
	}

	public static void editMenu(String srchValue,String bookID,String bookName,String bookCateg) {
		try {
			
			BufferedReader in=Functions.bufferedReader();
			String currWord,newWord;
			System.out.println("*******************************************");
			System.out.println("*                EDIT BOOK                *");
			System.out.println("*******************************************");
			System.out.print("\nENTER WORD YOU WANT TO EDIT : ");
			currWord=in.readLine();
			
				if(currWord.equalsIgnoreCase(bookID)) {
						System.out.println("\n"+currWord.toUpperCase()+" IS AN ID,YOU CAN'T EDIT ANY ID NUMBER\n");
						bookMenu();
				}else if(currWord.equalsIgnoreCase(bookName) || currWord.equalsIgnoreCase(bookCateg)){
					System.out.print("ENTER NEW WORD : ");
					newWord=in.readLine();
					Functions.editRecordAllFiles(Functions.getAllBooksRecord(),currWord.toUpperCase(), newWord.toUpperCase());
					Functions.editRecord(Functions.getBookRecord(srchValue), currWord.toUpperCase(), newWord.toUpperCase());
					System.out.println("****************UPDATE SUCCESSFULLY****************\n");
				}else {
					System.out.print(currWord.toUpperCase()+" NOT FOUND");
				}
			
		}catch(Exception ex) {
			System.out.println("EDIT ERROR : "+ex.getMessage());
		}
	}
}


