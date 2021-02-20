package pablo.suarez.matriculacionalumnos.BaseDeDatos;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import pablo.suarez.matriculacionalumnos.DAOS.AlumnoDAO;
import pablo.suarez.matriculacionalumnos.DAOS.AsignaturaDAO;
import pablo.suarez.matriculacionalumnos.DAOS.AsignaturasAlumnoDAO;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;

//CREAMOS LA BASE DE DATOS Y LE PASAMOS LAS ENTIDADES QUE HEMOS CREADO
@Database(entities = {Asignatura.class, Alumno.class, AsignaturasAlumno.class}, version = 4, exportSchema = false)
public abstract class BaseDeDatos extends RoomDatabase {

    //DECLARAMOS LOS DATA ACCESS OBJECT DE LAS ENTIDADES
    public abstract AsignaturaDAO asignaturaDAO();
    public abstract AlumnoDAO alumnoDAO();
    public abstract AsignaturasAlumnoDAO asignaturasAlumnoDAO();

    //VARIABLE CON LA QUE ACCEDEREMOS A LA BASE DE DATOS
    private static BaseDeDatos INSTANCE;

    //MÉTODO CON EL QUE LLAMAREMOS A LA BASE DE DATOS
    //LO DECLARAMOS SYNCRONIZED PARA QUE SOLO UN HILO PUEDA ACCEDER A ELL
    public static synchronized BaseDeDatos getBasedeDatos(Context context) {
        if (INSTANCE == null) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(), BaseDeDatos.class,
                            "Base_de_Datos_Matriculacion15")
                            .fallbackToDestructiveMigration()
                            .addCallback(roomCallback)
                            .build();
                }
            }
        return INSTANCE;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PrepoblarBaseDeDatosAsyncTask(INSTANCE).execute();
        }
    };

    //MÉTODO PARA PREPOBLAR LA BASE DE DATOS
    private static class PrepoblarBaseDeDatosAsyncTask extends AsyncTask <Void, Void, Void> {

        private AsignaturaDAO asignaturaDAO;
        private AlumnoDAO alumnoDAO;
        private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

        private PrepoblarBaseDeDatosAsyncTask (BaseDeDatos baseDeDatos) {
            asignaturaDAO = baseDeDatos.asignaturaDAO();
            alumnoDAO = baseDeDatos.alumnoDAO();
            asignaturasAlumnoDAO = baseDeDatos.asignaturasAlumnoDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            asignaturaDAO.insertarAsignatura(new Asignatura(1, "PMDM","Programación Multimedia"));
            asignaturaDAO.insertarAsignatura(new Asignatura(2, "PSP","Programación de Hilos"));
            alumnoDAO.insertarAlumno(new Alumno("44877847V","Pablo", "Suárez Pantaleón"));
            alumnoDAO.insertarAlumno(new Alumno("99655235H","María", "Martínez Martín"));
            asignaturasAlumnoDAO.insertarAsignaturaAlumno(new AsignaturasAlumno( "44877847V", 1, "Programación Multimedia"));
            asignaturasAlumnoDAO.insertarAsignaturaAlumno(new AsignaturasAlumno( "44877847V", 2, "Programación de Hilos"));
            asignaturasAlumnoDAO.insertarAsignaturaAlumno(new AsignaturasAlumno( "99655235H", 1, "Programación Multimedia"));

            return null;
        }
    }
}