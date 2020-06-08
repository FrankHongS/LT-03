package com.frankhon.librarytest03.transition;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.frankhon.librarytest03.MainActivity;
import com.frankhon.librarytest03.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Frank_Hon on 8/2/2019.
 * E-mail: v-shhong@microsoft.com
 */
public class FragmentA extends Fragment {

    @BindView(R.id.btn_navigate)
    Button navigate;
    @BindView(R.id.tv_a)
    TextView textA;
    @BindView(R.id.iv_a)
    ImageView imageA;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        ButterKnife.bind(this, view);

        ViewCompat.setTransitionName(imageA,"hi");

        postponeEnterTransition();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navigate.setOnClickListener(v -> {
            Activity activity = getActivity();
            if (activity != null) {
                Pair<View, String> pair = new Pair<>(imageA, "hi");
                ((MainActivity) activity).navigateTo(new FragmentB(), pair);
            }
        });
    }
}
