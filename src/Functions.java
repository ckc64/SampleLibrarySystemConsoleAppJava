
import java.io.*;
import java.util.*;
import java.text.*;

public class Functions {
	private static String bookInfo[];
	private static String bookName,bookID,bookDateOfRegistered;
	
	private static String studIDnum,studName,studContactNum,studEmailAddress,studCourse,studYearLevel,studDateRegistered;
	private static String StudentInfo[];
	
	public static BufferedReader bufferedReader()throws IOException {
		return new BufferedReader(new InputStreamReader(System.in));
	}
	public static PrintWriter printWriter(File fileName)throws IOException {
		return new PrintWriter(new FileWriter(fileName,true));
	}
	public static File file(String fileDir)throws IOException {
		return new File(fileDir);
	}
	public static Date dateTime() {
		return new Date();
	}

	public static BufferedWriter bufferedWriter(File fileName)throws IOException {
		return new BufferedWriter(new FileWriter(fileName,true));
	}
	public static BufferedReader txtFileReader(String fileName)throws IOException {
		return new BufferedReader(new FileReader(fileName));
	}
	
	
	//-----------------------BOOK FUNCTIONS-------------------------------------------------------
	

	
	public static String getBookRecord(String idNum) {
		String bookRecord="D:\\Java Eclipse Programs\\LibrarySystemFinal\\database\\books\\"+idNum+".txt";
		return bookRecord;
	}
	
	public static String getAllBooksRecord(){
		
		String allBooksRecord="D:\\Java Eclipse Programs\\LibrarySystemFinal\\database\\BooksRecord.txt";
		return allBooksRecord;
	}
	
	
	public static String getDate() {
		String currDate;
		
		Date currDateTime=new Date();
		DateFormat dateFormat=new SimpleDateFormat("MM-DD-yyyy hh:mm:ss a");
		currDate=dateFormat.format(currDateTime);
		
		return currDate;
	}
	
	public static void createAbookFileData(String BookID,String BookName,String dateRegistered,String categ){
		try {
			PrintWriter print=printWriter(file(getBookRecord(BookID.toUpperCase())));
			print.println(BookID.toUpperCase()+"/"+BookName.toUpperCase()+"/"+categ+"/"+dateRegistered);
			
			print.close();
		}catch(Exception err){
			System.out.println("Create New Book File Error : "+err.getMessage());
		}
		
	}
	
	public static boolean ifBookExist(String idNum) {
		try {
			if(file(getBookRecord(idNum)).exists()) {
				return true;
			}else {
				return false;	
			}
	
		}catch(Exception err){
			System.out.println("File Exist : "+err.getMessage());
		}
		return false;
		
	}
		
	public static int getNumberOfRows(String fileName)throws IOException {
		BufferedReader read= txtFileReader(fileName);
		int countRow=0;
		String line;
			while((line=read.readLine())!=null) {
				countRow++;
			}
			return countRow;
	}
	
	public static void searchByName(String srchName) {
		try {	
			
			BufferedReader read=txtFileReader(getAllBooksRecord());
			String line,bookCateg;
			//String bookName,bookID,bookDateOfRegistered;
			System.out.println("************************************************");
			System.out.println("*      GENERATING BOOK "+srchName+" RECORDS    *");
			System.out.println("************************************************");
			System.out.println("________________________________________________");
			System.out.println("BOOK NUMBER | BOOK NAME | BOOK DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				while((line=read.readLine())!=null) {
					
					bookInfo=line.split(",");
					bookID=bookInfo[0];
					bookName=bookInfo[1];
					bookCateg=bookInfo[2];
					bookDateOfRegistered=bookInfo[3];
					if(bookName.equalsIgnoreCase(srchName)) {
						System.out.println(bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateOfRegistered); 
					}else if(srchName.equalsIgnoreCase("")) {
						System.out.println("NO RECORDS");
					    BookMethods.bookSearchMenu();
					}
				}
				System.out.println();
				read.close();
			
		}catch(Exception ex) {
			System.out.println("ERROR ON SEARCH BY NAME : "+ex.getMessage());
		}
		
	}
	
	public static void searchByLetter(String srchLetter) {
		
		try {
			BufferedReader read=Functions.txtFileReader(Functions.getAllBooksRecord());
			String line="";	
			//String bookName,bookID,bookDateOfRegistered;
			System.out.println("************************************************");
			System.out.println("*  GENERATING BOOKS WITH "+srchLetter.toUpperCase()+" RECORD  *");
			System.out.println("************************************************");
			System.out.println("________________________________________________");
			System.out.println("BOOK NUMBER | BOOK NAME | BOOK DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			while((line=read.readLine())!=null) {
				char srchLetterFirstLetter,bookNameFirstLetter;
				bookInfo=line.split(",");
				bookID=bookInfo[0];
				bookName=bookInfo[1];
				bookDateOfRegistered=bookInfo[2];
				
				srchLetterFirstLetter=srchLetter.charAt(0);
				bookNameFirstLetter=bookName.charAt(0);
				
				if(Character.toLowerCase(bookNameFirstLetter)==Character.toLowerCase(srchLetterFirstLetter)) {
					System.out.println(bookID+"|"+bookName+"|"+bookDateOfRegistered);
				}
			}
			System.out.println();
			read.close();
		
	   }catch(Exception ex) {
		   System.out.println("ERROR ON SEARCH LETTER : "+ex.getMessage());
	   }
	}
	
	public static void readOneTextFile(String srchID){
		try {
			
			BufferedReader read=txtFileReader(getBookRecord(srchID.toUpperCase()));
			
			System.out.println("***************************************************************");
			System.out.println("     GENERATING BOOK "+srchID.toUpperCase()+" RECORDS          ");
			System.out.println("***************************************************************");
			System.out.println("BOOK NUMBER | BOOK NAME |       CATEGORY      | BOOK DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				String line,bookCateg;
				while((line=read.readLine())!=null) {
//				String BookInfo[] = line.split("/");
//						bookID=BookInfo[0];
//						bookName=BookInfo[1];
//						bookCateg=BookInfo[2];
//						bookDateOfRegistered=BookInfo[3];
//						
//						System.out.println(bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateOfRegistered);
					System.out.println(line);
					}
							System.out.println();
						read.close();
		}catch(Exception ex) {
			System.out.println("ERROR ON READ BOOK RECORD : "+ex.getMessage());
			BookMethods.bookSearchMenu();
		}
		
	}
	
	public static void readBookRecords() {
		try {
			
			BufferedReader read=txtFileReader(getAllBooksRecord());
					String bookID,bookName,bookDateRegistered,bookCateg;			
				String line;
				
				System.out.println("*******************************************");
				System.out.println("*        GENERATING BOOK RECORDS          *");
				System.out.println("*******************************************");
				System.out.println("_____________________________________________________________________________");
				System.out.println("BOOK NUMBER |     BOOK NAME      |       CATEGORY      | BOOK DATE REGISTERED");
				System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
					while((line=read.readLine())!=null) {
					String BookInfo[] = line.split(",");
							bookID=BookInfo[0];
							bookName=BookInfo[1];
							bookCateg=BookInfo[2];
							bookDateRegistered=BookInfo[3];
							
							System.out.println(bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateRegistered);
						}
				System.out.println();
				read.close();
		}catch(Exception ex) {
			System.out.println("ERROR ON READ ALL BOOK RECORDS : "+ex.getMessage());
		}
		
	}

	public static void editRecordAllFiles(String AllfilePath, String oldString, String newString)
	{
		File fileToBeModified = new File(AllfilePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	}

	public static void editRecord(String filePath, String oldString, String newString)
	{
		File fileToBeModified = new File(filePath);
		
		String oldContent = "";
		
		BufferedReader reader = null;
		
		FileWriter writer = null;
		
		try 
		{
			reader = new BufferedReader(new FileReader(fileToBeModified));
			
			//Reading all the lines of input text file into oldContent
			
			String line = reader.readLine();
			
			while (line != null) 
			{
				oldContent = oldContent + line + System.lineSeparator();
				
				line = reader.readLine();
			}
			
			//Replacing oldString with newString in the oldContent
			
			String newContent = oldContent.replaceAll(oldString, newString);
			
			//Rewriting the input text file with newContent
			
			writer = new FileWriter(fileToBeModified);
			
			writer.write(newContent);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try 
			{
				//Closing the resources
				
				reader.close();
				
				writer.close();
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
	

		
	}

	public static void displayByCategory(String srchCateg) {
		
		try {
			
			BufferedReader read=Functions.txtFileReader(Functions.getAllBooksRecord());
			String line="",bookCateg,srchLetter;	
			//String bookName,bookID,bookDateOfRegistered;
			System.out.println("************************************************");
			System.out.println("*  GENERATING BOOKS WITH "+srchCateg.toUpperCase()+" RECORD  *");
			System.out.println("************************************************");
			System.out.println("____________________________________________________________________");
			System.out.println("BOOK NUMBER | BOOK NAME |       CATEGORY      | BOOK DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
			while((line=read.readLine())!=null) {
				
				bookInfo=line.split(",");
				bookID=bookInfo[0];
				bookName=bookInfo[1];
				bookCateg=bookInfo[2];
				bookDateOfRegistered=bookInfo[3];
				
				//BookMethods.categoryList(srchCateg);
				if(srchCateg.equalsIgnoreCase(bookCateg)) {
					
					System.out.println(bookID+" | "+bookName+" | "+bookCateg+" | "+bookDateOfRegistered);
				}
			}
			System.out.println();
			read.close();
			
			
		}catch(Exception ex) {
			System.out.println("ERROR MESSAGE ON DISPLAYING CATEGORY : "+ex.getMessage());
		}
		
	}
	
	//-----------------------END OF BOOK FUNCTIONS-------------------------------------------------------
	
	//-----------------------STUDENT FUNCTIONS-----------------------------------------------------------
	
	
	public static String getAllStudentsRecord(){
		
		String allStudentsRecord="D:\\Java Eclipse Programs\\LibrarySystemFinal\\database\\StudentsRecord.txt";
		return allStudentsRecord;
	}
	public static String getStudentsRecord(String idNum){
		
		String StudentsRecord="D:\\Java Eclipse Programs\\LibrarySystemFinal\\database\\students\\"+idNum+".txt";
		return StudentsRecord;
	}
	
	public static void createAStudentFileData(String studIDnum,String studName,String studContactNum,String studEmailAddress,
			String studCourse,String studYearLevel,String dateRegistered){
		
		try {
			PrintWriter print=printWriter(file(getStudentsRecord(studIDnum.toUpperCase())));
			print.println(studIDnum.toUpperCase()+"/"+studName.toUpperCase()+"/"+studCourse.toUpperCase()+
					"/"+studYearLevel.toUpperCase()+""
					+ "/"+studContactNum.toUpperCase()+"/"+studEmailAddress.toUpperCase()+"/"+dateRegistered.toUpperCase());
			
			print.close();
		}catch(Exception err){
			System.out.println("Create New File Error : "+err.getMessage());
		}
		
	}
	
	public static boolean ifStudentExist(String idNum) {
		try {
			if(file(getStudentsRecord(idNum)).exists()) {
				return true;
			}else {
				return false;	
			}
	
		}catch(Exception err){
			System.out.println("File Exist : "+err.getMessage());
		}
		return false;
		
	}

	public static void searchStudentByLetter(String srchLetter) {
		
		try {
			BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
			String line="";	
			System.out.println("**********************************************************************************************************************");
			System.out.println("*                            GENERATING STUDENT RECORDS WITH "+srchLetter.toUpperCase()+"                            *");
			System.out.println("**********************************************************************************************************************");
			System.out.println("___________________________________________________________________________________________________________________________________________________");
			System.out.println("ID NUMBER |      NAME      |       COURSE      |      YEAR LEVEL      |      CONTACT NUMBER      |       EMAIL ADDRESS       |      DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				while((line=read.readLine())!=null) {
					char srchLetterFirstLetter,studNameFirstLetter;
						StudentInfo=line.split(",");
						studIDnum=StudentInfo[0];
						studName=StudentInfo[1];
						studCourse=StudentInfo[2];
						studYearLevel=StudentInfo[3];
						studContactNum=StudentInfo[4];
						studEmailAddress=StudentInfo[5];
						studDateRegistered=StudentInfo[6];
						
						srchLetterFirstLetter=srchLetter.charAt(0);
						studNameFirstLetter=studName.charAt(0);
						if(Character.toLowerCase(studNameFirstLetter)==Character.toLowerCase(srchLetterFirstLetter)) {
						System.out.println(studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
								"      |      "+studEmailAddress+"      |      "+studDateRegistered);
						}
						
					}
						System.out.println();
						read.close();
		
	   }catch(Exception ex) {
		   System.out.println("ERROR ON SEARCH LETTER : "+ex.getMessage());
	   }
	}
	
	public static void searchStudentByName(String srchName) {
		try {	
			
			BufferedReader read=txtFileReader(getAllStudentsRecord());
			String line;
			
			System.out.println("**********************************************************************************************************************");
			System.out.println("*                            GENERATING STUDENT RECORDS WITH "+srchName.toUpperCase()+"                              *");
			System.out.println("**********************************************************************************************************************");
			System.out.println("___________________________________________________________________________________________________________________________________________________");
			System.out.println("ID NUMBER |      NAME      |       COURSE      |      YEAR LEVEL      |      CONTACT NUMBER      |       EMAIL ADDRESS       |      DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				while((line=read.readLine())!=null) {
					
						StudentInfo=line.split(",");
						studIDnum=StudentInfo[0];
						studName=StudentInfo[1];
						studCourse=StudentInfo[2];
						studYearLevel=StudentInfo[3];
						studContactNum=StudentInfo[4];
						studEmailAddress=StudentInfo[5];
						studDateRegistered=StudentInfo[6];
						
						
						if(studName.equalsIgnoreCase(srchName.toUpperCase())) {
							
								System.out.println(studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
								"      |      "+studEmailAddress+"      |      "+studDateRegistered);
								
					}
//						else if(srchName.equalsIgnoreCase("")) {
//							System.out.println("-----------------------ERROR - DONT LEAVE BLANK-----------------------");
//							StudentMethods.studentSearchMenu();
//						}
						
					}
						System.out.println();
						read.close();
			
		}catch(Exception ex) {
			System.out.println("ERROR ON SEARCH BY NAME : "+ex.getMessage());
		}
	}

	public static void searchStudentByID(String srchID) {
		try {	
			
			BufferedReader read=txtFileReader(getStudentsRecord(srchID));
			String line;
			
			System.out.println("**********************************************************************************************************************");
			System.out.println("*                            GENERATING STUDENT RECORDS WITH "+srchID.toUpperCase()+"                                *");
			System.out.println("**********************************************************************************************************************");
			System.out.println("___________________________________________________________________________________________________________________________________________________");
			System.out.println("ID NUMBER |      NAME      |       COURSE      |      YEAR LEVEL      |      CONTACT NUMBER      |       EMAIL ADDRESS       |      DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				while((line=read.readLine())!=null) {
					
						StudentInfo=line.split("/");
						studIDnum=StudentInfo[0];
						studName=StudentInfo[1];
						studCourse=StudentInfo[2];
						studYearLevel=StudentInfo[3];
						studContactNum=StudentInfo[4];
						studEmailAddress=StudentInfo[5];
						studDateRegistered=StudentInfo[6];
						
						System.out.println(studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
								"      |      "+studEmailAddress+"      |      "+studDateRegistered);
						System.out.println(line);
						
					}
						System.out.println();
						read.close();
			
		}catch(Exception ex) {
			System.out.println("ERROR ON SEARCH BY ID : "+ex.getMessage());
		}
	}

	public static void readOneStudentTextFile(String srchID) {
		try {
			
			BufferedReader read=txtFileReader(getStudentsRecord(srchID));
			
			String line;
			
			System.out.println("**********************************************************************************************************************");
			System.out.println("*                             GENERATING STUDENT RECORDS WITH "+srchID.toUpperCase()+"                               *");
			System.out.println("**********************************************************************************************************************");
			System.out.println("___________________________________________________________________________________________________________________________________________________");
			System.out.println("ID NUMBER |      NAME      |       COURSE      |      YEAR LEVEL      |      CONTACT NUMBER      |       EMAIL ADDRESS       |      DATE REGISTERED");
			System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
				while((line=read.readLine())!=null) {
				
					
//						StudentInfo=line.split("/");
//						studIDnum=StudentInfo[0];
//						studName=StudentInfo[1];
//						studCourse=StudentInfo[2];
//						studYearLevel=StudentInfo[3];
//						studContactNum=StudentInfo[4];
//						studEmailAddress=StudentInfo[5];
//						studDateRegistered=StudentInfo[6];
						
						
						
						System.out.println(line);
						
						
						
					}
						System.out.println();
						read.close();
		}catch(Exception ex) {
			System.out.println("ERROR ON READ STUDENT RECORD : "+ex.getMessage());
		}
		
	}


}

