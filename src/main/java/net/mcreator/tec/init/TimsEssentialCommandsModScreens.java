
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tec.init;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.gui.screens.MenuScreens;

import net.mcreator.tec.client.gui.WMV1SpawnSettingsScreen;
import net.mcreator.tec.client.gui.WMV1PermsScreen;
import net.mcreator.tec.client.gui.WMV1MainScreen;
import net.mcreator.tec.client.gui.WMV1GamerulesScreen;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class TimsEssentialCommandsModScreens {
	@SubscribeEvent
	public static void clientLoad(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			MenuScreens.register(TimsEssentialCommandsModMenus.WMV_1_MAIN, WMV1MainScreen::new);
			MenuScreens.register(TimsEssentialCommandsModMenus.WMV_1_GAMERULES, WMV1GamerulesScreen::new);
			MenuScreens.register(TimsEssentialCommandsModMenus.WMV_1_PERMS, WMV1PermsScreen::new);
			MenuScreens.register(TimsEssentialCommandsModMenus.WMV_1_SPAWN_SETTINGS, WMV1SpawnSettingsScreen::new);
		});
	}
}
