package de.riagade.bot.task.feedback;

import de.riagade.bot.FabiAlertDiscordBot;
import de.riagade.bot.util.ResourcesHelper;
import de.riagade.genericDiscordBot.A_FeedbackTask;

public class WeeklyOverlordTask extends A_FeedbackTask {
    private FabiAlertDiscordBot bot;

    public WeeklyOverlordTask(FabiAlertDiscordBot bot){
        setBot(bot);
    }

    /**
     * @return the current {@link FabiAlertDiscordBot}
     */
    public FabiAlertDiscordBot getBot() {
        return bot;
    }

    private void setBot(FabiAlertDiscordBot bot) {
        this.bot = bot;
    }

    @Override
    public void runLogic() {
        getBot().sendMessage(ResourcesHelper.getResourceFileContent(getClass().getClassLoader(),
                "WeeklyOverlordTask.txt"));
    }
}
