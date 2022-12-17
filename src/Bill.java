import java.util.Scanner;

public class Bill {
	Scanner s = new Scanner(System.in);
	String[] Tvrtka; //Naziv, Ulica, Broj, Grad_Sjedista, Postanski_Broj; 
	String Ime, Prezime, OIB;
	
	void enterCompanyInfo() {
		System.out.println();
		Tvrtka = new String[5];
		for(int i=0; i<5; i++) {
			if(i==0) System.out.println("Unesi naziv: ");
			else if(i==1) System.out.println("Unesi ulicu: ");
			else if(i==2) System.out.println("Unesi broj mobitela: ");
			else if(i==3) System.out.println("Unesi grad sjedista: ");
			else if(i==4) System.out.println("Unesi postanski broj: ");
		
			Tvrtka[i] = s.nextLine();

		}	
	}
	
	void enterPersonalDetails() {
		System.out.println("\r\nUnesi ime: ");
		Ime = s.nextLine();
		System.out.println("Unesi prezime: ");
		Prezime = s.nextLine();
		
		System.out.println("Unesi OIB: ");
		String temp = new String();
		do {
			
			temp = s.nextLine();
			if(temp.length() == 11) OIB=temp;
			else System.out.println("Krivi OIB unos! Pokušaj opet: ");
		}while(temp.length() != 11);
	}
	
	void money() {
		System.out.println("\r\nOdaberi valutu: ");
		System.out.println("1. HRK");
		System.out.println("2. EUR");
		if(s.nextInt() == 1) System.out.println("Unesi izons: ");
		if(s.nextInt() == 2) System.out.println("Unesi izons: ");
	}
	
	void printInfo() {
		for(int i=0; i<5; i++) {
			System.out.println(Tvrtka[i]);
		}
		
		
	}
	
	
}
