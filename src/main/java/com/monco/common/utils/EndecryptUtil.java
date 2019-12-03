package com.monco.common.utils;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.monco.entity.User;
import org.apache.shiro.codec.Base64;
import org.apache.shiro.codec.Hex;
import org.apache.shiro.crypto.AesCipherService;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.crypto.hash.SimpleHash;

import java.security.Key;

/**
 * @author : monco
 * @date : 2019/9/16 10:46
 * @description : 加解密工具
 */
public class EndecryptUtil {

    /**
     * base64进制加密
     *
     * @param password
     * @return
     */
    public static String encrytBase64(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
        byte[] bytes = password.getBytes();
        return Base64.encodeToString(bytes);
    }

    /**
     * base64进制解密
     *
     * @param cipherText
     * @return
     */
    public static String decryptBase64(String cipherText) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
        return Base64.decodeToString(cipherText);
    }

    /**
     * 16进制加密
     *
     * @param password
     * @return
     */
    public static String encrytHex(String password) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(password), "不能为空");
        byte[] bytes = password.getBytes();
        return Hex.encodeToString(bytes);
    }

    /**
     * 16进制解密
     *
     * @param cipherText
     * @return
     */
    public static String decryptHex(String cipherText) {
        Preconditions.checkArgument(!Strings.isNullOrEmpty(cipherText), "消息摘要不能为空");
        return new String(Hex.decode(cipherText));
    }


    public static String generateKey() {
        AesCipherService aesCipherService = new AesCipherService();
        Key key = aesCipherService.generateNewKey();
        return Base64.encodeToString(key.getEncoded());
    }


    public static void main(String[] args) {
        String password = "123";
        String salt = new SecureRandomNumberGenerator().nextBytes().toString(); //Shiro自带的工具类，生成盐
        int times = 2; //加密次数
        String algorithmName = "md5"; //算法名
        String encodedPassword = new SimpleHash(algorithmName, password, salt, times).toString();
        System.out.printf("原始密码是 %s , 盐是： %s, 运算次数是： %d, 运算出来的密文是：%s ", password, salt, times, encodedPassword);


    }
}
