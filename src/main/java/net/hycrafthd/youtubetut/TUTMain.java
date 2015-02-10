package net.hycrafthd.youtubetut;

import net.hycrafthd.youtubetut.block.TUTBlock;
import net.hycrafthd.youtubetut.item.TUTItem;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

@Mod(modid = TUTMain.MODID, version = TUTMain.VERSION)
public class TUTMain
{
    public static final String MODID = "tutyoutube";
    public static final String VERSION = "1.0";
    
    public static Item tutitem;
    
    public static Block tutblock;
    
    public static CreativeTabs tuttab;
    
    @EventHandler
    public void preinit(FMLPreInitializationEvent event)
    {
    	
    	tuttab = new CreativeTabs("tuttab") {
			@Override
			public Item getTabIconItem() {
				return Item.getItemFromBlock(Blocks.diamond_ore);
			}
		};
    	
    	tutitem = new TUTItem().setUnlocalizedName("tutitem").setCreativeTab(tuttab);
    	
    	tutblock = new TUTBlock().setUnlocalizedName("tutblock").setCreativeTab(tuttab);
    	
    }
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	
    	crafting();
    	registerItems();
    	registerBlocks();
    	
    }
    
    @EventHandler
    public void postinit(FMLPostInitializationEvent event)
    {
    	
    }
    
    //Craftingrezepte
    private void crafting() {
    	
    	GameRegistry.addRecipe(new ItemStack(Blocks.diamond_block, 64), new Object[]{
    		"ggg",
    		"gbg",
    		"ggg",
    		Character.valueOf('g'), Blocks.gold_block,
    		Character.valueOf('b'), Items.diamond
    	});
    	
    	GameRegistry.addShapelessRecipe(new ItemStack(Items.diamond, 2), new ItemStack(Blocks.dirt), new ItemStack(Items.compass));
    	
    }
    
    //RegisterItem
    private void registerItems() {
    	
    	GameRegistry.registerItem(tutitem, "tutitem");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(tutitem, 0, new ModelResourceLocation(MODID + ":tutitem", "inventory"));
    	
    }
    
    //RegisterBlock
    private void registerBlocks() {
    	
    	GameRegistry.registerBlock(tutblock, "tutblock");
    	Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(tutblock), 0, new ModelResourceLocation(MODID + ":tutblock", "inventory"));
    	
    }
}
