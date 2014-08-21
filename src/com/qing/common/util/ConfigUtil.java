/*
 * Title:        
 * Description:  [描述模块的功能、作用、使用方法和注意事项]
 * Copyright:    Copyright (c) 2012
 * Company:      Tai woo. Co., Ltd
 * @author      zhanghongbin
 * @version      1.0  2014年5月30日
 */
package com.qing.common.util;

/**
 * 配置文件（config.properties）映射类
 * (一句话功能简述)
 * (功能详细描述)
 * @author       zhanghongbin
 * @see          [相关类,可选,也可多条,对于重要的类或接口建议注释]
 * @since        清清网系统, 2014年8月16日
 */
public class ConfigUtil {
	/**
	 * 每天的分享次数
	 */
	private int shareNum;

	/**
	 * 每天的评论次数
	 */
	private int commentNum;

	/** 图片保存地址 **/
	private String absUploadPath;

	/** 图片服务器访问地址 **/
	private String resourceContext;
	/**
	 * 礼品图片保存路径
	 */
	private String giftPath;
	/**
	 * 礼品图片访问地址
	 */
	private String giftUrl;

	/**
	 * 微信验证的token
	 */
	private String token;
	/**
	 * 第三方用户唯一凭证
	 */
	private String appId;
	/**
	 * 第三方用户唯一凭证密钥
	 */
	private String appSecret;
	/**
	 * 创建菜单URL
	 */
	private String menuCreateUrl;
	/**
	 * 删除菜单URL
	 */
	private String menuDeleteUrl;
	/**
	 * 获取accessTokenURL
	 */
	private String accessTokenUrl;

	public int getShareNum() {
		return this.shareNum;
	}

	public void setShareNum(int shareNum) {
		this.shareNum = shareNum;
	}

	public int getCommentNum() {
		return this.commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getAbsUploadPath() {
		return this.absUploadPath;
	}

	public void setAbsUploadPath(String absUploadPath) {
		this.absUploadPath = absUploadPath;
	}

	public String getResourceContext() {
		return this.resourceContext;
	}

	public void setResourceContext(String resourceContext) {
		this.resourceContext = resourceContext;
	}

	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAppId() {
		return this.appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public String getAppSecret() {
		return this.appSecret;
	}

	public void setAppSecret(String appSecret) {
		this.appSecret = appSecret;
	}

	public String getMenuCreateUrl() {
		return this.menuCreateUrl;
	}

	public void setMenuCreateUrl(String menuCreateUrl) {
		this.menuCreateUrl = menuCreateUrl;
	}

	public String getMenuDeleteUrl() {
		return this.menuDeleteUrl;
	}

	public void setMenuDeleteUrl(String menuDeleteUrl) {
		this.menuDeleteUrl = menuDeleteUrl;
	}

	public String getAccessTokenUrl() {
		return this.accessTokenUrl;
	}

	public void setAccessTokenUrl(String accessTokenUrl) {
		this.accessTokenUrl = accessTokenUrl;
	}

	public String getGiftPath() {
		return this.giftPath;
	}

	public void setGiftPath(String giftPath) {
		this.giftPath = giftPath;
	}

	public String getGiftUrl() {
		return this.giftUrl;
	}

	public void setGiftUrl(String giftUrl) {
		this.giftUrl = giftUrl;
	}

}
