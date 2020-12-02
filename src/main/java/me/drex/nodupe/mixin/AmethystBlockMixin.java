package me.drex.nodupe.mixin;

import net.minecraft.block.AmethystBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.piston.PistonBehavior;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(AmethystBlock.class)
public class AmethystBlockMixin {

    /**
     * @author Drex
     * @reason Fix amethyst dupe
     */
    @Overwrite
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

}
