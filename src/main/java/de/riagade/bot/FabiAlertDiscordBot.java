package de.riagade.bot;

import de.riagade.bot.task.timed.DailyRacoonTask;
import de.riagade.bot.task.timed.DailyWorldBossTask;
import de.riagade.genericDiscordBot.A_TimedBot;
import de.riagade.genericDiscordBot.A_TimedTask;
import de.riagade.bot.task.timed.GuildBallTask;
import de.riagade.bot.task.timed.GuildVsGuildTask;
import de.riagade.bot.task.timed.RuinsBossTask;
import de.riagade.bot.task.timed.WeeklyOverlordTask;

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
        tasks.add(new DailyRacoonTask(this, "0 40 19 ? * * *"));
        tasks.add(new DailyWorldBossTask(this, "0 20 12,16,22 ? * * *"));
        tasks.add(new GuildBallTask(this, "0 20 20 ? * SUN,MON,WED,FRI *"));
		tasks.add(new GuildVsGuildTask(this, "0 50 20 ? * TUE,THU *"));
		tasks.add(new RuinsBossTask(this, "0 50 14,22 ? * FRI,SAT *"));
        tasks.add(new WeeklyOverlordTask(this, "0 50 20 ? * FRI *"));
        return tasks;
    }
}
