package datos;

import java.util.Scanner;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;

import view.MongoMenu;


public class MongoDBManager implements AccesoDatos{
	
	private MongoClient mongoCli;
	private MongoDatabase db;
	private MongoCollection<Document> coll;
	
	public MongoDBManager() {
		System.out.println("---ACCESO A DATOS MONGODB---");
		connectDB();
		MongoMenu.show();
		this.selectMongoOption();
	}

	public void connectDB() {
		mongoCli = new MongoClient();
		db = mongoCli.getDatabase("arachnida");
		System.out.println("Connected to db "+db.getName());
		//db.createCollection("Aranae");
		coll = db.getCollection("aranae");
		System.out.println("Collection selected succesfully");
	}
	
	public void showAll() {
		MongoCursor<Document> it = coll.find().iterator();
		//int i = 1;
	    while (it.hasNext()) {
	    	System.out.println(it.next());
	    	//i++; 
	    }
	}
	
	public void addOne() {
		Document document = new Document("id", "9").append("subordo", "tuViella");	 
		coll.insertOne(document);
		System.out.println("Document inserted successfully...");
	}
	
	public void searchOne() {
		System.out.println("Type filter search by family: ");
		String input = new Scanner(System.in).nextLine();
		Document searchQuery = new Document("familia",input);
		//searchQuery.put("familia", "Thomisidae"); //same as BasicDBObject searchQuery = new BasicDBObject().append("name", "Olivia");
		MongoCursor<Document> it = coll.find(searchQuery).iterator();
		//int i = 1;
	    while (it.hasNext()) {
	    	System.out.println(it.next());
	    	//i++; 
	    }
	}
	
	public void updateOne() {
		
	}
	
	public void eliminateOne() {
		
	}
	
	public void dropCollection() {
		
	}
	
	public void disconnectDB() {
		System.out.println("Disconnecting from MongoDB");
		mongoCli.close();
	}
	

	public void selectMongoOption() {
		switch (new Scanner(System.in).nextInt()) {

		case 1:
			// NullPointerException??
			showAll();
			break;
		case 2:
			addOne();
			break;
		case 3:
			searchOne();
			break;
		case 4:
			updateOne();
			break;
		case 5:
			eliminateOne();
			break;
		case 6:
			dropCollection();
			break;
		case 0:

			break;
		}

	}
}
