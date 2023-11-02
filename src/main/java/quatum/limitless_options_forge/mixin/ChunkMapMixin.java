package quatum.limitless_options_forge.mixin;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(ChunkMap.class)
public class ChunkMapMixin{

    @Redirect(method = "setServerViewDistance", at = @At(value = "INVOKE", target = "net/minecraft/util/Mth.clamp(III)I"))
    private int redirectClamp(int p_140168_, int min, int max) {
        // Hier leitest du den Aufruf von Mth.clamp um und gibst einfach 'value' zurück
        return Mth.clamp(p_140168_, 1, Byte.MAX_VALUE -2);
    }
}
