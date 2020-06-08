package com.frankhon.librarytest03;

import android.os.Bundle;
import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.frankhon.librarytest03.transition.FragmentA;
import com.frankhon.librarytest03.transition.NavigationController;

public class MainActivity extends AppCompatActivity {

    private NavigationController navigationController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationController = new NavigationController(this);

        if (savedInstanceState==null){
            navigationController.init(new FragmentA());
        }
    }

    public void navigateTo(Fragment target) {
        navigationController.navigateTo(target);
    }

    public void navigateTo(Fragment target, Pair<View, String> sharedElement) {
        navigationController.navigateTo(target, sharedElement);
    }
}
