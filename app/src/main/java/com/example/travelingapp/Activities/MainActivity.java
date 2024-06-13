package com.example.travelingapp.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.travelingapp.Fragments.FirebaseServices;
import com.example.travelingapp.Homepage;
import com.example.travelingapp.R;
import com.example.travelingapp.Fragments.ForgotPasswordFragment;
import com.example.travelingapp.Fragments.LoginFragment;
import com.example.travelingapp.Fragments.SignUpFragment;


public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirebaseServices fbs = FirebaseServices.getInstance();

        if (fbs.getAuth().getCurrentUser() != null) {
            Intent i = new Intent(this, Homepage.class);
            startActivity(i);
            ((Activity) this).overridePendingTransition(0, 0);
        }
        else {
            gotoLoginFragment();
        }
    }

    public void gotoSignUpFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new SignUpFragment());
        ft.commit();
    }

    private void gotoLoginFragment() {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new LoginFragment());
        ft.commit();
    }


    public void gotoForgotPasswordFragment(View view) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new ForgotPasswordFragment());
        ft.commit();
    }
}

