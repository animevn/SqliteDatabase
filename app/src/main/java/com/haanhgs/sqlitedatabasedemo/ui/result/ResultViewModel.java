package com.haanhgs.sqlitedatabasedemo.ui.result;

import android.database.Cursor;
import com.haanhgs.sqlitedatabasedemo.App;
import com.haanhgs.sqlitedatabasedemo.DataHelper;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class ResultViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public ResultViewModel() {
        mText = new MutableLiveData<>();

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
            mText.setValue(builder.toString());
        }
    }

    public LiveData<String> getText() {
        return mText;
    }
}