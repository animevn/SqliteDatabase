package com.haanhgs.sqlitedatabase.ui.result;

import android.database.Cursor;
import com.haanhgs.sqlitedatabase.App;
import com.haanhgs.sqlitedatabase.DataHelper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultViewModel extends ViewModel {

    private final MutableLiveData<String> text;

    public ResultViewModel() {
        text = new MutableLiveData<>();

        DataHelper helper = new DataHelper(App.context());
        Cursor cursor = helper.selectAll();
        if (cursor != null){
            StringBuilder builder = new StringBuilder();
            while (cursor.moveToNext()){
                builder
                        .append(cursor.getString(0)).append(" - ")
                        .append(cursor.getString(1)).append(" - ")
                        .append(cursor.getString(2)).append(";").append("\n");
            }
            text.setValue(builder.toString());
        }
    }

    public LiveData<String> getText() {
        return text;
    }
}