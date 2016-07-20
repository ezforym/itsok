/**
 * 
 */
package com.cth.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cth.json.JsonMessage;
import com.cth.pojo.User;
import com.cth.service.IUserService;
import com.cth.utils.Const;
import com.cth.utils.ErrorCode;
import com.cth.utils.Msg;
import com.cth.utils.OpenfireXmpp;

/**
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/user")
public class UserController implements ErrorCode {
          @Resource(name = "userService")
          private IUserService userService;
          
          @RequestMapping("/get")
          @ResponseBody
          public String updateOBase(ModelMap model) {
                    int code = 1;
                    User u = new User();
                    u.setName("wuyize");
                    u.setPhone("13548558596");
                    code = this.userService.save(u);
                    return JsonMessage.getJsonMsg(new Msg(code));
          }
          
          @RequestMapping("/send")
          public String sendMsg(ModelMap model, String user, String password, String subject, String body, String to) {
                    int code = FAILED;
                    OpenfireXmpp s = new OpenfireXmpp();
                    try {
                              s.sendmsg(user, password, subject, body, to);
                    } catch (InterruptedException e) {
                              e.printStackTrace();
                    }
                    String jsonData = JsonMessage.getJsonMsg(new Msg(code));
                    model.addAttribute("data", jsonData);
                    return Const.VIEW_JSON;
          }
          
          @RequestMapping(value = "/test", method = RequestMethod.GET)
          @ResponseBody
          public String sendMqMsg() {
                    int code = FAILED;
                    // code = Sender.send(msg, topic);
                    String jsonData = JsonMessage.getJsonMsg(new Msg(code));
                    return jsonData;
          }
}
