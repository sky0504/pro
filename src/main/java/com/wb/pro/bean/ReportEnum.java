package com.wb.pro.bean;

/**
 * @author:yuxj
 * @descriptio
 * @create:2018/8/6 上午9:44
 */
public enum ReportEnum {

    HTML("html"),
    PDF("pdf"),
    EXCEL("excel");


    String name;
    ReportEnum(String name){
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public static Boolean contains(String name){
        boolean bool = false;
        for(ReportEnum reportEnum : ReportEnum.values()){
            if(name.equals(reportEnum.getName())){
                bool = true;
                break;
            }
        }

        return bool;
    }

    public static ReportEnum getReportEnum(String content){
        for (ReportEnum reportEnum : ReportEnum.values()){
            if (reportEnum.getName().equals(content)){
                return reportEnum;
            }
        }
        return null;
    }
}
