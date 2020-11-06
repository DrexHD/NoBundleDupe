package me.drex.nobundledupe.mixin;

import net.minecraft.item.BundleItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(BundleItem.class)
public class BundleItemMixin {

    @Redirect(method = "method_31562", at = @At(value = "INVOKE", target = "Lnet/minecraft/item/ItemStack;method_31574(Lnet/minecraft/item/Item;)Z"))
    private static boolean denySpecialCaseBundle(ItemStack itemStack, Item item) {
        return false;
    }
}
