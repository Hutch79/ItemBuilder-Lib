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
     * @param material Item Material
     */
    ItemBuilder(Material material) {
        this.material = material;
    }

    /**
     * @param material Item Material
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    /**
     * @param name Item Displayname
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param unbreakable True: Set Unbreakable - False: Not Unbreakable
     */
    public void setUnbreakable(Boolean unbreakable) {
        this.unbreakable = unbreakable;
    }

    /**
     * @return Complete Item based on previous configuration
     */
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
