package pablo.suarez.shopinglist.data.daos;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import pablo.suarez.shopinglist.data.entities.Collaborator;
import pablo.suarez.shopinglist.data.entities.Info;
import pablo.suarez.shopinglist.data.entities.ShoppingList;
import pablo.suarez.shopinglist.data.partialentities.ShoppingListId;
import pablo.suarez.shopinglist.data.partialentities.ShoppingListInsert;
import pablo.suarez.shopinglist.data.relationentities.ShoppingListWithCollaborators;
import pablo.suarez.shopinglist.data.relationentities.ShoppingListWithItems;

@Dao
public abstract class ShoppingListDao {
    @Transaction
    @Query("SELECT shopping_list_id, name, is_favorite FROM shopping_list")
    public abstract LiveData<List<ShoppingListWithCollaborators>> getAll();

    @Transaction
    @Query("SELECT * FROM shopping_list WHERE shopping_list_id = :id")
    public abstract LiveData<ShoppingListWithItems> shoppingListWithItems(String id);

    @Transaction
    @Query("SELECT shopping_list_id, name, is_favorite FROM shopping_list WHERE category IN(:categories)")
    public abstract LiveData<List<ShoppingListWithCollaborators>> getShoppingListsByCategories(List<String> categories);

    @Transaction
    public void insertWithInfoAndCollaborators(ShoppingListInsert shoppingList,
                                               Info info, List<Collaborator> collaborators) {
        insertShoppingList(shoppingList);
        insertInfo(info);
        insertAllCollaborators(collaborators);
    }

    @Transaction
    public void insertAllWithInfosAndCollaborators(List<ShoppingListInsert> shoppingLists,
                                                   List<Info> infos,
                                                   List<Collaborator> collaborators) {
        insertAll(shoppingLists);
        insertAllInfos(infos);
        insertAllCollaborators(collaborators);
    }

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    protected abstract void insertAllCollaborators(List<Collaborator> collaborators);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertShoppingList(ShoppingList shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertShoppingList(ShoppingListInsert shoppingList);

    @Insert(onConflict = OnConflictStrategy.IGNORE, entity = ShoppingList.class)
    abstract void insertAll(List<ShoppingListInsert> lists);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertInfo(Info info);

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    abstract void insertAllInfos(List<Info> infos);

    @Transaction
    public void markFavorite(String id) {
        updateShoppingListFavorite(id);
        updateInfoLastUpdated(id);
    }

    @Query("UPDATE shopping_list SET is_favorite= NOT is_favorite WHERE shopping_list_id = :id")
    protected abstract void updateShoppingListFavorite(String id);

    @Query("UPDATE info SET last_updated = CURRENT_TIMESTAMP WHERE shopping_list_id=:shoppingListId")
    protected abstract void updateInfoLastUpdated(String shoppingListId);

    @Delete(entity = ShoppingList.class)
    public abstract void deleteShoppingList(ShoppingListId id);

    @Query("DELETE FROM shopping_list")
    public abstract void deleteAll();
}

