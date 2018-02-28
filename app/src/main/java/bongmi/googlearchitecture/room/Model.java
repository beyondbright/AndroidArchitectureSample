package bongmi.googlearchitecture.room;

import android.arch.persistence.room.PrimaryKey;

/**
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

public class Model {
  @PrimaryKey(autoGenerate = true)
  private int mid;

  public int getMid() {
    return mid;
  }

  public void setMid(int mid) {
    this.mid = mid;
  }
}
