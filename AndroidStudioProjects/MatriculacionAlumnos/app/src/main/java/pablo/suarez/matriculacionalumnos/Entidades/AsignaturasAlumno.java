package pablo.suarez.matriculacionalumnos.Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

//TABLA DE ASIGNATURAS
@Entity(tableName = "Tabla_asignaturas_del_alumno", primaryKeys = {"dni_alumno", "id_asignatura"})
public class AsignaturasAlumno {

    //COLUMNA CÓDIGO DE ASIGNATURA
    @NonNull
    @ColumnInfo(name = "dni_alumno")
    private String dni_alumno;

    //COLUMNA NOMBRE DE ASIGNATURA
    @NonNull
    @ColumnInfo(name = "id_asignatura")
    private int id_asignatura;

    //COLUMNA NOMBRE DE ASIGNATURA
    @ColumnInfo(name = "nombre_asignatura")
    private String nombre_asignatura;

    public AsignaturasAlumno(String dni_alumno, int id_asignatura, String nombre_asignatura) {
        this.dni_alumno = dni_alumno;
        this.id_asignatura = id_asignatura;
        this.nombre_asignatura = nombre_asignatura;
    }

    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }

    public String getDni_alumno() {
        return dni_alumno;
    }

    public void setDni_alumno(String dni_alumno) {
        this.dni_alumno = dni_alumno;
    }

    public int getId_asignatura() {
        return id_asignatura;
    }

    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

}


