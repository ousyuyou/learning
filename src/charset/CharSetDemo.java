package charset;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;

public class CharSetDemo {
	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		String str = "’†";
		
		char[] dst = new char[str.length()];
		str.getChars(0, str.length(), dst, 0);
		
		for(char c:dst){
			System.out.println("char value: "+c);
		}
		byte[] bytes = getBytes(dst);
		System.out.println("Java String's char byte[]");
		printHexString(bytes);
		
		System.out.println("sjis_0213 char byte[]");
		byte[] byte_sjis = str.getBytes("sjis_0213");
		printHexString(byte_sjis);
		
//		String str2 = new String(byte_sjis,"sjis_0213");
//		System.out.println(str2);
		
		System.out.println("windows-31j(default charset) char byte[]");
		byte[] bytes_31j = str.getBytes("windows-31j");//
//		System.out.println(bytes_31j.length);
		printHexString(bytes_31j);
//		String str3 = new String(bytes_31j);
//		System.out.println(str3);
		
		System.out.println("utf-8 char byte[]");
		byte[] byte_utf8 = str.getBytes("utf-8");//
//		System.out.println(byte_utf8.length);
		
		printHexString(byte_utf8);
//		String str4 = new String(byte_utf8,"utf-8");
//		System.out.println(str4);
		
		System.out.println("utf-16 char byte[]");
		byte[] byte_utf16 = str.getBytes("utf-16");//FE FF:BOM(UTF-16BE)Byte Order Mark
//		System.out.println(byte_utf16.length);
		printHexString(byte_utf16);
		
		System.out.println("unicode char byte[]");
		byte[] bytesUC = str.getBytes("unicode");//FE FF:BOM
//		System.out.println(bytesUC.length);
		printHexString(bytesUC);
		
	}
	
	public static void printHexString( byte[] b) {  
		   for (int i = 0; i < b.length; i++) { 
		     String hex = Integer.toHexString(b[i] & 0xFF); 
		     if (hex.length() == 1) { 
		       hex = '0' + hex; 
		     }
		     System.out.println(hex.toUpperCase() ); 
		   } 

	}
	
	private static byte[] getBytes(char[] chars) {
		   Charset cs = Charset.forName ("windows-31j");
		   CharBuffer cb = CharBuffer.allocate (chars.length);
		   cb.put(chars);
		   cb.flip();
		   ByteBuffer bb = cs.encode(cb);
		  
		   return bb.array();
	}
	
//	private static char[] getChars(byte[] bytes) {
//	      Charset cs = Charset.forName("UTF-8");
//	      ByteBuffer bb = ByteBuffer.allocate (bytes.length);
//	      bb.put (bytes);
//	      bb.flip ();
//	      CharBuffer cb = cs.decode (bb);
//	  
//	      return cb.array();
//	}
}
