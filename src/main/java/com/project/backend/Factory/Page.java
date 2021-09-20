package com.project.backend.Factory;

import java.util.List;

public abstract class Page<T> {

    private List<T> list;
    private int totalPage;
    private long totalRow;


    public Page(List<T> list, int totalPage, long totalRow) {
        this.list = list;
        this.totalPage = totalPage;
        this.totalRow = totalRow;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public long getTotalRow() {
        return totalRow;
    }

    public void setTotalRow(long totalRow) {
        this.totalRow = totalRow;
    }

    //    public abstract T mapDtoToResponse(T t);
}
