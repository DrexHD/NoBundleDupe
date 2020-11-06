package me.drex.nobundledupe.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.class_5541;
import net.minecraft.class_5542;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(class_5542.class)
public class class_5542Mixin extends class_5541 {

    public class_5542Mixin(Settings settings) {
        super(settings);
    }

    /*
    * This method makes sure crystals are actually destroyed when pushed by a piston
    * */
    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

}
