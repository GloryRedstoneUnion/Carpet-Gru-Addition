package org.gru.carpet.carpetgruaddition.extension;

import carpet.CarpetExtension;
import org.gru.carpet.carpetgruaddition.loggers.FireworkRocketLogger;

public class GruAdditionExtension implements CarpetExtension {
    /**
     * 注册日志记录器
     */
    @Override
    public void registerLoggers() {
        FireworkRocketLogger.staticRegister();
    }
}