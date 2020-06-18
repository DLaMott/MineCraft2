package me.dylan.helloBitch.util;

import me.dylan.helloBitch.HelloWorld;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;


public class CustomRecipe {
    public HelloWorld plugin;

    public CustomRecipe(HelloWorld plugin) {
        this.plugin = plugin;
    }

    @SuppressWarnings("Deprciation")
    public ShapedRecipe getRecipe() {

        ItemStack item = new ItemStack(Material.NETHER_STAR);
        NamespacedKey key = new NamespacedKey(plugin, "silly_starrr");
        ShapedRecipe recipe = new ShapedRecipe(key, item);
        recipe.shape(" T ", "TET", " T ");
        recipe.setIngredient('T', Material.GHAST_TEAR);
        recipe.setIngredient('E', Material.EMERALD_BLOCK);

        return recipe;
    }
}
