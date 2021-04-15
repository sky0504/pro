package com.wb.pro.util;

import org.junit.Test;

import java.security.KeyPair;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Map;

/**
 * @author wangbin
 * @date 2021/4/11 15:01
 */
public class AesUtilTest {
    @Test
    public void aesTest() throws Exception {
        /*
         * 此处使用AES-128-ECB加密模式，key需要为16位。
         */
        String cKey = "1234567890123456";
        // 需要加密的字串
        String cSrc = "buxuewushu";
        LogPrintUtil.systemOutPrintln(cSrc);
        // 加密
        String enString = AesUtil.Encrypt(cSrc, cKey);
        LogPrintUtil.systemOutPrintln("加密后的字串是：" + enString);

        // 解密
        String DeString = AesUtil.Decrypt(enString, cKey);
        LogPrintUtil.systemOutPrintln("解密后的字串是：" + DeString);
    }

    @Test
    public void desTest() throws Exception {
        String data = "123 456";
        String key = "wang!@#$";
        String key1 = "wang!@#$11123";
        LogPrintUtil.systemOutPrintln(DesUtil.encrypt(data, key));
        LogPrintUtil.systemOutPrintln(DesUtil.decrypt(DesUtil.encrypt(data, key), key1));
    }

    @Test
    public void rsaTest() throws NoSuchAlgorithmException, InvalidKeySpecException {
        Map<String, String> keyMap = RsaUtil.createKeys(1024);
        String  publicKey = keyMap.get("publicKey");
        String  privateKey = keyMap.get("privateKey");
        System.out.println("公钥: \n\r" + publicKey);
        System.out.println("私钥： \n\r" + privateKey);

        System.out.println("公钥加密——私钥解密");
        String str = "code_cayden";
        System.out.println("\r明文：\r\n" + str);
        System.out.println("\r明文大小：\r\n" + str.getBytes().length);
        String encodedData = RsaUtil.publicEncrypt(str, RsaUtil.getPublicKey(publicKey));
        System.out.println("密文：\r\n" + encodedData);
        String decodedData = RsaUtil.privateDecrypt(encodedData, RsaUtil.getPrivateKey(privateKey));
        System.out.println("解密后文字: \r\n" + decodedData);
    }
}
