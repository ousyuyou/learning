package regex;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegulaExpression {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Pattern pattern = Pattern.compile("[,|]+");
		String[] strs = pattern.split("Java Hello World  Java,Hello,,World|Sun");
		for (int i=0;i<strs.length;i++) {	
		    System.out.println(strs[i]);
		}

		//mail address justify
		String str="21500-11@yahoo.com-1.cn";
		System.out.println(isMailAddress(str));
		
		//replace html tag
		str = "<a href=\"index.html/\">homepage</a>";
		System.out.println(replaceHtmlTag(str));
		
		String tel = "021-67519871";
		System.out.println(isTel(tel));
		tel = "0556-7519871";
		System.out.println(isTel(tel));
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
}
