package pablo.suarez.matriculacionalumnos.Entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import android.provider.BaseColumns;

//TABLA DE ASIGNATURAS
@Entity(tableName = "Tabla_asignaturas")
public class Asignatura {

    //CLAVE PRIMARIA AUTOGENERADA
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_asignatura")
    private int id_asignatura;

    //COLUMNA CÓDIGO DE ASIGNATURA
    @ColumnInfo(name = "codigo_asignatura")
    private String codigo_asignatura;

    //COLUMNA NOMBRE DE ASIGNATURA
    @ColumnInfo(name = "nombre_asignatura")
    private String nombre_asignatura;

    //CONTRUCTOR DE ASIGNATURAS
    public Asignatura(String codigo_asignatura, String nombre_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
        this.nombre_asignatura = nombre_asignatura;
    }

    public Asignatura(int id_asignatura, String codigo_asignatura, String nombre_asignatura) {
        this.id_asignatura = id_asignatura;
        this.codigo_asignatura = codigo_asignatura;
        this.nombre_asignatura = nombre_asignatura;
    }

    //CONSTRUCTOR VACÍO DE ASIGNATURA
    public Asignatura() {
    }

    //GETTER ID ASIGNATURA
    public int getId_asignatura() {
        return id_asignatura;
    }

    //SETTER ID ASIGNATURA
    public void setId_asignatura(int id_asignatura) {
        this.id_asignatura = id_asignatura;
    }

    //GETTER CÓDIGO ASIGNATURA
    public String getCodigo_asignatura() {
        return codigo_asignatura;
    }

    //SETTER CÓDIGO ASIGNATURA
    public void setCodigo_asignatura(String codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }

    //GETTER NOMBRE ASIGNATURA
    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    //SETTER NOMBRE ASIGNATURA
    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }
}
