package pablo.suarez.matriculacionalumnos.Repositorios;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

import pablo.suarez.matriculacionalumnos.BaseDeDatos.BaseDeDatos;
import pablo.suarez.matriculacionalumnos.DAOS.AlumnoDAO;
import pablo.suarez.matriculacionalumnos.DAOS.AsignaturaDAO;
import pablo.suarez.matriculacionalumnos.DAOS.AsignaturasAlumnoDAO;
import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;

//REPOSITORIO DESDE EL QUE CONTROLAREMOS EL DAO Y LA BASE DE DATOS PARA GRABAR LOS DATOS EN ROOM
public class Repositorio {

    //DECLARAMOS LOS DATA ACCESS OBJECT DE LAS ENTIDADES
    private AsignaturaDAO asignaturaDAO;
    private AlumnoDAO alumnoDAO;
    private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

    //DECLARAMOS LAS LISTAS DE LAS ENTIDADES QUE IRÁN ACTUALIZÁNDOSE AUTOMÁTICAMENTE CON LIVEDATA
    private LiveData<List<Asignatura>> lista_asignaturas;
    private LiveData<List<Alumno>> lista_alumnos;
    private LiveData<List<AsignaturasAlumno>> lista_asignaturas_alumno;

    //CONSTRUCTOR DEL REPOSITORIO
    public Repositorio(Application application) {

        //INSTANCIAMOS LAS BASE DE DATOS
        BaseDeDatos baseDatos = BaseDeDatos.getBasedeDatos(application);

        //ASIGNAMOS EL DAO A NUESTRAS LISTAS
        asignaturaDAO = baseDatos.asignaturaDAO();
        lista_asignaturas = asignaturaDAO.getAsignaturas();
        alumnoDAO = baseDatos.alumnoDAO();
        lista_alumnos = alumnoDAO.getAlumnos();
        asignaturasAlumnoDAO = baseDatos.asignaturasAlumnoDAO();
        lista_asignaturas_alumno = asignaturasAlumnoDAO.getAsignaturaAlumnos();
    }

/////////////////////////////////////////////////////////////////////////////////////
////////////////////////////// REPOSITORIO ASIGNATURAS //////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    //INSERTAMOS UNA ASIGNATURA
    public void insertarAsignatura(Asignatura asignatura) {
        new InsertarAsignaturaAsyncTask(asignaturaDAO).execute(asignatura);
    }

    //ACTUALIZAMOS UNA ASIGNATURA
    public void actualizarAsignatura(Asignatura asignatura) {
        new ActualizarAsignaturaAsyncTask(asignaturaDAO).execute(asignatura);
    }

    //ELIMINAMOS UNA ASIGNATURA
    public void borrarAsignatura(Asignatura asignatura) {
        new BorrarAsignaturaAsyncTask(asignaturaDAO).execute(asignatura);
    }

    //ELIMINAMOS TODAS LAS ASIGNATURAS
    public void borrarAsignaturas() {
        new BorrarAsignaturasAsyncTask(asignaturaDAO).execute();
    }

    //RECUPERAMOS TODAS LAS ASIGNATURAS
    public LiveData<List<Asignatura>> getAsignaturas() {
        return lista_asignaturas;
    }

    //MÉTODO ASÍNCRONO PARA INSERTAR UNA ASIGNATURA
    private static class InsertarAsignaturaAsyncTask extends AsyncTask <Asignatura, Void, Void> {

        private AsignaturaDAO asignaturaDAO;

        private InsertarAsignaturaAsyncTask(AsignaturaDAO asignaturaDAO) {
            this.asignaturaDAO=asignaturaDAO;
        }

        @Override
        protected Void doInBackground(Asignatura... asignaturas) {
            asignaturaDAO.insertarAsignatura(asignaturas[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA ACTUALIZAR UNA ASIGNATURA
    private static class ActualizarAsignaturaAsyncTask extends AsyncTask <Asignatura, Void, Void> {

        private AsignaturaDAO asignaturaDAO;

        private ActualizarAsignaturaAsyncTask(AsignaturaDAO asignaturaDAO) {
            this.asignaturaDAO=asignaturaDAO;
        }

        @Override
        protected Void doInBackground(Asignatura... asignaturas) {
            asignaturaDAO.actualizarAsignatura(asignaturas[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR UNA ASIGNATURA
    private static class BorrarAsignaturaAsyncTask extends AsyncTask <Asignatura, Void, Void> {

        private AsignaturaDAO asignaturaDAO;

        private BorrarAsignaturaAsyncTask(AsignaturaDAO asignaturaDAO) {
            this.asignaturaDAO=asignaturaDAO;
        }

        @Override
        protected Void doInBackground(Asignatura... asignaturas) {
            asignaturaDAO.borrarAsignatura(asignaturas[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR TODAS LAS ASIGNATURA
    private static class BorrarAsignaturasAsyncTask extends AsyncTask <Asignatura, Void, Void> {

        private AsignaturaDAO asignaturaDAO;

        private BorrarAsignaturasAsyncTask(AsignaturaDAO asignaturaDAO) {
            this.asignaturaDAO=asignaturaDAO;
        }

        @Override
        protected Void doInBackground(Asignatura... asignaturas) {
            asignaturaDAO.borrarAsignaturas();
            return null;
        }
    }

/////////////////////////////////////////////////////////////////////////////////
////////////////////////////// REPOSITORIO ALUMNOS //////////////////////////////
/////////////////////////////////////////////////////////////////////////////////

    //INSERTAMOS UN ALUMNO
    public void insertarAlumno(Alumno alumno) {
        new InsertarAlumnoAsyncTask(alumnoDAO).execute(alumno);
    }

    //ACTUALIZAMOS UN ALUMNO
    public void actualizarAlumno(Alumno alumno) {
        new AcualizarAlumnoAsyncTask(alumnoDAO).execute(alumno);
    }

    //ELIMINAMOS UN ALUMNO
    public void borrarAlumno(Alumno alumno) {
        new BorrarAlumnoAsyncTask(alumnoDAO).execute(alumno);
    }

    //ELIMINAMOS TODOS LOS ALUMNOS
    public void borrarAlumnos() {
        new BorrarAlumnosAsyncTask(alumnoDAO).execute();
    }

    //RECUPERAMOS TODOS LOS ALUMNOS
    public LiveData<List<Alumno>> getAlumnos() {
        return lista_alumnos;
    }

    //MÉTODO ASÍNCRONO PARA INSERTAR UN ALUMNO
    private static class InsertarAlumnoAsyncTask extends AsyncTask <Alumno, Void, Void> {

        private AlumnoDAO alumnoDAO;

        private InsertarAlumnoAsyncTask(AlumnoDAO alumnoDAO) {
            this.alumnoDAO=alumnoDAO;
        }

        @Override
        protected Void doInBackground(Alumno... alumnos) {
            alumnoDAO.insertarAlumno(alumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA ACTUALIZAR UN ALUMNO
    private static class AcualizarAlumnoAsyncTask extends AsyncTask <Alumno, Void, Void> {

        private AlumnoDAO alumnoDAO;

        private AcualizarAlumnoAsyncTask(AlumnoDAO alumnoDAO) {
            this.alumnoDAO=alumnoDAO;
        }

        @Override
        protected Void doInBackground(Alumno... alumnos) {
            alumnoDAO.actualizarAlumno(alumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR UN ALUMNO
    private static class BorrarAlumnoAsyncTask extends AsyncTask <Alumno, Void, Void> {

        private AlumnoDAO alumnoDAO;

        private BorrarAlumnoAsyncTask(AlumnoDAO alumnoDAO) {
            this.alumnoDAO=alumnoDAO;
        }

        @Override
        protected Void doInBackground(Alumno... alumnos) {
            alumnoDAO.borrarAlumno(alumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR TODOS LOS ALUMNOS
    private static class BorrarAlumnosAsyncTask extends AsyncTask <Void, Void, Void> {

        private AlumnoDAO alumnoDAO;

        private BorrarAlumnosAsyncTask(AlumnoDAO alumnoDAO) {
            this.alumnoDAO=alumnoDAO;
        }

        @Override
        protected Void doInBackground(Void... alumnos) {
            alumnoDAO.borrarAlumnos();
            return null;
        }
    }

/////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////// REPOSITORIO RELACION ////////////////////////////////
/////////////////////////////////////////////////////////////////////////////////////

    //INSERTAMOS UN ALUMNO
    public void insertarAsignaturasAlumno(AsignaturasAlumno asignaturasAlumno) {
        new InsertarAsignaturasAlumnoAsyncTask(asignaturasAlumnoDAO).execute(asignaturasAlumno);
    }

    //ACTUALIZAMOS UN ALUMNO
    public void actualizarAsignaturasAlumno(AsignaturasAlumno asignaturasAlumno) {
        new AcualizarAsignaturasAlumnoAsyncTask(asignaturasAlumnoDAO).execute(asignaturasAlumno);
    }

    //ELIMINAMOS UN ALUMNO
    public void borrarAsignaturaAlumno(AsignaturasAlumno asignaturasAlumno) {
        new BorrarAsignaturasAlumnoAsyncTask(asignaturasAlumnoDAO).execute(asignaturasAlumno);
    }

    //ELIMINAMOS TODOS LOS ALUMNOS
    public void borrarAsignaturasAlumno() {
        new BorrarAsignaturasAlumnoAsyncTask(asignaturasAlumnoDAO).execute();
    }

    //RECUPERAMOS TODOS LOS ALUMNOS
    public LiveData<List<AsignaturasAlumno>> getAsignaturasAlumno() {
        return lista_asignaturas_alumno;
    }

    //MÉTODO ASÍNCRONO PARA INSERTAR UN ALUMNO
    private static class InsertarAsignaturasAlumnoAsyncTask extends AsyncTask <AsignaturasAlumno, Void, Void> {

        private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

        private InsertarAsignaturasAlumnoAsyncTask(AsignaturasAlumnoDAO asignaturasAlumnoDAO) {
            this.asignaturasAlumnoDAO=asignaturasAlumnoDAO;
        }

        @Override
        protected Void doInBackground(AsignaturasAlumno... asignaturasAlumnos) {
            asignaturasAlumnoDAO.insertarAsignaturaAlumno(asignaturasAlumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA ACTUALIZAR UN ALUMNO
    private static class AcualizarAsignaturasAlumnoAsyncTask extends AsyncTask <AsignaturasAlumno, Void, Void> {

        private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

        private AcualizarAsignaturasAlumnoAsyncTask(AsignaturasAlumnoDAO asignaturasAlumnoDAO) {
            this.asignaturasAlumnoDAO=asignaturasAlumnoDAO;
        }

        @Override
        protected Void doInBackground(AsignaturasAlumno... asignaturasAlumnos) {
            asignaturasAlumnoDAO.actualizarAsignaturasAlumno(asignaturasAlumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR UN ALUMNO
    private static class BorrarAsignaturasAlumnoAsyncTask extends AsyncTask <AsignaturasAlumno, Void, Void> {

        private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

        private BorrarAsignaturasAlumnoAsyncTask(AsignaturasAlumnoDAO asignaturasAlumnoDAO) {
            this.asignaturasAlumnoDAO=asignaturasAlumnoDAO;
        }

        @Override
        protected Void doInBackground(AsignaturasAlumno... asignaturasAlumnos) {
            asignaturasAlumnoDAO.borrarAsignaturaAlumno(asignaturasAlumnos[0]);
            return null;
        }
    }

    //MÉTODO ASÍNCRONO PARA BORRAR TODOS LOS ALUMNOS
    private static class BorrarAsignaturasAlumnosAsyncTask extends AsyncTask <Void, Void, Void> {

        private AsignaturasAlumnoDAO asignaturasAlumnoDAO;

        private BorrarAsignaturasAlumnosAsyncTask(AsignaturasAlumno asignaturasAlumno) {
            this.asignaturasAlumnoDAO=asignaturasAlumnoDAO;
        }

        @Override
        protected Void doInBackground(Void... asignaturasAlumno) {
            asignaturasAlumnoDAO.borrarAsignaturasAlumno();
            return null;
        }
    }
}

