package pablo.suarez.shopinglist.data.relationentities;

import androidx.room.Embedded;
import androidx.room.Junction;
import androidx.room.Relation;

import java.util.List;

import pablo.suarez.shopinglist.data.entities.Item;
import pablo.suarez.shopinglist.data.entities.ShoppingList;
import pablo.suarez.shopinglist.data.entities.ShoppingListItem;

public class ShoppingListWithItems {
    @Embedded
    public ShoppingList shoppingList;

    @Relation(
            parentColumn = "shopping_list_id",
            entityColumn = "item_id",
            associateBy = @Junction(ShoppingListItem.class)
    )
    public List<Item> items;
}
