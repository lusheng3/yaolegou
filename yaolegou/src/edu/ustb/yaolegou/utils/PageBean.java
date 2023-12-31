package edu.ustb.yaolegou.utils;

import java.util.List;

/**
* 分页相关参数及结果List
*
*/
public class PageBean<T> {
    // 当前页
    private int pageIndex;
    //每一页记录数
    private int pageRecord;
    //总页数
    private int pageCount;
    //总记录数
    private int totalRecord;

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageRecord() {
        return pageRecord;
    }

    public void setPageRecord(int pageRecord) {
        this.pageRecord = pageRecord;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getTotalRecord() {
        return totalRecord;
    }

    public void setTotalRecord(int totalRecord) {
        this.totalRecord = totalRecord;
    }

    public List<T> getResultList() {
        return resultList;
    }

    public void setResultList(List<T> resultList) {
        this.resultList = resultList;
    }

    private List<T> resultList;
}
