package com.jackiecrazi.noarcher;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = NoArcher.MODID, version = NoArcher.VERSION)
public class NoArcher {
    public static final String MODID = "noarcher";
    public static final String VERSION = "1.0.0";
    @Mod.Instance(NoArcher.MODID)
    public static NoArcher INST = new NoArcher();
    @EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(ArcherEventHandler.class);
    }

}
