import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class CreateBill {
    Scanner s = new Scanner(System.in);
    ArrayList<Bill> accounts = new ArrayList<Bill>(); 
    Bill tempBill;

	void showMenu(){
        System.out.println();
		System.out.println(
			"a. Kreiranje racuna tvrtke \r\n" +
			"n. Odaberi kreirani racun \r\n" +
			"b. Prikaz stanja racuna \r\n" +
			"c. Prikaz prometa po racunu \r\n" +
			"d. Polog novca na racun \r\n" +
			"e. Podizanje novca s racuna \r\n" +
			"f. Izlaz iz programa "
		);

		String a = s.nextLine();
		if(a.equals("a")) addAccount();
		else if(a.equals("n")) chooseAccount();
		else if(a.equals("b")) showAccountInfo();
		else if(a.equals("c")) {
			cleanScreen();
			accountCheck();
			tempBill.printTraffic();
			showMenu();
		}
		else if(a.equals("d")) {
			cleanScreen();
			accountCheck();
			tempBill.addMoney();
			showMenu();
		}
		else if(a.equals("e")) {
			cleanScreen();
			accountCheck();
			tempBill.withdrawMoney();
			showMenu();
		}
		else if(a.equals("f"));
		else {
			System.out.println("Krivi unos! Pokusaj opet: ");
			showMenu();
		}
	}

	public void addAccount() {
		cleanScreen();
		accounts.add(new Bill());
		accounts.get(accounts.size()-1).enterCompanyInfo();
		tempBill = accounts.get(accounts.size()-1);
		showMenu();
	}

	void setAccount(int a){
		tempBill = accounts.get(a);
	}

	public void showAccountInfo() {
		cleanScreen();
		accountCheck();
        if(accounts.size() < 2)accounts.get(accounts.size()-1).printInfo();
		else tempBill.printInfo();
		cleanScreen();
		showMenu();
	}

    public void chooseAccount(){
		cleanScreen();
		accountCheck();
		if(accounts.size()<2){
			System.out.println("Krivi unos! Pokusaj opet: ");
			showMenu();
		}
		String a;
		String tempstring2;
		System.out.println("Odaberi racun:\r\n" +
							"1. Po imenu\r\n" +
							"2. Po OIB-u\r\n" );
		a = s.nextLine();
		if(a.equals("1")){
			System.out.print("Unesi ime: ");
			tempstring2 = s.nextLine();
			for (int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).Ime.equals(tempstring2)){
					setAccount(i);
				}
			}
		}else if(a.equals("2")){
			System.out.print("Unesi OIB: ");
			tempstring2 = s.nextLine();
			for (int i = 0; i < accounts.size(); i++) {
				if(accounts.get(i).OIB.equals(tempstring2)){
					setAccount(i);
				}
			}
		}
		cleanScreen();
		showMenu();
    }
	
	void accountCheck(){
		if(accounts.size() == 0){
			System.out.println("Kreiraj racun!");
			showMenu();
		}else;
	}

    public static void cleanScreen (){
		try{
        new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
		}catch(InterruptedException | IOException exception) {}
    }
}
