package com.xetius.itemfilter.handler;

import com.xetius.itemfilter.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ItemPickupHandler {
    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        LogHelper.info("Item picked up" + event.toString());
    }
}
