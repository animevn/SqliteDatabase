package com.haanhgs.sqlitedatabasedemo.ui.result;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import com.haanhgs.sqlitedatabasedemo.R;

public class ResultFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        ResultViewModel resultViewModel = ViewModelProviders.of(this).get(ResultViewModel.class);
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        final TextView tvSearchAllResult = view.findViewById(R.id.tvSearchAllResult);
        resultViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                tvSearchAllResult.setText(s);
            }
        });
        return view;
    }
}