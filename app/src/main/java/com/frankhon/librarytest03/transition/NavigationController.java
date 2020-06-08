package com.frankhon.librarytest03.transition;

import android.util.Pair;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.frankhon.librarytest03.R;

/**
 * Created by Frank_Hon on 8/2/2019.
 * E-mail: v-shhong@microsoft.com
 */
public class NavigationController {

    private FragmentManager fragmentManager;

    public NavigationController(AppCompatActivity activity) {
        this.fragmentManager = activity.getSupportFragmentManager();
    }

    public void init(Fragment fragment) {
        fragmentManager.beginTransaction()
                .add(R.id.fragment_container, fragment)
                .commit();
    }

    public void navigateTo(Fragment target) {
        fragmentManager.beginTransaction()
                .replace(R.id.fragment_container, target)
                .addToBackStack(null)
                .commit();
    }

    public void navigateTo(Fragment target, Pair<View, String> sharedElement) {
        fragmentManager.beginTransaction()
                .addSharedElement(sharedElement.first, sharedElement.second)
                .replace(R.id.fragment_container, target)
                .addToBackStack(null)
                .commit();
    }

}
