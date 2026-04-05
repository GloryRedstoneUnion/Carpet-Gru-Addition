package org.gru.carpet.carpetgruaddition.logging;

import carpet.logging.LoggerRegistry;
import carpet.logging.HUDLogger;
import carpet.logging.Logger;
import org.gru.carpet.carpetgruaddition.CarpetgruadditionMod;
import org.gru.carpet.carpetgruaddition.logging.loggers.AbstractLogger;
import org.gru.carpet.carpetgruaddition.logging.loggers.FireworkRocketLogger;
import com.google.common.collect.Lists;

import java.lang.reflect.Field;
import java.util.List;

public class GruAdditionLoggerRegistry {
    private static final List<Runnable> onRegisteredCallbacks = Lists.newArrayList();

    public static boolean __fireworkRocket;

    public static void registerLoggers() {
        // Register loggers here
        FireworkRocketLogger.staticRegister();
        onRegisteredCallbacks.forEach(Runnable::run);
    }

    public static void register(AbstractLogger logger) {
        register(logger.createCarpetLogger());
    }

    private static void register(Logger logger) {
        if (logger != null) {
            LoggerRegistry.registerLogger(logger.getLogName(), logger);
        }
    }

    public static Field getLoggerField(String logName) {
        try {
            return GruAdditionLoggerRegistry.class.getField("__" + logName);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(String.format("Failed to get logger field \"%s\" @ %s", logName, CarpetgruadditionMod.MOD_NAME));
        }
    }

    public static Logger standardLogger(String logName, String def, String[] options) {
        return new Logger(
                getLoggerField(logName), logName, def, options
        );
    }

    public static HUDLogger standardHUDLogger(String logName, String def, String[] options) {
        return new HUDLogger(
                getLoggerField(logName), logName, def, options, true
        );
    }

    public static void addLoggerRegisteredCallback(Runnable callback) {
        onRegisteredCallbacks.add(callback);
    }
}