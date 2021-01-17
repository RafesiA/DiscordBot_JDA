package Commands;

import java.awt.Color;

import Discord.Bot.MainApp;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.User;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class UserInfoCommand extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		if(args.length == 1 && args[0].equalsIgnoreCase(MainApp.prefix + "user")) {
			event.getChannel().sendMessage("����� �̸� �Է��ϱ�").queue();
		}
		else if(args.length == 2 && args[0].equalsIgnoreCase(MainApp.prefix + "user")) {
			String userName = args[1];
			EmbedBuilder avatarEmbed = new EmbedBuilder();
			
			User user = event.getGuild().getMembersByName(userName, true).get(0).getUser();
			System.out.println(event.getGuild().getMembersByName(userName, true).size());
			
			String avatar = user.getAvatarUrl();
			// issue online status always display "OFFLINE", and can't find featured member.
			avatarEmbed.setTitle(userName + "�� ����: ");
			avatarEmbed.setColor(Color.GREEN);
			avatarEmbed.addField("����� �̸�:", user.getName(), true);
			avatarEmbed.addField("����: ", event.getGuild().getMembersByName(userName, true).get(0).getOnlineStatus().toString(), true);
			avatarEmbed.setThumbnail(avatar);
			event.getChannel().sendMessage(avatarEmbed.build()).queue();
		}
		
	}
}
