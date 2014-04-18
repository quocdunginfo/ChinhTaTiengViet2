package qd.Dict.pkg;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

public class MyDict {
	public static String allow = "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđqertyuiopasdghklxcvbnm";
	public void updateDict(String document)
	{
		
	}
	public static String formatDoc(String raw)
	{
		//loai bo ky ky dac biet
		String re;
		re = raw.replaceAll("[$&+,:;=?@#|]", "_");
		//chuyen ve in thuong het
		re = re.toLowerCase();
		//them khoang trang vao truoc va sau dau cau
		re = re.trim();
		while(re.contains("  "))
		{
			re = re.replace("  ", " ");
		}
		return re;
	}
	public static Boolean isWord(String input)
	{
		String tmp = input.toLowerCase();
		for(Character k:tmp.toCharArray())
		{
			if(!allow.contains(k.toString()))
			{
				return false;
			}
		}
		return true;
		
	}
}
