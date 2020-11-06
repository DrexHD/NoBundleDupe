package me.drex.nobundledupe.mixin;

import net.minecraft.item.BundleItem;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BundleItem.class)
public abstract class BundleItemMixin {

    /*
    * This method blocks players from putting more than one bundle inside a bundle
    * */
    @Inject(method = "method_31562", at = @At("HEAD"), cancellable = true)
    private static void getCount(ItemStack itemStack, CallbackInfoReturnable<Integer> cir) {
        cir.setReturnValue(64 / itemStack.getMaxCount());
    }

}
