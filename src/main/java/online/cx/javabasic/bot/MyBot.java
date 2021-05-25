package online.cx.javabasic.bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.List;

/**
 * Created on 2021/5/25.
 *
 * @author 曹鑫
 */
public class MyBot {

    public static void main(String[] args) {
        //-Djava.net.useSystemProxies=true -Dhttp.proxyHost=127.0.0.1 -Dhttp.proxyPort=7890


        // Create your bot passing the token received from @BotFather
        TelegramBot bot = new TelegramBot("1841417663:AAGwFQQBmPfJuTZRkvp850S3tRegjmfaPPs");

// Register for updates
        bot.setUpdatesListener(updates -> {
            // ... process updates
            updates.forEach(update -> {
                String text = update.message().text();
                bot.execute(new SendMessage(update.message().chat().id(), text));
            });
            // return id of last processed update or confirm them all
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });

// Send messages
//        SendMessage sendMessage = new SendMessage("1875520087", "Hello!");
//        SendResponse response = bot.execute(sendMessage);

    }

}
