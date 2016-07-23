/**
 * 
 */
package com.cth.utils;

import java.io.Serializable;

/**
 * 分页排序参数
 * 
 * @author wuyize
 * 
 * @version v1.0.0
 * @date 2015-10-16
 * 
 */
public class Paginate implements Serializable {
          /** */
          private static final long serialVersionUID = 4800281008750230453L;
          private String pageSize;
          private String pageIndex;
          
          public String getPageSize() {
                    return pageSize;
          }
          
          public void setPageSize(String pageSize) {
                    this.pageSize = pageSize;
          }
          
          public String getPageIndex() {
                    return pageIndex;
          }
          
          public void setPageIndex(String pageIndex) {
                    this.pageIndex = pageIndex;
          }
          
}
