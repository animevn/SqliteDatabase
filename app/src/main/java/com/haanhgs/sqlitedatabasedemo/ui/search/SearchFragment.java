package com.haanhgs.sqlitedatabasedemo.ui.search;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SearchView;
import android.widget.TextView;
import com.haanhgs.sqlitedatabasedemo.DataHelper;
import com.haanhgs.sqlitedatabasedemo.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class SearchFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final TextView tvSearchResult = view.findViewById(R.id.tvSearchResult);
        final EditText etSearchName = view.findViewById(R.id.etSearchName);
        final SearchViewModel viewModel = new ViewModelProvider(this).get(SearchViewModel.class);
        viewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(String string) {
                if (string != null) tvSearchResult.setText(string);
            }
        });
        Button bnSearch = view.findViewById(R.id.bnSearch);
        bnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etSearchName.getText())){
                    viewModel.setText(etSearchName.getText().toString());
                }
            }
        });

        return view;
    }
}