package application;

import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exceptions.DomainExceptions;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		try {
		System.out.println("Enter account data");
		System.out.print("Number: ");
		Integer number = sc.nextInt();
		System.out.print("Holder: ");
		String holder = sc.next();
		System.out.print("Initial balance: ");
		Double balance = sc.nextDouble();
		System.out.print("Withdraw limit: ");
		Double withdrawLimit = sc.nextDouble();
		
		Account account = new Account(number,holder,balance,withdrawLimit);
		
		System.out.println();
		System.out.print("Enter amount for withdraw:");
		Double withdraw = sc.nextDouble();
		account.withdraw(withdraw);
		System.out.println(account);
		}
		//catch(IllegalArgumentException e){
		catch(DomainExceptions e){
			System.out.println("Error on withdraw: "+ e.getMessage());
		}
		catch(RuntimeException e){
			System.out.println("Unexpected error! "+ e.getMessage());
		}
		
		
		
		sc.close();
		
		
	}

}
