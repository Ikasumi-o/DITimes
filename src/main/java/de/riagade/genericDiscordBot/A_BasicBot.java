package de.riagade.genericDiscordBot;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.Locale;

/**
 * a basic Discord bot for generic tasks which connects automatically.
 * use {@link Override} to use methods of {@link ListenerAdapter}
 */
public abstract class A_BasicBot extends ListenerAdapter {
    private long guildId, channelId;
    private String botToken;
    private Locale locale;
    private JDA jda;

    /**
     * @param botToken  the token which the bot uses to authenticate
     * @param guildId   the server id to connect the bot to
     * @param channelId the channel id for the bot to look at
     * @param locale    the locale for the bot to use
     */
    public A_BasicBot(String botToken, long guildId, long channelId, Locale locale){
        setBotToken(botToken);
        setGuildId(guildId);
        setChannelId(channelId);
        setLocale(locale);
        connect();
    }

    /**
     * @return the server id to which to connect
     */
    public long getGuildId() {
        return guildId;
    }

    private void setGuildId(long guildId) {
        this.guildId = guildId;
    }

    /**
     * @return the channel id to which the bot is assigned to
     */
    public long getChannelId() {
        return channelId;
    }

    private void setChannelId(long channelId) {
        this.channelId = channelId;
    }

    private String getBotToken() {
        return botToken;
    }

    private void setBotToken(String botToken) {
        this.botToken = botToken;
    }

    /**
     * @return the {@link Locale} that the bot uses
     */
    public Locale getLocale() {
        return locale;
    }

    private void setLocale(Locale locale) {
        this.locale = locale;
    }

    /**
     * @return the {@link JDA} to get more information from the discord server
     */
    public JDA getJda() {
        return jda;
    }

    private void setJda(JDA jda) {
        this.jda = jda;
    }

    /**
     * connects the bot to the server getGuildId
     */
    private void connect() {
        try {
            JDABuilder builder = new JDABuilder(AccountType.BOT);
            builder.setToken(getBotToken());
            builder.setAutoReconnect(true);
            builder.setStatus(OnlineStatus.ONLINE);
            setJda(builder.build());
            getJda().awaitReady();
        } catch (LoginException e){
            e.printStackTrace();
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    /**
     * disconnects the bot from the server getGuildId
     */
    public void disconnect() {
        getJda().shutdown();
    }

    /**
     * sends a message into the channel from getChannelId
     * @param msg the message to send
     */
    public void sendMessage(String msg) {
        try {
            getJda().getTextChannelById(getChannelId()).sendMessage(msg).queue();
        } catch (NullPointerException e){
            e.printStackTrace();
        }
    }

}