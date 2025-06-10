package ru.ceuvento;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class Main {

    private static JDA jda;
    private static Dotenv dotenv;

    public static void main(String[] args) throws InterruptedException {
        dotenv = Dotenv.configure().load();
        final String TOKEN = dotenv.get("TOKEN");

        jda = JDABuilder
                .createDefault(TOKEN)
                .addEventListeners(new EventHandler())
                .build()
                .awaitReady();
        jda.updateCommands().addCommands(Commands.slash("bussin", "Добрая команда :3")).queue();
    }

    public static Dotenv getDotenv() {
        return dotenv;
    }
}

