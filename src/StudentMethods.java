import java.io.*;

public class StudentMethods {
	private static String studIDnum,studName,studContactNum,studEmailAddress,studCourse,studYearLevel;
	private static String StudentInfo[];
	
	public static void addStudents() {
		try {
			BufferedReader in=Functions.bufferedReader();
			System.out.println("************************************************");
			System.out.println("*                  ADD STUDENT                 *");
			System.out.println("************************************************");
			System.out.print("\nSTUDENT ID NUMBER : ");
			studIDnum=in.readLine();
			if(Functions.ifStudentExist(studIDnum.toUpperCase())) {
				System.out.println("ID NUMBER "+studIDnum.toUpperCase()+" IS ALREADY EXIST\n");
				
			}else{
				
				System.out.print("NAME OF STUDENT : ");
				studName=in.readLine();
				System.out.print("COURSE : ");
				studCourse=in.readLine();
				System.out.print("YEAR LEVEL : ");
				studYearLevel=in.readLine();
				System.out.print("CONTACT NUMBER : ");
				studContactNum=in.readLine();
				System.out.print("EMAIL ADDRESS : ");
				studEmailAddress=in.readLine();
				
				File fileName=Functions.file(Functions.getAllStudentsRecord());
				PrintWriter print=Functions.printWriter(fileName);
				
				print.println(studIDnum.toUpperCase()+","+studName.toUpperCase()+","+studCourse.toUpperCase()+","
				+studYearLevel.toUpperCase()+","+studContactNum.toUpperCase()+","+studEmailAddress.toUpperCase()+
				","+Functions.getDate());
				
				Functions.createAStudentFileData(studIDnum, studName, studContactNum, studEmailAddress, studCourse, 
						studYearLevel, Functions.getDate());
				
				System.out.println("");
				System.out.println("---------------STUDENT DATA SAVED---------------");
				System.out.println("");
				
				print.close();
			}
		}catch(Exception ex) {
			System.out.println("ERROR ON ADD STUDENTS : "+ex.getMessage());
		}
		
	}
	
	public static void viewAllStudents() {
			try {
			
				BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
									
					String line;
					
					System.out.println("**********************************************************************************************************************");
					System.out.println("*                                         GENERATING STUDENT RECORDS                                                 *");
					System.out.println("**********************************************************************************************************************");
					System.out.println("______________________________________________________________________________________________________________________");
					System.out.println("ID NUMBER |      NAME      |       COURSE      |      YEAR LEVEL      |      CONTACT NUMBER      |       EMAIL ADDRESS");
					System.out.println("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
						while((line=read.readLine())!=null) {
								StudentInfo=line.split(",");
								studIDnum=StudentInfo[0];
								studName=StudentInfo[1];
								studCourse=StudentInfo[2];
								studYearLevel=StudentInfo[3];
								studContactNum=StudentInfo[4];
								studEmailAddress=StudentInfo[5];
								
								System.out.println(studIDnum+" |      "+studName+"      |      "+studCourse+"      |      "+studYearLevel+"      |      "+studContactNum+
										"      |      "+studEmailAddress);
							}
						
						read.close();
					System.out.println();
					read.close();
			}catch(Exception ex) {
				System.out.println("ERROR ON READ ALL STUDENT RECORDS : "+ex.getMessage());
			}
		}

	public static void searchStudentNameByLetter() {
		try {
			BufferedReader in=Functions.bufferedReader();
			String letterSrch;
			
			System.out.print("ENTER A LETTER : ");
			letterSrch=in.readLine();
			Functions.searchStudentByLetter(letterSrch);
			
		}catch(Exception ex) {
			System.out.println("Search by letter : "+ex.getMessage());
		}
	}
	public static void studentSearchMenu() {
		 try {
				
				BufferedReader in=Functions.bufferedReader();
				String selectOption;
				
				do {
					OtherMethods otherMethods=new OtherMethods();
					
						System.out.println("*******************************************");
						System.out.println("*               SEARCH MENU               *");
						System.out.println("*******************************************");
						System.out.println("--------------SELECT OPTION----------------");
						System.out.println("| [A].BY LETTER     	  [B].BY NAME     |");
						System.out.println("| [C].BY ID         	  [X].EXIT        |");
						System.out.println("| [D].BACK TO STUDENT MENU                |");
						System.out.println("-------------------------------------------");
						System.out.print("SELECT : ");
						selectOption=in.readLine();
						System.out.print("\n");

							if(selectOption.equalsIgnoreCase("a")) {
									searchStudentNameByLetter();
							}else if(selectOption.equalsIgnoreCase("b")){
									searchStudentByName();
							}else if(selectOption.equalsIgnoreCase("c")){
								searchStudentByID();
							}else if(selectOption.equalsIgnoreCase("d")){
									otherMethods.studentMenu();
							}else if(selectOption.equalsIgnoreCase("x")){
									System.out.println("GOODBYE AND THANK YOU!");
									System.exit(0);
							}else{
								System.out.println("INVALID INPUT........");
							}
					
				}while(!selectOption.equalsIgnoreCase("a") || !selectOption.equalsIgnoreCase("b") || !selectOption.equalsIgnoreCase("x")
						|| !selectOption.equalsIgnoreCase("d") || !selectOption.equalsIgnoreCase("c"));
				
			}catch(Exception err) {
				System.out.println("Error on STUDENT Search Menu : "+err.getMessage());
			}
	}

	public static void searchStudentByName() {
		try {

			BufferedReader in=Functions.bufferedReader();
			
			String srchName,yesno;
			
			System.out.print("ENTER STUDENT NAME : ");
			srchName=in.readLine();
			Functions.searchStudentByName(srchName);
				
			do {
				String line="";
				
				BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
			
				System.out.println("DO YOU WANT TO EDIT ?");
				System.out.println("[Y].YES        [N].NO");
				System.out.print("SELECT : ");
				yesno=in.readLine();
					if(yesno.equalsIgnoreCase("y")) {
						while((line=read.readLine())!=null) {
							StudentInfo=line.split(",");
							studIDnum=StudentInfo[0];
							studName=StudentInfo[1];
							studCourse=StudentInfo[2];
							studYearLevel=StudentInfo[3];
							studContactNum=StudentInfo[4];
							studEmailAddress=StudentInfo[5];

						if(srchName.equalsIgnoreCase(studName) || srchName.equalsIgnoreCase(studCourse) ) {
								editStudentMenu(studIDnum, studIDnum, studName);
							}
							
						}
						read.close();
						break;
					}else if(yesno.equalsIgnoreCase("n")) {
							studentSearchMenu();
					}else {
						System.out.println("INVALID INPUT......");
					}
			}while(!yesno.equalsIgnoreCase("y")||!yesno.equalsIgnoreCase("n"));
			
		}catch(Exception err) {
			//System.out.println("Error on Search by Name : "+err.getMessage());
		}

	}
	

	public static void searchStudentByID() {
		try {

			BufferedReader in=Functions.bufferedReader();
			
			String srchID,yesno;
			
			BufferedReader read=Functions.txtFileReader(Functions.getAllStudentsRecord());
			String line;
			
			System.out.print("ENTER STUDENT ID : ");
			srchID=in.readLine();
				if(Functions.ifStudentExist(srchID)) {
					Functions.readOneStudentTextFile(srchID);		
				}else {
					System.out.println(srchID+" DONT EXIST");
					System.out.println("DO YOU WANT TO ADD ?");
					System.out.println("[Y].YES        [N].NO");
					System.out.print("SELECT : ");
					yesno=in.readLine();
					if(yesno.equalsIgnoreCase("y")) {
							addStudents();
					}else if(yesno.equalsIgnoreCase("n")) {
							studentSearchMenu();
					}else {
						System.out.println("INVALID INPUT...");
						studentSearchMenu();
							
					}
				}
				
				do {
					
					System.out.println("DO YOU WANT TO EDIT ?");
					System.out.println("[Y].YES        [N].NO");
					System.out.print("SELECT : ");
					yesno=in.readLine();
						if(yesno.equalsIgnoreCase("y")) {
							
							while((line=read.readLine())!=null) {
								StudentInfo=line.split(",");
								studIDnum=StudentInfo[0];
								studName=StudentInfo[1];
								studCourse=StudentInfo[2];
								studYearLevel=StudentInfo[3];
								studContactNum=StudentInfo[4];
								studEmailAddress=StudentInfo[5];
								
								editStudentMenu(srchID,srchID,studName );
							}
							
							read.close();
							break;
							
						}else if(yesno.equalsIgnoreCase("n")) {
							studentSearchMenu();
						}else {
							System.out.println("INVALID INPUT......");
						}
				}while(!yesno.equalsIgnoreCase("y")||!yesno.equalsIgnoreCase("n"));
			
		}catch(Exception err) {
			System.out.println("Error on Search by student id : "+err.getMessage());
		}

	}

	public static void editStudentMenu(String srchValue,String studID,String studName) {
		try {
			
			BufferedReader in=Functions.bufferedReader();
			String currWord,newWord;
			System.out.println("*******************************************");
			System.out.println("*                EDIT STUDENT             *");
			System.out.println("*******************************************");
			System.out.print("\nENTER WORD YOU WANT TO EDIT : ");
			currWord=in.readLine();
			
				if(currWord.equalsIgnoreCase(studID)) {
						System.out.println("\n"+currWord.toUpperCase()+" IS AN ID,YOU CAN'T EDIT ANY ID NUMBER\n");
						OtherMethods.studentMenu();
				}else{
					System.out.print("ENTER NEW WORD : ");
					newWord=in.readLine();
					Functions.editRecordAllFiles(Functions.getAllStudentsRecord(),currWord.toUpperCase(), newWord.toUpperCase());
					Functions.editRecord(Functions.getStudentsRecord(srchValue), currWord.toUpperCase(), newWord.toUpperCase());
					System.out.println("****************UPDATE SUCCESSFULLY****************\n");
				}
			
		}catch(Exception ex) {
			System.out.println("EDIT ERROR : "+ex.getMessage());
		}
	}
}
