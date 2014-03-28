package qd.WebFrameWork.pkg;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class MyHTML {

	public String getContent(String url_)
	{
		URL url;
		String re="";
		try {
			url = new URL(url_);
			InputStream in = url.openStream();
			Scanner scan = new Scanner(in);
			 
			int line = 1;
			while (scan.hasNext())
			{
			    String str = scan.nextLine();
			    System.out.println( (line++) + ": " + str);
			}
			scan.close();
			return re;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return re;
	}

}
