package com.tools.cipher;

public class CipherUtil
{
	private CipherUtil()
	{

	}

	/**
	 * 将byte数组转换为表�?6进制值的字符串， 如：byte[]{8,18}转换为：0813，和hexStr2ByteArr(String strhex) 互为可�?的转换过�?
	 * 
	 * @param byteArr
	 *            �?��转换的byte数组
	 * @return 转换后的字符�?
	 */
	public static String byteArr2HexStr(byte[] byteArr)
	{
		String hs = "";
		String stmp = "";
		for (int n = 0; n < byteArr.length; n++)
		{
			stmp = (Integer.toHexString(byteArr[n] & 0XFF));
			if (stmp.length() == 1)
			{
				hs = hs + "0" + stmp;
			}
			else
			{
				hs = hs + stmp;
			}
		}
		return hs.toUpperCase();
	}

	/**
	 * 将表�?6进制值的字符串转换为byte数组�?�?byteArr2HexStr(byte[] byteArr) 互为可�?的转换过�?
	 * 
	 * @param strhex
	 *            �?��转换的字符串
	 * @return 转换后的byte数组
	 */
	public static byte[] hexStr2ByteArr(String strhex)
	{
		if (strhex == null)
		{
			return null;
		}
		int l = strhex.length();

		if (l % 2 == 1)
		{
			return null;
		}
		byte[] b = new byte[l / 2];
		for (int i = 0; i != l / 2; i++)
		{
			b[i] = (byte) Integer.parseInt(strhex.substring(i * 2, i * 2 + 2), 16);
		}
		return b;
	}

	public static byte[] bcd(String nstr)
	{
		// BCD编码
		return bcd(nstr, 'F');
	}

	public static byte[] bcd(String nstr, char padding)
	{
		// BCD编码
		String ss = nstr;
		int c2 = nstr.getBytes().length % 2;
		if (c2 != 0)
			ss += padding;
		int n2 = ss.getBytes().length / 2;
		byte[] bs = new byte[n2];
		for (int i = 0; i < n2; i++)
		{
			int b1 = hex(ss.charAt(i * 2));
			int b2 = hex(ss.charAt(i * 2 + 1));
			int bi = b1 * 16 + b2;
			bs[i] = (byte) bi;
		}
		// System.out.println("- BCD : "+nstr+" => "+Util.px(bs));
		return bs;
	}

	private static int hex(char c)
	{
		// BCD编码
		int b = -1;
		if ('0' <= c && c <= '9')
			b = c - '0';
		else if ('A' <= c && c <= 'F')
			b = c - 'A' + 10;
		else if ('a' <= c && c <= 'f')
			b = c - 'a' + 10;
		else
			b = -1;
		return b;
	}

}
