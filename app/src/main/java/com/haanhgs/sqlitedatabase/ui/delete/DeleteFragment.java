package com.haanhgs.sqlitedatabase.ui.delete;

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

public class DeleteFragment extends Fragment {

    private Context context;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_delete, container, false);
        final EditText etDeleteName = view.findViewById(R.id.etDeleteName);
        Button bnDelete = view.findViewById(R.id.bnDelete);
        final DataHelper helper = new DataHelper(context);

        bnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!TextUtils.isEmpty(etDeleteName.getText())){
                    helper.delete(etDeleteName.getText().toString());
                }
            }
        });
        return view;
    }
}