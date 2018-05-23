import java.io.*;
import java.util.*;
import java.util.function.Function;
import java.text.*;

public class BorrowedBooksMethod {
	private static String studIDnum,studName,studContactNum,studEmailAddress,studCourse,studYearLevel,studDateRegistered;
	private static String StudentInfo[];
	
	private static String bookInfo[];
	private static String bookName,bookID,bookDateOfRegistered,bookCateg;
	
	public static void addBorrowedBooks() {
		try {
			String bookNumber,studID;
			
			BufferedReader in=Functions.bufferedReader();
			
			
			System.out.println("************************************************");
			System.out.println("*              ADD BORROWED BOOKS              *");
			System.out.println("************************************************");
			
			System.out.print("\nBOOK NUMBER : ");
			bookNumber=in.readLine();
			if(!Functions.ifBookExist(bookNumber.toUpperCase())) {
				System.out.println("BOOK NUMBER DATA NOT FOUND PLEASE CHECK BOOK NUMBER");
				OtherMethods.bookMenu();
			}
			File file = new File(Functions.getBookRecord(bookNumber));	
			PrintWriter print = Functions.printWriter(file);
			BufferedReader bookread=Functions.txtFileReader(Functions.getAllBooksRecord());
			//String bookID,bookName,bookDateRegistered,bookCateg;			
				
				
				String lineBook;
				//String bookName,bookID,bookDateOfRegistered;
				System.out.println("************************************************");
				System.out.println("*      GENERATING BOOK "+bookNumber.toUpperCase()+" RECORDS    *");
				System.out.println("************************************************");
				System.out.println("_____________________________________________________________________________");
				System.out.println("BOOK NUMBER |     BOOK NAME      |       CATEGORY      | BOOK DATE REGISTERED");
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
					while((lineBook=bookread.readLine())!=null) {
						
						bookInfo=lineBook.split(",");
						bookID=bookInfo[0];
						bookName=bookInfo[1];
						bookCateg=bookInfo[2];
						bookDateOfRegistered=bookInfo[3];
						if(bookID.equalsIgnoreCase(bookNumber.toUpperCase())) {
							System.out.println(bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateOfRegistered); 
						}
					}
					System.out.println();
					bookread.close();
				
				
				System.out.print("\nID NUMBER OF BORROWER : ");
				studID=in.readLine();
				
				if(!Functions.ifStudentExist(studID.toUpperCase())) {
					System.out.println("STUDENT ID DATA NOT FOUND PLEASE CHECK STUDENT ID");
					OtherMethods.bookMenu();
				}
				
				BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
				String line="";
				while((line=read.readLine())!=null) {
					
					
					StudentInfo=line.split(",");
					studIDnum=StudentInfo[0];
					studName=StudentInfo[1];
					studCourse=StudentInfo[2];
					studYearLevel=StudentInfo[3];
					studContactNum=StudentInfo[4];
					studEmailAddress=StudentInfo[5];
					studDateRegistered=StudentInfo[6];
					
					if(studIDnum.equalsIgnoreCase(studID.toUpperCase())) {
					System.out.println(studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
							"      |      "+studEmailAddress+"      |      "+studDateRegistered);
					System.out.println("\nPROCESS DONE");
					print.println("\nBOOK IS BORROWED BY "+studName+" with ID of "+studID.toUpperCase()+" Date : "+Functions.getDate());
					break;
					}
					
				}
				
					
					//print.println("BOOK "+bookName+" with ID of "+bookID+" borrowed by "+studName+" with ID of "+studID+" Date : "+Functions.getDate());
					System.out.println();
					read.close();
					print.close();
					
		}catch(Exception ex) {
			System.out.println("BORROWED BOOKS ERROR : "+ex.getMessage());
		}
	}

	public static void addReturnedBooks() {
		
		try {
			String bookNumber,studID;
			
			BufferedReader in=Functions.bufferedReader();
			
			
			System.out.println("************************************************");
			System.out.println("*              ADD RETURNED BOOKS              *");
			System.out.println("************************************************");
			
			System.out.print("\nBOOK NUMBER : ");
			bookNumber=in.readLine();
			
			File file = new File(Functions.getBookRecord(bookNumber));	
			PrintWriter print = Functions.printWriter(file);
			BufferedReader bookread=Functions.txtFileReader(Functions.getAllBooksRecord());
			//String bookID,bookName,bookDateRegistered,bookCateg;			
				
				
				String lineBook;
				//String bookName,bookID,bookDateOfRegistered;
				System.out.println("************************************************");
				System.out.println("*      GENERATING BOOK "+bookNumber.toUpperCase()+" RECORDS    *");
				System.out.println("************************************************");
				System.out.println("_____________________________________________________________________________");
				System.out.println("BOOK NUMBER |     BOOK NAME      |       CATEGORY      | BOOK DATE REGISTERED");
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
					while((lineBook=bookread.readLine())!=null) {
						
						bookInfo=lineBook.split(",");
						bookID=bookInfo[0];
						bookName=bookInfo[1];
						bookCateg=bookInfo[2];
						bookDateOfRegistered=bookInfo[3];
						if(bookID.equalsIgnoreCase(bookNumber)) {
							System.out.println("\n"+bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateOfRegistered); 
						}
					}
					System.out.println();
					bookread.close();
				
				
				System.out.print("\nID NUMBER OF BORROWER : ");
				studID=in.readLine();
				BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
				String line="";
				while((line=read.readLine())!=null) {
					
					
					StudentInfo=line.split(",");
					studIDnum=StudentInfo[0];
					studName=StudentInfo[1];
					studCourse=StudentInfo[2];
					studYearLevel=StudentInfo[3];
					studContactNum=StudentInfo[4];
					studEmailAddress=StudentInfo[5];
					studDateRegistered=StudentInfo[6];
					
					if(studIDnum.equalsIgnoreCase(studID)) {
					System.out.println("\n"+studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
							"      |      "+studEmailAddress+"      |      "+studDateRegistered);
					System.out.println("\nPROCESS DONE");
					print.println("\nBOOK IS RETURNED BY "+studName+" with ID of "+studID.toUpperCase()+" Date : "+Functions.getDate());
					break;
					}
					
				}
				
					//print.println("BOOK "+bookName+" with ID of "+bookID+" borrowed by "+studName+" with ID of "+studID+" Date : "+Functions.getDate());
					System.out.println();
					read.close();
					print.close();
					
		}catch(Exception ex) {
			System.out.println("BORROWED BOOKS ERROR : "+ex.getMessage());
		}
		
		
	}
}
