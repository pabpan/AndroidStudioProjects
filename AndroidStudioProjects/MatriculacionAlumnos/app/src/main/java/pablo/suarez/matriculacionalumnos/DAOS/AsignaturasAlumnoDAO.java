package pablo.suarez.matriculacionalumnos.DAOS;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;

@Dao
public interface AsignaturasAlumnoDAO {

    //INSERTAR ALUMNO
    @Insert
    void insertarAsignaturaAlumno(AsignaturasAlumno asignaturasAlumno);

    //BORRAR ALUMNO
    @Delete
    void borrarAsignaturaAlumno(AsignaturasAlumno asignaturasAlumno);

    //ACTUALIZAR ALUMNO
    @Update
    void actualizarAsignaturasAlumno(AsignaturasAlumno asignaturasAlumno);

    //BORRAR TODOS LOS ALUMNOS
    @Query("DELETE FROM Tabla_asignaturas_del_alumno")
    void borrarAsignaturasAlumno();

    //SELECCIONAR TODOS LOS ALUMNOS
    @Query("SELECT * FROM Tabla_asignaturas_del_alumno")
    LiveData<List<AsignaturasAlumno>> getAsignaturaAlumnos();
}
