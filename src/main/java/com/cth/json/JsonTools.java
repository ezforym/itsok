/***************************************************************************************
 *				  		 Jackyyang Personal 版权所有
 *				Copyright (c) 2014 -***.Inc All Rights Reserved
 **************************************************************************************/
package com.cth.json;

import java.io.UnsupportedEncodingException;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializerFeature;

/**
 * 将对象转换为Json数据的工具类
 * 
 * @author wuyize
 * 
 * @version v1.0
 * @date 2015年5月21日
 * 
 */
public class JsonTools {
          /**
           * 转换对象为默认的JSON数据
           * 
           * @param o
           * @return
           */
          public static String toJson(Object o) {
                    String s1 = JSONObject.toJSONString(o, SerializerFeature.WriteMapNullValue,
                                        SerializerFeature.WriteNullBooleanAsFalse,
                                        SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullNumberAsZero,
                                        SerializerFeature.WriteNullStringAsEmpty);
                    String s2 = "";
                    try {
                              s2 = new String(s1.getBytes("UTF-8"), "ISO-8859-1");
                    } catch (UnsupportedEncodingException e) {
                              e.printStackTrace();
                    }
                    return s2;
          }
          
}
