package com.ssm.other.page;

import java.util.List;

/**
 * 页码参数
 */
public class Page {
    private int pageSize;//每页上的记录数.不能为零
    private int totalPage;//总页数
    private int rowCount; //总记录数
    private int currentPage; //当前页码
    private int offset;//当前开始记录的位置
    private List list; //返回的记录列表

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
    }

    private boolean hasPreviousPage;  //是否有前一页

    public boolean isHasNextPage() {
        return hasNextPage;
    }

    public boolean isHasPreviousPage() {
        return hasPreviousPage;
    }

    private boolean hasNextPage;  //是否有下一页

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public void setHasPreviousPage(boolean hasPreviousPage) {
        this.hasPreviousPage = hasPreviousPage;
    }

    public void setHasNextPage(boolean hasNextPage) {
        this.hasNextPage = hasNextPage;
    }

    public static int resetPageSize(int pageSize){
        if (pageSize ==0){
            pageSize=10;
        }
        return pageSize;
    }


    /**
     * 计算当前页，若为0或者请求的URL中没有“?page = ”则用1代替
     * @param currentPage 传入的参数（可能为空，即0  则返回1）
     * @return
     */
    public static int countCurrentPage(int currentPage){
        final int currePage = (currentPage <= 0 ? 1 : currentPage);
        return currePage;
    }
    /**
     * 计算当前页开始的记录
     * @param pageSize 每页记录数
     * @param currentPage 当前第几页
     * @return 当前页开始记录号
     */
    public static int countOffset(final int pageSize,final int currentPage){
        final int offset = pageSize * (currentPage - 1);
        if(offset >0) {
            return offset;
        }else{
            return 0;
        }
    }

    /**
     * 计算总页数  静态方法
     * @param pageSize  每页的记录数
     * @param rowCount  总记录数
     * @return 总页数
     */
    public static int countTotalPage(final int pageSize,final int rowCount){
        int totaPage = rowCount % pageSize == 0 ? rowCount/pageSize : rowCount/pageSize + 1;
        return totaPage;
    }

    public static void setPreOrNextBoolean(Page page) {
        if (page.getCurrentPage() <= 1) {
            page.setHasPreviousPage(false);
        } else {
            page.setHasPreviousPage(true);
        }
        if (page.getCurrentPage() <= page.getTotalPage()) {
            page.setHasNextPage(true);
        } else {
            page.setHasNextPage(false);
        }
    }

    public static void init(Page page){

        int pageSize=Page.resetPageSize(page.getPageSize());
        page.setPageSize(pageSize);


        //当前页码
        final   int currentPage = Page.countCurrentPage(page.getCurrentPage());
        page.setCurrentPage(currentPage);

        //总页数
        final   int totalPage = Page.countTotalPage(pageSize, page.getRowCount()); //总页数
        page.setTotalPage(totalPage);

        //当前页开始的记录
        page.setOffset(Page.countOffset(pageSize, currentPage)); //当前页开始记录

        //判断
        Page.setPreOrNextBoolean(page);


    }



}