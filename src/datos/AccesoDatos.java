package datos;

public interface AccesoDatos {
	
	public void connectDB();
	public void showAll();
	public void addOne();
	public void searchOne();
	public void updateOne();
	public void eliminateOne();
	public void dropCollection();
	public void disconnectDB();
//	public void showFile();
//	public void addOneFile();
//	public void fileToDB();
//	public void dbToFile();

}
