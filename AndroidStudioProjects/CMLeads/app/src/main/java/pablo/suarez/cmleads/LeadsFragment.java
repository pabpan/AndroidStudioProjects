package pablo.suarez.cmleads;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LeadsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LeadsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    ListView mLeadsList;
    ArrayAdapter<String> mLeadsAdapter;

    public LeadsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment LeadsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LeadsFragment newInstance(/*String param1, String param2*/) {
        LeadsFragment fragment = new LeadsFragment();
        /*Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);*/
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }

    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//    // Instancia del ListView.
//        View root = inflater.inflate(R.layout.fragment_leads, container, false);;
//        mLeadsList = (ListView) root.findViewById(R.id.leads_list);
//
//        String[] leadsNames = {
//                "Alexander Pierrot",
//                "Carlos Lopez",
//                "Sara Bonz",
//                "Liliana Clarence",
//                "Benito Peralta",
//                "Juan Jaramillo",
//                "Christian Steps",
//                "Alexa Giraldo",
//                "Linda Murillo",
//                "Lizeth Astrada"
//        };
//
//        mLeadsAdapter = new ArrayAdapter<>(
//                getActivity(),
//                android.R.layout.simple_list_item_1,
//                leadsNames);
//
//        mLeadsList.setAdapter(mLeadsAdapter);
//
//        return root;
//    }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View root = inflater.inflate(R.layout.fragment_leads, container, false);

            // Instancia del ListView.
            mLeadsList = (ListView) root.findViewById(R.id.leads_list);

            // Inicializar el adaptador con la fuente de datos.
            ArrayAdapter <Lead> mLeadsAdapter = new LeadsAdapter(getActivity(),
                    LeadsRepository.getInstance().getLeads());

            //Relacionando la lista con el adaptador
            mLeadsList.setAdapter(mLeadsAdapter);

            return root;
        }
}