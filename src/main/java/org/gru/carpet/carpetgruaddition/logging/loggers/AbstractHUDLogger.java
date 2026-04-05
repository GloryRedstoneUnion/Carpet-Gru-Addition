package org.gru.carpet.carpetgruaddition.logging.loggers;

import carpet.logging.HUDLogger;
import org.gru.carpet.carpetgruaddition.logging.GruAdditionLoggerRegistry;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.Text;

public abstract class AbstractHUDLogger extends AbstractLogger {
    public AbstractHUDLogger(String name, boolean strictOption) {
        super(name, strictOption);
    }

    public abstract Text[] onHudUpdate(String option, PlayerEntity playerEntity);

    @Override
    public HUDLogger createCarpetLogger() {
        return GruAdditionLoggerRegistry.standardHUDLogger(
                this.getName(), this.getDefaultLoggingOption(), this.getSuggestedLoggingOption()
        );
    }
}