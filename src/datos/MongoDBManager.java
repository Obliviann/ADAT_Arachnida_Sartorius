package datos;

import org.bson.Document;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.BasicDBObject;

import view.MongoMenu;


public class MongoDBManager {
	
	private MongoClient mongoCli;
	private MongoDatabase db;
	private MongoCollection<Document> coll;
	
	public MongoDBManager() {
		System.out.println("---ACCESO A DATOS MONGODB---");
		connectToDB();
		MongoMenu.show();
		MongoMenu.selectOption();
	}

	public void connectToDB() {
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
		Document document = new Document("nombreColor", "negro").append("valorHexadec", "tuViella");	 
		coll.insertOne(document);
		System.out.println("Document inserted successfully...");
	}
	
	public void searchOne() {
		Document searchQuery = new Document();
		System.out.println("Type filter search: ");
		searchQuery.put("name", "Jaime"); //same as BasicDBObject searchQuery = new BasicDBObject().append("name", "Olivia");
	}
	
	public void updateOne() {
		
	}
	
	public void eliminateOne() {
		
	}
	
	public void dropCollection() {
		
	}
	
	public void exitMongo() {
		mongoCli.close();
	}
	
	
	//
}
