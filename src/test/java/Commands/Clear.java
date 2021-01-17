package Commands;

import java.util.List;

import Discord.Bot.MainApp;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Clear extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		
		if(args[0].equalsIgnoreCase(MainApp.prefix + "clear")) {
			if(args.length < 2) {
				// Too many messages
				EmbedBuilder usage = new EmbedBuilder();
				usage.setColor(0xff3923);
				usage.setTitle("삭제하고자하는 메세지의 양을 함께 적어야 됨");
				usage.setDescription("Usage: " + MainApp.prefix + "clear #개의 메세지");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("최근 메세지  " + args[1] + "개가 삭제됨.");
					event.getChannel().sendMessage(success.build()).queue();
					System.out.println("Deleted Messages.");
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit is between 1 and 100 messages.")) {
						// Too many messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("삭제하고자 하는 메세지의 양이 너무 많거나 너무 적음");
						error.setDescription("1부터 100개의 메세지 삭제 가능. 총합 101개 삭제 가능 ");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						// Messages too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("오래된 메세지는 삭제가 불가능함.");
						error.setDescription("2주 이상 된 메세지는 삭제가 불가능합니다.");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
				}
			}
		}
	}
}
