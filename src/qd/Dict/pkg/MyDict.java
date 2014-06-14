package qd.Dict.pkg;

import com.sun.org.apache.bcel.internal.generic.AllocationInstruction;

public class MyDict {
	public static String allow = "àáạảãâầấậẩẫăằắặẳẵèéẹẻẽêềếệểễìíịỉĩòóọỏõôồốộổỗơờớợởỡùúụủũưừứựửữỳýỵỷỹđqertyuiopasdghklxcvbnmfjwz";
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
	/**
	 * Loc bo moi ky tu dac biet ra khoi 1 tu tieng viet
	 * @param word
	 * @return
	 */
	public static String filterRightWord(String word)
	{
		String tmp = word.toLowerCase();
		String re="";
		for(Character k:tmp.toCharArray())
		{
			if(allow.contains(k.toString()))
			{
				re+=k;
			}
		}
		return re;
	
	}
}
