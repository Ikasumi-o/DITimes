package de.riagade.genericDiscordBot;

import de.riagade.genericDiscordBot.util.CronHelper;
import org.quartz.CronExpression;
import org.springframework.scheduling.support.CronSequenceGenerator;

import java.text.ParseException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * a timed task that calculates the next time to run using a cron expression
 */
public abstract class A_TimedTask extends TimerTask {
    public static final long CHECK_INTERVAL = TimeUnit.SECONDS.toMillis(15);
    private String cronExpression;
    private A_FeedbackTask task;
    private A_FeedbackTask cloneTask;
    private A_BasicBot bot;

    /**
     * @param cronExpression the cron expression to calculate the next execution
     */
    public A_TimedTask(A_BasicBot bot, String cronExpression){
        setBot(bot);
        setCronExpression(cronExpression);
        setTask(createFeedbackTask());
    }

    /**
     * @return the current {@link A_BasicBot}
     */
    public A_BasicBot getBot() {
        return bot;
    }

    private void setBot(A_BasicBot bot) {
        this.bot = bot;
    }

    /**
     * @return the current set cron expression
     */
    public String getCronExpression() {
        return cronExpression;
    }

    private void setCronExpression(String cronExpression) {
        this.cronExpression = cronExpression;
    }

    /**
     * @return the {@link A_FeedbackTask} to use as a base for running
     */
    public A_FeedbackTask getTask() {
        return task;
    }

    private void setTask(A_FeedbackTask task) {
        this.task = task;
    }

    /**
     * @return the {@link A_FeedbackTask} to run on the given time
     */
    public A_FeedbackTask getCloneTask() {
        return cloneTask;
    }

    private void setCloneTask(A_FeedbackTask cloneTask) {
        this.cloneTask = cloneTask;
    }

    /**
     * initiate the timer and checking every time if the {@link A_FeedbackTask}
     * should be scheduled, using CHECK_INTERVAL as an interval
     */
    public void initiate() {
        try {
            setCloneTask(getTask().clone());
            getCloneTask().setRun(Boolean.TRUE);
            new Timer().scheduleAtFixedRate(this, new Date(), A_TimedTask.CHECK_INTERVAL);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        try {
            if(getCloneTask().hasRun()) {
                setCloneTask(getTask().clone());
                new Timer().schedule(getCloneTask(), CronHelper.getNextDate(getCronExpression()));
                getCloneTask().setRun(Boolean.FALSE);
            }
        } catch (IllegalStateException | CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * @return the {@link A_FeedbackTask} that will be scheduled
     */
    public abstract A_FeedbackTask createFeedbackTask();
}