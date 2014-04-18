package qd.DB.pkg;

import java.sql.SQLException;

import qd.Entities.pkg.MyLinker;
import qd.Entities.pkg.MyWord;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.table.TableUtils;

public class MySQLiteHelper {
	public static final String DB_NAME = "wordmap";
	private JdbcConnectionSource mCon = null;

	private Dao<MyLinker, Long> myLinkerDAO = null;

	private Dao<MyWord, Long> myWordDAO = null;

	public MySQLiteHelper() {
		try {
			mCon = new JdbcConnectionSource("jdbc:sqlite:" + DB_NAME);
			onCreate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// if you need to create the table
	}

	public JdbcConnectionSource getmCon() {
		return mCon;
	}

	public Dao<MyLinker, Long> getMyLinkerDAO() {
		try {
			if (myLinkerDAO == null) {
				myLinkerDAO = DaoManager.createDao(mCon, MyLinker.class);
			}
			return myLinkerDAO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public Dao<MyWord, Long> getMyWordDAO() {
		try {
			if (myWordDAO == null) {
				myWordDAO = DaoManager.createDao(mCon, MyWord.class);
			}
			return myWordDAO;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void onCreate() {
		try {
			TableUtils.createTable(mCon, MyWord.class);
			TableUtils.createTable(mCon, MyLinker.class);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onDestroy() {
		try {
			TableUtils.dropTable(mCon, MyWord.class, true);
			TableUtils.dropTable(mCon, MyLinker.class, true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void close()
	{
		try{
			if(mCon!=null)
			{
				mCon.close();
				myLinkerDAO = null;
				myWordDAO = null;
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
