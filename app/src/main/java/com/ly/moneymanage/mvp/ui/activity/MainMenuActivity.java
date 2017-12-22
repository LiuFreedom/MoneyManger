package com.ly.moneymanage.mvp.ui.activity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;

import com.jess.arms.base.BaseActivity;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.ly.moneymanage.R;
import com.ly.moneymanage.di.component.DaggerMainMenuComponent;
import com.ly.moneymanage.di.module.MainMenuModule;
import com.ly.moneymanage.mvp.contract.MainMenuContract;
import com.ly.moneymanage.mvp.presenter.MainMenuPresenter;

import butterknife.BindView;

import static com.jess.arms.utils.Preconditions.checkNotNull;


public class MainMenuActivity extends BaseActivity<MainMenuPresenter> implements MainMenuContract.View {
    protected ActionBar supportActionBar;
    @BindView(R.id.toolbar_default)
    Toolbar toolbar;

    @Override
    public void setupActivityComponent(AppComponent appComponent) {
        DaggerMainMenuComponent //如找不到该类,请编译一下项目
                .builder()
                .appComponent(appComponent)
                .mainMenuModule(new MainMenuModule(this))
                .build()
                .inject(this);
    }

    @Override
    public int initView(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WindowManager.LayoutParams localLayoutParams = getWindow().getAttributes();
            localLayoutParams.flags = (WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS | localLayoutParams.flags);
        }
        return R.layout.test_layout; //如果你不需要框架帮你设置 setContentView(id) 需要自行设置,请返回 0
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            supportActionBar = getSupportActionBar();
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(ContextCompat.getColor(this, android.R.color.transparent));
        toolbar.setVisibility(View.GONE);
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(@NonNull String message) {
        checkNotNull(message);
        UiUtils.snackbarText(message);
    }

    @Override
    public void launchActivity(@NonNull Intent intent) {
        checkNotNull(intent);
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.nav_camera) {
//            // Handle the camera action
//        } else if (id == R.id.nav_gallery) {
//
//        } else if (id == R.id.nav_slideshow) {
//
//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        drawer.closeDrawer(GravityCompat.START);
//        return true;
//    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

//    public static class MyReceiver extends BroadcastReceiver {
//
//        @Override
//        public void onReceive(Context context, Intent intent) {
//            // TODO Auto-generated method stub
//            Log.d("MyTag", "onclock......................");
//            String msg = intent.getStringExtra("msg");
//            Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
//        }
//
//    }
//   //        //创建Intent对象，action为ELITOR_CLOCK，附加信息为字符串“你该打酱油了”
//        Intent intent = new Intent("ELITOR_CLOCK");
//        intent.putExtra("msg", "测试闹钟");
//
//        PendingIntent sender = PendingIntent.getBroadcast(MainMenuActivity.this, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);
//        AlarmManager am = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT && Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
//            am.setExact(AlarmManager.RTC_WAKEUP, 10000, sender);
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            mJobScheduler = (JobScheduler) getSystemService(Context.JOB_SCHEDULER_SERVICE);
//            JobInfo.Builder builder = new JobInfo.Builder(JOB_ID, new ComponentName(getPackageName(), JobSchedulerService.class.getName()));
//
//            builder.setPeriodic(60 * 1000); //每隔60秒运行一次
//            builder.setRequiresCharging(true);
//            builder.setPersisted(true);  //设置设备重启后，是否重新执行任务
//            builder.setRequiresDeviceIdle(true);
//
//            if (mJobScheduler.schedule(builder.build()) <= 0) {
//                //If something goes wrong
//            }
//        } else {
//            am.set(AlarmManager.RTC_WAKEUP, 10000, sender);
//        }
}
