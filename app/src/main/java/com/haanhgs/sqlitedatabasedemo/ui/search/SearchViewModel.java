package com.haanhgs.sqlitedatabasedemo.ui.search;

import android.database.Cursor;
import com.haanhgs.sqlitedatabasedemo.App;
import com.haanhgs.sqlitedatabasedemo.DataHelper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SearchViewModel extends ViewModel {

    private final MutableLiveData<String> text = new MutableLiveData<>();

    public LiveData<String> getText() {
        return text;
    }

    public void setText(String name){
        DataHelper helper = new DataHelper(App.context());
        Cursor cursor = helper.selectName(name);
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
}