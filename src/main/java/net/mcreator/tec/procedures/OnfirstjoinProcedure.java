package net.mcreator.tec.procedures;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.event.entity.player.PlayerEvent;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

import javax.annotation.Nullable;

@Mod.EventBusSubscriber
public class OnfirstjoinProcedure {
	@SubscribeEvent
	public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		execute(event, event.getPlayer().level, event.getPlayer());
	}

	public static void execute(LevelAccessor world, Entity entity) {
		execute(null, world, entity);
	}

	private static void execute(@Nullable Event event, LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (TimsEssentialCommandsModVariables.MapVariables.get(world).first_join == 1) {
			TimsEssentialCommandsModVariables.MapVariables.get(world).first_join = 0;
			TimsEssentialCommandsModVariables.MapVariables.get(world).syncData(world);
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_x = entity.getX();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_y = entity.getY();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_z = entity.getZ();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
		}
	}
}
