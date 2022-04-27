package com.company.lockers;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class LockedME {
  public static final String filePath="D:\\Saima\\simplilearnProject\\CompanyLockerProject\\LockedMeFiles";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice;
		do {
          displayMenu();
          System.out.println("Enter Your Choice");
          Scanner scanner=new Scanner(System.in);
  		  choice=Integer.parseInt(scanner.nextLine());
  		  
  		  switch(choice) {
		  		 case 1:displayFile();
		  		         break;
		  		 case 2:createFile();
			         break;
		  		 case 3:deleteFile();
			         break;
		  		 case 4:searchFile();
			         break;
		  		 case 5:System.exit(0);
			         break;
			      default: 
  		  }
		}while(choice>0);
	}

	public static void displayMenu() {
		System.out.println("*****************************************************************");
		System.out.println("*********Welcome To Company Locker : LockedMe.com****************");
		System.out.println("****Developer's Name : SAIMA IDRIS*******************************");
		System.out.println("*****************************************************************");
		System.out.println("\t\t 1. Display All Files ");
		System.out.println("\t\t 2. Create Files ");
		System.out.println("\t\t 3. Delete Files ");
		System.out.println("\t\t 4. Seach Files");
		System.out.println("\t\t 5. EXIT");
		System.out.println("*****************************************************************");
		
	}
	
	public static void displayFile() {
	try {	
		File[] listOfFiles=new File(filePath).listFiles();
		for(File file:listOfFiles) {
			System.out.println(file.getName());
		}
	}catch(Exception e){
		System.out.println("Some Error Occured");
	}
	}
	
	public static void createFile() {
		try {	
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the FileName");
			String fileName=scanner.nextLine();
			System.out.println("Enter Number of lines You want to write in File.");
			int lines=Integer.parseInt(scanner.nextLine());
			FileWriter fw=new FileWriter(filePath+"\\"+fileName);
			for(int i=1;i<=lines;i++) {
				System.out.println("Enter Line Number :: "+i);
				fw.write(scanner.nextLine()+"\n");
			}
			System.out.println("File Created SuccessFully.");
			fw.close();
		}catch(Exception e){
			System.out.println("Some Error Occured");
		}
	}
	
	public static void deleteFile() {
		try {	
			Scanner scanner=new Scanner(System.in);
			System.out.println("Enter the FileName of File To Delete");
			String fileName=scanner.nextLine();
			File file=new File(filePath+"\\"+fileName);
			
			if(file.exists()) {
				file.delete();
				System.out.println("FIle Deleted Successfully");
			}else {
		        System.out.println("File Does Not Exist");
			}	
		}catch(Exception e){
			System.out.println("Some Error Occured");
		}
	}
	
	public static void searchFile() {
	try {	
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the FileName");
		String fileName=scanner.nextLine();
		File file=new File(filePath+"\\"+fileName);
		
		if(file.exists()) {
			
			System.out.println("File is available");
		}else {
	        System.out.println("File is not available");
		}	
	}catch(Exception e){
		System.out.println("Some Error Occured");
	}
	}
}
