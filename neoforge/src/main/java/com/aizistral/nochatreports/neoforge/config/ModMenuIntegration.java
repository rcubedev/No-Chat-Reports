package com.aizistral.nochatreports.neoforge.config;

import com.aizistral.nochatreports.common.NCRCore;
import com.aizistral.nochatreports.common.config.ClothConfigIntegration;

import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;

@Mod(value = "nochatreports", dist = Dist.CLIENT)
public class ModMenuIntegration {
    public ModMenuIntegration(IEventBus modEventBus) {
        if (!ClothConfigIntegration.ACTIVE) {
            NCRCore.LOGGER.warn("ClothConfig API not found, cannot provide config screen factory.");
            return;
        }
        ModLoadingContext.get().registerExtensionPoint(
            IConfigScreenFactory.class,
            () -> (minecraft, screen) -> ClothConfigIntegration.getConfigScreen(screen)
        );
    }
}