package Discord.Bot.Events;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReceived extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		// event.getMessage().addReaction("❌").queue();
	}
}
