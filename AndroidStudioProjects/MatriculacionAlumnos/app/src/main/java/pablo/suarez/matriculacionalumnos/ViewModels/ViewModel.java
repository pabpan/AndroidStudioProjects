package pablo.suarez.matriculacionalumnos.ViewModels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.Repositorios.Repositorio;

//EL VIEW MODEL ES LA CAPA SUPERIOR AL REPOSITORIO, ASÍ QUE TRABAJARÁ SOBRE ÉL
public class ViewModel extends AndroidViewModel {

    //CREAMOS VARIABLE PARA REPOSITORIO Y OTRAS DOS PARA LAS LISTAS
    private Repositorio repositorio;
    LiveData<List<Asignatura>> lista_asignaturas;
    LiveData<List<Alumno>> lista_alumnos;
    LiveData<List<AsignaturasAlumno>> lista_asignaturas_alumno;

    //CREAMOS EL CONTRUCTOR DEL VIEWMODEL
    public ViewModel(@NonNull Application application) {
        super(application);
        repositorio = new Repositorio(application);
        lista_asignaturas = repositorio.getAsignaturas();
        lista_alumnos = repositorio.getAlumnos();
        lista_asignaturas_alumno = repositorio.getAsignaturasAlumno();
    }

////////////////////////////////////////////////////////////////////////////////
///////////////// EJECUTAMOS LAS ACCIONES DESDE EL REPOSITORIO /////////////////
////////////////////////////////////////////////////////////////////////////////
//////////////////////////// REPOSITORIO ASIGNATURAS ///////////////////////////
////////////////////////////////////////////////////////////////////////////////

    //INSERTAR ASIGNATURA DESDE REPOSITORIO
    public void insertarAsignatura(Asignatura asignatura) {
        repositorio.insertarAsignatura(asignatura);
    }

    //ACTUALIZAR ASIGNATURA DESDE REPOSITORIO
    public void actualizarAsignatura(Asignatura asignatura) {
        repositorio.actualizarAsignatura(asignatura);
    }

    //BORRAR ASIGNATURA DESDE REPOSITORIO
    public void borrarAsignatura(Asignatura asignatura) {
        repositorio.borrarAsignatura(asignatura);
    }

    //BORRAR TODAS LAS ASIGNATURAS DESDE REPOSITORIO
    public void borrarAsignaturas(LiveData<List<Asignatura>> asignatura) {
        repositorio.borrarAsignaturas();
    }

    //LISTAR TODAS LAS ASIGNATURAS
    public LiveData<List<Asignatura>> getLista_asignaturas() {
        return lista_asignaturas;
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////// REPOSITORIO ALUMNOS// ///////////////////////////
////////////////////////////////////////////////////////////////////////////////

    //INSERTAR ALUMNO DESDE REPOSITORIO
    public void insertarAlumno(Alumno alumno) {
        repositorio.insertarAlumno(alumno);
    }

    //ACTUALIZAR ALUMNO DESDE REPOSITORIO
    public void actualizarAlumno(Alumno alumno) {
        repositorio.actualizarAlumno(alumno);
    }

    //BORRAR ALUMNO DESDE REPOSITORIO
    public void borrarAlumno(Alumno alumno) {
        repositorio.borrarAlumno(alumno);
    }

    //BORRAR TODOS LOS ALUMNOS DESDE REPOSITORIO
    public void borrarAlumnos(LiveData<List<Alumno>> alumno) {
        repositorio.borrarAlumnos();
    }

    //LISTAR TODOS LOS ALUMNOS DESDE REPOSITORIO
    public LiveData<List<Alumno>> getLista_alumnos() {
        return lista_alumnos;
    }

////////////////////////////////////////////////////////////////////////////////
////////////////////////////// REPOSITORIO RELACION ////////////////////////////
////////////////////////////////////////////////////////////////////////////////

    //INSERTAR ALUMNO DESDE REPOSITORIO
    public void insertarAsignaturaAlumno(AsignaturasAlumno asignaturaAlumno) {
        repositorio.insertarAsignaturasAlumno(asignaturaAlumno);
    }

    //ACTUALIZAR ALUMNO DESDE REPOSITORIO
    public void actualizarAsignaturaAlumno(AsignaturasAlumno asignaturaAlumno) {
        repositorio.actualizarAsignaturasAlumno(asignaturaAlumno);
    }

    //BORRAR ALUMNO DESDE REPOSITORIO
    public void borrarAsignaturaAlumno(AsignaturasAlumno asignaturaAlumno) {
        repositorio.borrarAsignaturaAlumno(asignaturaAlumno);
    }

    //BORRAR TODOS LOS ALUMNOS DESDE REPOSITORIO
    public void borrarAsignaturasAlumno(LiveData<List<AsignaturasAlumno>> asignaturas_alumno) {
        repositorio.borrarAsignaturasAlumno();
    }

    //LISTAR TODOS LOS ALUMNOS DESDE REPOSITORIO
    public LiveData<List<AsignaturasAlumno>> getLista_AsignaturasAlumno() {
        return lista_asignaturas_alumno;
    }

}
