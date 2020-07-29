package com.tools.cipher;

/**
 * @param <T>
 */
public interface ICipher
{
	public String encrypt(String plainText) throws Exception;
	
	public String decrypt(String cipherText) throws Exception;
}
