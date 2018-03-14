package bongmi.mylibrary

import android.arch.persistence.room.*

/**
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

@Dao
interface UserDao {
  @Query("SELECT * FROM user limit 1")
  fun get(): User

  @Query("SELECT * FROM user")
  fun getAll(): List<User>

  @Query("SELECT * FROM user WHERE id IN (:userIds)")
  fun loadAllByIds(userIds: IntArray): List<User>

  @Query("SELECT * FROM user WHERE first_name LIKE :first AND last_name LIKE :last LIMIT 1")
  fun findByName(first: String, last: String): User

  @Query("SELECT * FROM user WHERE :where LIMIT 1")
  fun testFindByName(where: String): User

  @Insert
  fun insertAll(users: Array<User>)

  @Delete
  fun delete(user: User)

  @Query("delete from user")
  fun deleteAll()

  @Update
  fun update(user: User)

  @Query("select count(*) from user")
  fun count(): Int
}
