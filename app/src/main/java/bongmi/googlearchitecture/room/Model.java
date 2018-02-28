package bongmi.googlearchitecture.room;

import android.arch.persistence.room.PrimaryKey;

/**
 * Id 和 id 大小写敏感
 * Copyright (c) 2018, Bongmi
 * All rights reserved
 * Author: wangjunjie@bongmi.com
 */

public class Model {
  @PrimaryKey(autoGenerate = true)
  private int Id;

  public int getId() {
    return Id;
  }

  public void setId(int id) {
    Id = id;
  }
}
