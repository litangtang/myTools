package com.tools.cipher;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * <b>类名称：</b>com.mytools.utils.cipher.AESCipher<br>
 * <b>类描述：</b>TODO<br>
 * <b>创建人：</b>hp<br>
 * <b>创建时间：</b>2019-2-18 下午02:38:51<br>
 * <b>修改人：</b>  <br>
 * <b>修改时间：</b>2019-2-18 下午02:38:51<br>
 * <b>修改备注：</b> <br>
 * @version 1.0.0
 * @since JDK 1.5
 */
public class AESCipher extends AbstractSymmetricCipher {

	public static final String KEY_ALGORITHM = "AES";
	public String key;

	/**
	 * @param key
	 */
	public AESCipher(String key) {
		super(KEY_ALGORITHM);
		this.key = key;
	}

	/* 密钥长度为16个字节即128位则为AES-128
	 * @see com.mytools.utils.cipher.AbstractSymmetricCipher#getSecretKey()
	 */
	@Override
	protected SecretKey getSecretKey() {
		// 判断Key是否为16位
//        if (this.key.length() != 16) {
//            System.out.println("Key长度不是16位");
//            return null;
//        }
//		SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
//		return secretKey;
		KeyGenerator kg = null;
		try {
			kg = KeyGenerator.getInstance("AES");
			kg.init(128, new SecureRandom("uecpaes".getBytes("UTF-8")));
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return kg.generateKey();
	}

	/**
	 *
	 * @param seed 种子
	 */
	private void generateKeyByPass(String seed) {
		try {
			KeyGenerator kg = KeyGenerator.getInstance("AES");
			kg.init(128, new SecureRandom(seed.getBytes("UTF-8")));
			SecretKey sk = kg.generateKey();
			byte[] b = sk.getEncoded();
			System.out.println(new String(b, "UTF-8"));
			String s = byteToHexString(b);
			System.out.println(s);
			System.out.println("十六进制密钥长度为"+s.length());
			System.out.println("二进制密钥的长度为"+s.length()*4);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * byte数组转化为16进制字符串
	 * @param bytes
	 * @return
	 */
	public static String byteToHexString(byte[] bytes) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bytes.length; i++) {
			String strHex=Integer.toHexString(bytes[i]);
			if(strHex.length() > 3) {
				sb.append(strHex.substring(6));
			} else {
				if(strHex.length() < 2) {
					sb.append("0" + strHex);
				} else {
					sb.append(strHex);
				}
			}
		}
		return sb.toString();
	}


	public static void main(String[] args) throws Exception {
		AESCipher aesCipher = new AESCipher("ttQLEg4MuvQq8Mb6");
//		aesCipher.generateKeyByPass("uecpaes");
//		System.out.println("银行卡号AES-128加密结果：" + aesCipher.encrypt("6226200104000076"));//卡号
//		System.out.println("银行卡号AES-128解密结果：" + aesCipher.decrypt("EC45C3F8A8EFCE5EAB381E65438A913064E51CE411E54D519DD59FE37381D4F5"));
//		System.out.println("身份证号AES-128加密结果：" + aesCipher.encrypt("110101198001010176"));
		System.out.println("身份证号AES-128解密结果：" + aesCipher.decrypt("wzIFmOOkDYfLYWgS1ml4NUuY8OxMSY24tO+4XxfJydw="));
//		System.out.println("姓名AES-128加密结果：" + aesCipher.encrypt("联动优势商务有限公司"));
//		System.out.println("姓名AES-128解密结果：" + aesCipher.decrypt("wzIFmOOkDYfLYWgS1ml4NUuY8OxMSY24tO+4XxfJydw="));
//		System.out.println(aesCipher.decrypt("D006424B716A8033E9B964C46889D5E9"));



//		System.out.println(RandomStringUtils.randomAlphanumeric(16));
	}

}
