package com.xetius.itemfilter.handler;

import com.xetius.itemfilter.utility.LogHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.EntityItemPickupEvent;

public class ItemPickupHandler {
    @SubscribeEvent
    public void onItemPickup(EntityItemPickupEvent event) {
        ItemStack itemStack = event.item.getEntityItem();

        LogHelper.info("Item picked up" + itemStack + " (" + itemStack.getItem() + ")");

        if (itemStack.getItem().equals(Items.wheat_seeds)) {
            event.setCanceled(true);
            LogHelper.info("Not picking up seeds");
        }
    }
}
