package Discord.Bot;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.*;

public class MainApp extends ListenerAdapter{
	public static String prefix = "!";
	public static JDA jda;
	

	public static void main(String [] args) throws LoginException {
		String token = "";			// BOT Token.
		jda = JDABuilder.createDefault(token).build();
		
		jda.getPresence().setActivity(Activity.playing("Currently Working"));
		
		Commands cmd = new Commands();
		Clear clear = new Clear();
		jda.addEventListener(cmd);
		jda.addEventListener(clear);
		jda.addEventListener(new Status());
	}
	

}
