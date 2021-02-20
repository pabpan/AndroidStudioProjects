package pablo.suarez.matriculacionalumnos.Entidades;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import android.provider.BaseColumns;

import java.io.Serializable;

//TABLA DE ALUMNOS
@Entity(tableName = "Tabla_Alumnos")
public class Alumno implements Serializable {

    //CLAVE PRIMARIA AUTOGENERADA
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id_alumno")
    private int id_alumno;

    //COLUMNA DNI ALUMNO
    @ColumnInfo(name = "dni_alumno")
    private String dni_alumno;

    //COLUMNA NOMBRE ALUMNO
    @ColumnInfo(name = "nombre_alumno")
    private String nombre_alumno;

    //COLUMNA APELLIDOS ALUMNO
    @ColumnInfo(name = "apellidos_alumno")
    private String apellidos_alumno;

    //CONSTRUCTOR DE ALUMNO
    public Alumno(String dni_alumno, String nombre_alumno, String apellidos_alumno) {
        this.dni_alumno = dni_alumno;
        this.nombre_alumno = nombre_alumno;
        this.apellidos_alumno = apellidos_alumno;
    }

    public Alumno(int id_alumno, String dni_alumno, String nombre_alumno, String apellidos_alumno) {
        this.id_alumno = id_alumno;
        this.dni_alumno = dni_alumno;
        this.nombre_alumno = nombre_alumno;
        this.apellidos_alumno = apellidos_alumno;
    }

    //CONSTRUCTOR VACÍO DE ALUMNO
    public Alumno() {
    }

    //GETTER ID ALUMNO
    public int getId_alumno() {
        return id_alumno;
    }

    //SETTER ID ALUMNO
    public void setId_alumno(int id_alumno) {
        this.id_alumno = id_alumno;
    }

    //GETTER DNI ALUMNO
    public String getDni_alumno() {
        return dni_alumno;
    }

    //SETTER DNI ALUMNO
    public void setDni_alumno( String dni_alumno) {
        this.dni_alumno = dni_alumno;
    }

    //GETTER NOMBRE ALUMNO
    public String getNombre_alumno() {
        return nombre_alumno;
    }

    //SETTER NOMBRE ALUMNO
    public void setNombre_alumno(String nombre_alumno) {
        this.nombre_alumno = nombre_alumno;
    }

    //GETTER APELLIDOS ALUMNO
    public String getApellidos_alumno() {
        return apellidos_alumno;
    }

    //SETTER APELLIDOS ALUMNO
    public void setApellidos_alumno(String apellidos_alumno) {
        this.apellidos_alumno = apellidos_alumno;
    }
}
