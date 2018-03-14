package bongmi.googlearchitecture;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import bongmi.googlearchitecture.room.AppDatabase;
import bongmi.mylibrary.User;
import bongmi.mylibrary.UserDao;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
  private static final String TAG = "MainActivity";
  private UserDao userDao;

  private void addUser() {
    User user = new User();
    user.setFirstName("first name");
    user.setLastName("last name");
    user.setCount(11);
    userDao.insertAll(new User[]{user});
  }

  private void deleteAllUser() {
    userDao.deleteAll();
  }

  private void updateUser() {
    User user = userDao.get();
    user.setCount(0);
    user.setFirstName("update last");
    userDao.update(user);
  }

  private void query() {
    User user = userDao.findByName("first name", "last name");
    Log.d(TAG, user.toString());
    user = userDao.testFindByName("first_name LIKE 'first name'");
    if (user != null) {
      Log.d(TAG, user.toString());
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Log.d(TAG, "onCreate : " + Thread.currentThread().getName());
    Observable.create(new ObservableOnSubscribe<Object>() {
      @Override
      public void subscribe(ObservableEmitter<Object> e) throws Exception {
        Log.d(TAG, "subscribe : " + Thread.currentThread().getName());
        userDao = AppDatabase.getDatabase(getApplicationContext()).getUserDao();
        addUser();
        query();
        Log.d(TAG, "subscribe : count : " + userDao.count());
        e.onNext("onNext");
      }
    }).subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<Object>() {
          @Override
          public void onSubscribe(Disposable d) {
            Log.d(TAG, "onSubscribe : " + Thread.currentThread().getName());
          }

          @Override
          public void onNext(Object o) {
            Log.d(TAG, o + " : " + Thread.currentThread().getName());
            onComplete();
          }

          @Override
          public void onError(Throwable e) {
            Log.d(TAG, e + " : " + Thread.currentThread().getName());
          }

          @Override
          public void onComplete() {
            Log.d(TAG, "onComplete : " + Thread.currentThread().getName());
          }
        });
  }
}
