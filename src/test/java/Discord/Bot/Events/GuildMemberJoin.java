package Discord.Bot.Events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {
	String [] messages = {
			"[member]�� ��� ���°��� �𸣰����� ���� ������� ȯ�� ������",
			"�߾� ������ ���� �Դ� ������ �̸��� [member]��µ�?",
			"[member]�� �ȳ��ϼ��� ���� �ٽ� �����ø� �ǿ�",
			"�ʷõ�� [member] �޾ƶ�",
			"��- ����úθ�- [member]��-",
			"[member]�� �ȳ��ϼ���. �λ�� �̰ɷ� ���Դϴ� ����",
			"�̻������ [member]�� �Դµ� ���� �ϰ� �ִ°Գ�",
			"ũũũ- �Դ°�.. ���� ���� [member]."
		};
	
	public void onGuildMemberJoin(GuildMemberJoinEvent event) {
		Random rand = new Random();		
		int number = rand.nextInt(messages.length);
		
		System.out.println("Identified New Memeber.");
		
		EmbedBuilder join = new EmbedBuilder();
		join.setColor(0x66d8ff);
		join.setDescription(messages[number].replace("[member]", event.getMember().getAsMention()));
		
		// New member when invited, send welcome message.
		event.getGuild().getDefaultChannel().sendMessage(join.build()).queue();
		
		// And add new role to New.
		event.getGuild().addRoleToMember(event.getMember(), (Role) event.getGuild().getRolesByName("Newbie", true)).complete();
		
	}
}
