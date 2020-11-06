package me.drex.nodupe.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(CakeBlock.class)
public interface CakeBlockInvoker {

    @Invoker("tryEat")
    static ActionResult tryEat(WorldAccess worldAccess, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity) {
        throw new AssertionError();
    }
}
