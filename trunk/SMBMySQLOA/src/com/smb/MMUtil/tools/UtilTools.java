/**
 * 
 */
package com.smb.MMUtil.tools;

import sun.misc.BASE64Decoder;

/**
 * @author huangyi
 * 
 */
public class UtilTools {

	// 将 string 进行 BASE64 编码
	public static String getBASE64(String string) {
		if (string == null)
			return null;
		return (new sun.misc.BASE64Encoder()).encode(string.getBytes());
	}

	// 将 BASE64 编码的字符串 base64 进行解码
	public static String getFromBASE64(String base64) {
		if (base64 == null)
			return null;
		BASE64Decoder decoder = new BASE64Decoder();
		try {
			byte[] b = decoder.decodeBuffer(base64);
			return new String(b);
		} catch (Exception e) {
			return null;
		}
	}
	
	 
	
}
 
