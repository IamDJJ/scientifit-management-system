package com.scientific.manage.util;

import java.security.MessageDigest;
import java.sql.Blob;
import java.sql.SQLException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class StaticMethod {
	 public static String getRandom(int i) {
		  Random jjj = new Random();
		  // int suiJiShu = jjj.nextInt(9);
		  if (i == 0)
		   return "";
		  String jj = "";
		  for (int k = 0; k < i; k++) {
		   jj = jj + jjj.nextInt(9);
		  }
		  return jj;
		 }
	 public static Date getNowDate() {
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dateString = formatter.format(currentTime);
		 ParsePosition pos = new ParsePosition(8);
		 Date currentTime_2 = formatter.parse(dateString, pos);
		 return currentTime_2;
		 }
	 public static String getStringDate() {
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		 String dateString = formatter.format(currentTime);
		 return dateString;
		 }
	 public static String getStringDateShort() {
		 Date currentTime = new Date();
		 SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 String dateString = formatter.format(currentTime);
		 return dateString;
		 }
	 public static String BtoStr(Object o) throws SQLException{
			String str = null;
			byte[] inbyte=null;
			if(o instanceof Blob){
				Blob blob = (Blob) o;
		        if (blob != null) {
		            inbyte = blob.getBytes(1, (int) blob.length());
		        }
				str =new String (inbyte);
			}
			return str;
		}
	 
	 public static String MD5(String key) {
	        char hexDigits[] = {
	                '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'
	        };
	        try {
	            byte[] btInput = key.getBytes();
	            // ���MD5ժҪ�㷨�� MessageDigest ����
	            MessageDigest mdInst = MessageDigest.getInstance("MD5");
	            // ʹ��ָ�����ֽڸ���ժҪ
	            mdInst.update(btInput);
	            // �������
	            byte[] md = mdInst.digest();
	            // ������ת����ʮ�����Ƶ��ַ�����ʽ
	            int j = md.length;
	            char str[] = new char[j * 2];
	            int k = 0;
	            for (int i = 0; i < j; i++) {
	                byte byte0 = md[i];
	                str[k++] = hexDigits[byte0 >>> 4 & 0xf];
	                str[k++] = hexDigits[byte0 & 0xf];
	            }
	            return new String(str);
	        } catch (Exception e) {
	            return null;
	        }
	    }

	 public static void main(String[] args) {
		 System.out.println("radom+"+getRandom(4));
		 System.out.println("getNowDate=="+getStringDate());
		 System.out.println("getStringDateShort=="+getStringDateShort());
		
	 }
}
