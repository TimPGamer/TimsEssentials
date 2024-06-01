package net.mcreator.tec.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

public class MinusPermTPSpawnProcedure {
	public static void execute(LevelAccessor world) {
		if (TimsEssentialCommandsModVariables.MapVariables.get(world).TP_to_Spawn_Perm_LVL > 0) {
			TimsEssentialCommandsModVariables.MapVariables.get(world).TP_to_Spawn_Perm_LVL = TimsEssentialCommandsModVariables.MapVariables.get(world).TP_to_Spawn_Perm_LVL - 1;
			TimsEssentialCommandsModVariables.MapVariables.get(world).syncData(world);
		}
	}
}
