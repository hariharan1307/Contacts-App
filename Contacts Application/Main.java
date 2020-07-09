package com.ContactsApp;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.lang.NullPointerException;

public class Main
{
	private static MobilePhone mobile=new MobilePhone("My mobile");
	private static Scanner input=new Scanner(System.in);
	private static void addContacts()
	{
		System.out.println("Enter the Name: ");
		String Name=input.nextLine();//input.nextLine();
		System.out.println("Enter the Number: ");
		String Phone=input.nextLine();//input.nextLine();
		Contacts newContact=new Contacts(Name,Phone);
		if(mobile.addContact(newContact))
		{
			System.out.println(Name+ " was successfully added");
			return;
		}
		System.out.println("Contacts Already Exists");
		return;
		
	}
	private static  void searchContact()
	{
		int last;
		int first;
		System.out.println("Enter the Name: ");
		String Name=input.nextLine();//input.nextLine();
		if(mobile.searchContact(Name)==null)
		{
			System.out.println("Contact Does Not  Exists");
            return;
		}
		
		Contacts requiredContact=mobile.searchContact(Name);
		System.out.println("Name:" +requiredContact.getName()
		                   +" phone:" +requiredContact.getNumber() );
		
	}
	
	
	private static void removeContact()
	{
		System.out.println("Enter the Name: ");
		String Name=input.nextLine();//input.nextLine();
		Contacts removeContact=mobile.searchContact(Name);
		try
		{
			if(mobile.removeContact(removeContact))
			{
//				System.out.println(Name+" was successfully removed from your contacts");
				return;

			}
		System.out.println(Name+" does not exist in your contacts");
		return;
		}
		catch(NullPointerException n)
		{
			System.out.println("There are no entries in your contacts to remove");
		}
		

	}
	private static void updateContact()
	{
		System.out.println("Enter the Name: ");
		String oldName=input.nextLine();//input.nextLine();
		System.out.println("Enter the Number: ");
		String oldPhone=input.nextLine();//input.nextLine();
		Contacts oldContact=mobile.searchContact(oldName);
		if(oldContact==null)
		{
			System.out.println(oldName+" does not exist in your contacts");
			return;
		}
		System.out.println("Enter the Name: ");
		String newName=input.nextLine();//input.nextLine();
		System.out.println("Enter the Number: ");
		String newPhone=input.nextLine();//input.nextLine();
		Contacts newContact=new Contacts(newName,newPhone);
		if(mobile.updateContact(oldContact,newContact));
		{
		  System.out.println(oldContact.getName()+ " is replaced by "+newContact.getName());

		}
		

		
	}
	private static void printContacts()
	{
		mobile.printContacts();
	}
	

	public static void main(String[] args) 
	{
		System.out.print("Openning contacts Application.........");
		System.out.print("\nWelcome");
		boolean enter=true;
		mobile.printMenu();
		while (enter)
		{
			try
			{
				System.out.print("Enter your choice:");
				int ch=input.nextInt();
				input.nextLine();
				switch(ch)
				{
				case 1:
					addContacts();
					break;
				case 2:
					printContacts();
					break;
				case 3:
					removeContact();
					break;
				case 4:
					updateContact();
					break;
				case 5:
					searchContact();
					break;
				case 6:
					mobile.printMenu();
					break;
				case 7:
					enter=false;
				}
				
			}
			catch(InputMismatchException i)
			{
				System.out.println("please enter an integer");
				break;
			}
		}
		System.out.println("...................Exiting....................");
		

	}

}
