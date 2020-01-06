package javacore.effectJava.a50;

import dataCollect.server.domain.Data;

import java.util.Date;

public class Period {
    private final Date start;
    private final Date end;

    public Period(Date start, Date end) {
        this.start = new Date(start.getTime());// 保护性拷贝
        //this.end = (Date) end.clone();//能够复制Date的域，但是域里面的引用和被克隆对象还是用一个引用。
        this.end = new Date(end.getTime());
    }

    @Override
    public String toString() {
        return "Period{" +
                "start=" + start.getTime() +
                ", end=" + end.getTime() +
                '}';
    }

    public Date getEnd() {
        return new Date(end.getTime());// 防止p.getEnd().setYear(); 修改
    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public static void main(String[] args) {
        Date start =new Date();
        Date end =new Date();
        Period p =new Period(start,end);
        System.out.printf(p.toString());

        end.setYear(2018);
        System.out.printf(p.toString());
    }
}
