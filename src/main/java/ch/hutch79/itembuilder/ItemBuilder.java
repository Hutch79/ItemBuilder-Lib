package ch.hutch79.itembuilder;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemBuilder {

    private Material material;
    private String name;
    private Boolean unbreakable = false;
    private int count = 1;


    /**
     * Creates a new Item.
     * @param material Material which should be used to create the item
     */
    ItemBuilder(Material material) {

        this.material = Objects.requireNonNull(material);
    }

    /**
     * Set the Material for the current item.
     * @param material Material which should be used to create the item
     */
    public void setMaterial(Material material) {
        this.material = Objects.requireNonNull(material);
    }

    /**
     * Set the display name for the current item
     * @param name The Item displayname to be set on creation
     */
    public void setDisplayName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Set the Item to Unbreakable or not.
     * @param unbreakable True: Unbreakable - False: Not Unbreakable
     */
    public void setUnbreakable(Boolean unbreakable) {
        this.unbreakable = Objects.requireNonNull(unbreakable);
    }

    /**
     * Set the size of the ItemStack
     * @param count The count of Items in this ItemStack
     */
    public void setAmount(int count) {
        this.count = count;

        if (count < 1) {
            this.count = 1;
        } else if (count > 64) {
            this.count = 64;
        }
    }


    /**
     * Create the Item, based on previous configurations, and return it.
     * @return Created Item
     * */
    public ItemStack getItem() {
        ItemStack itemStack = new ItemStack(this.material);
        if (this.material != Material.valueOf("PLAYER_HEAD")) {
            ItemMeta itemMeta = itemStack.getItemMeta();

            if (this.name != null) {
                itemMeta.setDisplayName(this.name);
            }

            itemMeta.setUnbreakable(this.unbreakable);
            itemStack.setAmount(this.count);



            itemStack.setItemMeta(itemMeta);
        }


        return itemStack;
    }

}
