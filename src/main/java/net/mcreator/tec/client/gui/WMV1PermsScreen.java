
package net.mcreator.tec.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tec.world.inventory.WMV1PermsMenu;
import net.mcreator.tec.procedures.UpdatePermTPSpawnProcedure;
import net.mcreator.tec.procedures.UpdatePermSetSpawnProcedure;
import net.mcreator.tec.network.WMV1PermsButtonMessage;
import net.mcreator.tec.TimsEssentialCommandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WMV1PermsScreen extends AbstractContainerScreen<WMV1PermsMenu> {
	private final static HashMap<String, Object> guistate = WMV1PermsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_back;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;

	public WMV1PermsScreen(WMV1PermsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tims_essential_commands:textures/screens/wmv_1_perms.png");

	@Override
	public void render(PoseStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void renderBg(PoseStack ms, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		RenderSystem.setShaderTexture(0, texture);
		this.blit(ms, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void containerTick() {
		super.containerTick();
	}

	@Override
	protected void renderLabels(PoseStack poseStack, int mouseX, int mouseY) {
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_world_manager_v1"), 82, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_command_perms"), 87, 16, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_permission_level_04"), 117, 31, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_permission_name"), 7, 31, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_setting_spawn"), 12, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.label_tp_to_spawn"), 12, 76, -12829636);
		this.font.draw(poseStack,

				UpdatePermSetSpawnProcedure.execute(world), 172, 51, -12829636);
		this.font.draw(poseStack,

				UpdatePermTPSpawnProcedure.execute(world), 172, 76, -12829636);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardHandler.setSendRepeatsToGui(false);
	}

	@Override
	public void init() {
		super.init();
		this.minecraft.keyboardHandler.setSendRepeatsToGui(true);
		button_back = new Button(this.leftPos + 7, this.topPos + 136, 61, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.button_back"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1PermsButtonMessage(0, x, y, z));
				WMV1PermsButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_empty = new Button(this.leftPos + 187, this.topPos + 46, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.button_empty"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1PermsButtonMessage(1, x, y, z));
				WMV1PermsButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 142, this.topPos + 46, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.button_empty1"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1PermsButtonMessage(2, x, y, z));
				WMV1PermsButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new Button(this.leftPos + 142, this.topPos + 71, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.button_empty2"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1PermsButtonMessage(3, x, y, z));
				WMV1PermsButtonMessage.handleButtonAction(entity, 3, x, y, z);
			}
		});
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new Button(this.leftPos + 187, this.topPos + 71, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_perms.button_empty3"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1PermsButtonMessage(4, x, y, z));
				WMV1PermsButtonMessage.handleButtonAction(entity, 4, x, y, z);
			}
		});
		guistate.put("button:button_empty3", button_empty3);
		this.addRenderableWidget(button_empty3);
	}
}
