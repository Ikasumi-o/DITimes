package de.riagade.bot.task.timed;

import de.riagade.bot.FabiAlertDiscordBot;
import de.riagade.bot.task.feedback.WedTask;
import de.riagade.genericDiscordBot.A_FeedbackTask;
import de.riagade.genericDiscordBot.A_TimedTask;

public class DailieEventsOverviewWedTask extends A_TimedTask {
    /**
     * @param cronExpression the cron expression to calculate the next execution
     */
    public DailieEventsOverviewWedTask(FabiAlertDiscordBot bot, String cronExpression) {
        super(bot, cronExpression);
    }

    @Override
    public A_FeedbackTask createFeedbackTask() {
        return new WedTask((FabiAlertDiscordBot) getBot());
    }
}
