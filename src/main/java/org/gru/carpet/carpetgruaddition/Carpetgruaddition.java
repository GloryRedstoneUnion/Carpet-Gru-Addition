package org.gru.carpet.carpetgruaddition;

import carpet.CarpetServer;
import net.fabricmc.api.ModInitializer;
import org.gru.carpet.carpetgruaddition.extension.GruAdditionExtension;

public class Carpetgruaddition implements ModInitializer {

    @Override
    public void onInitialize() {
        // 注册扩展
        CarpetServer.manageExtension(new GruAdditionExtension());
    }
}
