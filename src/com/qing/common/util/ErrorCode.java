/**
 *  Copyright (c) 2011, Eryptogram.java TAIHEIOT and/or its affiliates. All rights reserved.
 *
 *  Licensed under the TAIHEIOT License, Version 1.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package com.qing.common.util;

/**
 * Title: 错误代码定义<br>
 * Description: 错误代码定义<br>
 * CreateTime: 2014-08-06 16:39<br>
 * Copyright: Copyright (c) 2012 taiheiot.com<br>
 * 
 * @author 张洪斌
 * @since 1.0
 */
public interface ErrorCode
{

    /**
     * 基础异常
     */
    public String BASE_ERROR = "ERROR.BASE";

    /**
     * 数据访问模块异常
     */
    public String DAO_ERROR = "ERROR.DAO";

    /**
     * 数据访问保存异常
     */
    public String DAO_SAVE_ERROR_001 = "ERROR.DAO001";

    /**
     * 数据访问模块删除异常
     */
    public String DAO_DELETE_ERROR_002 = "ERROR.DAO002";

    /**
     * 数据访问模块更新异常
     */
    public String DAO_UPDATE_ERROR_003 = "ERROR.DAO003";

    /**
     * 数据访问模块查询异常
     */
    public String DAO_QUERY_ERROR_004 = "ERROR.DAO004";

    /**
     * 数据访问模块执行存储过程异常
     */
    public String DAO_PROC_ERROR_005 = "ERROR.DAO005";

    /**
     * 业务服务模块异常
     */
    public String SERVICE_ERROR = "ERROR.SERVICE";

    /**
     * 保存异常
     */
    public String SERVICE_SAVE_ERROR_001 = "ERROR.SERVICE001";

    /**
     * 业务服务模块删除异常
     */
    public String SERVICE_DELETE_ERROR_002 = "ERROR.SERVICE002";

    /**
     * 业务服务模块更新异常
     */
    public String SERVICE_UPDATE_ERROR_003 = "ERROR.SERVICE003";

    /**
     * 业务服务模块查询异常
     */
    public String SERVICE_QUERY_ERROR_004 = "ERROR.SERVICE004";

    /**
     * 业务服务模块执行存储过程异常
     */
    public String SERVICE_PRO_ERROR_005 = "ERROR.SERVICE005";

    /**
     * 数据异常
     */
    public String DATA_ERROR = "ERROR.DATA";

    /**
     * 页面控制模块异常
     */
    public String ACTION_ERROR = "ERROR.ACTION";

    /**
     * 远程访问异常, 数据不能为零
     */
    public String REMOTING_ZERO_ERROR = "ERROR.REMOTING001";

    /**
     * 远程访问异常, 数据不能为空
     */
    public String REMOTING_NULL_ERROR = "ERROR.REMOTING002";

    /**
     * 远程访问异常, 权限错误
     */
    public String REMOTING_AUTH_ERROR = "ERROR.REMOTING003";
}
