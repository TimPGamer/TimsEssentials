package net.mcreator.tec.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

public class SpawntpProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_x, TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_y, TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_x, TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_y,
						TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_z, _ent.getYRot(), _ent.getXRot());
		}
		new Object() {
			private int ticks = 0;
			private float waitTicks;
			private LevelAccessor world;

			public void start(LevelAccessor world, int waitTicks) {
				this.waitTicks = waitTicks;
				MinecraftForge.EVENT_BUS.register(this);
				this.world = world;
			}

			@SubscribeEvent
			public void tick(TickEvent.ServerTickEvent event) {
				if (event.phase == TickEvent.Phase.END) {
					this.ticks += 1;
					if (this.ticks >= this.waitTicks)
						run();
				}
			}

			private void run() {
				{
					Entity _ent = entity;
					if (!_ent.level.isClientSide() && _ent.getServer() != null)
						_ent.getServer().getCommands().performCommand(_ent.createCommandSourceStack().withSuppressedOutput().withPermission(4), "/title @s title {\"bold\":true,\"color\":\"gold\",\"text\":\"Teleported!\"}");
				}
				MinecraftForge.EVENT_BUS.unregister(this);
			}
		}.start(world, 10);
	}
}
