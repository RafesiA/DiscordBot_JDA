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
				usage.setTitle("�����ϰ����ϴ� �޼����� ���� �Բ� ����� ��");
				usage.setDescription("Usage: " + MainApp.prefix + "clear #���� �޼���");
				event.getChannel().sendMessage(usage.build()).queue();
			}
			else {
				try {
					List<Message> messages = event.getChannel().getHistory().retrievePast(Integer.parseInt(args[1])).complete();
					event.getChannel().deleteMessages(messages).queue();
					
					// Success
					EmbedBuilder success = new EmbedBuilder();
					success.setColor(0x22ff2a);
					success.setTitle("�ֱ� �޼���  " + args[1] + "���� ������.");
					event.getChannel().sendMessage(success.build()).queue();
					System.out.println("Deleted Messages.");
					
				} catch (IllegalArgumentException e) {
					e.printStackTrace();
					if(e.toString().startsWith("java.lang.IllegalArgumentException: Message retrieval limit is between 1 and 100 messages.")) {
						// Too many messages
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("�����ϰ��� �ϴ� �޼����� ���� �ʹ� ���ų� �ʹ� ����");
						error.setDescription("1���� 100���� �޼��� ���� ����. ���� 101�� ���� ���� ");
						event.getChannel().sendMessage(error.build()).queue();
					}
					else {
						// Messages too old
						EmbedBuilder error = new EmbedBuilder();
						error.setColor(0xff3923);
						error.setTitle("������ �޼����� ������ �Ұ�����.");
						error.setDescription("2�� �̻� �� �޼����� ������ �Ұ����մϴ�.");
						event.getChannel().sendMessage(error.build()).queue();
						
					}
				}
			}
		}
	}
}
