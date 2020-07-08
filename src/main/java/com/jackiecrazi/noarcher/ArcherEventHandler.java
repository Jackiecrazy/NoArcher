package com.jackiecrazi.noarcher;

import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.living.LivingKnockBackEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ArcherEventHandler {
    private static boolean nerf;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public static void spite(LivingHurtEvent e) {
        nerf=false;
        if (e.getSource().isProjectile()) {
            DamageSource ds = e.getSource();
            if (ds.getImmediateSource() == null) return;
            EntityEntry a = (EntityRegistry.getEntry(ds.getImmediateSource().getClass()));
            if (a == null || a.getRegistryName() == null) return;
            for (String s : GeneralConfig.ignoredNames)
                if (a.getRegistryName().toString().contains(s)) return;
            if (ds.getTrueSource() != null) {
                EntityEntry b = (EntityRegistry.getEntry(ds.getTrueSource().getClass()));
                if (b != null && b.getRegistryName() != null)
                    for (String s : GeneralConfig.shooterIgnoredNames)
                        if (b.getRegistryName().toString().contains(s))
                            return;
            }
            e.setAmount((float) (e.getAmount() * GeneralConfig.damMult));
            nerf=true;
        }
    }

    @SubscribeEvent(priority = EventPriority.HIGHEST)
    public static void knock(LivingKnockBackEvent e) {
        if (GeneralConfig.knockback) return;
        if (nerf) {
            e.setCanceled(true);
        }
    }
}
