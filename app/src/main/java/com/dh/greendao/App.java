package com.dh.greendao;

import android.app.Application;

import com.dh.greendao.gen.DaoMaster;
import com.dh.greendao.gen.DaoSession;

import org.greenrobot.greendao.database.Database;

/**
 * Created by hpc on 2017-3-10.
 */

public class App extends Application {
    public static DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initGreenDao();
    }

    private void initGreenDao() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "test_db", null);
        Database db = devOpenHelper.getWritableDb();
        mDaoSession = new DaoMaster(db).newSession();
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
}
