/**
 * 
 */
package com.cth.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.cth.json.JsonMessage;
import com.cth.pojo.User;
import com.cth.service.IUserService;
import com.cth.utils.ErrorCode;
import com.cth.utils.Msg;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController implements ErrorCode {
          @Resource(name = "userService")
          private IUserService userService;
          
          @RequestMapping(value = "/add", method = RequestMethod.POST)
          @ResponseBody
          public String add(@RequestBody String data) {
                    int code = FAILED;
                    User u = JSONObject.parseObject(data, User.class);
                    if (u != null) {
                              code = this.userService.save(u);
                    }
                    return JsonMessage.getJsonMsg(new Msg(code));
          }
          
          @RequestMapping(value = "/login", method = RequestMethod.POST)
          @ResponseBody
          public String login(@RequestBody String data) {
                    int code = FAILED;
                    Msg m = new Msg(code);
                    JSONObject jo = JSONObject.parseObject(data);
                    User user = this.userService.validateUser(jo.getString("phone"), jo.getString("password"));
                    if (user != null) {
                              m.setCode(SUCCESS);
                              m.setData(user);
                    }
                    return JsonMessage.getJsonMsg(m);
          }
          
          @RequestMapping(value = "/test", method = RequestMethod.GET)
          @ResponseBody
          public String sendMqMsg() {
                    int code = FAILED;
                    String jsonData = JsonMessage.getJsonMsg(new Msg(code));
                    return jsonData;
          }
}
