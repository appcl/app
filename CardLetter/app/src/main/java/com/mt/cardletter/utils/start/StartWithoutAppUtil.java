package com.mt.cardletter.utils.start;


import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Looper;
import android.util.Log;
import android.widget.Toast;


import com.mt.cardletter.utils.ToastUtils;

import java.util.List;

/**
 * Created by jk on 2018/3/5.
 */

public class StartWithoutAppUtil {

    public static void doStartApplicationWithPackageName(Context context, String packagename,String errorString) {
        getAppList(context);
        // 通过包名获取此APP详细信息，包括Activities、services、versioncode、name等等
        PackageInfo packageinfo = null;
        try {
            packageinfo = context.getPackageManager().getPackageInfo(packagename, 0);
            Log.d("jk--", packageinfo.toString());

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        if (packageinfo == null) {
            Looper.prepare();
            Toast.makeText(context, "这是一个Toast222", Toast.LENGTH_SHORT).show();
            Looper.loop();

            System.out.println("jj-----------------------请下载----");
            return;
        }
        // 创建一个类别为CATEGORY_LAUNCHER的该包名的Intent
        Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
        //resolveIntent.addCategory(Intent.CATEGORY_DEFAULT);
        resolveIntent.setPackage(packageinfo.packageName);
        // 通过getPackageManager()的queryIntentActivities方法遍历
        List<ResolveInfo> resolveinfoList = context.getPackageManager()
                .queryIntentActivities(resolveIntent, 0);

        Log.d("jk--", "resolveinfoList.size::"+resolveinfoList.size());

        ResolveInfo resolveinfo = resolveinfoList.iterator().next();
        if (resolveinfo != null) {
            // packagename = 参数packname
            String packageName = resolveinfo.activityInfo.packageName;
            // 这个就是我们要找的该APP的LAUNCHER的Activity[组织形式：packagename.mainActivityname]
            String className = resolveinfo.activityInfo.name;
            // LAUNCHER Intent
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_LAUNCHER);
            System.out.println("jk--aaaaaaa---"+className);
            // 设置ComponentName参数1:packagename参数2:MainActivity路径
            ComponentName cn = new ComponentName(packageName, className);

            intent.setComponent(cn);
            context.startActivity(intent);
        }else{
            Log.d("jk--", "resolveinfo == null");
            ToastUtils.makeShortText("请下载 \"errorString\" APP",context);
        }
    }

    private static void getAppList(Context context) {
        PackageManager pm = context.getPackageManager();
        // Return a List of all packages that are installed on the device.
        List<PackageInfo> packages = pm.getInstalledPackages(0);

        for (PackageInfo packageInfo : packages) {
            // 判断系统/非系统应用
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) == 0) // 非系统应用
            {
                String s = packageInfo.applicationInfo.loadLabel(context.getPackageManager()).toString();
                String className = packageInfo.applicationInfo.className;
                String s1 = "";
                if (className!=null){
                    s1 = className;
                }
                System.out.println("jk--packageInfo:  " + packageInfo.packageName+"---------"+s+"-----"+s1);
            } else {
                // 系统应用
            }
        }
    }
}
