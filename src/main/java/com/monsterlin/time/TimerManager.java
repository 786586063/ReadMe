package com.monsterlin.time;


import java.util.Calendar;
import java.util.Date;
import java.util.Timer;

/**
 * 定时任务的时间管理
 *
 * @author monsterlin
 * @date 2017-05-25
 */
public class TimerManager {

    //时间间隔，ms为单位
    private static final long PERIOD_DAY = 24 * 60 * 60 * 1000;

    /**
     * 构造方法，用于初始化
     */
    public TimerManager() {
        Calendar calendar = Calendar.getInstance();

        calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);


        Date date = calendar.getTime();  //第一次执行定时任务的时间


        /**
         * 如果第一次执行任务的时间小于当前的时间
         * 此时要在第一次执行任务的时间上+1天，以便此任务在下个时间点执行
         * 如果不+1天，则立即执行
         */

        if (date.before(new Date())) {
            date = this.addDay(date, 2);
        }

        Timer timer = new Timer();

        GrabDataTimerTask task = new GrabDataTimerTask();

        //安排指定的任务在指定的时间开始进行重复的固定延迟执行。
        timer.schedule(task, date, PERIOD_DAY);


    }

    /**
     * 增加天数
     *
     * @param date
     * @param num
     * @return
     */
    public Date addDay(Date date, int num) {
        Calendar startDT = Calendar.getInstance();
        startDT.setTime(date);
        startDT.add(Calendar.DAY_OF_MONTH, num);
        return startDT.getTime();
    }

}
