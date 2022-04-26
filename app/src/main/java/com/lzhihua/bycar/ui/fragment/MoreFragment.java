package com.lzhihua.bycar.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.lzhihua.bycar.R;
import com.lzhihua.bycar.databinding.MoreFragmentBinding;
import com.lzhihua.bycar.ui.ReleaseMessageactivity;

public class MoreFragment extends Fragment {
    private MoreFragmentBinding binding;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding=MoreFragmentBinding.inflate(inflater);
        binding.momentTopSubmit.setOnClickListener(view -> {
            Intent intent=new Intent(getContext(), ReleaseMessageactivity.class);
            startActivity(intent);
        });
        return binding.getRoot();
    }
}
