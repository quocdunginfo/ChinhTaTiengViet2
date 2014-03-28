package qd.DB.pkg;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLHelper {
	Connection mCon = null;
	public MySQLHelper()
	{
		mCon = null;
	    try {
	      Class.forName("org.sqlite.JDBC");
	      mCon = DriverManager.getConnection("jdbc:sqlite:quocdunginfo.db");
	    } catch ( Exception e ) {
	      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	      System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	}
	public Connection getConnection()
	{
		return this.mCon;
	}
}
