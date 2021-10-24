package com.example.calculator;

import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class upper_ans extends Fragment {

    private LowerOperationViewModel mViewModel;
    TextView textView;
    public static upper_ans newInstance() {
        return new upper_ans();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.upper_ans_fragment, container, false);
        textView=view.findViewById(R.id.hi);
        mViewModel=new ViewModelProvider(requireActivity()).get(LowerOperationViewModel.class);
        mViewModel.getitem().observe(getViewLifecycleOwner(), new Observer<CharSequence>() {
            @Override
            public void onChanged(CharSequence charSequence) {
                textView.setText(charSequence);
            }
        });
        return view;
    }
}