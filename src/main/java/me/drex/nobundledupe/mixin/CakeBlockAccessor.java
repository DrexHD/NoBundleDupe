package me.drex.nobundledupe.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.CakeBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldAccess;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CakeBlock.class)
public class CakeBlockAccessor {
    static ActionResult tryEat(WorldAccess worldAccess, BlockPos blockPos, BlockState blockState, PlayerEntity playerEntity) {
        return tryEat(worldAccess, blockPos, blockState, playerEntity);
    }
}
