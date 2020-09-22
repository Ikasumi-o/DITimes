package de.riagade.genericDiscordBot.util;

import org.quartz.CronExpression;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

public class CronHelper {
    public static long getPeriod(String cronExpression) {
        Date next = getNextDate(cronExpression);
        Date last = getLastDate(cronExpression);
        return next.getTime() - last.getTime();
    }

    public static Date getNextDate(String cronExpression) {
        try{
        CronExpression expression = new CronExpression(cronExpression);
        return expression.getNextValidTimeAfter(Calendar.getInstance().getTime());
        } catch (ParseException e){
            e.printStackTrace();
            return new Date(0);
        }
    }

    public static Date getLastDate(String cronExpression) {
        try{
            CronExpression expression = new CronExpression(cronExpression);
            Date next = expression.getNextValidTimeAfter(Calendar.getInstance().getTime());
            Calendar baseCalendar = Calendar.getInstance();
            Date last = expression.getNextValidTimeAfter(baseCalendar.getTime());
            while(!next.after(last)){
                baseCalendar.add(Calendar.MINUTE, -1);
                last = expression.getNextValidTimeAfter(baseCalendar.getTime());
            }
            return last;
        } catch (ParseException e){
            e.printStackTrace();
            return new Date(0);
        }
    }
}
