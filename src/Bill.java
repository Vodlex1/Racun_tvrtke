import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;

public class Bill {
	Scanner s = new Scanner(System.in);
	String[] Tvrtka; 
	String Ime, Prezime, OIB, currency;
	double money = 0;
	ArrayList<String> traffic = new ArrayList<String>();
	String sdf = new SimpleDateFormat("dd-MM-yyyy (hh:mm:ss)").format(Calendar.getInstance().getTime());
	int a = 0;

	void enterCompanyInfo() {
		int a;
		Tvrtka = new String[5];
		for(int i=0; i<5; i++) {
			if(i==0) System.out.print("Unesi naziv tvrtke: ");
			else if(i==1) System.out.print("Unesi ulicu tvrtke: ");
			else if(i==2) System.out.print("Unesi broj tvrtke: ");
			else if(i==3) System.out.print("Unesi grad sjedista tvrtke: ");
			else if(i==4) System.out.print("Unesi postanski broj grada: ");
			Tvrtka[i] = s.nextLine();
		}	
		System.out.println(
		"\r\nOdaberi valutu: "+
		"\r\n1. HRK"+
		"\r\n2. EUR");
		a = Integer.parseInt(s.nextLine());
		if(a==1){
			currency = " HRK";
		}else if(a==2){
			currency = " EUR";
		}
		enterPersonalDetails();
	}

	void enterPersonalDetails() {
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
		CreateBill.cleanScreen();
	}
	
	void addMoney() {
		System.out.print("Unesi izons: ");
		if(currency == " HRK"){
			traffic.add(s.nextLine());
			money += Double.parseDouble(traffic.get(a));
			a++;
			traffic.add(sdf);
			a++;
		}else if(currency == " EUR"){
			traffic.add(s.nextLine());
			money += Double.parseDouble(traffic.get(a));
			a++;
			traffic.add(sdf);
			a++;
		}
		CreateBill.cleanScreen();
	}

	void withdrawMoney(){
		double temp;
		System.out.print("Unesi izons: ");
		if(currency == " HRK"){
			temp = Double.parseDouble(s.nextLine()) * -1;
			traffic.add(Double.toString(temp));
			money += temp;
			a++;
			traffic.add(sdf);
			a++;
		}else if(currency == " EUR"){
			temp = Double.parseDouble(s.nextLine()) * -1;
			traffic.add(Double.toString(temp));
			money += temp;
			a++;
			traffic.add(sdf);
			a++;
		}
		CreateBill.cleanScreen();
	}

	void printInfo() {
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
		s.nextLine();
	}

	void printTraffic(){
		System.out.println("Promet racuna: ");
		if(traffic.size() == 0 ) System.out.println("\t-Nema ikakvog prometa-");
		for (int i = 0; i < traffic.size(); i++) {
			if(Double.parseDouble(traffic.get(i)) > 0) {
				System.out.println("+" + traffic.get(i) + "    " + traffic.get(i+1));
				i++;
		}
			else {
				System.out.println(traffic.get(i) + "    " + traffic.get(i+1));
				i++;
			}
		}
		s.nextLine();
		CreateBill.cleanScreen();
	}
}
