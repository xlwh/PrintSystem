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

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Title: 读取属性文件工具类<br>
 * Description: 读取属性文件工具类<br>
 * CreateTime: 2014-08-06 16:39<br>
 * Copyright: Copyright (c) 2012 taiheiot.com<br>
 * 
 * @author 张洪斌
 * @since 1.0
 */
public class ConfigureUtils
{

    private static String hsqlResName = "hsql";

    private static String messageResName = "msg";

    private static String errorResName = "error";

    /**
     * 根据proKey读取在hsql文件中对应的属性值，文件路径/config/hsql_zh_CN.properties
     * 
     * @param proKey hsql文件中的key值
     * @return proKey在hsql文件中对应的属性值
     */
    public static String getHSqlConfig(String proKey)
    {
        ResourceBundle rb = ResourceBundle.getBundle(hsqlResName, Locale.CHINA);
        return rb.getString(proKey);
    }

    /**
     * 根据messageKey读取在msg文件中对应的属性值，文件路径/config/msg_zh_CN.properties
     * 
     * @param messageKey msg文件中的messageKey值
     * @return messageKey在msg文件中对应的属性值
     */
    public static String getMessageConfig(String messageKey)
    {
        ResourceBundle rb = ResourceBundle.getBundle(messageResName, Locale.CHINA);
        return rb.getString(messageKey);
    }

    /**
     * 根据errorKey读取在error文件中对应的属性值，文件路径/config/error_zh_CN.properties
     * 
     * @param errorKey error文件中的errorKey值
     * @return errorKey在error文件中对应的属性值
     */
    public static String getErrorConfig(String errorKey)
    {
        ResourceBundle rb = ResourceBundle.getBundle(errorResName, Locale.CHINA);
        return rb.getString(errorKey);
    }

}
