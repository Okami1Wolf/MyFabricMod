package com.example.myfabricmod.chat;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.message.v1.ClientChatReceivedEvents;
import net.minecraft.text.Text;

public class ChatManager implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // Фильтруем каждое сообщение в чате
        ClientChatReceivedEvents.CHAT.register((message, signedMessage, sender) -> {
            String text = message.getString();
            if (!ChatConfig.shouldDisplay(text)) {
                return false; // не отображать сообщение
            }
            return true; // показываем сообщение
        });
    }
}
