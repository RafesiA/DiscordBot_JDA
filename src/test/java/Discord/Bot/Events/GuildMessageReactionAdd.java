package Discord.Bot.Events;

import net.dv8tion.jda.api.events.message.guild.react.GuildMessageReactionAddEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMessageReactionAdd extends ListenerAdapter {
	@Override
	public void onGuildMessageReactionAdd(GuildMessageReactionAddEvent event) {
		System.out.println("누군가 리액션함");
		System.out.println(event.getReaction().getReactionEmote().getName());
		
		if(event.getReactionEmote().getName().equals("❌") &&
				!event.getMember().getUser().isBot()) {
			System.out.println("The User requested.");
			
			if(event.getMember().getUser().equals(event.getChannel().
							retrieveMessageById(event.getMessageId()).complete().getAuthor())) {
				// If it's the author
				event.getChannel().retrieveMessageById(event.getMessageId()).complete().delete().queue();
			}
			else {
				
				event.getReaction().removeReaction().queue();
			}
		}
	}
}
