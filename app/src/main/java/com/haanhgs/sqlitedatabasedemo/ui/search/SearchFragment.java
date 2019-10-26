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
import android.widget.TextView;
import com.haanhgs.sqlitedatabasedemo.DataHelper;
import com.haanhgs.sqlitedatabasedemo.R;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class SearchFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        final TextView tvSearchResult = view.findViewById(R.id.tvSearchResult);
        final EditText etSearchName = view.findViewById(R.id.etSearchName);
        Button bnSearch = view.findViewById(R.id.bnSearch);
        final DataHelper helper = new DataHelper(context);
        bnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etSearchName.getText())){
                    Cursor cursor = helper.selectName(etSearchName.getText().toString());
                    if (cursor != null){
                        StringBuilder builder = new StringBuilder();
                        while (cursor.moveToNext()){
                            builder
                                    .append(cursor.getString(0)).append(" - ")
                                    .append(cursor.getString(1)).append(" - ")
                                    .append(cursor.getString(2)).append(";").append("\n");
                        }
                        tvSearchResult.setText(builder);
                    }
                }
            }
        });

        return view;
    }
}