package Commands;

import java.util.Random;
import Discord.Bot.MainApp;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Status extends ListenerAdapter {
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String msg = event.getMessage().getContentRaw();
		String[] randomResponse = {
				"d", "����", "�ǽΰ� �����ϱ� �ú��������", "�����ϰ�ʹ�",
				"���� ��� ���� ��� ����", "�����ϸ� �ູ�ұ�?", "�̰� ��ճ�",
				"������ �� ������"
		};
		Random rand = new Random();
		
		if(msg.equalsIgnoreCase(MainApp.prefix + "status")) {
			event.getChannel().sendMessage(randomResponse[rand.nextInt(randomResponse.length)]).queue();
		}
	}
}
