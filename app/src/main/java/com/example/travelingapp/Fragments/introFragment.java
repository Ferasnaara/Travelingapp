package com.example.travelingapp.Fragments;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.traveling.R;
import com.example.traviling.LoginSignUpForgetPassword.LoginFragment;

public class introFragment extends Fragment {
    public class DetailsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.intro_page);
        }
    }

    public void gotoLoginFragment(View view) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new LoginFragment());
        ft.commit();

    }
}
