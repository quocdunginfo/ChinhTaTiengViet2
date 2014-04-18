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
	private static String mDomain = "http://nhipsongso.tuoitre.vn/Nhip-song-so/600189/Khong-cham-smartphone-10-phut-chuyen-gi-xay-ra.html";
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jk = "Về vấn đề này, Phó chủ tịch UBND TP HCM Hứa Ngọc Thuận cho rằng, thành phố có đề án quy hoạch lại các ngành nghề kinh doanh nhạy cảm trên địa bàn. Đề án này đã được đưa ra lấy ý kiến lãnh đạo, phòng văn hóa của 24 quận, huyện và được thông qua một lần tại hội nghị do ủy ban thành phố tổ chức. Sở Văn hóa đang hoàn thiện và tiếp tục lấy ý kiến các quận, huyện để sớm trình thường trực UBND TP và khoảng cuối tháng 4 sẽ thông qua.Tư tưởng chung của đề án là không tăng điểm kinh doanh các ngành nghề nhạy cảm nhưng phân cấp quyền cấp phép cho chủ tịch các quận, huyện và địa phương phải có trách nhiệm quản lý các cơ sở do mình cấp phép. Sở Văn hóa - Thể thao và Du lịch không phải là đơn vị cấp phép nữa, Phó chủ tịch phụ trách lĩnh vực văn hóa - xã hội của TP HCM cho biết. Tại hội nghị, lãnh đạo Công an TP HCM cũng cho biết, trong 3 tháng cao điểm, trên địa bàn thành phố xảy ra 1.155 vụ phạm pháp hình sự, giảm 13,8% so với thời gian liền kề và 6,1% so với cùng kỳ, làm chết 21 người, bị thương 157 người, tài sản thiệt hại trị giá trên 50 tỷ đồng. Công an đã điều tra khám phá 777 vụ phạm pháp hình sự, bắt 975 tên (đạt hơn 67%). Tình hình vận chuyển ma túy, vận chuyển vũ khí tự chế qua đường hàng không đang có chiều hướng diễn biến phức tạp";
		jk = jk.replace(",", " ");
		jk = jk.replace(".", " ");
		jk = jk.replace("!", " ");
		jk = jk.replace(":", " ");
		jk = jk.replace(";", " ");
		jk = jk.replace("&", " ");
		String[] m = jk.split(" ");
		for(String w:m)
		{
			if(MyDict.isWord(w))
			{
				System.out.println(w);
			}
		}
		MyDict.isWord("điên");
		
		System.out.print("what the fuck");
		String tmp;
		try {
			Document doc = Jsoup.connect(mDomain).get();
			//get page text
			tmp = doc.text();
			tmp = MyDict.formatDoc(tmp);
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
	}

}
