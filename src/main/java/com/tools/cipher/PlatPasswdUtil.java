package com.tools.cipher;

import java.security.MessageDigest;

/**
 * 业管平台密码加密工具类
 */
public class PlatPasswdUtil {

    public static final String algorithm = "SHA";

    public static String encodePassword(String password, String algorithm) {
        byte[] unencodedPassword = password.getBytes();
        MessageDigest md = null;

        try {
            md = MessageDigest.getInstance(algorithm);
        } catch (Exception var7) {
            return password;
        }

        md.reset();
        md.update(unencodedPassword);
        byte[] encodedPassword = md.digest();
        StringBuffer buf = new StringBuffer();

        for(int i = 0; i < encodedPassword.length; ++i) {
            if ((encodedPassword[i] & 255) < 16) {
                buf.append("0");
            }

            buf.append(Long.toString((long)(encodedPassword[i] & 255), 16));
        }

        return buf.toString();
    }

    public static void main(String[] args) {
        System.out.println(PlatPasswdUtil.encodePassword("umpay1234", algorithm));//bfe7c38cc10717dab3a8eaf0c94f33a2bac2364f
    }
}
