package com.tools.cipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 * <b>�����ƣ�</b>com.mytools.utils.cipher.AESUtil<br>
 * <b>��������</b>AES-128�ӽ��ܹ�����<br>
 * <b>�����ˣ�</b>hp<br>
 * <b>����ʱ�䣺</b>2019-2-18 ����05:40:38<br>
 * <b>�޸��ˣ�</b>  <br>
 * <b>�޸�ʱ�䣺</b>2019-2-18 ����05:40:38<br>
 * <b>�޸ı�ע��</b> <br>
 * @version 1.0.0
 * @since JDK 1.5
 */
public class AESUtil {
	
	public static final String KEY_ALGORITHM = "AES";//�㷨
	private SecretKey secretKey;//��Կ
	public String key;
	
	/**
	 * @param key
	 */
	public AESUtil(String key) {
		this.key = key;
	}

	/**
	 * ���ܷ���
	 * @param plainText ����
	 * @return
	 * @throws Exception
	 */
	public String encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		secretKey = getSecretKey();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return CipherUtil.byteArr2HexStr(cipher.doFinal(plainText.getBytes("UTF-8")));
	}
	
	/**
	 * ����
	 * @param cipherText ����
	 * @return
	 * @throws Exception
	 */
	public String decrypt(String cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
		secretKey = getSecretKey();
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return new String(cipher.doFinal(CipherUtil.hexStr2ByteArr(cipherText)), "UTF-8");
	}

	/**
	 * ��ȡ��Կ
	 * @return
	 */
	private SecretKey getSecretKey() {
		// �ж�Key�Ƿ�Ϊ16λ
        if (this.key.length() != 16) {
            System.out.println("Key���Ȳ���16λ");
            return null;
        }
		SecretKey secretKey = new SecretKeySpec(key.getBytes(), KEY_ALGORITHM);
		return secretKey;
	}
	
	public static void main(String[] args) throws Exception{
		AESUtil aesCipher = new AESUtil("1234567890ABCDEF");
		System.out.println("���п���AES-128���ܽ����" + aesCipher.encrypt("6226200104000076"));//����
		System.out.println("���п���AES-128���ܽ����" + aesCipher.decrypt("EC45C3F8A8EFCE5EAB381E65438A913064E51CE411E54D519DD59FE37381D4F5"));
		System.out.println("���֤��AES-128���ܽ����" + aesCipher.encrypt("110101198001010176"));
		System.out.println("���֤��AES-128���ܽ����" + aesCipher.decrypt("4FDBA73F61E9BD1DDCDE360CBCD159142D109892C66ABC80B4980057F26146C6"));
		System.out.println("����AES-128���ܽ����" + aesCipher.encrypt("���������������޹�˾"));
		System.out.println("����AES-128���ܽ����" + aesCipher.decrypt("097AF1F053B608CF9B5E353A8AF193470A01E407B93DD2C35C855735A3B12B5C"));
	}

}
