package com.masai;

import java.util.Scanner;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

/**
 * Hello world!
 *
 */
public class App 
{
	
	static EntityManagerFactory emf = null;
	
	static {
		emf = Persistence.createEntityManagerFactory("studentConnect");
	}
	
	static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}

	
	static void insertStudent(Scanner sc) {
		
		System.out.print("Enter Student Roll No: ");
		int rollNo = Integer.parseInt(sc.nextLine());
		
		System.out.print("Enter Student Name: ");
		String name = sc.nextLine();
		
		System.out.print("Enter Student Marks: ");
		int marks = Integer.parseInt(sc.nextLine());
		
		Student student = new Student(rollNo, name, marks);
		
		EntityManager em = getEntityManager();
		
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		
		em.persist(student);
		
		et.commit();
		
		System.out.println("Student details has inserted.");
		
	 em.close();	
	}
	
	
	static void viewStudentByRollNo(Scanner sc) {
		
		System.out.print("Enter Student Roll No: ");
		int rollNo = Integer.parseInt(sc.nextLine());
		
        EntityManager em = getEntityManager();
		
	    Student student = em.find(Student.class,rollNo);
		
	    if(student==null) {
	    	System.out.println("Invalid Roll No");
	    }else {
	    	System.out.println(student);
	    }
	    
	   em.close();	
		
		
	}
	
	static void updateStudentByRollNo(Scanner sc) {
		
		System.out.print("Enter Student Roll No: ");
		int rollNo = Integer.parseInt(sc.nextLine());
		
        EntityManager em = getEntityManager();
		
	    Student student = em.find(Student.class,rollNo);
		
	    if(student==null) {
	    	System.out.println("Invalid Roll No");
	    	return;
	    }
	    
	    System.out.print("Enter Marks to Update: ");
	    int marks = Integer.parseInt(sc.nextLine());
	    
	    em.getTransaction().begin();
	    
	    student.setMarks(marks);
	    
	    em.getTransaction().commit();
	    
	    System.out.println(student.getName()+", Student marks has updated.");
	    
	   em.close();
		
		
		
	}
	
	static void deleteStudentByRollNo(Scanner sc) {
		
		System.out.print("Enter Student Roll No: ");
		int rollNo = Integer.parseInt(sc.nextLine());
		
        EntityManager em = getEntityManager();
		
	    Student student = em.find(Student.class,rollNo);
		
	    if(student==null) {
	    	System.out.println("Invalid Roll No");
	    	return;
	    }
	    
	    em.getTransaction().begin();
	    
	    em.remove(student);
	    
	    em.getTransaction().commit();
	    
	    System.out.println(student.getName()+", Student marks has deleted.");
	    
	   em.close();
		
		
		
	}
	
	
	
	
	
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
		
		int choice =0;
		
		do {
			System.out.println("1. Insert Student");
			System.out.println("2. View Student");
			System.out.println("3. Update Student");
			System.out.println("4. Delete Student");
			System.out.println("5. Get Student List");
			System.out.println("0. Exit");
			System.out.println("---------------------");
			System.out.print("Enter your choice: ");
			choice = Integer.parseInt(sc.nextLine());
			
			switch(choice){
			case 1: 
				 insertStudent(sc);
				break;
			case 2: 
				viewStudentByRollNo(sc);
				break;
			case 3: 
				updateStudentByRollNo(sc);
				break;
			case 4:
			    deleteStudentByRollNo(sc);
				break;
			case 5:
			    //getStudentList();
				break;
			case 0:
				 System.out.println("Thank  you for using");
				 break;
			default:
				System.out.println("Invalid Input");
				
			}
			
		}while(choice!=0);
		
		sc.close();
		
		
	}
    	
  }
