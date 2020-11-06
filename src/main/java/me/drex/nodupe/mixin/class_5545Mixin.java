package me.drex.nodupe.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.class_5545;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;

import static net.minecraft.block.Block.dropStacks;

@Mixin(class_5545.class)
public abstract class class_5545Mixin {
    @Shadow
    protected static boolean method_31634(BlockHitResult blockHitResult) {
        return false;
    }



    @Shadow @Final public static BooleanProperty field_27183;

    /**
     * @author DrexHD
     * @reason This method fixes a candle duplication bug
     */
    @Overwrite
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (!itemStack.itemMatches(Items.FLINT_AND_STEEL) && !itemStack.itemMatches(Items.FIRE_CHARGE)) {
            if (method_31634(hit) && player.getStackInHand(hand).isEmpty() && state.get(field_27183)) {
                class_5540Invoker.method_31614(state, world, pos);
                return ActionResult.success(world.isClient);
            } else {
                ActionResult rs = CakeBlockInvoker.tryEat(world, pos, Blocks.CAKE.getDefaultState(), player);
                if (rs.isAccepted()) {
                    dropStacks(state, world, pos);
                }
                return rs;
            }
        } else {
            return ActionResult.PASS;
        }
    }

}
