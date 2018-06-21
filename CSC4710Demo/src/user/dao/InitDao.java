package user.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InitDao
{
	
	public void initDB()
	{
			//TEST TEST TEST
			//TEST 2 CHECK
		
		   Statement statement;
		 try {
		      Class.forName("com.mysql.jdbc.Driver").newInstance();
		      Connection connect = DriverManager
		          .getConnection("jdbc:mysql://localhost:3306/sampledb?"
		              + "user=root&password=algebraic");

		      // Statements allow to issue SQL queries to the database
		      statement = connect.createStatement();
		      statement.executeUpdate("DROP TABLE IF EXISTS Student");


		      String tbuserStatement = "CREATE TABLE IF NOT EXISTS tb_user(" +  
			      		"username VARCHAR(50)," + 
			      		"password VARCHAR(50)," + 
			      		"email VARCHAR(50)," + 
			      		"primary key (username)" + 
			      		")";
			       
		      
		      String paperStatement = "CREATE TABLE IF NOT EXISTS paper(" + 
		      		"paperid INTEGER," + 
		      		"title VARCHAR(50)," + 
		      		"abstract VARCHAR(250)," + 
		      		"pdf VARCHAR(100)," + 
		      		"primary key (paperid)" + 
		      		")";
		      
		      
		      String authorStatement = "CREATE TABLE IF NOT EXISTS author(" + 
		      		"email VARCHAR(100)," + 
		      		"name VARCHAR(50)," + 
		      		"affiliation VARCHAR(100)," + 
		      		"primary key(email)" + 
		      		")";
		      
		    String writesStatement = "CREATE TABLE IF NOT EXISTS writes(" + 
		    		"paperid INTEGER," + 
		    		"email VARCHAR(50)," + 
		    		"nameorder INTEGER," + 
		    		"PRIMARY KEY(paperid, email)," + 
		    		"FOREIGN KEY (paperid) REFERENCES paper(paperid)," + 
		    		"FOREIGN KEY (email) REFERENCES author(email)" +
		    		")";
		    
		    String pcmemberStatement = "CREATE TABLE IF NOT EXISTS pcmember(" + 
		    		"email VARCHAR(50)," + 
		    		"name VARCHAR(20)," + 
		    		"primary key (email)" + 
		    		")";
		    		
			String reviewStatement = "CREATE TABLE IF NOT EXISTS review(" + 
					"reportid integer," + 
					"sdate DATE," + 
					"comment VARCHAR(250)," + 
					"recommendation CHAR(1)," + 
					"paperid integer," + 
					"email VARCHAR(100)," + 
					"unique(paperid, email)," + 
					"FOREIGN KEY( paperid ) REFERENCES paper(paperid)," + 
					"FOREIGN KEY( email )REFERENCES pcmember(email)" +
					")";
					
/*			String threepcStatement = "CREATE ASSERTION threepc " + 
					"CHECK (NOT EXISTS( " + 
					"SELECT * FROM paper P " + 
					"WHERE 3 <> (" + 
					"SELECT COUNT( * ) " + 
					"FROM Review R " + 
					"WHERE R.paperid = P.paperid" + 
					") ) )";
			
			String atmostfiveStatement = "CREATE ASSERTION atmostfivepapers " + 
					"CHECK( NOT EXISTS " +  
					"SELECT * FROM pcmember P " + 
					"WHERE 5 < (" + 
					"SELECT * " + 
					"FROM review R " + 
					"WHERE R.email = P.email" + 
					") )";
*/				
					
			statement.executeUpdate(tbuserStatement);
			statement.executeUpdate(paperStatement);
		    statement.executeUpdate(authorStatement);
			statement.executeUpdate(writesStatement);
			statement.executeUpdate(pcmemberStatement);
			statement.executeUpdate(reviewStatement);
//			statement.executeUpdate(threepcStatement);
//			statement.executeUpdate(atmostfiveStatement);

		      
		 } catch (SQLException e) {
		         throw new RuntimeException(e);
		    } catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
	}

}
