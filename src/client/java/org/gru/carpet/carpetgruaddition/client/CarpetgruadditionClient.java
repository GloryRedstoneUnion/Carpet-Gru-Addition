package org.gru.carpet.carpetgruaddition.client;

import net.fabricmc.api.ClientModInitializer;
import org.gru.carpet.carpetgruaddition.CarpetgruadditionMod;

public class CarpetgruadditionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // 客户端初始化
        CarpetgruadditionMod.LOGGER.info("Carpet Gru Addition Client initialized");
    }
}
