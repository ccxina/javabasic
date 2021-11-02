package online.cx.javabasic.bot;


import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.request.*;
import com.pengrad.telegrambot.request.CopyMessage;
import com.pengrad.telegrambot.request.SendLocation;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendPhoto;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.File;

/**
 * @author Cao Xin
 * @since 2021/5/25
 */
public class BotMain {
    public static void main(String[] args) {

        TelegramBot bot = new TelegramBot("1841417663:AAGwFQQBmPfJuTZRkvp850S3tRegjmfaPPs");

        // Register for updates
        bot.setUpdatesListener(updates -> {
            // ... process updates
            // return id of last processed update or confirm them all
            updates.forEach(update -> {
                System.out.println(update);
                long chatId = update.message().chat().id();
                CopyMessage copyMessage = new CopyMessage(chatId, chatId, update.message().messageId());
//                SendLocation sendLocation = new SendLocation(chatId, );
//                bot.execute(copyMessage);
                Keyboard keyboard = new ReplyKeyboardMarkup(
                        new KeyboardButton("text"),
                        new KeyboardButton("contact").requestContact(true),
                        new KeyboardButton("location").requestLocation(true)
                );

                Keyboard replyKeyboardMarkup = new ReplyKeyboardMarkup(
                        new String[]{"first row button1", "first row button2"},
                        new String[]{"second row button1", "second row button2"})
                        .oneTimeKeyboard(true)   // optional
                        .resizeKeyboard(true)    // optional
                        .selective(true);        // optional

                Message message = update.editedMessage();
                InlineKeyboardMarkup inlineKeyboard = new InlineKeyboardMarkup(
                        new InlineKeyboardButton("url").url("www.google.com"),
                        new InlineKeyboardButton("callback_data").callbackData("callback_data"),
                        new InlineKeyboardButton("Switch!").switchInlineQuery("switch_inline_query"));
                copyMessage.replyMarkup(inlineKeyboard);
                bot.execute(copyMessage);
            });
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });


    }
}

