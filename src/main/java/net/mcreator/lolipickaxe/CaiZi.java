package net.mcreator.lolipickaxe;

import net.minecraft.ChatFormatting;

public class CaiZi {
    private static final ChatFormatting[] color = { 
        ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, ChatFormatting.GREEN, 
        ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.DARK_AQUA, 
        ChatFormatting.DARK_BLUE, ChatFormatting.DARK_GRAY, ChatFormatting.DARK_GREEN, 
        ChatFormatting.DARK_PURPLE, ChatFormatting.DARK_RED };
        
    private static final ChatFormatting[] color1 = { 
        ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, 
        ChatFormatting.WHITE, ChatFormatting.BLUE, ChatFormatting.WHITE, ChatFormatting.WHITE, 
        ChatFormatting.BLUE, ChatFormatting.WHITE, ChatFormatting.WHITE, ChatFormatting.BLUE, 
        ChatFormatting.RED, ChatFormatting.WHITE, ChatFormatting.GRAY, ChatFormatting.GRAY, 
        ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, 
        ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, 
        ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, ChatFormatting.GRAY, 
        ChatFormatting.GRAY, ChatFormatting.GRAY };
        
    private static final ChatFormatting[] color2 = {
    	ChatFormatting.GRAY };
    	
	private static final ChatFormatting[] color3 = {
    	ChatFormatting.DARK_GREEN };
    	
    private static final ChatFormatting[] color4 = { 
        ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, 
        ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, 
        ChatFormatting.LIGHT_PURPLE };

    private static final ChatFormatting[] color5 = { 
        ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.YELLOW, 
        ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.BLUE, 
        ChatFormatting.LIGHT_PURPLE, ChatFormatting.ITALIC, ChatFormatting.OBFUSCATED, ChatFormatting.UNDERLINE };

    private static final ChatFormatting[] color6 = {
    	ChatFormatting.BLUE };

   	private static final ChatFormatting[] color7 = {
    	ChatFormatting.WHITE };

    private static final ChatFormatting[] color8 = { 
      ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, 
      ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.RED, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, 
      ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, 
      ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.GOLD, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, 
      ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, ChatFormatting.YELLOW, 
      ChatFormatting.YELLOW, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, 
      ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.GREEN, ChatFormatting.AQUA, ChatFormatting.AQUA, 
      ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, 
      ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.AQUA, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, 
      ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.BLUE, 
      ChatFormatting.BLUE, ChatFormatting.BLUE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, 
      ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE, ChatFormatting.LIGHT_PURPLE };
    
    public static String rainbow(String input, ChatFormatting[] colors, double delay) {
        StringBuilder sb = new StringBuilder(input.length() * 3);
        if (delay <= 0.0D) {
            delay = 0.001D;
        }
        int offset = (int)Math.floor((System.currentTimeMillis() & 0x3FFF) / delay) % colors.length;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            sb.append(colors[((colors.length + i - offset) % colors.length)].toString());
            sb.append(c);
        }
        return sb.toString();
    }
    
    public static String rainbow(String input) {
        return rainbow(input, color, 52.5D);
    }
    
    public static String sanic(String input) {
        return rainbow(input, color1, 52.5D);
    }
    
    public static String gray(String input) {
        return rainbow(input, color2, 52.5D);
    }
    
    public static String green(String input) {
        return rainbow(input, color3, 52.5D);
    }

    public static String lightrainbow(String input) {
        return rainbow(input, color4, 52.5D);
    }
    
    public static String special(String input) {
        return rainbow(input, color5, 52.5D);
    }
    
    public static String blue(String input) {
        return rainbow(input, color6, 52.5D);
    }

    public static String white(String input) {
        return rainbow(input, color7, 52.5D);
    }

    public static String superlight(String input) {
        return rainbow(input, color8, 5.0D);
    }
}