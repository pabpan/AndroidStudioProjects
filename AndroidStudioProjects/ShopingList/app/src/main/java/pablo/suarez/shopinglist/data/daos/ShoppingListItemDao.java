package pablo.suarez.shopinglist.data.daos;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import java.util.List;

import pablo.suarez.shopinglist.data.entities.ShoppingListItem;

@Dao
public abstract class ShoppingListItemDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public abstract void insertAll(List<ShoppingListItem> shoppingListItems);
}
