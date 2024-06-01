package net.mcreator.tec.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

public class UpdatePermTPSpawnProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##.##").format(TimsEssentialCommandsModVariables.MapVariables.get(world).TP_to_Spawn_Perm_LVL) + "";
	}
}
