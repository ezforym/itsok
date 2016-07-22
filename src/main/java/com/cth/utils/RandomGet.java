/**
 * 
 */
package com.cth.utils;

import java.util.Random;

/**
 * 随机数
 * 
 * @author wuyize
 *
 * @version v1.0.0
 * @date 2016年3月31日
 *
 */
public class RandomGet {
          public static String getRandomString(int length, int type) { // length表示生成字符串的长度
                    String base = "qwertyuiopasdfghjklzxcvbnm";
                    if (type == 1) {
                              base = "0123456789";
                    }
                    Random random = new Random();
                    StringBuffer sb = new StringBuffer();
                    for (int i = 0; i < length; i++) {
                              int number = random.nextInt(base.length());
                              sb.append(base.charAt(number));
                    }
                    return sb.toString();
          }
}