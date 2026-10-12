package com.ciroxz.client;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;
import org.lwjgl.glfw.GLFW;

public class CiroxzClientMod implements ClientModInitializer {
    private static KeyBinding guiKeyBind;

    @Override
    public void onInitializeClient() {
        guiKeyBind = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.ciroxz.gui",
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_RIGHT_SHIFT,
                "category.ciroxz.general"
        ));

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            while (guiKeyBind.wasPressed()) {
                if (client.player != null) {
                    // Aquí se abrirá el menú cuando esté completo
                }
            }
        });
    }
}
