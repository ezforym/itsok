/*
 * Global.java
 * Copyright(C) 2013-2015 东方瑞呈科技有限公司
 * All rights reserved.
 * -----------------------------------------------
 * 2015年5月25日 Created
 */
package com.cth.utils;

/**
 * 全局常量接口
 * 
 * @author Jacky @version v1.0
 * @date 2015年9月11日
 * 
 */
public interface Global
{
	/** web http head */
	String	WEBHEAD				= "http://";
	/** 默认密码 */
	String	DEF_PWD				= "123456";
	/** 盐 */
	String	SALT				= "96I9aWGwA3ORKkjHNPfCrDNvtNlhb6Nc";
	/** 升序 */
	String	ASC					= "asc";
	/** 降序 */
	String	DESC				= "desc";
	/** 用户SESSION KEY */
	String	SESSION_KEY_USER	= "curUser";
	/** JSON 数据视图 */
	String	VIEW_JSON			= "json";

	/** 直辖市省ID */
	int Municipality_province_id = -100000;

	// 订单状态
	/** 订单状态-施工派单 */
	int			ORDER_STATUS_SGPD	= 0;
	/** 订单状态-安装中 */
	int			ORDER_STATUS_AZZ	= 1;
	/** 订单状态-等待验收 */
	int			ORDER_STATUS_DDYS	= 2;
	/** 订单状态-验收完成 */
	int			ORDER_STATUS_YSWC	= 3;
	/** 订单状态-问题订单 */
	int			ORDER_STATUS_WTDD	= 4;
	/** 订单状态-验收失败 */
	int			ORDER_STATUS_YSSB	= 5;
	/** 设备状态-穿管布线 */
	int			DEV_STATUS_CGBX		= 6;
	/** 设备状态-安装投屏 */
	int			DEV_STATUS_AZTP		= 7;
	/** 设备状态-通电调试 */
	int			DEV_STATUS_TDTS		= 8;
	/** 设备状态-更换设备 */
	int			DEV_STATUS_GHSB		= 9;
	/** 状态 */
	String[]	STATUS				= { "10000", "10010", "10020", "10030",
			"10040", "10050", "20000", "20010", "20020", "20030" };
	String[]	STATUS_NAME			= { "施工派单", "安装中", "等待验收", "验收完成", "问题订单",
			"验收失败", "穿管布线", "安装投屏", "通电调试", "更换设备" };

	// 统计订单类型
	/** 统计总类型订单数 */
	int	COUNT_ORDER_TYPE_ALL		= 1;
	/** 统计已派单类型订单数 */
	int	COUNT_ORDER_TYPE_SEND		= 2;
	/** 统计已完成类型订单数 */
	int	COUNT_ORDER_TYPE_COMPLETE	= 3;
	/** 统计问题类型订单数 */
	int	COUNT_ORDER_TYPE_PROBLEM	= 4;

	// 角色层级
	/** 最高级[老板、系统管理员] */
	int	ROLE_LEVEL_HIGH		= 0;
	/** 负责人 */
	int	ROLE_LEVEL_MANAGER	= 1;
	/** 普通成员 */
	int	ROLE_LEVEL_MENBER	= 2;

	// 用户层级
	/** 系统管理员、老板、负责人 */
	int	USER_LEVEL_HIGH_OR_MANAGER	= 1;
	/** 普通成员 */
	int	USER_LEVEL_MENBER			= 2;

}
