package de.riagade.bot;

import de.riagade.bot.task.timed.DailyDiabloBattlegroundTask;
import de.riagade.genericDiscordBot.A_TimedBot;
import de.riagade.genericDiscordBot.A_TimedTask;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class FabiAlertDiscordBot extends A_TimedBot {

    /**
     * @param botToken  the token which the bot uses to authenticate
     * @param guildId   the server id to connect the bot to
     * @param channelId the channel id for the bot to look at
     * @param locale    the locale for the bot to use
     */
    public FabiAlertDiscordBot(String botToken, long guildId, long channelId, Locale locale) {
        super(botToken, guildId, channelId, locale);
    }

    @Override
    public List<A_TimedTask> getTasksList() {
        List<A_TimedTask> tasks = new ArrayList<>();
        tasks.add(new DailyDiabloBattlegroundTask(this, "0 0 8,12,18,22 ? * * *"));
        return tasks;
    }
}
