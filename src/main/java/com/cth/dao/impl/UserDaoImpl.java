/**
 * 
 */
package com.cth.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.apache.log4j.Logger;
import com.cth.dao.IUserDao;
import com.cth.pojo.User;
import com.cth.utils.LogFactory;
import com.cth.utils.Paginate;

/**
 * @author Administrator
 *
 */
public class UserDaoImpl implements IUserDao {
          private final static Logger logger = LogFactory.getLogger(UserDaoImpl.class);
          @Resource(name = "jdbcTemplate")
          private NamedParameterJdbcTemplate jdbcTemplate;
          
          @Override
          public int save(User t) {
                    int result = -1;
                    String sql = "insert into user (\n" + "	name,\n" + "	phone\n" + ")\n" + "VALUES\n" + "	(\n"
                                        + "	:name,\n" + "	:phone\n" + ")\n";
                    SqlParameterSource sps = new BeanPropertySqlParameterSource(t);
                    KeyHolder key = new GeneratedKeyHolder();
                    try {
                              result = this.jdbcTemplate.update(sql, sps, key);
                              t.setId(key.getKey().intValue());
                    } catch (DataAccessException e) {
                              logger.error(e.getMessage());
                    }
                    return result;
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
          
}
