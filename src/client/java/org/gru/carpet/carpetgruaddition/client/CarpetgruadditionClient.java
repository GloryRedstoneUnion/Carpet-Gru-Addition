package org.gru.carpet.carpetgruaddition.client;

import carpet.CarpetServer;
import net.fabricmc.api.ClientModInitializer;
import org.gru.carpet.carpetgruaddition.extension.GruAdditionExtension;

public class CarpetgruadditionClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        // 注册扩展
        CarpetServer.manageExtension(new GruAdditionExtension());
    }
}
