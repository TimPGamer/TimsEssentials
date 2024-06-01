
package net.mcreator.tec.network;

import net.minecraftforge.network.NetworkEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.core.BlockPos;

import net.mcreator.tec.world.inventory.WMV1PermsMenu;
import net.mcreator.tec.procedures.WMV1BackProcedure;
import net.mcreator.tec.procedures.PlusPermTPSpawnProcedure;
import net.mcreator.tec.procedures.PlusPermSetSpawnProcedure;
import net.mcreator.tec.procedures.MinusPermTPSpawnProcedure;
import net.mcreator.tec.procedures.MinusPermSetSpawnProcedure;
import net.mcreator.tec.TimsEssentialCommandsMod;

import java.util.function.Supplier;
import java.util.HashMap;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class WMV1PermsButtonMessage {
	private final int buttonID, x, y, z;

	public WMV1PermsButtonMessage(FriendlyByteBuf buffer) {
		this.buttonID = buffer.readInt();
		this.x = buffer.readInt();
		this.y = buffer.readInt();
		this.z = buffer.readInt();
	}

	public WMV1PermsButtonMessage(int buttonID, int x, int y, int z) {
		this.buttonID = buttonID;
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public static void buffer(WMV1PermsButtonMessage message, FriendlyByteBuf buffer) {
		buffer.writeInt(message.buttonID);
		buffer.writeInt(message.x);
		buffer.writeInt(message.y);
		buffer.writeInt(message.z);
	}

	public static void handler(WMV1PermsButtonMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
		NetworkEvent.Context context = contextSupplier.get();
		context.enqueueWork(() -> {
			Player entity = context.getSender();
			int buttonID = message.buttonID;
			int x = message.x;
			int y = message.y;
			int z = message.z;
			handleButtonAction(entity, buttonID, x, y, z);
		});
		context.setPacketHandled(true);
	}

	public static void handleButtonAction(Player entity, int buttonID, int x, int y, int z) {
		Level world = entity.level;
		HashMap guistate = WMV1PermsMenu.guistate;
		// security measure to prevent arbitrary chunk generation
		if (!world.hasChunkAt(new BlockPos(x, y, z)))
			return;
		if (buttonID == 0) {

			WMV1BackProcedure.execute(world, x, y, z, entity);
		}
		if (buttonID == 1) {

			PlusPermSetSpawnProcedure.execute(world);
		}
		if (buttonID == 2) {

			MinusPermSetSpawnProcedure.execute(world);
		}
		if (buttonID == 3) {

			MinusPermTPSpawnProcedure.execute(world);
		}
		if (buttonID == 4) {

			PlusPermTPSpawnProcedure.execute(world);
		}
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		TimsEssentialCommandsMod.addNetworkMessage(WMV1PermsButtonMessage.class, WMV1PermsButtonMessage::buffer, WMV1PermsButtonMessage::new, WMV1PermsButtonMessage::handler);
	}
}
