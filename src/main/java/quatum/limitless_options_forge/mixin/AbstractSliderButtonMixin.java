package quatum.limitless_options_forge.mixin;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.components.AbstractSliderButton;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Async;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import quatum.limitless_options_forge.Config;

@Mixin(AbstractSliderButton.class)
public class AbstractSliderButtonMixin{
    int x=0;
    int width =0;
    @ModifyArg(method = "renderWidget",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V",ordinal = 0),index = 1)
    public int setX(int p_281513_){
            x=p_281513_;
            return p_281513_;
    }
    @ModifyArg(method = "renderWidget",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V",ordinal = 0),index = 3)
    public int setWidth(int p_281513_){
        width=p_281513_;
        return p_281513_;
    }

@ModifyArg(method = "renderWidget",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/gui/GuiGraphics;blitSprite(Lnet/minecraft/resources/ResourceLocation;IIII)V",ordinal = 1),index = 1)
    public int fixOutOfRange(int p_281513_){
    if (Config.sliderFix == true)
        return Mth.clamp(p_281513_,x, x+width-8);
    else
        return p_281513_;
    }

}
