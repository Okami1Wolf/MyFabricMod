package com.example.myfabricmod.chat;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.hud.ChatHud;
import net.minecraft.text.Text;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class ChatConfig implements ClientModInitializer {

    // Настройки
    public static int chatHeight = 180; // пол экрана (по умолчанию 180 пикселей)
    public static int chatWidth = 300;  // ширина чата
    public static Color chatColor = new Color(0, 0, 0, 128); // черный с прозрачностью
    public static List<String> filterKeywords = new ArrayList<>(); // фильтры сообщений

    @Override
    public void onInitializeClient() {
        // Каждое обновление проверяем чат
        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            ChatHud chatHud = client.inGameHud.getChatHud();
            if (chatHud != null) {
                chatHud.setChatHeightFocused(chatHeight); // увеличиваем высоту чата
                chatHud.setChatWidth(chatWidth);          // ширина
            }
        });
    }

    // Проверка фильтра сообщений
    public static boolean shouldDisplay(String message) {
        if (filterKeywords.isEmpty()) return true;
        for (String keyword : filterKeywords) {
            if (message.contains(keyword)) return false;
        }
        return true;
    }
}
