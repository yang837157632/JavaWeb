package StudentManagement;

import java.io.UnsupportedEncodingException;

public class CharactorTool {
	public static String convertUTF8(String str) {
		String result = null;
		try {

			result=new String(str.getBytes("iso-8859-1"), "utf-8");

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result;
	}
}
