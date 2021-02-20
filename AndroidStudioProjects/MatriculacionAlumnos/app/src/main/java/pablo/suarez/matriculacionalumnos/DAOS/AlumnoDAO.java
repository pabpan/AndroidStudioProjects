package pablo.suarez.matriculacionalumnos.DAOS;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import java.util.List;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;

@Dao
public interface AlumnoDAO {

    //INSERTAR ALUMNO
    @Insert
    void insertarAlumno(Alumno alumno);

    //BORRAR ALUMNO
    @Delete
    void borrarAlumno(Alumno alumno);

    //ACTUALIZAR ALUMNO
    @Update
    void actualizarAlumno(Alumno alumno);

    //BORRAR TODOS LOS ALUMNOS
    @Query("DELETE FROM Tabla_Alumnos")
    void borrarAlumnos();

    //SELECCIONAR TODOS LOS ALUMNOS
    @Query("SELECT * FROM Tabla_Alumnos ORDER BY apellidos_alumno DESC")
    LiveData<List<Alumno>> getAlumnos();
}