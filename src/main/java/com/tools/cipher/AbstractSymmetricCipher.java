package com.tools.cipher;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

/**
 * <b>类名称：</b>com.mytools.utils.cipher.AbstractSymmetricCipher<br>
 * <b>类描述：</b>对称加密算法模板方法类<br>
 * <b>创建人：</b>hp<br>
 * <b>创建时间：</b>2019-2-18 上午11:04:11<br>
 * <b>修改人：</b>  <br>
 * <b>修改时间：</b>2019-2-18 上午11:04:11<br>
 * <b>修改备注：</b> <br>
 * @version 1.0.0
 * @since JDK 1.5
 */
public abstract class AbstractSymmetricCipher implements ICipher{

	protected SecretKey secretKey;//密钥
	protected String keyAlgorithm;//密钥算法

	public AbstractSymmetricCipher(String keyAlgorithm) {
		this.keyAlgorithm = keyAlgorithm;
	}


	public String encrypt(String plainText) throws Exception {
		Cipher cipher = Cipher.getInstance(keyAlgorithm);
		secretKey = getSecretKey();
		cipher.init(Cipher.ENCRYPT_MODE, secretKey);
		return CipherUtil.byteArr2HexStr(cipher.doFinal(plainText.getBytes("UTF-8")));
	}

	public String decrypt(String cipherText) throws Exception {
		Cipher cipher = Cipher.getInstance(keyAlgorithm);
		secretKey = getSecretKey();
		cipher.init(Cipher.DECRYPT_MODE, secretKey);
		return new String(cipher.doFinal(CipherUtil.hexStr2ByteArr(cipherText)), "UTF-8");
	}

	protected abstract SecretKey getSecretKey();

}