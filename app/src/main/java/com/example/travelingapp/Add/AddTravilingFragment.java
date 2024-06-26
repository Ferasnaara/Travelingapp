package com.example.travelingapp.Add;
import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.example.travelingapp.R;
import com.example.travelingapp.Fragments.FirebaseServices;
import com.example.travelingapp.Traveling;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;


    public class AddTravilingFragment extends Fragment {

    private FirebaseServices fbs;
    private EditText etName, etDescription, etAddress, etPhone;
    private Button btnAdd;


    private static final String ARG_P1 = "p1";
    private static final String ARG_P2 = "p2";

    private String mParam1;
    private String mParam2;

    public AddTravilingFragment() {
    }
    public static AddTravilingFragment newInstance(String param1, String param2) {
        AddTravilingFragment fragment = new AddTravilingFragment();
        Bundle args = new Bundle();
        args.putString(ARG_P1, param1);
        args.putString(ARG_P2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_P1);
            mParam2 = getArguments().getString(ARG_P2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_main, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();

        connectComponents();

    }

    @SuppressLint("WrongViewCast")
    private void connectComponents() {
        fbs = FirebaseServices.getInstance();
        etName = getView().findViewById(R.id.btnSignupLogin);
        etDescription = getView().findViewById(R.id.btnBackSignup);
        etAddress = getView().findViewById(R.id.btnBackSignup);
        etPhone = getView().findViewById(R.id.btnSignupLogin);
        btnAdd = getView().findViewById(R.id.btnSignupLogin);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // get data from screen
                String name = etName.getText().toString();
                String description = etDescription.getText().toString();
                String address = etAddress.getText().toString();
                String phone = etPhone.getText().toString();

                if (name.trim().isEmpty() || description.trim().isEmpty() ||
                        address.trim().isEmpty() || phone.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "Some fields are empty!", Toast.LENGTH_LONG).show();
                    return;
                }

                Traveling traveling= new Traveling(name, description, address, phone);

                fbs.getFire().collection("restaurants").add(fbs).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(getActivity(), "Successfully added your restaurant!", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.e("Failure AddRestaurant: ", e.getMessage());
                    }
                });


            }
        });
    }
}
