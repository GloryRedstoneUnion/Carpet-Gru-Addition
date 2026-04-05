package org.gru.carpet.carpetgruaddition;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CarpetgruadditionMod implements ModInitializer {
    public static final String MOD_ID = "carpetgruaddition";
    public static final String MOD_NAME = "Carpet Gru Addition";
    public static final String COMPACT_NAME = MOD_ID.replace("-", "");
    private static String version;

    public static final Logger LOGGER = LogManager.getLogger();

    @Override
    public void onInitialize() {
        version = FabricLoader.getInstance().getModContainer(MOD_ID).orElseThrow(RuntimeException::new).getMetadata().getVersion().getFriendlyString();
        CarpetgruadditionServer.init();
    }

    public static String getVersion() {
        return version;
    }
}