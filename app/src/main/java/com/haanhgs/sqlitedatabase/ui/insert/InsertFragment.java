package com.haanhgs.sqlitedatabase.ui.insert;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import com.haanhgs.sqlitedatabase.DataHelper;
import com.haanhgs.sqlitedatabase.R;

public class InsertFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_insert, container, false);
        final EditText etInsertName = view.findViewById(R.id.etInsertName);
        final EditText etInsertAge = view.findViewById(R.id.etInsertAge);
        Button bnInsert = view.findViewById(R.id.bnInsert);
        final DataHelper helper = new DataHelper(context);

        bnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isNameOk = !TextUtils.isEmpty(etInsertName.getText());
                boolean isAgeOk = !TextUtils.isEmpty(etInsertAge.getText());
                if (isNameOk && isAgeOk){
                    helper.insert(
                            etInsertName.getText().toString(),
                            etInsertAge.getText().toString());
                }
            }
        });
        return view;
    }
}