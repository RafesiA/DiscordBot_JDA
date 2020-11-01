package Discord.Bot;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");

		
		if(args[0].equalsIgnoreCase(MainApp.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Jo Bot Information");
			info.setDescription("아직은 아무 쓸데가 없다.");
			info.addField("만든새끼", "조경진\n https://github.com/RafesiA", false);
			info.setColor(0xff0d00);
			info.setFooter("Called", event.getMember().getUser().getAvatarUrl());
			
			
			
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
		
	}
	
}
