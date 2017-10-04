import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import org.apache.log4j.chainsaw.Main;

public class DB {
	private static Connection getConnection() throws ClassNotFoundException, SQLException{
		ResourceBundle rb = ResourceBundle.getBundle("db");
		// Step - 1 Load the Driver
		// oracle.jdbc.driver.OracleDriver
		// org.h2.Driver
		//String driverName = "com.mysql.jdbc.Driver";
		String driverName = rb.getString("driver");
		Class.forName(driverName);
		// Step -2 Connection Build
		//jdbc:mysql://hostname:port/dbname
		// jdbc:oracle:thin:@hostName:portNo:serviceName
		// 
		//String url = "jdbc:mysql://localhost:3306/interntesting";
		String url = rb.getString("url");
		String dbUserid = rb.getString("userid");
		//String dbUserid = "root";
		String dbPassword = "";
		Connection connection = DriverManager.getConnection(url,dbUserid,dbPassword);
		if(connection==null){
			System.out.println("Connection Can't Created...");
			System.exit(0);
		}
		return connection;
				
		
	}
	public static Object[][] getAllUsers(String activeRecordStatus) throws ClassNotFoundException, SQLException{
		Object array [][]= new Object[2][2];
		int columnCount =0;
		int rowCount = 0;
		Connection connection = null;
		PreparedStatement pstmt = null; // Query from DB
		ResultSet rs = null; // Query Result Store
		final String SQL = "select email , password from users where status=?";
		try{
			connection = getConnection();
			pstmt  = connection.prepareStatement(SQL);
			pstmt.setString(1, activeRecordStatus);
			rs = pstmt.executeQuery();
			
			while(rs.next()){
				//System.out.println(rs.getString("email")+" "+rs.getString("password"));
				array[rowCount][0] = rs.getString("email");
				array[rowCount][1] = rs.getString("password");
				rowCount++;
			}
		}
		finally{
			if(rs!=null){
				rs.close();
			}
			if(pstmt!=null){
				pstmt.close();
			}
			if(connection!=null){
				connection.close();
			}
		}
		return array;
	}
//	public static void main(String[] args) throws ClassNotFoundException, SQLException {
//		DB.getAllUsers("Y");
//	}
}
