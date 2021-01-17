package Commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import Discord.Bot.MainApp;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.*;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter{
	public void onGuildMessageReceived(GuildMessageReceivedEvent event) {
		String[] args = event.getMessage().getContentRaw().split("\\s+");
		
		/*
		if(!event.getMember().getUser().isBot()) {
			for(int i=0; i<args.length; i++) {
				event.getChannel().sendMessage(args[i]).queue();
			}
		}
		 * 
		 */
		// Invite URL Command
		if(args[0].equalsIgnoreCase(MainApp.prefix + "invite")) {
			event.getChannel().sendMessage("초대 코드 " + event.getChannel().createInvite().complete().getUrl()).queue();
		}
		
		// Calculate Command
		if(args[0].equalsIgnoreCase(MainApp.prefix + "calc")) {
			if(args.length == 1) {
				System.out.println("empty");
				event.getChannel().sendMessage("give argument to calculate. ex) !calc 1 + 1").queue();
			} 
			
			else if(args.length < 4) {
				EmbedBuilder err = new EmbedBuilder();
				err.setTitle("The expression is incomplete.");
				err.setDescription("Check expression. arguments and operator.");
				err.setColor(0xff0d00);
				event.getChannel().sendMessage(err.build()).queue();
			}
			
			if(!args[1].isEmpty() && !args[2].isEmpty() && !args[3].isEmpty() && args.length != 1) {
				try {
					int arg1 = Integer.parseInt(args[1]);
					int arg2 = Integer.parseInt(args[3]);
					String operator = args[2];
					
					int result = calculateResult(arg1, arg2, operator);

					event.getChannel().sendMessage(args[1] + " " + args[2] + " " + args[3] + " = " + result).queue();
					
					
				} catch(NumberFormatException e) {
					EmbedBuilder err = new EmbedBuilder();
					err.setTitle("Out of boundary.");
					err.setDescription("This calculate support Integer.");
					err.setColor(0xff0d00);
					event.getChannel().sendMessage(err.build()).queue();
				} 
			} 
		}
		
		// Simple response Command
		if(args[0].equalsIgnoreCase(MainApp.prefix + "오이")) {
			event.getChannel().sendMessage("오이? 뒤질래?").queue();
		}
		// Get a user name test Command
		if(args[0].equalsIgnoreCase(MainApp.prefix + "안녕")) {
			String name = event.getMember().getUser().getName();
			if(!event.getMember().getUser().isBot()) {
				event.getChannel().sendMessage("안녕? 말이 짧다? " + name + "?").queue();
			}
		}
		// Information Command
		if(args[0].equalsIgnoreCase(MainApp.prefix + "info")) {
			EmbedBuilder info = new EmbedBuilder();
			info.setTitle("Jo Bot Information");
			info.setAuthor("Developed by 조경진", null, "https://github.com/RafesiA/DiscordBot_JDA/blob/main/KakaoTalk_20201106_094546029.jpg?raw=true");
			info.setDescription("아직은 아무 쓸데가 없다.");
			info.setColor(0xff0d00);
			info.setFooter("인포 명령한놈", event.getMember().getUser().getAvatarUrl());
			event.getChannel().sendTyping().queue();
			event.getChannel().sendMessage(info.build()).queue();
			info.clear();
		}
		
	}
	
	public int calculateResult(int arg1, int arg2, String op) {
		int result = 0;
		
		if(op.equals("-")) {
			result = arg1 - arg2;
		}
		
		if(op.equals("+")) {
			result = arg1 + arg2;
		}
		if(op.equals("*")) {
			result = arg1 * arg2;
		}
		if(op.equals("/")) {
			result = arg1 / arg2;
		}
		return result;
	}
	
	
}
