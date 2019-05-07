package com.example.p03_ps;

public class ModuleInfo {
    private int week;
    private String code;
    private String grade;
    public ModuleInfo(int week , String grade , String code){
        this.week = week;
        this.grade = grade;
        this.code = code;
    }
    public int getWeek(){
        return week;
    }
    public String getGrade(){
        return grade;
    }
    public String getCode(){
        return code;
    }
}
