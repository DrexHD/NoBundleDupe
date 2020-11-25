package me.drex.nodupe.mixin;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.CarpetBlock;
import net.minecraft.block.piston.PistonBehavior;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CarpetBlock.class)
public class CarpetBlockMixin extends Block {

    public CarpetBlockMixin(Settings settings) {
        super(settings);
    }

    @Override
    public PistonBehavior getPistonBehavior(BlockState state) {
        return PistonBehavior.DESTROY;
    }

}
