package bongmi.mylibrary;

import java.util.List;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

/**
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

@Dao
public interface UserDao {
  @Query("SELECT * FROM user limit 1")
  User get();

  @Query("SELECT * FROM user")
  List<User> getAll();

  @Query("SELECT * FROM user WHERE id IN (:userIds)")
  List<User> loadAllByIds(int[] userIds);

  @Query("SELECT * FROM user WHERE first_name LIKE :first AND "
      + "last_name LIKE :last LIMIT 1")
  User findByName(String first, String last);

  @Insert
  void insertAll(User... users);

  @Delete
  void delete(User user);

  @Query("delete from user")
  void deleteAll();

  @Update
  void update(User user);

  @Query("select count(*) from user")
  int count();
}
