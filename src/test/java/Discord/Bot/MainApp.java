package Discord.Bot;

import javax.security.auth.login.LoginException;

import Commands.Clear;
import Commands.Commands;
import Commands.LastoriginCommands;
import Commands.Status;
import Commands.UserInfoCommand;
import Discord.Bot.Events.GuildMemberJoin;
import Discord.Bot.Events.GuildMessageReactionAdd;
import Discord.Bot.Events.GuildMessageReceived;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class MainApp extends ListenerAdapter{
	public static String prefix = "!";
	public static JDA jda;
	

	public static void main(String [] args) throws LoginException {
		String token = "NzcyNDIxMjEwODAxMDQ1NTA1.X56bTw.pRxY8RQKEXfkE07AHapVlt5RTOs";
		jda = JDABuilder.createDefault(token).build();
		
		jda.getPresence().setActivity(Activity.playing("Áö±Ý »óÈ² ÆÄ¾ÇÀÌ ¾ÈµÅ?"));
		
		jda.addEventListener(new Commands());
		jda.addEventListener(new Clear());
		jda.addEventListener(new Status());
		jda.addEventListener(new GuildMemberJoin());
		jda.addEventListener(new GuildMessageReceived());
		jda.addEventListener(new GuildMessageReactionAdd());
		jda.addEventListener(new LastoriginCommands());
		jda.addEventListener(new UserInfoCommand());
	}
	

}
