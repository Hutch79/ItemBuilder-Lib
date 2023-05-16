package ch.hutch79.itembuilder;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;

public class ItemBuilder {

    private Material material;
    private String name;
    private Boolean unbreakable;


    /**
     * Creates a new Item.
     * @param material Item Material
     */
    ItemBuilder(Material material) {
        this.material = material;
    }

    /**
     * Set the Material for the current item.
     * @param material Item Material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * Set the display name for the current item
     * @param name Item Display-name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Set the Item to Unbreakable or not.
     * @param unbreakable True: Set Unbreakable - False: Not Unbreakable
     */
    public void setUnbreakable(Boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    /**
     * Create the Item based on previous configurations and return it.
     * @return Created Item
     * */
    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(this.material);
        if (this.material != Material.valueOf("PLAYER_HEAD")) {
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (this.name != null) {
                itemMeta.setDisplayName(this.name);
            }

            if (this.unbreakable != null) {
                itemMeta.setUnbreakable(this.unbreakable);
            }


            itemStack.setItemMeta(itemMeta);
        }


        return itemStack;
    }

}
