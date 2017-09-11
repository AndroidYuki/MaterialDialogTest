package com.example.materialdialogtest;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class MainActivity extends BasicActivity {
    public static final String TAG = "RxJava";
    @BindView(R.id.btn_dialog)
    Button btnDialog;
    @BindView(R.id.btn_list_dialog)
    Button btnListDialog;
    @BindView(R.id.btn_check_dialog)
    Button btnCheckDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);//绑定butterknife

        //创建一个上游

        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onNext(3);
                emitter.onComplete();
            }
        });
        //创建一个下游
        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable d) {
                Log.d(TAG, "subscribe");
            }

            @Override
            public void onNext(Integer value) {
                Log.d(TAG, "" + value);
            }

            @Override
            public void onError(Throwable e) {
                Log.d(TAG, "error");
            }

            @Override
            public void onComplete() {
                Log.d(TAG, "complete");
            }
        };
//建立连接
        observable.subscribe(observer);


    }


    @OnClick({R.id.btn_dialog, R.id.btn_list_dialog, R.id.btn_check_dialog})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_dialog:
                showAskDialog(MainActivity.this, "hahahahhahahah", new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        showToast("确定");

                    }
                });
                break;
            case R.id.btn_list_dialog:
                TestBean bean = new TestBean();
                bean.setName("xiaom");
                bean.setAge(11);
                ArrayList<TestBean> beans = new ArrayList<>();
                beans.add(bean);
                showListDialog(MainActivity.this, "列表列表列表", beans, null);
                break;
            case R.id.btn_check_dialog:
                TestBean bean2 = new TestBean();
                bean2.setName("xiaom");
                bean2.setAge(11);
                TestBean bean3 = new TestBean();
                bean3.setName("xiaosdfm");
                bean3.setAge(13);
                ArrayList<TestBean> beans2 = new ArrayList<>();
                beans2.add(bean2);
                beans2.add(bean3);
                showMutiCheckDialog(MainActivity.this, "多选多选",beans2, new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {

                        showToast("选中了" + dialog.getSelectedIndices().length );

                    }
                });
                break;
        }
    }
}
