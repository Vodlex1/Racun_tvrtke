import java.util.Scanner;

public class Bill {
	Scanner s = new Scanner(System.in);
	String[] Tvrtka; //Naziv, Ulica, Broj, Grad_Sjedista, Postanski_Broj; 
	String Ime, Prezime, OIB;
	Double money;
	
	void showMenu(){
		printInfo();
		System.out.println(
			"a. Kreiranje racuna tvrtke \r\n" +
			"b. Prikaz stanja racuna \r\n" +
			"c. Prikaz prometa po racunu \r\n" +
			"d. Polog novca na racun \r\n" +
			"e. Podizanje novca s racuna \r\n" +
			"f. Izlaz iz programa \r\n"
		);
	}

	void enterCompanyInfo() {
		System.out.println();
		Tvrtka = new String[5];
		for(int i=0; i<5; i++) {
			if(i==0) System.out.print("Unesi naziv: ");
			else if(i==1) System.out.print("Unesi ulicu: ");
			else if(i==2) System.out.print("Unesi broj mobitela: ");
			else if(i==3) System.out.print("Unesi grad sjedista: ");
			else if(i==4) System.out.print("Unesi postanski broj: ");
		
			Tvrtka[i] = s.nextLine();

		}	
	}
	
	void enterPersonalDetails() {
		System.out.print("\r\nUnesi ime: ");
		Ime = s.nextLine();
		System.out.print("Unesi prezime: ");
		Prezime = s.nextLine();
		
		System.out.print("Unesi OIB: ");
		String temp = new String();
		do {
			
			temp = s.nextLine();
			if(temp.length() == 11) OIB=temp;
			else System.out.print("Krivi OIB unos! Pokusaj opet: ");
		}while(temp.length() != 11);
	}
	
	void moneyMethod() {
		int a;
		System.out.println("\r\nOdaberi valutu: ");
		System.out.println("1. HRK");
		System.out.println("2. EUR");
		a = Integer.parseInt(s.nextLine());
		System.out.print("Unesi izons: ");
		conversion(a, Double.parseDouble(s.nextLine()));
	}
	
	void conversion(int a, double amount){
		if(a==1){
			money = amount;
			System.out.print(money + " HRK");
		}else if(a==2){
			money = amount;
			System.out.print(money + " EUR");
		}
	}

	void printInfo() {
		if(Tvrtka != null){
			for(int i=0; i<5; i++) {
				System.out.println(Tvrtka[i]);
			}
		}else return;
		
		System.out.println(money);
		
	}
	
	
}
