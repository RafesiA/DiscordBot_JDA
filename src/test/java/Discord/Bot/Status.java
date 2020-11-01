package Discord.Bot;

import java.util.Random;
import Discord.Bot.MainApp;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Status extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String msg = event.getMessage().getContentRaw();
		String[] randomResponse = {
			"d", "섹스", "피싸고 있으니까 시비걸지마셈", "자퇴하고싶다",
			"과제 대신 해줄 사람 구함", "종강하면 행복할까?", "이거 재밌네",
			"다음엔 뭘 만들지"
		};
		Random rand = new Random();
		
		if(msg.equalsIgnoreCase(MainApp.prefix + "status")) {
			event.getChannel().sendMessage(randomResponse[rand.nextInt(randomResponse.length)]).queue();
		}
	}
}
