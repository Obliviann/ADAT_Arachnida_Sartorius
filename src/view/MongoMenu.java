package view;

import java.util.Scanner;

import datos.MongoDBManager;

public class MongoMenu {
	static //NullPointerException
	MongoDBManager m = new MongoDBManager();

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

}
