package common;

public class Function {

	/**
	 * 스트링 인자값이 null일경우 ""값으로 리턴한다.
	 * @param str : check 값
	 * @param result : str이 null일경우 ""리턴.
	 */
	public static String nullCk(String str){
		if(str==null || str.equals("null") || str.equals("")){
			str="";
		}else{
			str = str.trim();
		}
		return str;
	}
	
	/**
	 * 스트링 인자값이 null일경우 ""값으로 리턴한다.
	 * @param str : check 값
	 * @param result : str이 null일경우 ""리턴.
	 */
	public static String nullChk(String str){
		if(str==null || str.equals("null") || str.equals("")){
			str="";
		}else{
			str = fnTagOff(str.trim());
		}
		return str;
	}
  
	/**
	 * 스트링 인자값이 null일경우 원하는 스트링 결과값으로 리턴한다.
	 * @param str : check 값
	 * @param result : str이 null일경우 원하는 값
	 */
	public static String nullChk(String str, String result){
		if(str==null || str.equals("null") || str.equals("")){
			return result;
		}else{
			str = fnTagOff(str.trim());
			return str;
		}
	}
  
	/**
	 * 스트링 인자값이 null일경우 원하는 int 결과값으로 리턴한다.
	 * @param str : check 값
	 * @param result : str이 null일경우 원하는 값
	 */
	public static int nullChk(String str, int result){
		if(str==null || str.equals("null") || str.equals("")){
			return result;
		}else{
			str = fnTagOff(str.trim());
			return Integer.parseInt(str);
		}
	}
	
	/**
	 * html tag 막기
	 * @param str
	 * @return
	 */
	public static String fnTagOff(String str){
		if(str==null || str.equals("null") || str.equals("")){
			str = "";
		}else{			
			str = str.trim();
			//str = str.replaceAll("&","&amp;");
			str = str.replaceAll("\"","&quot;");
			str = str.replaceAll("<","&lt;");
			str = str.replaceAll(">","&gt;");
			str = str.replaceAll("'","’"); //’는 한글 ㄴ의 특수문자임
		}
		return str;
	}
}
