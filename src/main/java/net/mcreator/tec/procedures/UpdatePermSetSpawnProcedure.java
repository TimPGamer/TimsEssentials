package net.mcreator.tec.procedures;

import net.minecraft.world.level.LevelAccessor;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

public class UpdatePermSetSpawnProcedure {
	public static String execute(LevelAccessor world) {
		return new java.text.DecimalFormat("##.##").format(TimsEssentialCommandsModVariables.MapVariables.get(world).Set_Spawn_Perm_LVL) + "";
	}
}
