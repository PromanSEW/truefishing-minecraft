package truefishing.blocks;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import truefishing.items.BaseSeeds;

public class BaseCrop extends BaseBlock {
	
	@SideOnly(Side.CLIENT)
	private IIcon[] icons = new IIcon[2];
	private BaseSeeds seeds;
	
	public BaseCrop(String name) {
		super("crops." + name, Material.plants);
		setBlockName("crops." + name);
		setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F , 1.5F, 1.0F);
		setTickRandomly(true);
	}
	
	public BaseCrop setSeeds(BaseSeeds seeds) { this.seeds = seeds; return this; }
	
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int x, int y, int z) {
		return null;
	}
	
	public int damageDropped(int metadata) { return metadata; }
	
	public int getRenderType() { return 6; }
	
	@SideOnly(Side.CLIENT)
	public IIcon getIcon(int side, int meta) {
		if(meta > 1) meta = 0;
	    return icons[meta];
	}
	
	@SideOnly(Side.CLIENT)
	@SuppressWarnings({"rawtypes", "unchecked"})
	public void getSubBlocks(Item item, CreativeTabs tab, List list) {
		for(int i=0; i < 2; i++) list.add(new ItemStack(item, 1, i));
	}
	
	public boolean isOpaqueCube() { return false; }
	
	public void updateTick(World world, int x, int y, int z, Random random) {
		if(world.getBlockMetadata(x, y, z) == 1) return;
		if(world.getBlockLightValue(x, y + 1, z) < 9) return;
		if(random.nextInt(isFertile(world, x, y - 1, z) ? 12 : 25) != 0) return;
		world.setBlock(x, y, z, this, 1, 2);
	}
	
	public void onNeighborBlockChange(World world, int x, int y, int z, Block block) {
		if(!canBlockStay(world, x, y, z)) {
			dropBlockAsItem(world, x, y, z, world.getBlockMetadata(x, y, z), 0);
			world.setBlockMetadataWithNotify(x, y, z, 1, 0);
		}
	}
	
	public boolean canBlockStay(World world, int x, int y, int z) {
		Block soil = world.getBlock(x, y - 1, z);
		return (world.getFullBlockLightValue(x, y, z) >= 8 || world.canBlockSeeTheSky(x, y, z)) &&
				(soil != null && soil.canSustainPlant(world, x, y - 1, z, ForgeDirection.UP, seeds));
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
	
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister reg) {
		for(int i=0; i < 2; i++) icons[i] = reg.registerIcon(textureName + "_" + i);
	}
}
