package net.asterite.item;

import net.asterite.Faculty;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItemRegistry {

    public static final Item ENVISIONER = register(
            new Item(new Item.Settings().maxCount(1)),
            "envisioner"
    );


    public static Item register(Item item, String id) {
        // Create the identifier for the item.
        Identifier itemID = Identifier.of(Faculty.MOD_ID, id);

        // Register the item.
        Item registeredItem = Registry.register(Registries.ITEM, itemID, item);

        // Return the registered item!
        return registeredItem;
    }

    public static void initialize() {
    }

}
