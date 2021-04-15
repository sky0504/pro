package com.wb.pro.util;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

/**
 * AES加密算法
 * @author wangbin
 * @date 2021/4/11 14:55
 */
public class AesUtil {

//    算法/模式/填充	16字节加密后数据长度	不满16字节加密后长度
//    AES/CBC/NoPadding	16	不支持
//    AES/CBC/PKCS5Padding	32	16
//    AES/CBC/ISO10126Padding	32	16
//    AES/CFB/NoPadding	16	原始数据长度
//    AES/CFB/PKCS5Padding	32	16
//    AES/CFB/ISO10126Padding	32	16
//    AES/ECB/NoPadding	16	不支持
//    AES/ECB/PKCS5Padding	32	16
//    AES/ECB/ISO10126Padding	32	16
//    AES/OFB/NoPadding	16	原始数据长度
//    AES/OFB/PKCS5Padding	32	16
//    AES/OFB/ISO10126Padding	32	16
//    AES/PCBC/NoPadding	16	不支持
//    AES/PCBC/PKCS5Padding	32	16
//    AES/PCBC/ISO10126Padding	32	16

    // 加密
    public static String Encrypt(String sSrc, String sKey) throws Exception {
        if (sKey == null) {
            LogPrintUtil.systemOutPrintln("Key为空null");
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            LogPrintUtil.systemOutPrintln("Key长度不是16位");
            return null;
        }
        byte[] raw = sKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");//"算法/模式/补码方式"
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
        byte[] encrypted = cipher.doFinal(sSrc.getBytes("utf-8"));

        return Base64.getEncoder().encodeToString(encrypted);//此处使用BASE64做转码功能，同时能起到2次加密的作用。
    }

    // 解密
    public static String Decrypt(String sSrc, String sKey) throws Exception {
        try {
            // 判断Key是否正确
            if (sKey == null) {
                LogPrintUtil.systemOutPrintln("Key为空null");
                return null;
            }
            // 判断Key是否为16位
            if (sKey.length() != 16) {
                LogPrintUtil.systemOutPrintln("Key长度不是16位");
                return null;
            }
            byte[] raw = sKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec);
            byte[] encrypted1 = Base64.getDecoder().decode(sSrc);//先用base64解密
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original,"utf-8");
                return originalString;
            } catch (Exception e) {
                LogPrintUtil.systemOutPrintln(e.toString());
                return null;
            }
        } catch (Exception ex) {
            LogPrintUtil.systemOutPrintln(ex.toString());
            return null;
        }
    }

}
