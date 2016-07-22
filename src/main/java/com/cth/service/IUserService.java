/**
 * 
 */
package com.cth.service;

import com.cth.pojo.User;

/**
 * @author Administrator
 *
 */
public interface IUserService extends IBaseService<User> {
          /**
           * 登录
           * 
           * @param accont
           *                  账号
           * @param password
           *                  密码
           * @return 是否成功
           */
          User validateUser(String accont, String password);
}
