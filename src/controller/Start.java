package controller;

import java.util.Scanner;

import view.Menu;
import datos.MongoDBManager;

public class Start {

	public void start() {
		boolean on = true;
		do {
			Menu.showMenu();
			on = this.selectOption();
		} while (on);
	}


	public boolean selectOption() {
		boolean terminalOn = true;
		//TODO: add letter input possibility
		switch (new Scanner(System.in).nextInt()) {
		
		case 1:
			MongoDBManager mongo = new MongoDBManager();
			break;
//		case 2:
//			
//			break;
//		case 3:
//			
//			break;
//		case 4:
//			
//			break;
//		case 5:
//			
//			break;			
		case 0:
			terminalOn = exit();
			break;
		default:
			System.out.println("Please write one of the numbers above");
			//this.selectOption();
		}
		return terminalOn;	
	}
	
	private boolean exit() {
		System.out.print("Are you sure you want to exit? (Y/N) : ");
		String input = new Scanner(System.in).nextLine();
		//will only return false if Y is written
		return (input.toUpperCase().charAt(0) != 'Y');
	}
	
}