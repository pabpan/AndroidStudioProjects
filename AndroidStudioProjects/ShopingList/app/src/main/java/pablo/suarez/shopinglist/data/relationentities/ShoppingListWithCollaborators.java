package pablo.suarez.shopinglist.data.relationentities;

import androidx.room.Embedded;
import androidx.room.Relation;

import java.util.List;

import pablo.suarez.shopinglist.data.entities.Collaborator;
import pablo.suarez.shopinglist.data.entities.Info;
import pablo.suarez.shopinglist.data.partialentities.ShoppingListForList;

public class ShoppingListWithCollaborators {
    @Embedded
    public ShoppingListForList shoppingList;

    @Relation(
            entity = Collaborator.class,
            parentColumn = "shopping_list_id",
            entityColumn = "shopping_list_id",
            projection = {"name"}
    )

    public List<String> collaboratorNames;

    @Relation(
            entity = Info.class,
            parentColumn = "shopping_list_id",
            entityColumn = "shopping_list_id",
            projection = {"created_date"}
    )
    public String createdDate;
}
