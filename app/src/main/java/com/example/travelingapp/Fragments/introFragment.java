package com.example.travelingapp.Fragments;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.travelingapp.Homepage;
import com.example.travelingapp.R;
import com.example.travelingapp.Fragments.LoginFragment;

public class introFragment extends Fragment {
    Button btnStart;
    public class DetailsActivity extends AppCompatActivity {

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.intro_page);
            btnStart = getView().findViewById(R.id.btnStartMain);

            btnStart.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(getActivity(), Homepage.class);
                    startActivity(i);
                    (getActivity()).overridePendingTransition(0, 0);
                }
            });
        }
    }

    public void gotoLoginFragment(View view) {
        FragmentTransaction ft = getActivity().getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.frameLayoutMain, new LoginFragment());
        ft.commit();

    }
}
