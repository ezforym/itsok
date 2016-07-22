package com.cth.dao;

import com.cth.pojo.User;

public interface IUserDao extends IBaseDao<User> {
          /**
           * 通过手机号或者邮箱查询用户
           * 
           * @param account
           *                  邮箱或者手机
           * @return 用户对象
           */
          User querySfdaUserByPhone(String account);
}
