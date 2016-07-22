/**
 * 
 */
package com.cth.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.springframework.security.crypto.codec.Hex;
import org.springframework.security.crypto.codec.Utf8;
import org.springframework.security.crypto.util.EncodingUtils;

/**
 * 密码加密
 * 
 * @author wuyize
 * 
 * @version v1.0.0
 * @date 2015-10-9
 * 
 */
public final class PasswordEncoder {
          private final MessageDigest digester;
          private final byte[] secret;
          
          /**
           * 默认构造函数
           * 
           * @throws NoSuchAlgorithmException
           */
          public PasswordEncoder() throws NoSuchAlgorithmException {
                    this("");
          }
          
          public PasswordEncoder(CharSequence secret) throws NoSuchAlgorithmException {
                    digester = MessageDigest.getInstance("MD5");
                    this.secret = Utf8.encode(secret);
          }
          
          public String encode(CharSequence rawPassword) {
                    byte[] digest = digest(rawPassword, secret);
                    return new String(Hex.encode(digest));
          }
          
          private byte[] digest(CharSequence rawPassword, byte[] salt) {
                    return digester.digest(EncodingUtils.concatenate(new byte[][] { Utf8.encode(rawPassword), salt }));
          }
          
          public boolean matches(CharSequence rawPassword, String encodedPassword, CharSequence salt) {
                    byte[] digested = decode(encodedPassword);
                    return matches(digested, digest(rawPassword, Utf8.encode(salt)));
          }
          
          private boolean matches(byte[] expected, byte[] actual) {
                    if (expected.length != actual.length) {
                              return false;
                    }
                    int result = 0;
                    for (int i = 0; i < expected.length; i++) {
                              result |= expected[i] ^ actual[i];
                    }
                    return result == 0;
          }
          
          private byte[] decode(CharSequence encodedPassword) {
                    return Hex.decode(encodedPassword);
          }
          
}
