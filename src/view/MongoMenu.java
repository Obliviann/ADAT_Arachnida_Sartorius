package view;

import java.util.Scanner;

import datos.MongoDBManager;

public class MongoMenu {
	//NullPointerException
	static MongoDBManager m = new MongoDBManager();

	public static void show() {
		
		System.out.println("  Por favor, escoge una opcion: ");
		System.out.println("");
		System.out.println("    1.- MOSTRAR TODOS");
		System.out.println("    2.- AÑADIR 1");
		System.out.println("    3.- BUSCAR 1");
		System.out.println("    4.- MODIFICAR 1");
		System.out.println("    5.- ELIMINAR 1");
		System.out.println("    6.- ELIMINAR TODOS");
		System.out.println("    0.- SALIR");

	}
	public static void selectOption() {	
		
		switch(new Scanner(System.in).nextInt()) {
		
		case 1:
			//NullPointerException??
			m.showAll();
			break;
		case 2:
			m.addOne();
			break;
		case 3:
			m.searchOne();
			break;
		case 4:
			m.updateOne();
			break;
		case 5:
			m.eliminateOne();
			break;
		case 6:
			m.dropCollection();
			break;
		case 0:
			
			break;		
		}
	}

}
