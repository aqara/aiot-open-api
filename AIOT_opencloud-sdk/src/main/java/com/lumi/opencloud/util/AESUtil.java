package com.lumi.opencloud.util;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.Base64;

/**
 * AES PKCS5
 */
public class AESUtil {

    private static final String ENCRYPT_AES = "AES/CBC/PKCS5Padding";
    public static final String CHARSET_UTF_8 = "utf-8";
    public static final String DEFAULT_AES_KEY = "mvDJmObSkSOuqT4Q";
    private static final int SECURE_KEY_LENGTH = 16;


    /**
     *  AES ECB 128加密
     *  iv偏移量，ECB不用设置
     *  加密结果再进行Base64加密
     * @param src
     * @param key
     * @throws Exception
     */
    public static String encryptEcb(String src, byte[] key) throws Exception {

        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec);

        byte[] content = src.getBytes(CHARSET_UTF_8);

        byte[] ret = cipher.doFinal(content);

        return  Base64.getEncoder().encodeToString(ret);
    }

    /**
     * ECB解密 结果含Base64加密
     * @param src
     * @param key
     * @return
     * @throws Exception
     */
    public static String decryptEcb(String src,byte[] key) throws Exception{

        byte[] srcByte = Base64.getDecoder().decode(src);
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, skeySpec);
        byte[] ret = cipher.doFinal(srcByte);
        return new String(ret,CHARSET_UTF_8);
    }

    /**
     * AES CBC 128加密
     * 加密结果再进行Base64编码
     * 动态偏移量
     * @param src 加密字符串
     * @param key 密码 16位
     * @throws Exception
     */
    public static String encryptCbc(String src, byte[] key) throws Exception {

        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        AlgorithmParameterSpec params = new IvParameterSpec(getIv(key));
        Cipher cipher = Cipher.getInstance(ENCRYPT_AES);

        cipher.init(Cipher.ENCRYPT_MODE, skeySpec, params);

        byte[] content = src.getBytes(CHARSET_UTF_8);

        byte[] ret = cipher.doFinal(content);

        return  Base64.getEncoder().encodeToString(ret);
    }

    /**
     * AES CBC 解密
     * 结果含Base64编码
     * 动态偏移量
     * @param src 加密字符串
     * @param key 密码 16位
     * @return
     * @throws Exception
     */
    public static String decryptCbc(String src,byte[] key) throws Exception{

        byte[] srcByte = Base64.getDecoder().decode(src);
        SecretKeySpec skeySpec = new SecretKeySpec(key, "AES");
        AlgorithmParameterSpec params = new IvParameterSpec(getIv(key));
        Cipher cipher = Cipher.getInstance(ENCRYPT_AES);
        cipher.init(Cipher.DECRYPT_MODE, skeySpec, params);
        byte[] ret = cipher.doFinal(srcByte);
        return new String(ret,CHARSET_UTF_8);
    }

    /**
     * AES 128获取16位密码
     * @param key
     * @return
     * @throws UnsupportedEncodingException
     */
    public static byte[] getAESKey(String key) throws UnsupportedEncodingException {
        byte[] keyBytes = key.getBytes(CHARSET_UTF_8);
        // Use the first 16 bytes (or even less if key is shorter)
        byte[] keyBytes128 = new byte[SECURE_KEY_LENGTH];
        System.arraycopy(keyBytes, 0, keyBytes128, 0, Math.min(keyBytes.length, SECURE_KEY_LENGTH));
        return keyBytes128;
    }

    /**
     * 生成IV偏移量
     * @param key
     * @return
     */
    public static byte[] getIv(byte[] key){
        byte[] iv = new byte[SECURE_KEY_LENGTH];
        for(int i=0; i< SECURE_KEY_LENGTH && i < key.length; i++){
            iv[i] = key[i];
        }
        if(key.length < SECURE_KEY_LENGTH){
            for(int i=key.length; i<SECURE_KEY_LENGTH; i++){
                iv[i] = '0';
            }
        }
        return iv;
    }

    public static void main(String[] args)throws Exception{
        String enkeyStr = Base64.getEncoder().encodeToString("123456".getBytes("utf-8"));
        enkeyStr =new String(Base64.getDecoder().decode("MTIzNDU2"),"utf-8");
        String destr = encryptCbc("oXOgsrAd", DEFAULT_AES_KEY.getBytes("utf-8"));
        String dechostr = decryptCbc(destr, DEFAULT_AES_KEY.getBytes("utf-8"));

    }

}
