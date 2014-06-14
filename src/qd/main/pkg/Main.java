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

import qd.DB.pkg.MySQLiteHelper;
import qd.Dict.pkg.MyDict;
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
	private static String mDomain = "http://nhipsongso.tuoitre.vn/Nhip-song-so/612679/Nong-voi-may-tinh-bang-moi-tu-Samsung-LG.html"; 
			//"http://nhipsongso.tuoitre.vn/Nhip-song-so/600189/Khong-cham-smartphone-10-phut-chuyen-gi-xay-ra.html";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String tmp;
		try {
			//lay HTML dang text ve
			Document doc = Jsoup.connect(mDomain).get();
			tmp = doc.text();
			//System.out.print(tmp);
			//Split by char
			String[] tmp2 = tmp.split("[,;\\.?!-]+");
			for(String item:tmp2)
			{
				String[] tmp3 = item.split(" ");
				for(String item2 :tmp3)
				{
					//loc bo moi ky tu khong co trong bang chu cai tieng viet ra
					System.out.println(MyDict.filterRightWord(item2));
				}
				System.out.println("===============");
			}
			//insert to Database
			
			for(Element item:doc.select("a[href]"))
			{
				String lnk=item.attr("abs:href");
				mLinks.put(lnk, true);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//MySQLHelper helper = new MySQLHelper();
		//Connection con = helper.getConnection();
		
		// create our data source
		
		/*
		MySQLiteHelper helper=new MySQLiteHelper();
		
		Dao<MyWord, Long> accountDao = helper.getMyWordDAO();
		try {
			accountDao.create(new MyWord("quocdunginfo"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		*/
		
		//URL 1 trang web
		
		//lay HTML ve
		
		//Tach loc ra tung chu 1
		
		//kiem tra 1 tu co la tieng viet (co hop le)
		
		//tao cau truc value-pair
		
		//luu vao DB
	}

}
