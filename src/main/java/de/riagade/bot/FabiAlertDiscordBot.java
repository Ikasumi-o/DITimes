package de.riagade.bot;
import de.riagade.bot.task.timed.DailyDiabloSchatzkammerTask;
import de.riagade.bot.task.timed.DailyDiabloVersammlungTask;
import de.riagade.bot.task.timed.DailyDiabloBattlegroundTask;
import de.riagade.bot.task.timed.TueFriDiabloKutscheTask;
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
        tasks.add(new DailyDiabloBattlegroundTask(this, "0 0 6,10,16,20 ? * * *"));
        tasks.add(new DailyDiabloVersammlungTask(this, "0 0 16 ? * MON,TUE,WED,THU,FRI,SAT *"));
        tasks.add(new DailyDiabloSchatzkammerTask(this, "0 0 10,17 ? * * *"));
        tasks.add(new TueFriDiabloKutscheTask(this, "0 50 9,19 ? * WED,SAT *"));
        tasks.add(new TueFriDiabloKutscheTask(this, "0 20 18 ? * WED,SAT *"));
        return tasks;
    }
}
