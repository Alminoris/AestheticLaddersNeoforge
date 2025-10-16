package net.alminoris.aestheticladders.datagen;

import net.alminoris.aestheticladders.block.ModBlocks;
import net.alminoris.aestheticladders.item.ModItems;
import net.alminoris.aestheticladders.util.helper.BlockSetsHelper;
import net.alminoris.aestheticladders.util.helper.ModJsonHelper;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder
{
    public ModRecipeProvider(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> pRegistries)
    {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput)
    {
        for(String name : BlockSetsHelper.WOODS)
        {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModItems.WOODEN_STICKS.get(name).get(), 4)
                    .define('#', BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name+"_planks")))
                    .pattern("# ")
                    .pattern(" #")
                    .unlockedBy(getHasName(BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name+"_planks"))),
                            has(BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name+"_planks"))))
                    .save(recipeOutput);

            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WOODEN_LADDERS.get(name).get(), 3)
                    .define('#', ModItems.WOODEN_STICKS.get(name).get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("# #")
                    .unlockedBy(getHasName(ModItems.WOODEN_STICKS.get(name).get()), has(ModItems.WOODEN_STICKS.get(name).get()))
                    .save(recipeOutput);
        }

        for(String name : BlockSetsHelper.EXTRA_WOODS_AN)
        {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WOODEN_LADDERS.get(name).get(), 3)
                    .define('#', ModItems.WOODEN_STICKS.get(name).get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("# #")
                    .unlockedBy(getHasName(ModItems.WOODEN_STICKS.get(name).get()), has(ModItems.WOODEN_STICKS.get(name).get()))
                    .save(recipeOutput);
        }

        for(String name : BlockSetsHelper.EXTRA_WOODS_WF)
        {
            ShapedRecipeBuilder.shaped(RecipeCategory.DECORATIONS, ModBlocks.WOODEN_LADDERS.get(name).get(), 3)
                    .define('#', ModItems.WOODEN_STICKS.get(name).get())
                    .pattern("# #")
                    .pattern("###")
                    .pattern("# #")
                    .unlockedBy(getHasName(ModItems.WOODEN_STICKS.get(name).get()), has(ModItems.WOODEN_STICKS.get(name).get()))
                    .save(recipeOutput);
        }

        for(String name : BlockSetsHelper.STONES)
        {
            Block block = BuiltInRegistries.BLOCK.get(ResourceLocation.withDefaultNamespace(name.equals("basalt_side") ? "basalt" :
                    (name.equals("quartz_block_bottom") ? "quartz_block" : name)));

            stonecutterResultFromBase(recipeOutput, RecipeCategory.BUILDING_BLOCKS, ModBlocks.STONE_LADDERS.get(name).get(), block, 1);
        }

        for(String name : BlockSetsHelper.EXTRA_STONES_WF)
        {
            ModJsonHelper.createStonecuttingRecipe("wildfields:"+name,
                    BuiltInRegistries.BLOCK.getKey(ModBlocks.STONE_LADDERS.get(name).get()).getPath(), "1");
        }
    }
}