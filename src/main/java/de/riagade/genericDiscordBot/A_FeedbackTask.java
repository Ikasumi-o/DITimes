package de.riagade.genericDiscordBot;

import java.util.TimerTask;

/**
 * a task which gives feedback of it's running state
 * the property run says if the task was executed or not
 */
public abstract class A_FeedbackTask extends TimerTask implements Cloneable{
    private boolean run;

    public A_FeedbackTask() {
        setRun(Boolean.FALSE);
    }

    @Override
    public void run() {
        runLogic();
        setRun(Boolean.TRUE);
    }

    /**
     * @return true if the task was executed
     */
    public boolean hasRun() {
        return run;
    }

    public void setRun(boolean run) {
        this.run = run;
    }

    /**
     * a method to write the task in
     */
    public abstract void runLogic();

    @Override
    public A_FeedbackTask clone() throws CloneNotSupportedException {
        return (A_FeedbackTask) super.clone();
    }
}