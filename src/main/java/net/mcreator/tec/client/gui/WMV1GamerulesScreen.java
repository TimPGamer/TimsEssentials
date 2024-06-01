
package net.mcreator.tec.client.gui;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Checkbox;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.Minecraft;

import net.mcreator.tec.world.inventory.WMV1GamerulesMenu;
import net.mcreator.tec.network.WMV1GamerulesButtonMessage;
import net.mcreator.tec.TimsEssentialCommandsMod;

import java.util.HashMap;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.systems.RenderSystem;

public class WMV1GamerulesScreen extends AbstractContainerScreen<WMV1GamerulesMenu> {
	private final static HashMap<String, Object> guistate = WMV1GamerulesMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	Checkbox CBOutput;
	Checkbox DNCycle;
	Button button_back;

	public WMV1GamerulesScreen(WMV1GamerulesMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 250;
		this.imageHeight = 166;
	}

	private static final ResourceLocation texture = new ResourceLocation("tims_essential_commands:textures/screens/wmv_1_gamerules.png");

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
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_gamerules.label_world_manager_v1"), 82, 6, -12829636);
		this.font.draw(poseStack, new TranslatableComponent("gui.tims_essential_commands.wmv_1_gamerules.label_gamerules"), 102, 16, -12829636);
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
		button_back = new Button(this.leftPos + 7, this.topPos + 136, 61, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_gamerules.button_back"), e -> {
			if (true) {
				TimsEssentialCommandsMod.PACKET_HANDLER.sendToServer(new WMV1GamerulesButtonMessage(0, x, y, z));
				WMV1GamerulesButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		});
		guistate.put("button:button_back", button_back);
		this.addRenderableWidget(button_back);
		CBOutput = new Checkbox(this.leftPos + 7, this.topPos + 31, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_gamerules.CBOutput"), false);
		guistate.put("checkbox:CBOutput", CBOutput);
		this.addRenderableWidget(CBOutput);
		DNCycle = new Checkbox(this.leftPos + 7, this.topPos + 56, 20, 20, new TranslatableComponent("gui.tims_essential_commands.wmv_1_gamerules.DNCycle"), false);
		guistate.put("checkbox:DNCycle", DNCycle);
		this.addRenderableWidget(DNCycle);
	}
}
