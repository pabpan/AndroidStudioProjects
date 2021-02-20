package pablo.suarez.matriculacionalumnos.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pablo.suarez.matriculacionalumnos.Entidades.Alumno;
import pablo.suarez.matriculacionalumnos.R;

public class AdaptadorAlumno extends RecyclerView.Adapter<AdaptadorAlumno.AlumnoHolder> {

    //CREAMOS UN ARRAYLIST DE AlumnoS QUE ES EL QUE IREMOS ACTUALIZANDO
    private List<Alumno> lista_alumnos = new ArrayList<>();

    //CREAMOS LA VARIABLE DE LA INTERFAZ QUE CREAMOS DEBAJO PARA MENEJAR LOS EVENTOS AL HACER CLICK
    private ItemListener mItemListener;

    //AL CREAR EL HOLDER INFLAMOS LA VIEW CON EL XML DEL ÍTEM
    @NonNull
    @Override
    public AlumnoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_alumno, parent, false);
        return new AlumnoHolder(itemview);
    }

    //AQUÍ VAMOS A POER IMAGEN A LOS CAMPOS EN LOS ÍTEMS
    @Override
    public void onBindViewHolder(@NonNull AlumnoHolder holder, int position) {

        //ASIGNAMOS LA Alumno ACTUAL
        Alumno alumnoactual = lista_alumnos.get(position);

        //ÉSTE ES EL TEXTO QUE QUEREMOS PONER EN LOS ÍTEMS
        holder.setear_dni_alumno.setText(alumnoactual.getDni_alumno());
        holder.setear_nombre_alumno.setText(alumnoactual.getNombre_alumno());
        holder.setear_apellidos_alumno.setText(alumnoactual.getApellidos_alumno());
    }

    //ESTA ES LA CANTIDAD DE ÍTEMS QUE QUEREMOS MOSTRAR EN EL HOLDER
    @Override
    public int getItemCount() {
        return lista_alumnos.size();
    }

    //AQUÍ BUSCAMOS LOS TEXTVIEWS PARA SETEAR
    public class AlumnoHolder extends RecyclerView.ViewHolder {

        private TextView setear_dni_alumno;
        private TextView setear_nombre_alumno;
        private TextView setear_apellidos_alumno;
        private ImageView setear_boton_borrar_alumno;
        private ImageView setear_boton_editar_alumno;
        private ImageView setear_boton_asignar_asignatura_alumno;

        public AlumnoHolder (View itemview) {
            super(itemview);
            setear_dni_alumno = itemview.findViewById(R.id.textview_item_alumno_dni_alumno);
            setear_nombre_alumno = itemview.findViewById(R.id.textview_item_alumno_nombre_alumno);
            setear_apellidos_alumno = itemview.findViewById(R.id.textview_item_alumno_apellidos_alumno);
            setear_boton_borrar_alumno = itemview.findViewById(R.id.boton_borrar_alumno);
            setear_boton_editar_alumno = itemview.findViewById(R.id.boton_editar_alumno);
            setear_boton_asignar_asignatura_alumno = itemview.findViewById(R.id.boton_asignaturas_alumno);

            //ASIGNAMOS LOS EVENTOS A LOS BOTONES AL HACER CLICK
            setear_boton_borrar_alumno.setOnClickListener(this::manejarEventos);
            setear_boton_editar_alumno.setOnClickListener(this::manejarEventos);
            setear_boton_asignar_asignatura_alumno.setOnClickListener(this::manejarEventos);
            itemview.setOnClickListener(this::manejarEventos);
        }

        //AQUÍ LOS DEFINIMOS
        private void manejarEventos(View view) {

            if (mItemListener != null) {

                //RECOGEMOS QUÉ PUNTO HA SIDO CLICKADO
                Alumno clickedItem = lista_alumnos.get(getAdapterPosition());

                //EVENTO BORRAR
                if (view.getId() == R.id.boton_borrar_alumno) {
                    mItemListener.alPulsarBotonBorrar(clickedItem);
                    return;
                    //EVENTO EDITAR
                } else if (view.getId() == R.id.boton_editar_alumno) {
                    mItemListener.alPulsarBotonEditar(clickedItem);
                    return;
                } else if (view.getId() == R.id.boton_asignaturas_alumno) {
                    mItemListener.alPulsarBotonAsignarAsignaturas(clickedItem);
                    return;
                }

                mItemListener.onClick(clickedItem);
            }
        }
    }

    //DEFINIMOS LA INTERFAZ PARA EL CALLBACK PARA SER INVOCADO CUANDO UN ITEM DEL ADAPTADOR HA SIDO CLICKADO
    public interface ItemListener {
        void onClick(Alumno alumno);

        void alPulsarBotonBorrar(Alumno alumno);

        void alPulsarBotonEditar(Alumno alumno);

        void alPulsarBotonAsignarAsignaturas(Alumno alumno);
    }

    //CREAMOS UN MÉTODO SET PARA METER NUESTRA LISTA DE AlumnoS EN EL RECYCLERVIEW
    public void setAlumnos (List<Alumno> lista_alumnos) {
        this.lista_alumnos = lista_alumnos;

        //notificamos los cambios, aunque esta no es la mejor forma de hacerlo
        notifyDataSetChanged();
    }

    //ASIGNAMOS EL ITEMLISTENER
    public void setItemListener(AdaptadorAlumno.ItemListener listener) {
        mItemListener = listener;
    }
}