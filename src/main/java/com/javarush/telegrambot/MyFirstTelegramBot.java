package com.javarush.telegrambot;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import java.util.Map;

import static com.javarush.telegrambot.TelegramBotContent.*;

public class MyFirstTelegramBot extends MultiSessionTelegramBot {
    public static final String NAME = "CyberCat_2024_bot"; // TODO: добавьте имя бота в кавычках
    public static final String TOKEN = ; //TODO: добавьте токен бота в кавычках

    public MyFirstTelegramBot() {
        super(NAME, TOKEN);
    }

    @Override
    public void onUpdateEventReceived(Update updateEvent) {
        if (getMessageText().equals("/start")) {
            setUserGlory(0);
            sendTextMessageAsync(STEP_1_TEXT, Map.of("Взлом холодильника", "step_1_btn"));
        }
        if (getCallbackQueryButtonKey().equals("step_1_btn")) {
            addUserGlory(20);
            sendTextMessageAsync(STEP_2_TEXT,
                    Map.of("Взять сосиску! +20 славы", "step_2_btn",
                            "Взять рыбку! +20 славы", "step_2_btn",
                            "Скинуть банку с огурцами! +20 славы", "step_2_btn"
                    ));
        }

        if (getCallbackQueryButtonKey().equals("step_2_btn")) {
            addUserGlory(20);
            sendTextMessageAsync(STEP_3_TEXT,
                    Map.of("Взлом робота пылесоса +20 славы", "step_3_btn"
                    ));
        }
        if (getCallbackQueryButtonKey().equals("step_3_btn")) {
            addUserGlory(30);
            sendTextMessageAsync(STEP_4_TEXT,
                    Map.of("Отправить робот пылесос за едой! +30 славы", "step_4_btn",
                            "Покататься на работе пылесосе! +30 славы", "step_4_btn",
                            "Убегать от робопылесоса! +30 славы", "step_4_btn"
                    ));
        }


        if (getCallbackQueryButtonKey().equals("step_4_btn")) {
            addUserGlory(40);
            sendTextMessageAsync(STEP_5_TEXT,
                    Map.of("Надеть и включить GoPro!", "step_5_btn"
                    ));
        }

        if (getCallbackQueryButtonKey().equals("step_5_btn")) {
            addUserGlory(40);
            sendTextMessageAsync(STEP_6_TEXT,
                    Map.of("Бегать по крышам, снимать на GoPro! +40 славы", "step_6_btn",
                            "С GoPro нападать на других котов из засады! +40 славы", "step_6_btn",
                            "С GoPro нападать на собак из засады! +40 славы", "step_6_btn"
                    ));
        }
//        -----------------------------------
        if (getCallbackQueryButtonKey().equals("step_6_btn")) {
            addUserGlory(40);
            sendTextMessageAsync(STEP_7_TEXT,
                    Map.of("Взлом пароля", "step_7_btn"
                    ));
        }
        if (getCallbackQueryButtonKey().equals("step_7_btn")) {
            addUserGlory(0 );
            sendTextMessageAsync(STEP_8_TEXT,
                    Map.of("Выйти во двор", "step_8_btn"
                    ));
        }


        if (getCallbackQueryButtonKey().equals("step_8_btn")) {
            addUserGlory(40);
            sendTextMessageAsync(FINAL_TEXT);


        }


        if (getMessageText().equals("/glory")) {
            int z=getUserGlory();
            String strNumber = String.valueOf(z);
            sendTextMessageAsync(strNumber);
        }









    }

    public static void main(String[] args) throws TelegramApiException {
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
        telegramBotsApi.registerBot(new MyFirstTelegramBot());
    }
}




//sendTextMessageAsync("_Привет_, *как тебя зовут?*");
//        if (getMessageText().equals("/start")) {
//sendTextMessageAsync("Рад знакомству, я - *Кот*");
//        }
//                if (getMessageText().equals("привет, как тебя зовут?")) {
//sendTextMessageAsync("Рад знакомству, я - *Кот*");
//        }
//
//
//                if (getMessageText().equals("/bye")) {
//sendTextMessageAsync("Asta la vista, baby!");
//        }
//
//                if (getMessageText().equals("картинка")) {
//sendPhotoMessageAsync("step_8_pic");
//        }
//
//                if (getMessageText().equals("кот")) {
//sendTextMessageAsync("Ваше любимое животное? ",
//                     Map.of("Кот", "cat", "Собака", "dog"));
//        }
//        if (getCallbackQueryButtonKey().equals("cat")){
//sendPhotoMessageAsync("step_4_pic");
//        }
//
//                if (getCallbackQueryButtonKey().equals("dog")){
//sendPhotoMessageAsync("step_6_pic");
//        }
//                if (getCallbackQueryButtonKey().equals("smile")){
//var message = getLastSentMessage();
//editTextMessageAsync(message.getMessageId(), message.getText()+" :) ");
//        }
