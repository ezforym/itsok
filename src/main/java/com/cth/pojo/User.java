/**
 * 
 */
package com.cth.pojo;

/**
 * @author Administrator
 *
 */
public class User {
          private Integer id;
          private String name;
          private String phone;
          private String address;
          private boolean dr;
          
          public String getAddress() {
                    return address;
          }
          
          public void setAddress(String address) {
                    this.address = address;
          }
          
          public boolean isDr() {
                    return dr;
          }
          
          public void setDr(boolean dr) {
                    this.dr = dr;
          }
          
          public Integer getId() {
                    return id;
          }
          
          public void setId(Integer id) {
                    this.id = id;
          }
          
          public String getName() {
                    return name;
          }
          
          public void setName(String name) {
                    this.name = name;
          }
          
          public String getPhone() {
                    return phone;
          }
          
          public void setPhone(String phone) {
                    this.phone = phone;
          }
}
