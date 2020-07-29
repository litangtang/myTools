package com.tools.cipher;

import com.umpay.mall.aes.QuickAESTools;
import org.apache.commons.lang.StringUtils;

public class StdPayAESUtil {

    private static QuickAESTools.AesInf aes = new QuickAESTools.Aes16x();
    private static String taxKey ="ttQLEg4MuvQq8Mb6";
//    private static final MyLog log = MyLog.getLog(AES.class);

    /**
     * 使用默认密钥,加密
     * @param source
     * @return
     */
    public static String encrypt(String source) {
        return encrypt(source, taxKey);
    }

    /**
     * 使用默认密钥,解密
     * @param source
     * @return
     */
    public static String decrypt(String source) {
        return decrypt(source, taxKey);
    }


    /**
     * 使用指定密钥,加密
     * @param source
     * @return
     */
    public static String encrypt(String source, String aesKey) {
        if(StringUtils.isEmpty(source) || StringUtils.isEmpty(aesKey)){
            return "";
        }
        byte[] key = aesKey.getBytes();
        try {
            return aes.encrypt(key, source);
        } catch (Exception e) {
//            log.error(e, "AES加密异常");
            return source;
        }
    }

    /**
     * 使用指定密钥,解密
     * @param source
     * @return
     */
    public static String decrypt(String source, String aesKey) {
        if(StringUtils.isEmpty(source) || StringUtils.isEmpty(aesKey)){
            return "";
        }
        byte[] key = aesKey.getBytes();
        try {
            return aes.decrypt(key, source);
        } catch (Exception e) {
//            log.error(e, "AES解密异常");
            return source;
        }
    }

    public static void main(String[] args) {
        System.out.println(StdPayAESUtil.decrypt("wzIFmOOkDYfLYWgS1ml4NUuY8OxMSY24tO+4XxfJydw=", "ttQLEg4MuvQq8Mb6"));
    }
}
