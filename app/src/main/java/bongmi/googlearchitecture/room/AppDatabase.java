package bongmi.googlearchitecture.room;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.migration.Migration;
import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

@Database(entities = {User.class}, version = 2)
public abstract class AppDatabase extends RoomDatabase {
  private static final String TAG = "AppDatabase";
  private static AppDatabase sInstance;

  public static AppDatabase getDatabase(Context context) {
    if (sInstance == null) {
      sInstance = Room.databaseBuilder(context.getApplicationContext(),
          AppDatabase.class, "bongmi.db")
          .addCallback(new Callback() {
            @Override
            public void onCreate(@NonNull SupportSQLiteDatabase db) {
              Log.d(TAG, "onCreate");
            }

            @Override
            public void onOpen(@NonNull SupportSQLiteDatabase db) {
              Log.d(TAG, "onOpen");
            }
          }).addMigrations(new Migration(1, 2) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {

            }
          }).build();
    }
    return sInstance;
  }

  public static void onDestroy() {
    sInstance = null;
  }

  public abstract UserDao getUserDao();
}
