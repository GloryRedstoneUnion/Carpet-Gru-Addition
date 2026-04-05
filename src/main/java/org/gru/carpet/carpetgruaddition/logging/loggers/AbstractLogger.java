package org.gru.carpet.carpetgruaddition.logging.loggers;

import carpet.logging.Logger;
import carpet.logging.LoggerRegistry;
import org.gru.carpet.carpetgruaddition.CarpetgruadditionMod;
import org.gru.carpet.carpetgruaddition.logging.GruAdditionLoggerRegistry;
import com.google.common.base.Joiner;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Supplier;

public abstract class AbstractLogger {
    public final static String MULTI_OPTION_SEP_REG = "[, .]";
    public final static String OPTION_SEP = ",";

    private final String name;
    private final boolean strictOption;

    public AbstractLogger(String name, boolean strictOption) {
        this.name = name;
        this.strictOption = strictOption;
    }

    public String getName() {
        return this.name;
    }

    public String getDefaultLoggingOption() {
        String[] suggested = this.getSuggestedLoggingOption();
        return suggested != null && suggested.length > 0 ? suggested[0] : null;
    }

    public String[] getSuggestedLoggingOption() {
        return null;
    }

    public Logger createCarpetLogger() {
        return GruAdditionLoggerRegistry.standardLogger(
                this.getName(),
                wrapOption(this.getDefaultLoggingOption()),
                wrapOptions(this.getSuggestedLoggingOption())
        );
    }

    protected void actionWithLogger(Consumer<Logger> action) {
        Logger logger = LoggerRegistry.getLogger(this.getName());
        if (logger != null) {
            action.accept(logger);
        } else {
            CarpetgruadditionMod.LOGGER.warn("Failed to get carpet logger {}", this.getName());
        }
    }

    public void log(Supplier<net.minecraft.text.Text[]> messagePromise) {
        actionWithLogger(logger -> logger.log(messagePromise));
    }

    protected static String wrapOption(String option) {
        return option;
    }

    protected static String[] wrapOptions(String... options) {
        if (options == null) {
            return null;
        }
        options = options.clone();
        for (int i = 0; i < options.length; i++) {
            options[i] = wrapOption(options[i]);
        }
        return options;
    }

    protected static String createCompoundOption(Iterable<String> options) {
        return Joiner.on(OPTION_SEP).join(options);
    }

    protected static String createCompoundOption(String... options) {
        return createCompoundOption(Arrays.asList(options));
    }
}