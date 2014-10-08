package com.xetius.itemfilter.item;

import com.xetius.itemfilter.reference.Reference;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public abstract class XetiusItem extends Item {
    protected XetiusItem() {
        super();
        this.setMaxStackSize(1);
    }

    @Override
    public String getUnlocalizedName() {
        return String.format("item.%s%s", Reference.MOD_PREFIX, getUnwrappedUnlocalisedName(super.getUnlocalizedName()));
    }

    @Override
    public String getUnlocalizedName(ItemStack p_77657_1_) {
        return String.format("item.%s%s", Reference.MOD_PREFIX, getUnwrappedUnlocalisedName(super.getUnlocalizedName()));
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister iconRegister) {
        itemIcon = iconRegister.registerIcon(getUnwrappedUnlocalisedName(this.getUnlocalizedName()));
    }

    protected String getUnwrappedUnlocalisedName(String unlocalizedName) {
        return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
    }
}
