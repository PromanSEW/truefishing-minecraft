package truefishing.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import truefishing.items.ItemStore;

public class SlotItemInv extends Slot {

	public SlotItemInv(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}
	
	public boolean isItemValid(ItemStack stack) {
		return !(stack.getItem() instanceof ItemStore);
	}
}
