package me.drex.nodupe.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.class_5540;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(class_5540.class)
public interface class_5540Invoker {

    @Invoker("method_31614")
    static void method_31614(BlockState blockState, WorldAccess worldAccess, BlockPos blockPos) {
        throw new AssertionError();
    }

}
