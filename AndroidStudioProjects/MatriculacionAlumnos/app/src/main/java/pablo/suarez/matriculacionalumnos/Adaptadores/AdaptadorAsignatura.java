package pablo.suarez.matriculacionalumnos.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import pablo.suarez.matriculacionalumnos.Entidades.Asignatura;
import pablo.suarez.matriculacionalumnos.R;
import pablo.suarez.matriculacionalumnos.Repositorios.Repositorio;

public class AdaptadorAsignatura extends RecyclerView.Adapter<AdaptadorAsignatura.AsignaturaHolder> {

    //CREAMOS UN ARRAYLIST DE ASIGNATURAS QUE ES EL QUE IREMOS ACTUALIZANDO
    private List<Asignatura> lista_asignaturas = new ArrayList<>();

    //CREAMOS LA VARIABLE DE LA INTERFAZ QUE CREAMOS DEBAJO PARA MENEJAR LOS EVENTOS AL HACER CLICK
    private ItemListener mItemListener;

    //AL CREAR EL HOLDER INFLAMOS LA VIEW CON EL XML DEL ÍTEM
    @NonNull
    @Override
    public AsignaturaHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_asignatura, parent, false);
        return new AsignaturaHolder(itemview);
    }

    //AQUÍ VAMOS A POER IMAGEN A LOS CAMPOS EN LOS ÍTEMS
    @Override
    public void onBindViewHolder(@NonNull AsignaturaHolder holder, int position) {

        //ASIGNAMOS LA ASIGNATURA ACTUAL
        Asignatura asignaturaactual = lista_asignaturas.get(position);

        //ÉSTE ES EL TEXTO QUE QUEREMOS PONER EN LOS ÍTEMS
        holder.setear_codigo_asignatura.setText(asignaturaactual.getCodigo_asignatura());
        holder.setear_nombre_asignatura.setText(asignaturaactual.getNombre_asignatura());
    }

    //ESTA ES LA CANTIDAD DE ÍTEMS QUE QUEREMOS MOSTRAR EN EL HOLDER
    @Override
    public int getItemCount() {
        return lista_asignaturas.size();
    }

    //AQUÍ BUSCAMOS LOS TEXTVIEWS PARA SETEAR
    public class AsignaturaHolder extends RecyclerView.ViewHolder {

        private TextView setear_codigo_asignatura;
        private TextView setear_nombre_asignatura;
        private ImageView setear_boton_borrar_asignatura;
        private ImageView setear_boton_editar_asignatura;

        public AsignaturaHolder (View itemview) {
            super(itemview);

            setear_codigo_asignatura = itemview.findViewById(R.id.textview_item_asignatura_codigo_asignatura);
            setear_nombre_asignatura = itemview.findViewById(R.id.textview_item_asignatura_nombre_asignatura);
            setear_boton_borrar_asignatura = itemview.findViewById(R.id.boton_borrar_asignatura);
            setear_boton_editar_asignatura = itemview.findViewById(R.id.boton_editar_asignatura);

            //ASIGNAMOS LOS EVENTOS A LOS BOTONES AL HACER CLICK
            setear_boton_borrar_asignatura.setOnClickListener(this::manejarEventos);
            setear_boton_editar_asignatura.setOnClickListener(this::manejarEventos);
            itemview.setOnClickListener(this::manejarEventos);
        }

        //AQUÍ LOS DEFINIMOS
        private void manejarEventos(View view) {

            if (mItemListener != null) {

                //RECOGEMOS QUÉ PUNTO HA SIDO CLICKADO
                Asignatura clickedItem = lista_asignaturas.get(getAdapterPosition());

                //EVENTO BORRAR
                if (view.getId() == R.id.boton_borrar_asignatura) {
                    mItemListener.alPulsarBotonBorrar(clickedItem);
                    return;
                    //EVENTO EDITAR
                } else if (view.getId() == R.id.boton_editar_asignatura) {
                    mItemListener.alPulsarBotonEditar(clickedItem);
                    return;
                }

                mItemListener.onClick(clickedItem);
            }
        }
    }

    //DEFINIMOS LA INTERFAZ PARA EL CALLBACK PARA SER INVOCADO CUANDO UN ITEM DEL ADAPTADOR HA SIDO CLICKADO
    public interface ItemListener {
        void onClick(Asignatura asigntura);

        void alPulsarBotonBorrar(Asignatura asignatura);

        void alPulsarBotonEditar(Asignatura asignatura);
    }

    //CREAMOS UN MÉTODO SET PARA METER NUESTRA LISTA DE ASIGNATURAS EN EL RECYCLERVIEW
    public void setAsignaturas (List<Asignatura> lista_asignaturas) {
        this.lista_asignaturas = lista_asignaturas;

        //notificamos los cambios, aunque esta no es la mejor forma de hacerlo
        notifyDataSetChanged();
    }

    //ASIGNAMOS EL ITEMLISTENER
    public void setItemListener(ItemListener listener) {
        mItemListener = listener;
    }
}