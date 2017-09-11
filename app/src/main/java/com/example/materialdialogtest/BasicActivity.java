package com.example.materialdialogtest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.afollestad.materialdialogs.MaterialDialog;

import java.util.List;

public class BasicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
     * Create by Yuki on 2017/9/8 0008 15:41
     *
     * @Description: 吐司
     * @Params:msg
     * @Return:void
     */
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    /**
     * Create by Yuki on 2017/9/8 0008 15:39
     *
     * @Description: 默认询问对话框
     * @Params:context, content, callback
     * @Return:void
     */
    public void showAskDialog(Context context, String content, MaterialDialog.SingleButtonCallback listenOK) {
        new MaterialDialog.Builder(context)
                .title("请注意")
                .iconRes(R.drawable.gray_circle)
                .content(content)
                .positiveText("确定")
                .negativeText("取消")
                .onPositive(listenOK)
                .show();
    }
    public void showMoreAskDialog(Context context,String title,int iconId, String content,String positiveText,String negativeText, MaterialDialog.SingleButtonCallback listenOK) {
        new MaterialDialog.Builder(context)
                .title(title)
                .iconRes(iconId)
                .content(content)
                .positiveText(positiveText)
                .negativeText(negativeText)
                .onPositive(listenOK)
                .show();
    }

    /**
     * Create by Yuki on 2017/9/8 0008 16:13
     *
     * @Description:列表选择对话框
     * @Params:
     * @Return:void
     */
    public void showListDialog(Context context, String content, List items, MaterialDialog.ListCallback listCallback) {
        new MaterialDialog.Builder(context)
                .title("请选择")
                .iconRes(R.drawable.gray_circle)
                .content(content)
                .items(items)
                .itemsCallback(listCallback)
                .show();
    }
/**
 *Create by Yuki on 2017/9/8 0008 17:12
 *@Description: 多选对话框
 *@Params:
 *@Return:
 */
    public void showMutiCheckDialog(Context context, String content, List items, MaterialDialog.SingleButtonCallback listenOk){

        new MaterialDialog.Builder(context)
                .title("请选择")
                .positiveText("确定")
                .negativeText("取消")
                .iconRes(R.drawable.gray_circle)
                .content(content)
                .items(items)
                //多选框添加
                .itemsCallbackMultiChoice(null, new MaterialDialog.ListCallbackMultiChoice() {
                    @Override
                    public boolean onSelection(MaterialDialog dialog, Integer[] which, CharSequence[] text) {


                        return true;//false 的时候没有选中样式
                    }
                })
                .onPositive(listenOk)
                .show();
    }

}