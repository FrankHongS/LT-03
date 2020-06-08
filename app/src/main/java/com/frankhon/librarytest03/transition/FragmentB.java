package com.frankhon.librarytest03.transition;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.transition.Transition;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import androidx.fragment.app.Fragment;

import com.frankhon.librarytest03.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Frank_Hon on 8/2/2019.
 * E-mail: v-shhong@microsoft.com
 */
public class FragmentB extends Fragment {

    @BindView(R.id.tv_b)
    TextView textB;
    @BindView(R.id.iv_b)
    ImageView imageB;

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_b, container, false);
        ButterKnife.bind(this, view);

        ViewCompat.setTransitionName(imageB, "hi");

        Transition changeBounds = TransitionInflater.from(getContext())
                .inflateTransition(R.transition.change_bounds);
        // enter
        setSharedElementEnterTransition(changeBounds);

//        setExitTransition();
        // return
//        setSharedElementReturnTransition(changeBounds);
//        Fragment parentFragment = getParentFragment();
//        if (parentFragment != null) {
//            parentFragment.startPostponedEnterTransition();
//        }
        return view;
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}
