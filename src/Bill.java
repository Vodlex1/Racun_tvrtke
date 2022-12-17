import java.util.Scanner;

public class Bill {
	Scanner s = new Scanner(System.in);
	String[] Tvrtka; //Naziv, Ulica, Broj, Grad_Sjedista, Postanski_Broj; 
	String Ime, Prezime, OIB, currency;
	double money = 0;
	
	void showMenu(){
		System.out.println(
			"a. Kreiranje racuna tvrtke \r\n" +
			"b. Prikaz stanja racuna \r\n" +
			"c. Prikaz prometa po racunu \r\n" +
			"d. Polog novca na racun \r\n" +
			"e. Podizanje novca s racuna \r\n" +
			"f. Izlaz iz programa \r\n"
		);
		String a = s.nextLine();
		if(a.equals("a")) enterCompanyInfo();
		else if(a.equals("b")) printInfo();
		else if(a.equals("c"));
		else if(a.equals("d")) moneyMethod();
		else if(a.equals("e"));
		else if(a.equals("f"));
		else {
			for (int i = 0; i < 20; ++i) System.out.println();
			System.out.println("Krivi unos! Pokusaj opet: ");
			showMenu();
		}
		
	}

	void enterCompanyInfo() {
		int a;
		for (int i = 0; i < 50; ++i) System.out.println();
		Tvrtka = new String[5];
		for(int i=0; i<5; i++) {
			if(i==0) System.out.print("Unesi naziv tvrtke: ");
			else if(i==1) System.out.print("Unesi ulicu tvrtke: ");
			else if(i==2) System.out.print("Unesi broj tvrtke: ");
			else if(i==3) System.out.print("Unesi grad sjedista tvrtke: ");
			else if(i==4) System.out.print("Unesi postanski broj grada: ");
			Tvrtka[i] = s.nextLine();
		}	
		System.out.println("\r\nOdaberi valutu: ");
		System.out.println("1. HRK");
		System.out.println("2. EUR");
		a = Integer.parseInt(s.nextLine());
		if(a==1){
			currency = " HRK";
		}else if(a==2){
			currency = " EUR";
		}
		enterPersonalDetails();
	}
	
	void enterPersonalDetails() {
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.print("\r\nUnesi ime odgovorne osobe: ");
		Ime = s.nextLine();
		System.out.print("Unesi prezime odgovorne osobe: ");
		Prezime = s.nextLine();
		
		System.out.print("Unesi OIB odgovorne osobe: ");
		String temp = new String();
		do {
			temp = s.nextLine();
			if(temp.length() == 11) OIB=temp;
			else System.out.print("Krivi OIB unos! Pokusaj opet: ");
		}while(temp.length() != 11);
		showMenu();
	}
	
	void moneyMethod() {
		for (int i = 0; i < 50; ++i) System.out.println();
		System.out.print("Unesi izons: ");
		if(currency == " HRK"){
			money += Double.parseDouble(s.nextLine());
		}else if(currency == " EUR"){
			money += Double.parseDouble(s.nextLine());
		}
		showMenu();
	}
	
	void conversion(int a, double amount){

	}

	void printInfo() {
		for (int i = 0; i < 50; ++i) System.out.println();
		if(Tvrtka != null){
			for(int i=0; i<5; i++) {
				System.out.println(Tvrtka[i]);
			}
		}else System.out.println("Tvrtka nije unesena!");;
		if(money==0) System.out.println("-prazan racun-");
		else System.out.println(money + currency);

		System.out.println();
		if(Ime != null && Prezime != null && OIB != null){
			System.out.println(Ime);
			System.out.println(Prezime);
			System.out.println(OIB);
		}else System.out.println("Odgovorna osoba nije unesena!");
		System.out.println();

		System.out.println("Vrati se:");
		if(s.nextLine() != null) showMenu();
	}
}
