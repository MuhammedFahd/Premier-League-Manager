package menu;

import java.io.Serializable;

public class Date implements Serializable,Comparable<Date>{
    private int day;
    private int month;
    private int year;

    public Date(int day, int month, int year){
        boolean isValid=true;
        //validating the date
        if(day<1 || day>31){
            isValid=false;
        }else if(month<1 || month>12){
            isValid=false;
        }else if(year<0){
            isValid=false;
        }

        if(isValid){
            this.day=day;
            this.month=month;
            this.year=year;
        }else{
            System.out.println("please enter proper date!!!!!");
        }
    }

    public void setDay(int day){
        this.day=day;
    }
    public void setMonth(int month){
        this.month=month;
    }
    public void setYear(int year){
        this.year=year;
    }
    public int getDay(){
        return this.day;
    }
    public int getMonth(){
        return this.month;
    }
    public int getYear(){
        return this.year;
    }

    public String toString(){
        String output="Date[day= "+this.getDay()+", month= "+this.getMonth()+", year= "+this.getYear()+"]";
        return output;
    }

    public String getDate(){
        StringBuilder s=new StringBuilder();
        if(this.day<10){
            s.append("0");
        }
        s.append(String.valueOf(this.day));
        s.append("/");
        if(this.month<10){
            s.append("0");
        }
        s.append(String.valueOf(this.month));
        s.append("/");
        s.append(String.valueOf(this.year));

        return s.toString();
    }


    @Override
    public int compareTo(Date date) {
        if(this.year==date.getYear()){
            if(this.month==date.getMonth()){
                if(this.day==date.getDay()){
                    return 0;
                }else if(this.day>date.getDay()){
                    return 1;
                }else{
                    return -1;
                }
            }else if(this.month>date.getMonth()){
                return 1;
            }else{
                return -1;
            }
        }else if(this.year>date.getYear()){
            return 1;
        }else{
            return -1;
        }
    }
}
