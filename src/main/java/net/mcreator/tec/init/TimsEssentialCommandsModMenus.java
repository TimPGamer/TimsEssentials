
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tec.init;

import net.minecraftforge.network.IContainerFactory;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.RegistryEvent;

import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.inventory.AbstractContainerMenu;

import net.mcreator.tec.world.inventory.WMV1PermsMenu;
import net.mcreator.tec.world.inventory.WMV1MainMenu;
import net.mcreator.tec.world.inventory.WMV1GamerulesMenu;

import java.util.List;
import java.util.ArrayList;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class TimsEssentialCommandsModMenus {
	private static final List<MenuType<?>> REGISTRY = new ArrayList<>();
	public static final MenuType<WMV1MainMenu> WMV_1_MAIN = register("wmv_1_main", (id, inv, extraData) -> new WMV1MainMenu(id, inv, extraData));
	public static final MenuType<WMV1GamerulesMenu> WMV_1_GAMERULES = register("wmv_1_gamerules", (id, inv, extraData) -> new WMV1GamerulesMenu(id, inv, extraData));
	public static final MenuType<WMV1PermsMenu> WMV_1_PERMS = register("wmv_1_perms", (id, inv, extraData) -> new WMV1PermsMenu(id, inv, extraData));

	private static <T extends AbstractContainerMenu> MenuType<T> register(String registryname, IContainerFactory<T> containerFactory) {
		MenuType<T> menuType = new MenuType<T>(containerFactory);
		menuType.setRegistryName(registryname);
		REGISTRY.add(menuType);
		return menuType;
	}

	@SubscribeEvent
	public static void registerContainers(RegistryEvent.Register<MenuType<?>> event) {
		event.getRegistry().registerAll(REGISTRY.toArray(new MenuType[0]));
	}
}
