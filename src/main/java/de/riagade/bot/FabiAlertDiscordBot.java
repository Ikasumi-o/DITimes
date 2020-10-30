package de.riagade.bot;

import de.riagade.bot.task.timed.DailyRacoonTask;
import de.riagade.bot.task.timed.DailyWorldBossTask;
import de.riagade.bot.task.timed.MoWedFriSoGuildBallTask;
import de.riagade.bot.task.timed.TueThuGuildVsGuildTask;
import de.riagade.bot.task.timed.FrSaRuinsBossTask;
import de.riagade.bot.task.timed.WeeklyOverlordTask;
import de.riagade.bot.task.timed.TueDragonQuestTask;
import de.riagade.bot.task.timed.DailieEventsOverviewMoTask;
import de.riagade.bot.task.timed.DailieEventsOverviewTueTask;
import de.riagade.bot.task.timed.DailieEventsOverviewWedTask;
import de.riagade.bot.task.timed.DailieEventsOverviewThuTask;
import de.riagade.bot.task.timed.DailieEventsOverviewFriTask;
import de.riagade.bot.task.timed.DailieEventsOverviewSatTask;
import de.riagade.bot.task.timed.DailieEventsOverviewSunTask;
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
        tasks.add(new DailyRacoonTask(this, "0 40 17 ? * * *"));
        tasks.add(new DailyWorldBossTask(this, "0 20 10,14,20 ? * * *"));
        tasks.add(new MoWedFriSoGuildBallTask(this, "0 20 18 ? * SUN,MON,WED,FRI *"));
	tasks.add(new TueThuGuildVsGuildTask(this, "0 50 18 ? * TUE,THU *"));
	tasks.add(new FrSaRuinsBossTask(this, "0 50 12,20 ? * FRI,SAT *"));
        tasks.add(new WeeklyOverlordTask(this, "0 50 18 ? * FRI *"));
	tasks.add(new TueDragonQuestTask(this, "0 50 17 ? * TUE *"));
	tasks.add(new DailieEventsOverviewMoTask(this, "0 0 8 ? * MON *")); 
	tasks.add(new DailieEventsOverviewTueTask(this, "0 0 8 ? * TUE *")); 
	tasks.add(new DailieEventsOverviewWedTask(this, "0 0 8 ? * WED *"));
	tasks.add(new DailieEventsOverviewThuTask(this, "0 0 8 ? * THU *"));
	tasks.add(new DailieEventsOverviewFriTask(this, "0 0 8 ? * FRI *"));
	tasks.add(new DailieEventsOverviewSatTask(this, "0 0 8 ? * SAT *"));
	tasks.add(new DailieEventsOverviewSunTask(this, "0 0 8 ? * SUN *"));
        return tasks;
    }
}
