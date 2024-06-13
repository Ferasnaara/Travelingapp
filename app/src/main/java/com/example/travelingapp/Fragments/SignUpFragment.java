package com.example.travelingapp.Fragments;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.travelingapp.Fragments.FirebaseServices;
import com.example.travelingapp.Homepage;
import com.example.travelingapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;

public class SignUpFragment extends Fragment {
    private Button btnSignUpSIGNUP;
    private EditText etUsernameSIGNUP,etPasswordSIGNUP;
    private com.example.travelingapp.Fragments.FirebaseServices fbs;

    private static final String ARG_P1 = "p1";
    private static final String ARG_P2 = "p2";

    private String mP1;
    private String mP2;

    public SignUpFragment() {
    }


    public static SignUpFragment newInstance(String p1, String p2) {
        SignUpFragment fragment = new SignUpFragment();
        Bundle args = new Bundle();
        args.putString(ARG_P1, p1);
        args.putString(ARG_P2, p2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mP1 = getArguments().getString(ARG_P1);
            mP2 = getArguments().getString(ARG_P2);
        }
    }



    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    public void onStart() {
        super.onStart();
        connect();
    }

    private void connect() {
        etUsernameSIGNUP = getView().findViewById(R.id.etEmailSignup);
        etPasswordSIGNUP = getView().findViewById(R.id.etPasswordSignup);
        btnSignUpSIGNUP = getView().findViewById(R.id.btnSignupSignup);
        fbs= FirebaseServices.getInstance();
        btnSignUpSIGNUP.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                String eMail = etUsernameSIGNUP.getText().toString();
                String password = etPasswordSIGNUP.getText().toString();
                if (eMail.trim().isEmpty() ||
                        password.trim().isEmpty()) {
                    Toast.makeText(getActivity(), "some fields are empty!!!!", Toast.LENGTH_SHORT).show();
                    return;
                }
                fbs.getAuth().createUserWithEmailAndPassword(eMail, password).addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>()
                {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task)
                    {
                        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.frameLayoutMain, new introFragment());
                        ft.commit();


                    }
                });
            }
        });
    }

}