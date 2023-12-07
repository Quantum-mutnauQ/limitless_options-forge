package quatum.limitless_options_forge.mixin;

import net.minecraft.server.level.ChunkMap;
import net.minecraft.util.Mth;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ChunkMap.class)
public class ChunkMapMixin{
    @Mutable
    @Shadow @Final
    private static int MIN_VIEW_DISTANCE;
    @Mutable
    @Shadow @Final
    public static int MAX_VIEW_DISTANCE ;
    int anInt = 0;
    int anInt_ = 0;

    @Redirect(method = "setViewDistance", at = @At(value = "INVOKE", target = "net/minecraft/util/Mth.clamp(III)I"))
    private int redirectClamp(int p_140168_, int min, int max) {
        // Hier leitest du den Aufruf von Mth.clamp um und gibst einfach 'value' zurück
        return Mth.clamp(p_140168_, 1, Byte.MAX_VALUE - 2);
    }
    @Inject(method = "<clinit>",at = @At("TAIL"))
    private static void ViewdistancesFix(CallbackInfo ci){
        MIN_VIEW_DISTANCE = 1;
        MAX_VIEW_DISTANCE = Byte.MAX_VALUE -2;
    }
}
