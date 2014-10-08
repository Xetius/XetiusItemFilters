package com.xetius.itemfilter.init;

import com.xetius.itemfilter.item.ItemFilterItem;
import com.xetius.itemfilter.item.XetiusItem;
import cpw.mods.fml.common.registry.GameRegistry;

public class ModItems {

    public static final XetiusItem itemFilter = new ItemFilterItem();

    public static void init() {
        GameRegistry.registerItem(itemFilter, "itemFilter");
    }
}
