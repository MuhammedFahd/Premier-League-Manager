package menu;

import org.junit.Test;

import static org.junit.Assert.*;

public class DateTest {

    @Test
    public void getDay() {
        Date date=new Date(5,10,2020);
        int num=date.getDay();
        assertEquals(5,num);

    }

    @Test
    public void getMonth() {
        Date date=new Date(5,10,2020);
        int num=date.getMonth();
        assertEquals(10,num);
    }

    @Test
    public void getYear() {
        Date date=new Date(5,10,2020);
        int num=date.getYear();
        assertEquals(2020,num);
    }
}