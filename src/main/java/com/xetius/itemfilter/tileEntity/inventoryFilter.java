package com.xetius.itemfilter.tileEntity;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;

public class inventoryFilter extends TileEntity implements IInventory {

    private ItemStack[] inventory;

    public inventoryFilter() {
        this.inventory = new ItemStack[1];
    }

    @Override public int getSizeInventory() {
        return this.inventory.length;
    }

    @Override public ItemStack getStackInSlot(int slotIndex) {
        return inventory[slotIndex];
    }

    @Override public void setInventorySlotContents(int slotIndex, ItemStack stack) {
        inventory[slotIndex] = stack;
        if (stack != null && stack.stackSize > getInventoryStackLimit()) {
            stack.stackSize = getInventoryStackLimit();
        }
    }

    @Override public ItemStack decrStackSize(int slotIndex, int amount) {
        ItemStack stack = getStackInSlot(slotIndex);
        if (stack != null) {
            if (stack.stackSize <= amount) {
                setInventorySlotContents(slotIndex, null);
            } else {
                stack = stack.splitStack(amount);
                if (stack.stackSize == 0) {
                    setInventorySlotContents(slotIndex, null);
                }
            }
        }
        return stack;
    }

    @Override public ItemStack getStackInSlotOnClosing(int slotIndex) {
        ItemStack stack = getStackInSlot(slotIndex);
        if(stack != null){
            setInventorySlotContents(slotIndex, null);
        }
        return stack;
    }

    @Override public int getInventoryStackLimit() {
        return 64;
    }

    @Override public boolean isUseableByPlayer(EntityPlayer player) {
        return worldObj.getTileEntity(xCoord, yCoord, zCoord) == this && player.getDistanceSq(xCoord + 0.5, yCoord + 0.5, zCoord + 0.5) < 64;
    }

    @Override public String getInventoryName() {
        return "InventoryFilter";
    }

    @Override public boolean hasCustomInventoryName() {
        return true;
    }

    @Override public void openInventory() {

    }

    @Override public void closeInventory() {

    }

    @Override public boolean isItemValidForSlot(int slotIndex, ItemStack stack) {
        return true;
    }

    @Override public void readFromNBT(NBTTagCompound tagCompound) {
        super.readFromNBT(tagCompound);
    }
}
