package net.mcreator.tec.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.network.chat.TextComponent;
import net.minecraft.commands.arguments.coordinates.BlockPosArgument;
import net.minecraft.commands.CommandSourceStack;

import net.mcreator.tec.network.TimsEssentialCommandsModVariables;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.context.CommandContext;

public class SpawnsetProcedure {
	public static void execute(LevelAccessor world, CommandContext<CommandSourceStack> arguments, Entity entity) {
		if (entity == null)
			return;
		if (entity.hasPermissions(2)) {
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_x = new Object() {
				public double getX() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "spawn_xyz").getX();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getX();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_y = new Object() {
				public double getY() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "spawn_xyz").getY();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getY();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
			TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_z = new Object() {
				public double getZ() {
					try {
						return BlockPosArgument.getLoadedBlockPos(arguments, "spawn_xyz").getZ();
					} catch (CommandSyntaxException e) {
						e.printStackTrace();
						return 0;
					}
				}
			}.getZ();
			TimsEssentialCommandsModVariables.WorldVariables.get(world).syncData(world);
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent((("Spawn is now set at " + (TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_x + " , ")) + ""
						+ ((TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_y + " , ") + "" + (TimsEssentialCommandsModVariables.WorldVariables.get(world).spawn_z + " in this world.")))), (false));
		} else {
			if (entity instanceof Player _player && !_player.level.isClientSide())
				_player.displayClientMessage(new TextComponent("You don't have pemission to use this Command!"), (false));
		}
	}
}
