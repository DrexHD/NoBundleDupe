package me.drex.nodupe.mixin;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.nbt.Tag;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ServerPlayNetworkHandler.class)
public class ServerPlayNetworkHandlerMixin {

    @Shadow @Final private static Logger LOGGER;

    @Shadow public ServerPlayerEntity player;

    @Redirect(method = "onBookUpdate", at = @At(value = "INVOKE", target = "Lnet/minecraft/nbt/CompoundTag;getList(Ljava/lang/String;I)Lnet/minecraft/nbt/ListTag;"))
    public ListTag weDontNeedThesePages(CompoundTag compoundTag, String string, int i) {
        ListTag listTag = compoundTag.getList("pages", 8);
        boolean dupeAttempt = false;
        for (int j = 0; j < listTag.size(); j++) {
            Tag tag = listTag.get(j);
            if (tag instanceof StringTag) {
                StringTag stringTag = (StringTag) tag;
                final String s = stringTag.asString();
                if (s.length() > 300) {
                    stringTag = StringTag.of(s.substring(0, 300));
                    listTag.set(j, stringTag);
                    dupeAttempt = true;
                }
            }
        }
        if (dupeAttempt) LOGGER.warn(player.getEntityName() + " attempted to dupe!");
        return listTag;
    }

}
