
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

import net.mcreator.tec.world.inventory.WMV1MainMenu;
import net.mcreator.tec.network.WMV1MainButtonMessage;
import net.mcreator.tec.TimsEssentialCommandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WMV1MainScreen extends AbstractContainerScreen<WMV1MainMenu> {
	private final static HashMap<String, Object> guistate = WMV1MainMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_open;
	Button button_open1;
	Button button_open2;

	public WMV1MainScreen(WMV1MainMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tims_essential_commands:textures/screens/wmv_1_main.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.label_world_manager_v1"), 82, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.label_gamerules"), 57, 26, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.label_command_perms"), 57, 51, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.label_spawn_settings"), 57, 76, -12829636);
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
		button_open = new Button(this.leftPos + 7, this.topPos + 21, 46, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.button_open"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1MainButtonMessage(0, x, y, z));
				WMV1MainButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_open", button_open);
		this.addRenderableWidget(button_open);
		button_open1 = new Button(this.leftPos + 7, this.topPos + 46, 46, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.button_open1"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1MainButtonMessage(1, x, y, z));
				WMV1MainButtonMessage.handleButtonAction(entity, 1, x, y, z);
			}
		});
		guistate.put("button:button_open1", button_open1);
		this.addRenderableWidget(button_open1);
		button_open2 = new Button(this.leftPos + 7, this.topPos + 71, 46, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_main.button_open2"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1MainButtonMessage(2, x, y, z));
				WMV1MainButtonMessage.handleButtonAction(entity, 2, x, y, z);
			}
		});
		guistate.put("button:button_open2", button_open2);
		this.addRenderableWidget(button_open2);
	}
}
