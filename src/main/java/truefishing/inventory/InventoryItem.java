package truefishing.inventory;

import java.util.UUID;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import truefishing.items.ItemStore;

public class InventoryItem implements IInventory {
	
	public static final int INV_SIZE = 5;
	private ItemStack[] inv = new ItemStack[INV_SIZE];
	protected String uniqueID;
	
	public InventoryItem(ItemStack stack) {
		uniqueID = "";
		if (!stack.hasTagCompound()) {
			stack.setTagCompound(new NBTTagCompound());
			uniqueID = UUID.randomUUID().toString();
		}
		readFromNBT(stack.getTagCompound());
	}
	
	public int getSizeInventory() { return INV_SIZE; }
	
	public ItemStack getStackInSlot(int slot) { return inv[slot]; }
	
	public ItemStack decrStackSize(int slot, int amount) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null) {
			if(stack.stackSize > amount) {
				stack = stack.splitStack(amount);
				if(stack.stackSize == 0) setInventorySlotContents(slot, null);
			} else setInventorySlotContents(slot, null);
			markDirty();
		} return stack;
	}
	
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack stack = getStackInSlot(slot);
		if(stack != null) setInventorySlotContents(slot, null);
		return stack;
	}
	
	public void setInventorySlotContents(int slot, ItemStack stack) {
		inv[slot] = stack;
		if(stack != null && stack.stackSize > getInventoryStackLimit()) 
			stack.stackSize = this.getInventoryStackLimit();
		markDirty();
	}
	
	public String getInventoryName() { return ""; }
	
	public boolean hasCustomInventoryName() { return false; }
	
	public int getInventoryStackLimit() { return 1; }
	
	public void markDirty() {
		for(int i=0; i < getSizeInventory(); ++i) {
			if(getStackInSlot(i) != null && getStackInSlot(i).stackSize == 0) 
				setInventorySlotContents(i, null);
		}
	}
	
	public boolean isUseableByPlayer(EntityPlayer player) { return true; }
	
	public void openInventory() {}
	
	public void closeInventory() {}
	
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		return !(stack.getItem() instanceof ItemStore);
	}
		
	public void readFromNBT(NBTTagCompound compound) {
		if(uniqueID.equals("")) {
			uniqueID = compound.getString("uniqueID");
			if(uniqueID.equals("")) uniqueID = UUID.randomUUID().toString();
		}
		NBTTagList items = compound.getTagList("ItemInventory", compound.getId());
		for(int i=0; i < items.tagCount(); ++i) {
			NBTTagCompound item = items.getCompoundTagAt(i);
			byte slot = item.getByte("Slot");
			if(slot >= 0 && slot < getSizeInventory()) 
				setInventorySlotContents(slot, ItemStack.loadItemStackFromNBT(item));
		}
	}
	
	public void writeToNBT(NBTTagCompound compound) {
		NBTTagList list = new NBTTagList();
		for(int i=0; i < getSizeInventory(); ++i) {
			if (getStackInSlot(i) != null) {
				NBTTagCompound compound1 = new NBTTagCompound();
				compound1.setInteger("Slot", i);
				// Writes the itemstack in slot(i) to the Tag Compound we just made
				getStackInSlot(i).writeToNBT(compound1);
				// add the tag compound to our tag list
				list.appendTag(compound1);
			}
		}
		compound.setString("uniqueID", uniqueID);
		compound.setTag("ItemInventory", list);
	}
}
