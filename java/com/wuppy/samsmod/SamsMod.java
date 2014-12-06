
package com.wuppy.samsmod;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.util.WeightedRandomChestContent;
import net.minecraftforge.common.ChestGenHooks;
import net.minecraftforge.common.DungeonHooks;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.ShapedOreRecipe;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemArmor.ArmorMaterial;



@Mod(modid = SamsMod.MODID, version = SamsMod.VERSION)
public class SamsMod
{
    public static final String MODID = "samsmod";
    public static final String VERSION = "1.0";
    
    
    //items
    public static Item berry;
    public static Item housesmall;
    public static Item blazenew;
    public static Item breadnew;
    public static Item key;
    public static Item samdust;
    public static Item samingot;
    
    //blocks
    public static Block samstone;
    
    
    
    //tools
    public static Item sampickaxe;
    public static Item samaxe;
    //public static Item samhoe;
    public static Item samshovel;
    public static Item samsword;
    public static Item samhoe;
    public static Item sampaxel;
    public static Item samspax;
    
    //armor
    public static Item samhelmet;
    public static Item samchest;
    public static Item samleggings;
    public static Item samboots;
    
    //plants
    public static Block samPlant;
    public static Item samseed;
    
    //tile entity
    public static Block samTE;
    
    SamEventHandler handler =  new SamEventHandler();
    
    
    
    
    
    
    //materials
    ToolMaterial samium = EnumHelper.addToolMaterial("samium", 3, 1000,9.5F, 3.5F, 10);
    
    ArmorMaterial samarmor = EnumHelper.addArmorMaterial("samarmor", 20, new int[] {3, 7, 6, 3}, 10);
    
    @EventHandler
    public void preInit(FMLInitializationEvent event)
    {
    	
    	//item init
    	key = new ItemKey("key");
    	housesmall = new ItemSamGeneric("housesmall");
    	blazenew = new ItemSamGeneric("blazenew");
    	breadnew = new ItemSamGeneric("breadnew");
    	samdust = new ItemSamGeneric("samdust");
    	samingot = new ItemSamGeneric("samingot");
    	berry = new ItemBerry(3, 0.3F, true, "berry");
    	
    	//tool init
    	sampickaxe = new ItemSamPickaxe(samium, "sampickaxe");
    	samaxe = new ItemSamAxe(samium, "samaxe");
        //samhoe = new ItemSamHoe(samium, "samhoe");
        samshovel = new ItemSamShovel(samium, "samshovel");
        samsword = new ItemSamSword(samium, "samsword");
    	samhoe = new ItemSamHoe(samium, "samhoe");
    	sampaxel = new ItemSamPaxel(samium, "SamPaxel");
    	samspax = new ItemSamSpax(samium, "SamSpax");
    	
    	//armor
    	samhelmet = new ItemSamArmor(samarmor, 0, "samhelmet");
    	samchest = new ItemSamArmor(samarmor, 1, "samchestplate");
    	samleggings = new ItemSamArmor(samarmor, 2, "samleggings");
    	samboots = new ItemSamArmor(samarmor, 3, "samboots");
    	
    	//blocks
    	samstone = new BlockSamStone();
    	
    	//plants
    	samPlant = new BlockSamPlant();
    	samseed = new ItemSamSeed(samPlant);
    	
    	//tile entity
    	samTE = new BlockSamTE();
    	GameRegistry.registerBlock(samTE, "SamTE");
    	GameRegistry.registerTileEntity(TileEntitySam.class, "TE_samTE");
    	
    	GameRegistry.registerWorldGenerator(handler, 0);
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	//tool registry
    	GameRegistry.registerItem(sampickaxe, "SamPickaxe");
    	GameRegistry.registerItem(samdust, "SamDust");
    	GameRegistry.registerItem(samingot,  "SamIngot");
    	GameRegistry.registerItem(breadnew, "BreadNew");
    	GameRegistry.registerItem(blazenew, "BlazeNew");
    	GameRegistry.registerItem(housesmall, "House");
    	GameRegistry.registerItem(berry,"Berry");
    	GameRegistry.registerItem(key, "key");
    	GameRegistry.registerItem(samaxe, "SamsAxe");
        //GameRegistry.registerItem(samhoe, "SamsHoe");
        GameRegistry.registerItem(samshovel, "SamsShovel");
        GameRegistry.registerItem(samsword, "SamsSword");
    	GameRegistry.registerItem(samhoe,  "SamHoe");
    	GameRegistry.registerItem(sampaxel, "SamPaxel");
    	GameRegistry.registerItem(samspax, "SamSpax");
    	GameRegistry.registerItem(samhelmet, "SamsHelmet");
    	GameRegistry.registerItem(samchest, "SamsChestPlate");
    	GameRegistry.registerItem(samleggings, "SamsLeggings");
    	GameRegistry.registerItem(samboots, "SamsBoots");
    	GameRegistry.registerBlock(samstone, ItemSamStone.class, "SamStone");
    	GameRegistry.registerBlock(samPlant, "SamPlant");
    	GameRegistry.registerItem(samseed, "SamSeed");
    	
        GameRegistry.addSmelting(samdust, new ItemStack(samingot),0.3F);
        
        OreDictionary.registerOre("ingotSam", new ItemStack(samingot));
        	
        GameRegistry.addRecipe(new ItemStack(SamsMod.sampickaxe),
    	    	"XXX",
    	    	" Y ",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
        GameRegistry.addRecipe(new ItemStack(SamsMod.samaxe),
    	    	"XX ",
    	    	"XY ",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        GameRegistry.addRecipe(new ItemStack(SamsMod.samhoe),
    	    	"XX ",
    	    	" Y ",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
        GameRegistry.addRecipe(new ItemStack(SamsMod.samshovel),
    	    	" X ",
    	    	" Y ",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
        GameRegistry.addRecipe(new ItemStack(SamsMod.samsword),
    	    	" X ",
    	    	" X ",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
        GameRegistry.addRecipe(new ItemStack(SamsMod.sampaxel),
    	    	"XXX",
    	    	"XYX",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
        GameRegistry.addRecipe(new ItemStack(SamsMod.samspax),
    	    	"XX ",
    	    	"XYX",
    	    	" Y ",
    	    	'X', SamsMod.samingot, 'Y', Items.stick
    	        );
        
    }
    
    @EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		//Recipes
	    GameRegistry.addRecipe(new ItemStack(Items.apple),
	    	"XXX",
	    	"XXX",
	    	"XXX",
	    	'X', Blocks.leaves
	    	);
	    GameRegistry.addRecipe(new ItemStack(Items.arrow), 
	        	"YZ",
	        	"X ",
	        	'X', Items.flint, 'Y', Items.stick, 'Z', Blocks.leaves
	        );
	    GameRegistry.addRecipe(new ItemStack(Items.dye, 2, 1), 
	        	"XY",
	        	'X', Items.redstone, 'Y', new ItemStack(Items.dye, 1, 1)
	        );
	    
	    GameRegistry.addShapelessRecipe(new ItemStack(Blocks.grass),
	            Blocks.dirt, Blocks.vine
	    		);
	    
	    
       
        
      
        
	   
	    
	  //Enchanted Recipes
	    ItemStack enchantedSwordItemStack = new ItemStack(Items.stone_sword );
	    enchantedSwordItemStack.addEnchantment(Enchantment.sharpness, 30
	    	);
	    
	    GameRegistry.addShapelessRecipe(enchantedSwordItemStack, 
	        	Items.flint, Items.stone_sword
	    );
	    ItemStack knockbackItemStack = new ItemStack(Items.diamond_sword);
	    knockbackItemStack.addEnchantment(Enchantment.knockback, 15
	    	);
	    
	    GameRegistry.addShapelessRecipe(knockbackItemStack, 
	        	Items.gunpowder, Items.diamond_sword
	    );
	    
	    GameRegistry.addSmelting(Blocks.gravel, new ItemStack(Items.flint), 0.3F);
	
	    
	    
	
	    
	    DungeonHooks.addDungeonMob("Pig", 200);
	    
	    
	    	
		// some example code
	    //System.out.println("DIRT BLOCK >> "+Blocks.dirt.getUnlocalizedName());
	}
}
