package org.gru.carpet.carpetgruaddition;

import net.fabricmc.api.ModInitializer;

public class Carpetgruaddition implements ModInitializer {

    @Override
    public void onInitialize() {
        // 初始化模组
        new CarpetgruadditionMod().onInitialize();
    }
}
