package truefishing.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.BlockCrops;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.EnumPlantType;
import truefishing.TrueFishing;
import truefishing.items.BaseSeeds;

public class BaseCrop extends BlockCrops {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons = new IIcon[2];
	private BaseSeeds seeds;
	
	public BaseCrop(String name) {
		super();
		setBlockName("crops." + name);
		setCreativeTab(TrueFishing.creativeTab);
	}
	
	public BaseCrop setSeeds(BaseSeeds seeds) { this.seeds = seeds; return this; }
	
	public int damageDropped(int metadata) { return metadata; }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) { if (meta > 1) meta = 0; return icons[meta]; }
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for (int i=0; i < 2; i++) list.add(new ItemStack(item, 1, i));
	}
	
	@SideOnly(Side.CLIENT)
    public Item getItem(World world, int x, int y, int z) { return seeds; }
	
	public void updateTick(World world, int x, int y, int z, Random random) {
		if (world.getBlockMetadata(x, y, z) == 1) return;
		if (world.getBlockLightValue(x, y + 1, z) < 9) return;
		if (random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) return;
		world.setBlock(x, y, z, this, 1, 2);
	}
	
	public Item getItemDropped(int metadata, Random rand, int par3) { return seeds; }
	
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z, EntityPlayer player) {
        return new ItemStack(seeds);
	}
	
	public ArrayList<ItemStack> getDrops(World world, int x, int y, int z, int metadata, int fortune) {
		ArrayList<ItemStack> items = new ArrayList<ItemStack>();
		items.add(new ItemStack(seeds));
		return items;
	}
	
	public EnumPlantType getPlantType(IBlockAccess world, int x, int y, int z) { return EnumPlantType.Crop; }
	
	public void func_149863_m(World world, int x, int y, int z) { world.setBlockMetadataWithNotify(x, y, z, 1, 2); }
	
	public boolean func_149851_a(World world, int x, int y, int z, boolean p_149851_5_) {
		return world.getBlockMetadata(x, y, z) != 1;
	}
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		for (int i=0; i < 2; i++) icons[i] = reg.registerIcon(textureName + "_" + i);
	}
}
