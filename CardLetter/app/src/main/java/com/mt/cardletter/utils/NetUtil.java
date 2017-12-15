package com.mt.cardletter.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;


public class NetUtil {
    public static final int NETWORN_NONE = 0;
    public static final int NETWORN_WIFI = 1;
    public static final int NETWORN_MOBILE = 2;

    /**
     * 获取网络状态
     *
     * @param context
     * @return
     */
    public static int getNetworkState(Context context) {
        ConnectivityManager connManager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        // Wifi
        NetworkInfo.State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORN_WIFI;
        }

        // 3G
        state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .getState();
        if (state == NetworkInfo.State.CONNECTED || state == NetworkInfo.State.CONNECTING) {
            return NETWORN_MOBILE;
        }
        return NETWORN_NONE;
    }

    /**
     * 获取当前网络状态
     *
     * @param context 上下文
     * @return 网络连接返回true；未连接返回false
     */
    public static boolean getNetworkIsConnected(Context context) {
        // 获取网络连接管理器
        ConnectivityManager manager = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        // 如果管理器为null，返回false
        if (manager == null) {
            return false;
        }
        // 获取正在活动的网络信息
        NetworkInfo info = manager.getActiveNetworkInfo();
        // 如果网络信息为null，返回false
        if (info == null) {
            return false;
        }
        // 返回网络是否连接
        return info.isConnected();
    }

    /**
     * 网络类型
     *
     * @param context
     * @return true ：是，false ：否
     */
    public static boolean isWiFi(Context context) {
        ConnectivityManager connectMgr = (ConnectivityManager) context

                .getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo info = connectMgr.getActiveNetworkInfo();
        if (info == null) {
            return false;
        } else {
            if (info.getType() == ConnectivityManager.TYPE_WIFI) {
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * 该方法用于当下载数据错误时提示用户
     * @param context
     * @param msg 当网络状态良好时,提示的内容
     *  2017年9月25
     *  GG小鬼
     */
    public static void showNetError(Context context,String msg){
        boolean isConnected = getNetworkIsConnected(context);
        if (isConnected){
            ToastUtils.makeShortText(msg,context);
        }else{
            ToastUtils.makeShortText("请检查您的网络",context);
        }
    }
//    /**
//     * 单点登录显示的dialog
//     * @param context
//     */
//    public static void showAlertDialog(final Activity context) {
//        CustomDialog.Builder builder = new CustomDialog.Builder(context);
//        builder.setMessage("您的账号出现异常，已在其他设备登录!");
//        builder.setTitle("警告");
//        builder.setPositiveButton("退出登录", new DialogInterface.OnClickListener() {
//            public void onClick(DialogInterface dialog, int which) {
//                dialog.dismiss();
//                UIHelper.showLogin(context);
//            }
//        });
//        builder.create().show();
//    }
}
