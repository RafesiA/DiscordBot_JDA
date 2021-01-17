package Discord.Main.Commands;

import java.util.List;

import Discord.Main.MainApp;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageClear(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if(args[0].equalsIgnoreCase(MainApp.prefix + "clear")) {
			if(args.length < 2) {
				// TODO error
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
				} catch (Exception e) {
					e.printStackTrace();
					if(e.toString().startsWith("java.lang.IllegalArgumentException: ")) {
						
					}
				}
			}
		}
	}
}
