package qd.main.pkg;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import qd.DB.pkg.MySQLHelper;
import qd.Entities.pkg.MyLinker;
import qd.Entities.pkg.MyWord;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import com.sun.tools.javac.util.Log;

public class Main {
	private static HashMap<String, Boolean> mLinks = null;
	static {
		mLinks = new HashMap<String, Boolean>();
	}
	private static String mDomain = "http://nhipsongso.tuoitre.vn/Nhip-song-so/600189/Khong-cham-smartphone-10-phut-chuyen-gi-xay-ra.html";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		System.out.print("what the fuck");
		String tmp;
		try {
			Document doc = Jsoup.connect(mDomain).get();
			//get page text
			tmp = doc.text();
			//inssert to Database
			
			for(Element item:doc.select("a[href]"))
			{
				String lnk=item.attr("abs:href");
				mLinks.put(lnk, true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		//MySQLHelper helper = new MySQLHelper();
		//Connection con = helper.getConnection();
		
		// create our data source
		try {
			JdbcConnectionSource connectionSource = new JdbcConnectionSource("jdbc:sqlite:mem:account");
			// if you need to create the table
			TableUtils.createTable(connectionSource, MyWord.class);
			TableUtils.createTable(connectionSource, MyLinker.class);
			
			Dao<MyWord, Long> accountDao = DaoManager.createDao(connectionSource, MyWord.class);
			accountDao.create(new MyWord("quocdunginfo"));
			accountDao.create(new MyWord("binhnguyen"));
			accountDao.create(new MyWord("ducminh"));
			
			Dao<MyLinker, Long> accountDao2 = DaoManager.createDao(connectionSource, MyLinker.class);
			MyWord tmp1 = accountDao.queryForId(1l);
			MyWord tmp2 = accountDao.queryForId(2l);
			
			accountDao2.create(new MyLinker(tmp1, tmp2));
			accountDao2.create(new MyLinker(tmp2, tmp1));
			//accountDao2.create(new MyLinker(tmp2, tmp1));
			
			connectionSource.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
