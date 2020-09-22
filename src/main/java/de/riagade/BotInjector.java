package de.riagade;


import de.riagade.bot.FabiAlertDiscordBot;
import org.codehaus.plexus.util.StringUtils;

import java.util.Locale;

public class BotInjector {

    public static void main(String[] args) {
        //FabiAlertDiscordBot fadb = new FabiAlertDiscordBot(System.getenv().get("BOT_TOKEN"),
        //        getLongFromString(System.getenv().get("GUILD_ID")),
        //        getLongFromString(System.getenv().get("CHANNEL_ID")),
        //        Locale.GERMANY);
        FabiAlertDiscordBot fadb = new FabiAlertDiscordBot("NzEzMzg0MzQyOTQ4NDEzNTMx.XsfU8Q.EktCCZf0NqrWRBjeHM6POEmYrdY",
                487181512844771331L,
                487190167665508362L,
                Locale.GERMANY);
    }

    private static Long getLongFromString(String str) {
        if(StringUtils.isNumeric(str)){
            return Long.valueOf(str);
        }
        return 0L;
    }

}