package com.tools.cipher;


/**
 * <b>�����ƣ�</b>com.mytools.utils.cipher.UecpAESUtil<br>
 * <b>��������</b>TODO<br>
 * <b>�����ˣ�</b>hp<br>
 * <b>����ʱ�䣺</b>2019-2-18 ����05:51:37<br>
 * <b>�޸��ˣ�</b>  <br>
 * <b>�޸�ʱ�䣺</b>2019-2-18 ����05:51:37<br>
 * <b>�޸ı�ע��</b> <br>
 * @version 1.0.0
 * @since JDK 1.5
 */
public class UecpAESUtil {
	
	private static final String UECP_AES_PREFIX = "AES#";//����ǰ׺
	private static AESUtil aesUtil = null;
	private static DESCipher desCipher = null;
	static {
		//TODO �������ļ���ȡ��Կ�ַ���
		
		aesUtil = new AESUtil("1234567890ABCDEF");
		desCipher = new DESCipher("KSagZxG3");
	}
	
	/**
	 * ���ܹ��̣� AES-128���ܽ������ǰ׺AES#
	 * @param plainText
	 * @return
	 * @throws Exception
	 */
	public static String encrypt(String plainText) throws Exception {
		String cipherText = aesUtil.encrypt(plainText);
		return UECP_AES_PREFIX + cipherText;
	}
	
	/**
	 * ���ܹ�����
	 * @param cipherText
	 * @return
	 * @throws Exception
	 */
	public static String decrypt(String cipherText) throws Exception {
		if(cipherText.startsWith(UECP_AES_PREFIX)) {
			return aesUtil.decrypt(cipherText.substring(4));
		}
		return desCipher.decrypt(cipherText);
	}
	
	public static void main(String[] args) throws Exception {
		AESUtil aesUtil = new AESUtil("1234567890ABCDEF");
		System.out.println("���п���AES-128���ܽ����" + UecpAESUtil.encrypt("6226200104000076"));//����
		System.out.println(UecpAESUtil.decrypt("AES#EC45C3F8A8EFCE5EAB381E65438A913064E51CE411E54D519DD59FE37381D4F5"));
		System.out.println(UecpAESUtil.decrypt("52098cbaf9ff9f8ac9340b233c60cf645db1cb928ee91229"));
	}
}
