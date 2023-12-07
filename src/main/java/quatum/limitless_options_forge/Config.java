package quatum.limitless_options_forge;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = LimitlessOptions_Forge.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

     private static final ForgeConfigSpec.BooleanValue Troll = BUILDER
            .comment("Enable oanly linux version")
            .define("onalyLinux",false);
    static final ForgeConfigSpec SPEC = BUILDER.build();

    static boolean troll = false;
    @SubscribeEvent(priority = EventPriority.NORMAL)
    public static void configload(ModConfigEvent.Loading event){
        troll = Troll.get();
    }
}