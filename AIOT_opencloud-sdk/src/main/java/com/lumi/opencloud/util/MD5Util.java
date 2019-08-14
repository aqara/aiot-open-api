package com.lumi.opencloud.util;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author lumi
 */
public class MD5Util {
    private static Logger log = LoggerFactory.getLogger(MD5Util.class);
    /**
     * md5 - 32位
     * @param sourceStr
     * @return
     * @throws Exception
     */
    public static String MD5(String sourceStr){
        String result = "";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(sourceStr.getBytes(Charset.defaultCharset()));
            byte[] b = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < b.length; offset++) {
                i = b[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            result = buf.toString();
        } catch (NoSuchAlgorithmException e) {
            log.error("md5 error, e:{}", e);
        }
        return result;
    }


}
