package com.tools.cipher;

import javax.crypto.SecretKey;
import java.util.Base64;

/**
 * <b>类名称：</b>com.mytools.utils.cipher.DESCipher<br>
 * <b>类描述：</b>TODO<br>
 * <b>创建人：</b>hp<br>
 * <b>创建时间：</b>2019-2-18 下午02:47:00<br>
 * <b>修改人：</b>  <br>
 * <b>修改时间：</b>2019-2-18 下午02:47:00<br>
 * <b>修改备注：</b> <br>
 * @version 1.0.0
 * @since JDK 1.5
 */
public class DESCipher extends AbstractSymmetricCipher {

	public String key;
	public static final String KEY_ALGORITHM = "DES";

	/**
	 * @param key
	 */
	public DESCipher(String key) {
		super(KEY_ALGORITHM);
		this.key = key;
	}



	/* (non-Javadoc)
	 * @see com.mytools.utils.cipher.AbstractSymmetricCipher#getSecretKey()
	 */
	@Override
	protected SecretKey getSecretKey() {
		byte[] arrBTmp = key.getBytes();
		// 创建一个空的8位字节数组（默认值为0）
		byte[] arrB = new byte[8];
		// 将原始字节数组转换为8位
		for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
			arrB[i] = arrBTmp[i];
		}

		// 生成密钥
		SecretKey key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
		return key;
	}

	public static void main(String[] args) throws Exception {
//		DESCipher desCipher = new DESCipher("KSagZxG3");
		DESCipher desCipher = new DESCipher("GXlJzbo0");//pbg
//		System.out.println(desCipher.encrypt("222401198307313114"));//52098cbaf9ff9f8ac9340b233c60cf645db1cb928ee91229
//		System.out.println(desCipher.encrypt("6225551111111199"));
		System.out.println(desCipher.decrypt("7292a1b24e4ff7f630db629f030a99b56f3f4d7d3d2a72de"));
	}

}
