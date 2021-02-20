package pablo.suarez.matriculacionalumnos.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pablo.suarez.matriculacionalumnos.DAOS.AsignaturaDAO;
import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.Entidades.AsignaturasAlumno;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.Repositorios.Repositorio;
import pablo.suarez.matriculacionalumnos.ViewModels.ViewModel;

public class AdaptadorAsignaturasAlumno extends RecyclerView.Adapter<AdaptadorAsignaturasAlumno.AsignaturasAlumnoHolder> {

    Repositorio repositorio;
    //CREAMOS UN ARRAYLIST DE ASIGNATURAS QUE ES EL QUE IREMOS ACTUALIZANDO
    private List<AsignaturasAlumno> lista_asignaturas_alumno = new ArrayList<>();

    //CREAMOS LA VARIABLE DE LA INTERFAZ QUE CREAMOS DEBAJO PARA MENEJAR LOS EVENTOS AL HACER CLICK
    private AdaptadorAsignaturasAlumno.ItemListener mItemListener;

    //AL CREAR EL HOLDER INFLAMOS LA VIEW CON EL XML DEL ÍTEM
    @NonNull
    @Override
    public AdaptadorAsignaturasAlumno.AsignaturasAlumnoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_relacion, parent, false);
        return new AdaptadorAsignaturasAlumno.AsignaturasAlumnoHolder(itemview);
    }

    //AQUÍ VAMOS A POER IMAGEN A LOS CAMPOS EN LOS ÍTEMS
    @Override
    public void onBindViewHolder(@NonNull AdaptadorAsignaturasAlumno.AsignaturasAlumnoHolder holder, int position) {


        //ASIGNAMOS LA ASIGNATURA ACTUAL
        AsignaturasAlumno asignaturas_alumno_actuales = lista_asignaturas_alumno.get(position);


        //ÉSTE ES EL TEXTO QUE QUEREMOS PONER EN LOS ÍTEMS
        holder.setear_codigo_asignatura.setText(asignaturas_alumno_actuales.getDni_alumno());
        holder.setear_nombre_asignatura.setText(asignaturas_alumno_actuales.getNombre_asignatura());

//        holder.setear_nombre_asignatura.setText(asignaturas_alumno_actuales.getNombre_asignatura());
    }

    //ESTA ES LA CANTIDAD DE ÍTEMS QUE QUEREMOS MOSTRAR EN EL HOLDER
    @Override
    public int getItemCount() {
        return lista_asignaturas_alumno.size();
    }

    //CREAMOS UN MÉTODO SET PARA METER NUESTRA LISTA DE ASIGNATURAS EN EL RECYCLERVIEW
    public void setAsignaturasAlumno(List<AsignaturasAlumno> lista_asignaturas_alumno) {
        this.lista_asignaturas_alumno = lista_asignaturas_alumno;
        //notificamos los cambios, aunque esta no es la mejor forma de hacerlo
        notifyDataSetChanged();
    }

    //ASIGNAMOS EL ITEMLISTENER
    public void setItemListener(AdaptadorAsignaturasAlumno.ItemListener listener) {
        mItemListener = listener;
    }

    //DEFINIMOS LA INTERFAZ PARA EL CALLBACK PARA SER INVOCADO CUANDO UN ITEM DEL ADAPTADOR HA SIDO CLICKADO
    public interface ItemListener {
        void onClick(AsignaturasAlumno asignaturasAlumno);

        void alPulsarBotonBorrar(AsignaturasAlumno asignaturasAlumno);
    }

    //AQUÍ BUSCAMOS LOS TEXTVIEWS PARA SETEAR
    public class AsignaturasAlumnoHolder extends RecyclerView.ViewHolder {


        private TextView setear_codigo_asignatura;
        private TextView setear_nombre_asignatura;
        private ImageView setear_boton_borrar_asignatura;

        public AsignaturasAlumnoHolder(View itemview) {
            super(itemview);


            setear_codigo_asignatura = itemview.findViewById(R.id.textview_item_relacion_codigo_asignatura);
            setear_nombre_asignatura = itemview.findViewById(R.id.textview_item_relacion_nombre_asignatura);
            setear_boton_borrar_asignatura = itemview.findViewById(R.id.boton_borrar_relacion_asignatura);


            //ASIGNAMOS LOS EVENTOS A LOS BOTONES AL HACER CLICK
            setear_boton_borrar_asignatura.setOnClickListener(this::manejarEventos);
            itemview.setOnClickListener(this::manejarEventos);
        }

        //AQUÍ LOS DEFINIMOS
        private void manejarEventos(View view) {

            if (mItemListener != null) {

                //RECOGEMOS QUÉ PUNTO HA SIDO CLICKADO
                AsignaturasAlumno clickedItem = lista_asignaturas_alumno.get(getAdapterPosition());

                //EVENTO BORRAR
                if (view.getId() == R.id.boton_borrar_relacion_asignatura) {
                    mItemListener.alPulsarBotonBorrar(clickedItem);
                    return;
                    //EVENTO EDITAR
                }

                mItemListener.onClick(clickedItem);
            }
        }
    }
}