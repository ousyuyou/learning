package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegulaExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Pattern pattern = Pattern.compile("[,|]+");
//		String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
//		for (int i=0;i<strs.length;i++) {
//		    System.out.println(strs[i]);
//		}
//		
//		pattern = Pattern.compile("[^\\\\]*$");
//		Matcher matcher = pattern.matcher("C:\\programe files\\a.txt");
//		while(matcher.find()){
//			System.out.println(matcher.group());
//		}
		
//		//mail address justify
//		String str="21500-11@yahoo.com-1.cn";
//		System.out.println(isMailAddress(str));
//		
//		//replace html tag
//		str = "<a href=\"index.html/\">homepage</a>";
//		System.out.println(replaceHtmlTag(str));
//		
//		String tel = "021-67519871";
//		System.out.println(isTel(tel));
//		tel = "0556-7519871";
//		System.out.println(isTel(tel));
//		
//		String dec1 = "12.3750000392";
//		String dec2 = "01.500";
//		
//		trimDecimal(dec1);
//		trimDecimal(dec2);
//		String dec3 = "2984144215";
//		System.out.println(formatDecimal(dec3));
		
		String strWord = "this that that is abc";
		System.out.println(matchMultipyWord(strWord));

	}
	
	public static boolean isMailAddress(String input){
		//mail address justify
		Pattern pattern = Pattern.compile("[\\w-]+@[\\w-]+\\.[\\w-]+[\\.\\w-]*",Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}

	public static String replaceHtmlTag(String input){
		Pattern pattern = Pattern.compile("<.+?>", Pattern.DOTALL);
		Matcher matcher = pattern.matcher(input);
		String string = matcher.replaceAll("");
		
		return string;
	}
	
	public static boolean isTel(String input){
		Pattern pattern = Pattern.compile("\\d{3,4}-\\d{7,8}", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		return matcher.matches();
	}
	
	public static void trimDecimal(String input){
		Pattern pattern = Pattern.compile("([1-9][0-9]*)(\\.\\d\\d[1-9]?)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		while(matcher.find()){
			System.out.println(matcher.group());
		}
	}
	
	public static String formatDecimal(String input){
		String strCopy = new String(input);
		Pattern pattern = Pattern.compile("(?<=\\d)(?=(\\d\\d\\d)+$)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(strCopy);
		strCopy = matcher.replaceAll(",");
		return strCopy;
	}
	
	public static boolean matchMultipyWord(String input){
		//TODO:bug for fix
		Pattern pattern = Pattern.compile("\\b(\\[a-z]+)((?:\\s)+)(\\1\\b)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(input);
		if(matcher.matches()){
			System.out.println(matcher.group());
			System.out.println(matcher.replaceAll("$1"));
			return true;
		}
		return false;
	}
}
