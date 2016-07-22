/**
 * 
 */
package com.cth.service.impl;

import java.util.List;

import javax.annotation.Resource;

import com.cth.dao.IUserDao;
import com.cth.pojo.User;
import com.cth.service.IUserService;
import com.cth.utils.ErrorCode;
import com.cth.utils.Global;
import com.cth.utils.Paginate;
import com.cth.utils.PasswordEncoder;

/**
 * @author Administrator
 *
 */
public class UserServiceImpl implements IUserService, ErrorCode {
          @Resource(name = "userDao")
          private IUserDao userDao;
          @Resource(name = "encoder")
          private PasswordEncoder encoder;
          
          @Override
          public int save(User t) {
                    t.setSalt(Global.SALT);
                    t.setPassword(encoder.encode(t.getPassword()));
                    return this.userDao.save(t) == 1 ? SUCCESS : FAILED;
          }
          
          @Override
          public int delete(int id) {
                    // TODO Auto-generated method stub
                    return 0;
          }
          
          @Override
          public int update(User t) {
                    // TODO Auto-generated method stub
                    return 0;
          }
          
          @Override
          public User get(int id) {
                    // TODO Auto-generated method stub
                    return null;
          }
          
          @Override
          public long getCount() {
                    // TODO Auto-generated method stub
                    return 0;
          }
          
          @Override
          public long getCount(int key, int value) {
                    // TODO Auto-generated method stub
                    return 0;
          }
          
          @Override
          public List<User> initTop(int limit) {
                    // TODO Auto-generated method stub
                    return null;
          }
          
          @Override
          public List<User> paginate(Paginate pag) {
                    // TODO Auto-generated method stub
                    return null;
          }
          
          @Override
          public List<User> paginate(int key, int value, Paginate pag) {
                    // TODO Auto-generated method stub
                    return null;
          }
          
          @Override
          public User validateUser(String account, String password) {
                    User su = this.userDao.querySfdaUserByPhone(account);
                    if (su != null) {
                              if (encoder.matches(password, su.getPassword(), su.getSalt())) {
                                        su.setSalt(null);
                                        su.setPassword(null);
                              } else {
                                        su = null;
                              }
                    }
                    return su;
          }
}
