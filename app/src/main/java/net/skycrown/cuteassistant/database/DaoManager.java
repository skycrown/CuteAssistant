package net.skycrown.cuteassistant.database;

import net.skycrown.cuteassistant.base.MainApplication;

import org.greenrobot.greendao.query.QueryBuilder;

/**
 * Created by skycrown on 2018/6/17.
 * 数据库管理类
 */

public enum DaoManager {
    INSTANCE;
    private static final String TAG = "DaoManager";
    private static final String DATABASE_NAME = "cute_assistant.db";
    private DaoMaster mDaoMaster;
    private DaoMaster.DevOpenHelper mHelper;
    private DaoSession mDaoSession;

    DaoManager() {
        mHelper = new DaoMaster.DevOpenHelper(MainApplication.getInstance(), DATABASE_NAME, null);
        mDaoMaster = new DaoMaster(mHelper.getWritableDatabase());
        mDaoSession = mDaoMaster.newSession();
    }

    public DaoMaster getDaoMaster() {
        return mDaoMaster;
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    public void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }

    public void closeDaoSession() {
        if (mDaoSession != null) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    public void closeConnection() {
        closeHelper();
        closeDaoSession();
    }



    public void setDebug() {
        QueryBuilder.LOG_SQL = true;
        QueryBuilder.LOG_VALUES = true;
    }
}
