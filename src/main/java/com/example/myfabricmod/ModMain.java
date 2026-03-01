package com.example.myfabricmod;

import com.example.myfabricmod.chat.ChatConfig;
import com.example.myfabricmod.chat.ChatManager;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.ModInitializer;

public class ModMain implements ModInitializer {

    @Override
    public void onInitialize() {
        System.out.println("MyFabricMod loaded!");
    }

    public static class Client implements ClientModInitializer {
        @Override
        public void onInitializeClient() {
            new ChatConfig().onInitializeClient();
            new ChatManager().onInitializeClient();
        }
    }
}
