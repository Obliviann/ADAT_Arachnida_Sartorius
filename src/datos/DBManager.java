package datos;

import java.sql.Statement;

//import com.sun.rowset.CachedRowSetImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
//https://docs.oracle.com/javase/tutorial/jdbc/basics/connecting.html
public class DBManager {

    private String host, user, pass, database, direc;
    private Statement st;
    private Connection cn;

    //TODO: no poner los valores de los att en la clase, si no en un fichero de configuración, y que los lea desde aquí.
    public DBManager() {
        this.host = "localhost:80"; //TODO: this was written "10.90.36.109"
//        this.user = "alumno";
//        this.pass = "alumno";
        this.database = "Aranae";
    }

    public DBManager(String host, String user, String pass, String database) {
        this.host = host;
//        this.user = user;
//        this.pass = pass;
        this.database = database;
    }
    
    //1. our data source (i.e. a DBMS, a legacy file system...) will allwas be smth with a corresponding JDBC driver
    private void connectDB() {
    	//Montamos la dirección de conexión - your BMS JDBC driver uses to conn to a DB
    	direc = "jdbc:mysql://" + this.host + "/" + this.database;
    	
    	try {
            //Class.forName("com.mysql.cj.jdbc.Driver"); - used to be necesary to initialize your driver prior to conn
    		/*DV class - a JDBC app uses to connect to a target data source. When it first attempts to establish a conn,
    					it automatically loads any 4.0 JDBC drivers found within the class path.*/								
            cn = DriverManager.getConnection(direc, user, pass); //- returns a onnection obj, query the DB through this obj
            st = cn.createStatement();

        } catch (SQLException e) {
            System.out.println("Error en la conexion");
        }
    }
    
    private void disconnectDB() {
        try {
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al desconectar");
        }
    }
    
    public Boolean executeQuerys(String query) {
    	   try{
               //1. CONECTAMOS
               this.connectDB();
               //2. EJECUTA
               Boolean result = st.execute(query);
               //3. DESCONECTAR
               this.disconnectDB();
               //4. RESPUESTA
               return result;
           }catch (SQLException e){
               return false;
           }
    }
    
    //TODO: método para sentencia SELECT con ResultSet
  
//    public ResultSet executeSelect(String query){
//        try{
//            //1� CONECTAR
//            this.connectDB();
//            //2� EJECUTAR SENTENCIA
//            ResultSet result = st.executeQuery(query);
////          CachedRowSetImpl filas = new CachedRowSetImpl();
////          filas.populate(result);
//            //3� DESCONECTAMOS
//            this.disconnectDB();
//            //4� RESPUESTA
////          return filas;
//        }catch(Exception e){
//            return null;
//        }                
//    }
}
