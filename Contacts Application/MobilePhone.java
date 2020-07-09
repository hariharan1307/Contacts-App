package com.ContactsApp;
import java.util.ArrayList;
public class MobilePhone 
{
	private static ArrayList<Contacts> contacts;
	private String Name;
	
	public MobilePhone(String Name)
	{
		this.Name=Name;
		this.contacts=new ArrayList<Contacts>();
		
	}
	public ArrayList<Contacts> getContacts()
	{
		return this.contacts;
	}
	private static int findContact(String Name,String phone)
	{
		for(int i=0;i<contacts.size();i++)
		{
			Contacts existingContacts=contacts.get(i);
			if(existingContacts.getName().equals(Name) && existingContacts.getNumber().equals(phone))
			{
				return i;
			
			}
		}
		return -1;
	}
	private static int findContact(String Name)
	{
		for(int i=0;i<contacts.size();i++)
		{
			Contacts existingContacts=contacts.get(i);
			if(existingContacts.getName().equals(Name))
			{
				return i;
			
			}
		}
		return -1;
	}
	
	public boolean addContact(Contacts NewContact)
	{
		if(findContact(NewContact.getName(),NewContact.getNumber())>=0)
		{
//			System.out.println("Contacts Already Exists");
			return false;
		}
		contacts.add(NewContact);
		return true;
	}
	public boolean updateContact(Contacts oldContact,Contacts newContact)
	{
		int position=findContact(oldContact.getName());
		if (position>=0)
		{
			contacts.set(position, newContact);
//			System.out.println(oldContact.getName()+ " is replaced by "+newContact.getName());
			return true;
		}
		System.out.println(oldContact.getName()+ " does not exist in your contact");
		return false;
		
	}
	public boolean removeContact(Contacts contact)
	{
		int position=findContact(contact.getName());
		if(position>=0)
		{
			contacts.remove(position);
			System.out.println(contact.getName()+" was successfully removed from your contacts");
			return true;
		}
		System.out.println(contact.getName()+" does not exists your contacts");
		return false;
		
	}
	public Contacts searchContact(String Name)
	{
		int position=findContact(Name);
		if(position>=0)
		{
			Contacts existingContact=contacts.get(position);
			return existingContact;
		}
		return null;
	}
	public Contacts searchContact(Contacts Name)
	{
		int position=findContact(Name.getName());
		if(position>=0)
		{
			Contacts existingContact=contacts.get(position);
			return existingContact;
		}
		return null;
	}
	public void printContacts()
	{
		System.out.println("There are " + contacts.size() +" entries in your contacts");
		for(int i=0;i<contacts.size();i++)
		{
			Contacts phoneContacts=contacts.get(i);
			int position=findContact(phoneContacts.getName());
			System.out.println((position+1)+ "."+"Name:"+ phoneContacts.getName() + " Phone Number:"+phoneContacts.getNumber());
		}
	}
	
	
	

	public static void printMenu()
	{
		System.out.println("\nPress"
				                  + "\n 1-to add contact"
				                  + "\n 2-print contacts"
				                  + "\n 3-remove a contact"
				                  + "\n 4-update contact"
				                  + "\n 5-search contact "
				                  + "\n 6-print menu"
				                  + "\n 7-to exit    ");
	}
	
	

}
