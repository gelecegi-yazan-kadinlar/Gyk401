package com.gyk.gyk401;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import static android.content.ContentValues.TAG;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link HomeFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment {

    private EditText editTextBoy;
    private EditText editTextKilo;


    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public HomeFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        editTextBoy = (EditText) view.findViewById(R.id.editTextBoy);
        editTextKilo = (EditText) view.findViewById(R.id.editTextKilo);
        Button buttonHesapla = (Button) view.findViewById(R.id.buttonHesapla);

        buttonHesapla.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    if (editTextBoy.getText().toString().isEmpty()) {
                        editTextBoy.setError("Boy boş bırakılamaz!");

                        return;
                    }
                    if (editTextKilo.getText().toString().isEmpty()) {
                        editTextKilo.setError("Kilo boş bırakılamaz!");
                        return;
                    }
                    double boy = Double.valueOf(editTextBoy.getText().toString());
                    double kilo = Double.valueOf(editTextKilo.getText().toString());
                    hesapla(boy, kilo);
                } catch (Exception e) {
                    Log.w(TAG, "onClick: ", e);
                }
            }
        });

        return view;
    }

    private void hesapla(double boy, double kilo) {

        boy = boy / 100;
        double endeks = (kilo / (boy * boy));
        String resultMessage = "";
        if (endeks < 15) {
            resultMessage = "Aşırı Zayıf";
        } else if (endeks > 15 && endeks <= 30) {
            resultMessage = "Zayıf";

        } else if (endeks > 30 && endeks <= 40) {
            resultMessage = "Normal";
        } else if (endeks > 40) {
            resultMessage = "Aşırı Şişman (Morbid Obez)";
        } else {
            resultMessage = "Aşırı Şişman (Morbid Obez)";
        }
        Toast.makeText(getContext(), ""+resultMessage, Toast.LENGTH_SHORT).show();

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
