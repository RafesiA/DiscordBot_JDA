package Discord.Bot.Events;

import java.util.Random;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.events.guild.member.GuildMemberJoinEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class GuildMemberJoin extends ListenerAdapter {
	String [] messages = {
			"[member]님 어떻게 들어온건진 모르겠지만 여기 사람들은 환영 안해줌",
			"야야 ㅋㅋㅋ 신입 왔다 ㅋㅋㅋ 이름이 [member]라는데?",
			"[member]님 안녕하세요 이제 다시 나가시면 되요",
			"십련들아 [member] 받아라",
			"여- 히사시부리- [member]쿤-",
			"[member]님 안녕하세요. 인사는 이걸로 끝입니다 일해",
			"이새끼들아 [member]님 왔는데 뭣들 하고 있는게냐",
			"크크크- 왔는가.. 나의 종속 [member]."
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
