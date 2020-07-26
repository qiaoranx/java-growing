package com.company.entity;

import java.util.ArrayList;
import java.util.List;

import static com.company.util.Const.PAGESIZE;

//封装一个分页对象：包括当前页码，总页码等属性
public class Page<T> {
    private Integer curPage;
    private Integer totalCount;
    private List<T> pageList;

    public Page(String curPage) {
        if(curPage!=null){
            this.curPage=Integer.parseInt(curPage) ;
        }else{
            this.curPage=1;
        }
        this.pageList=new ArrayList<>();
    }

//    public Page(String curPage,List<T> list) {
//        if(curPage!=null){
//            this.curPage=Integer.parseInt(curPage) ;
//        }else{
//            this.curPage=1;
//        }
//        this.pageList=list;
//    }

    public Integer getCurPage() {
        return curPage;
    }



    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }


    public Integer getTotalPage() {
        return totalCount%PAGESIZE==0?totalCount/PAGESIZE:totalCount/PAGESIZE+1;
    }

    public List<T> getPageList() {
        return this.pageList;
    }
}
