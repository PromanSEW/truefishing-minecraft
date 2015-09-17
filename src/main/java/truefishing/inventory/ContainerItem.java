package truefishing.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class ContainerItem extends Container {
	
	public final Inventory inv;
	
	/** Stores ItemStack that was used to open the container; used for saving to NBT
	* Without this variable, the game will crash when GUI is open and you move the
	* ItemStore whose inventory is currently in use */
	private final ItemStack containerstack;
	
	public boolean needsUpdate;
	
	private static final int INV_START = Inventory.INV_SIZE, INV_END = INV_START+26;
	private static final int HOTBAR_START = INV_END+1, HOTBAR_END = HOTBAR_START+8;
	
	public ContainerItem(EntityPlayer player, InventoryPlayer invPlayer, Inventory item) {
		inv = item;
		containerstack = player.getHeldItem();
		int i;
		// ITEM INVENTORY - you'll need to adjust the slot locations to match your texture file
		// I have them set vertically in columns of 4 to the right of the player model

		for(i=0; i < Inventory.INV_SIZE; ++i) {

			// You can make a custom Slot if you need different behavior,
			// such as only certain item types can be put into this slot
			// We made a custom slot to prevent our inventory-storing item
			// from being stored within itself, but if you want to allow that and
			// you followed my advice at the end of the above step, then you
			// could get away with using the vanilla Slot class

			addSlotToContainer(new SlotItemInv(inv, i, 80 + (18 * (int) (i/4)), 8 + (18 * (i % 4))));
		}

		// PLAYER INVENTORY - uses default locations for standard inventory texture file

		for(i=0; i < 3; ++i) {
			for (int j = 0; j < 9; ++j) {
				addSlotToContainer(new Slot(invPlayer, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
			}
		}

		// PLAYER ACTION BAR - uses default locations for standard action bar texture file

		for(i=0; i < 9; ++i) addSlotToContainer(new Slot(invPlayer, i, 8 + i * 18, 142));
	}
	
	/**
	* Writes contents of inventory to correct itemstack's NBT Tag Compound
	* This is the method we will call from our custom Item's onUpdate method
	*/
	public void writeToNBT() {
		if(!containerstack.hasTagCompound()) containerstack.setTagCompound(new NBTTagCompound());
		inv.writeToNBT(containerstack.getTagCompound());
	}
	
	public boolean canInteractWith(EntityPlayer entityplayer) { return true; }

	/**
	* Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	* Only real change we make to this is to set needsUpdate to true at the end
	*/
	public ItemStack transferStackInSlot(EntityPlayer player, int index) {
		ItemStack stack = null;
		Slot slot = (Slot) inventorySlots.get(index);
		if(slot != null && slot.getHasStack()) {
			ItemStack stack2 = slot.getStack();
			stack = stack2.copy();
			// If item is in our custom Inventory or armor slot
			if(index < INV_START) {
				// try to place in player inventory / action bar
				if(!mergeItemStack(stack2, INV_START, HOTBAR_END + 1, true)) return null;
				slot.onSlotChange(stack2, stack);
			} else {
				
				/* If your inventory only stores certain instances of Items,
				* you can implement shift-clicking to your inventory like this:
				
				// Check that the item is the right type
			
				if(stack2.getItem() instanceof ItemCustom){
				
					// Try to merge into your custom inventory slots
					// We use 'InventoryItem.INV_SIZE' instead of INV_START just in case
					// you also add armor or other custom slots
					
					if(!mergeItemStack(stack2, 0, InventoryItem.INV_SIZE, false)) return null;
				}
			
				* Otherwise, you have basically 2 choices:
				* 1. shift-clicking between action bar and inventory
				* 2. shift-clicking between player inventory and custom inventory
				* I've implemented number 1:
				*/
	
				// item is in player's inventory, but not in action bar
				if(index >= INV_START && index < HOTBAR_START) {
					// place in action bar
					if(!mergeItemStack(stack2, HOTBAR_START, HOTBAR_END + 1, false)) return null;
				} else if(index >= HOTBAR_START && index < HOTBAR_END + 1) {
					// item in action bar - place in player inventory
					if(!mergeItemStack(stack2, INV_START, INV_END + 1, false)) return null;
				}
			}
			if(stack2.stackSize == 0) slot.putStack(null);
			else slot.onSlotChanged();
			if(stack2.stackSize == stack.stackSize) return null;
			slot.onPickupFromSlot(player, stack2);
		}
		needsUpdate = true;
		return stack;
	}
	
	protected boolean mergeItemStack(ItemStack stack, int par2, int par3, boolean par4) {
		boolean flag = false;
		int k = par2;
		if(par4) k = par3 - 1;
		Slot slot;
		ItemStack stack1;
		if(stack.isStackable()) {
			while(stack.stackSize > 0 && (!par4 && k < par3 || par4 && k >= par2)) {
				slot = (Slot) inventorySlots.get(k);
				stack1 = slot.getStack();
				if(stack1 != null && stack1.getItem() == stack.getItem() && 
						(!stack.getHasSubtypes() || stack.getItemDamage() == stack1.getItemDamage()) && 
						ItemStack.areItemStackTagsEqual(stack, stack1)) {
					int l = stack1.stackSize + stack.stackSize;
					if(l <= stack.getMaxStackSize() && l <= slot.getSlotStackLimit()) {
						stack.stackSize = 0;
						stack1.stackSize = l;
						inv.markDirty();
						flag = true;
					} else if(stack1.stackSize < stack.getMaxStackSize() && l < slot.getSlotStackLimit()) {
						stack.stackSize -= stack.getMaxStackSize() - stack1.stackSize;
						stack1.stackSize = stack.getMaxStackSize();
						inv.markDirty();
						flag = true;
					}
				}
				if(par4) --k; else ++k;
			}
		}
		if(stack.stackSize > 0) {
			if(par4) k = par3 - 1; else k = par2;
			while(!par4 && k < par3 || par4 && k >= par2) {
				slot = (Slot) inventorySlots.get(k);
				stack1 = slot.getStack();
				if(stack1 == null) {
					int l = stack.stackSize;
					if(l <= slot.getSlotStackLimit()) {
						slot.putStack(stack.copy());
						stack.stackSize = 0;
						inv.markDirty();
						flag = true;
						break;
					} else {
						putStackInSlot(k, new ItemStack(stack.getItem(), slot.getSlotStackLimit()));
						stack.stackSize -= slot.getSlotStackLimit();
						inv.markDirty();
						flag = true;
					}
				}
				if(par4) --k; else ++k;
			}
		} return flag;
	}
	
	public ItemStack slotClick(int slotID, int buttonPressed, int flag, EntityPlayer player) {
		needsUpdate = true;
		return super.slotClick(slotID, buttonPressed, flag, player);
	}
}
