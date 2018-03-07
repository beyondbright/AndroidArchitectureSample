package bongmi.googlearchitecture.room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

/**
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

@Entity
public class User extends Model {

  @ColumnInfo(name = "first_name")
  private String firstName;

  @ColumnInfo(name = "last_name")
  private String lastName;

  @ColumnInfo(name = "count")
  private int count;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public int getCount() {
    return count;
  }

  public void setCount(int count) {
    this.count = count;
  }
}
