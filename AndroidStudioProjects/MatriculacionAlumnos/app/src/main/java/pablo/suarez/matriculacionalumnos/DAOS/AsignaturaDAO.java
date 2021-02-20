package pablo.suarez.matriculacionalumnos.DAOS;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;

@Dao
public interface AsignaturaDAO {

        //INSERTAR ASIGNATURA
        @Insert
        void insertarAsignatura(Asignatura asignatura);

        //BORRAR ASIGNATURA
        @Delete
        void borrarAsignatura(Asignatura asignatura);

        //ACTUALIZAR ASIGNATURA
        @Update
        void actualizarAsignatura(Asignatura asignatura);

        //BORRAR TODAS LAS ASIGNATURAS
        @Query("DELETE FROM Tabla_asignaturas")
        void  borrarAsignaturas();

        //SELECCIONAR TODAS LAS ASIGNATURA
        @Query("SELECT * FROM Tabla_asignaturas ORDER BY id_asignatura DESC")
        LiveData<List<Asignatura>> getAsignaturas();

}