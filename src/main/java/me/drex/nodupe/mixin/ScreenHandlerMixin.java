package me.drex.nodupe.mixin;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.CraftingScreenHandler;
import net.minecraft.screen.PlayerScreenHandler;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.util.ClickType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ScreenHandler.class)
public class ScreenHandlerMixin {

    @Redirect(method = "method_30010", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;onStackClicked(Lnet/minecraft/item/ItemStack;Lnet/minecraft/util/ClickType;Lnet/minecraft/entity/player/PlayerInventory;)Z"))
    private boolean updateRecipe(ItemStack cursorStack, ItemStack selectedItem, ClickType clickType, PlayerInventory playerInventory) {
        boolean result = cursorStack.onStackClicked(selectedItem, clickType, playerInventory);
        if (result) {
            PlayerEntity player = playerInventory.player;
            ScreenHandler currentScreen = player.currentScreenHandler;
            if (currentScreen instanceof CraftingScreenHandler || currentScreen instanceof PlayerScreenHandler) {
                currentScreen.sendContentUpdates();
                currentScreen.onContentChanged(player.getInventory());
            }
        }
        return result;
    }
}
