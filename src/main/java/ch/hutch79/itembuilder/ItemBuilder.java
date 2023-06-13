package ch.hutch79.itembuilder;

import jdk.internal.org.objectweb.asm.tree.IntInsnNode;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ItemBuilder {

    private Material material;
    private String name;
    private Boolean unbreakable = false;
    private int count = 1;
    private HashMap<Enchantment, Integer> enchantments;


    /**
     * Creates a new Item.
     * @param material Material which should be used to create the item
     */
    ItemBuilder(Material material) {
        this.material = Objects.requireNonNull(material);
    }

    /**
     * Sets the Material for the current item.
     * @param material Material which should be used to create the item
     */
    public void setMaterial(Material material) {
        this.material = Objects.requireNonNull(material);
    }

    /**
     * Sets the display name for the current item
     * @param name The Item displayname to be set on creation
     */
    public void setDisplayName(String name) {
        this.name = Objects.requireNonNull(name);
    }

    /**
     * Sets the Item to Unbreakable or not.
     * @param unbreakable True: Unbreakable - False: Not Unbreakable
     */
    public void setUnbreakable(Boolean unbreakable) {
        this.unbreakable = Objects.requireNonNull(unbreakable);
    }

    /**
     * Sets the size of the ItemStack
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
     * Add as many enchantments as you want to an Item.
     * @param enchantement Enchantment Name
     * @param level Enchantment Level
     */
    public void addEnchantement(String enchantement, int level) {
        enchantments.put(Enchantment.getByName(enchantement), level);
    }

    /**
     * Creates the Item, based on this configurations
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

            if (!this.enchantments.isEmpty()) {
                for (Map.Entry<Enchantment, Integer> set: this.enchantments.entrySet()) {
                    itemMeta.addEnchant(set.getKey(), set.getValue(), true);
                }
            }



            itemStack.setItemMeta(itemMeta);
        }


        return itemStack;
    }

}
