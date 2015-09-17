package truefishing.inventory;

import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import truefishing.items.InventoryItem;

public class InvItemSlot extends Slot {

	public InvItemSlot(IInventory inv, int index, int x, int y) {
		super(inv, index, x, y);
	}
	
	public boolean isItemValid(ItemStack stack) {
		return !(stack.getItem() instanceof InventoryItem);
	}
}
