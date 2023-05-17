package ch.hutch79.itembuilder;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class ItemBuilder {

    private Material material;
    private String name;
    private Boolean unbreakable = false;
    private int count = 1;
    private Boolean enchanted = false;
    private Enchantment enchantedValue;
    private int enchantedLevel;


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

    public void setEnchantement(String enchantement, int level) {
        this.enchanted = true;
        this.enchantedValue = Enchantment.getByName(Objects.requireNonNull(enchantement));
        this.enchantedLevel = Objects.requireNonNull(level);
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

            if (this.enchanted) {
                itemMeta.addEnchant(this.enchantedValue, this.enchantedLevel, true);
                itemMeta.addItemFlags(ItemFlag.valueOf("HIDE_ENCHANTS"));
            }



            itemStack.setItemMeta(itemMeta);
        }


        return itemStack;
    }

}
