package com.songwen.ping.entity;

import java.io.Serializable;

/**
 * Created by Administrator on 2018/5/11.
 */
public class Page implements Serializable {

    private int page=1;
    private int size=5;
    private String sidx="id";
    private String sord="asc";

    @Override
    public String toString() {
        return "Page{" +
                "page=" + page +
                ", size=" + size +
                ", sidx='" + sidx + '\'' +
                ", sord='" + sord + '\'' +
                '}';
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getSidx() {
        return sidx;
    }

    public void setSidx(String sidx) {
        this.sidx = sidx;
    }

    public String getSord() {
        return sord;
    }

    public void setSord(String sord) {
        this.sord = sord;
    }
}
