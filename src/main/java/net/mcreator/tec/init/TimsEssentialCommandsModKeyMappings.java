
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.tec.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.client.ClientRegistry;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.tec.network.WMV1Message;
import net.mcreator.tec.TimsEssentialCommandsMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TimsEssentialCommandsModKeyMappings {
	public static final KeyMapping WMV_1 = new KeyMapping("key.tims_essential_commands.wmv_1", GLFW.GLFW_KEY_O, "key.categories.ui");

	@SubscribeEvent
	public static void registerKeyBindings(FMLClientSetupEvent event) {
		ClientRegistry.registerKeyBinding(WMV_1);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onKeyInput(InputEvent.KeyInputEvent event) {
			if (Minecraft.getInstance().screen == null) {
				if (event.getKey() == WMV_1.getKey().getValue()) {
					if (event.getAction() == GLFW.GLFW_PRESS) {
						TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1Message(0, 0));
						WMV1Message.pressAction(Minecraft.getInstance().player, 0, 0);
					}
				}
			}
		}
	}
}
