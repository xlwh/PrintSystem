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

import java.util.List;

/**
 * Title: 封装分页和排序查询的结果<br>
 * Description: 封装分页和排序查询的结果<br>
 * CreateTime: 2014-08-06 16:39<br>
 * Copyright: Copyright (c) 2012 taiheiot.com<br>
 * 
 * @author 张洪斌
 * @since 1.0
 */
public class Page<T> extends QueryParameter {

    private List<T> result = null;

    private int totalCount = -1;

    public int getTotalPage() {
	return totalPage;
    }

    public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
    }

    private int totalPage = -1;

    public Page() {
    }

    public Page(int pageSize) {
	this.pageSize = pageSize;
    }

    public Page(int pageSize, boolean autoCount) {
	this.pageSize = pageSize;
	this.autoCount = autoCount;
    }

    /**
     * 页内的数据列表.
     */
    public List<T> getResult() {
	return result;
    }

    public void setResult(List<T> result) {
	this.result = result;
    }

    /**
     * 总记录数.
     */
    public int getTotalCount() {
	return totalCount;
    }

    public void setTotalCount(int totalCount) {
	this.totalCount = totalCount;
	setTotalPage(getTotalPages());
    }

    /**
     * 计算总页数.
     */
    public Integer getTotalPages() {
	if (totalCount == -1)
	    return -1;

	int count = totalCount / pageSize;
	if (totalCount % pageSize > 0) {
	    count++;
	}
	return new Integer(count);
    }

    /**
     * 是否还有下一页.
     */
    public boolean isHasNext() {
	return (pageNo + 1 <= getTotalPages());
    }

    /**
     * 返回下页的页号,序号从1开始.
     */
    public int getNextPage() {
	if (isHasNext())
	    return pageNo + 1;
	else
	    return pageNo;
    }

    /**
     * 是否还有上一页.
     */
    public boolean isHasPre() {
	return (pageNo - 1 >= 1);
    }

    /**
     * 返回上页的页号,序号从1开始.
     */
    public int getPrePage() {
	if (isHasPre())
	    return pageNo - 1;
	else
	    return pageNo;
    }
}