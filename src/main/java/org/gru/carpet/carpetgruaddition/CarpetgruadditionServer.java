package org.gru.carpet.carpetgruaddition;

import carpet.CarpetExtension;
import carpet.CarpetServer;
import org.gru.carpet.carpetgruaddition.logging.GruAdditionLoggerRegistry;
import org.gru.carpet.carpetgruaddition.logging.GruAdditionHUDController;
import net.minecraft.server.MinecraftServer;

public class CarpetgruadditionServer implements CarpetExtension {
    private static final CarpetgruadditionServer INSTANCE = new CarpetgruadditionServer();
    public static MinecraftServer minecraft_server;

    @Override
    public String version() {
        return CarpetgruadditionMod.MOD_ID;
    }

    public static CarpetgruadditionServer getInstance() {
        return INSTANCE;
    }

    public static void init() {
        CarpetServer.manageExtension(INSTANCE);
    }

    @Override
    public void onGameStarted() {
        GruAdditionLoggerRegistry.registerLoggers();
    }

    @Override
    public void onServerLoaded(MinecraftServer server) {
        minecraft_server = server;
    }

    @Override
    public void onTick(MinecraftServer server) {
        GruAdditionHUDController.updateHUD(server);
    }

    @Override
    public void registerLoggers() {
        GruAdditionLoggerRegistry.registerLoggers();
    }
}