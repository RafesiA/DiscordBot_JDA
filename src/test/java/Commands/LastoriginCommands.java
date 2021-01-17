package Commands;

import Discord.Bot.MainApp;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class LastoriginCommands extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String msg = event.getMessage().getContentRaw();
	
		if(msg.equalsIgnoreCase(MainApp.prefix + "πÃ»£")) {
			EmbedBuilder miho = new EmbedBuilder();
			miho.setTitle("");
		}
	}
}
