
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

import net.mcreator.tec.world.inventory.WMV1SpawnSettingsMenu;
import net.mcreator.tec.network.WMV1SpawnSettingsButtonMessage;
import net.mcreator.tec.TimsEssentialCommandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WMV1SpawnSettingsScreen extends AbstractContainerScreen<WMV1SpawnSettingsMenu> {
	private final static HashMap<String, Object> guistate = WMV1SpawnSettingsMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Button button_empty;
	Button button_empty1;
	Button button_empty2;
	Button button_empty3;
	Button button_empty4;
	Button button_empty5;
	Button button_back;
	Button button_empty6;
	Button button_empty7;

	public WMV1SpawnSettingsScreen(WMV1SpawnSettingsMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tims_essential_commands:textures/screens/wmv_1_spawn_settings.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_world_manager_v1"), 82, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_spawn_settings"), 7, 21, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_empty"), 2, 31, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_x_coordinate"), 12, 46, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_y_coordinate"), 12, 71, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.label_z_coordinate"), 12, 96, -12829636);
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
		button_empty = new Button(this.leftPos + 187, this.topPos + 41, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty"), e -> {
		});
		guistate.put("button:button_empty", button_empty);
		this.addRenderableWidget(button_empty);
		button_empty1 = new Button(this.leftPos + 137, this.topPos + 41, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty1"), e -> {
		});
		guistate.put("button:button_empty1", button_empty1);
		this.addRenderableWidget(button_empty1);
		button_empty2 = new Button(this.leftPos + 137, this.topPos + 66, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty2"), e -> {
		});
		guistate.put("button:button_empty2", button_empty2);
		this.addRenderableWidget(button_empty2);
		button_empty3 = new Button(this.leftPos + 187, this.topPos + 66, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty3"), e -> {
		});
		guistate.put("button:button_empty3", button_empty3);
		this.addRenderableWidget(button_empty3);
		button_empty4 = new Button(this.leftPos + 187, this.topPos + 91, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty4"), e -> {
		});
		guistate.put("button:button_empty4", button_empty4);
		this.addRenderableWidget(button_empty4);
		button_empty5 = new Button(this.leftPos + 137, this.topPos + 91, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty5"), e -> {
		});
		guistate.put("button:button_empty5", button_empty5);
		this.addRenderableWidget(button_empty5);
		button_back = new Button(this.leftPos + 7, this.topPos + 136, 61, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_back"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1SpawnSettingsButtonMessage(6, x, y, z));
				WMV1SpawnSettingsButtonMessage.handleButtonAction(entity, 6, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		button_empty6 = new Button(this.leftPos + 192, this.topPos + 136, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty6"), e -> {
		});
		guistate.put("button:button_empty6", button_empty6);
		this.addRenderableWidget(button_empty6);
		button_empty7 = new Button(this.leftPos + 217, this.topPos + 136, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_spawn_settings.button_empty7"), e -> {
		});
		guistate.put("button:button_empty7", button_empty7);
		this.addRenderableWidget(button_empty7);
	}
}
