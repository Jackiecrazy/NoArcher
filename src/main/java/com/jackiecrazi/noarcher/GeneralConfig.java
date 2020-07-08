package com.jackiecrazi.noarcher;

import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = NoArcher.MODID)
@Config.LangKey("armorcurve.general")
public class GeneralConfig {
   @Config.Comment("Enables knockback from projectile attacks")
    public static boolean knockback=false;
    @Config.Comment("Multiplier for ranged damage")
    public static double damMult=0.5;
    @Config.Comment("Parts of entity names to ignore. For instance, putting minecraft here will make it ignore all vanilla projectiles")
    public static String[] ignoredNames={"example","modid:otherexample","taoism"};
    @Config.Comment("Parts of entity names to ignore. For instance, putting minecraft here will make it ignore all vanilla mobs")
    public static String[] shooterIgnoredNames={"example","modid:otherexample","taoism"};

    @Mod.EventBusSubscriber(modid = NoArcher.MODID)
    private static class EventHandler {

        /**
         * Inject the new values and save to the config file when the config has been changed from the GUI.
         *
         * @param event The event
         */
        @SubscribeEvent
        public static void onConfigChanged(final ConfigChangedEvent.OnConfigChangedEvent event) {
            if (event.getModID().equals(NoArcher.MODID)) {
                ConfigManager.sync(NoArcher.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
