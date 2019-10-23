package com.example.test.myapplication;

import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView mMainNav;
    private FrameLayout mMainFrame;

    private HomeFragment homeFragment;
    private FeedbackFragment feedbackFragment;
    private FundraisingFragment fundraisingFragment;
    private ShopFragment shopFragment;
    private AccountFragment accountFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //color status bar
        if (Build.VERSION.SDK_INT >= 21){
            Window window = this.getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            window.setStatusBarColor(this.getResources().getColor(R.color.colorBlack));
        }


        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);

        mMainFrame = (FrameLayout) findViewById(R.id.main_frame);
        mMainNav = (BottomNavigationView) findViewById(R.id.navigation);

        homeFragment = new HomeFragment();
        fundraisingFragment = new FundraisingFragment();
        feedbackFragment = new FeedbackFragment();
        shopFragment = new ShopFragment();
        accountFragment = new AccountFragment();

        mMainNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_home:
                        setFragment(homeFragment);
                        return true;

                    case R.id.nav_fundraising:
                        setFragment(fundraisingFragment);
                        return true;

                    case R.id.nav_feedback:
                        setFragment(feedbackFragment);
                        return true;

                    case R.id.nav_shop:
                        setFragment(shopFragment);
                        return true;

                    case R.id.nav_account:
                        setFragment(accountFragment);
                        return true;

                        default:
                            return false;
                }
            }


        });

        setFragment(homeFragment);
    }

    private void setFragment(Fragment fragment) {

        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.main_frame, fragment);
        fragmentTransaction.commit();

    }
//    public interface Backable {
//        public void goBack();
//        public boolean canGoBack();
//    }

//    @Override
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
//        if (event.getAction()==KeyEvent.ACTION_DOWN){
//            switch (keyCode){
//                case KeyEvent.KEYCODE_BACK:
//                    if (homeFragment.canGoBack()){
//                        MainActivity.goback();
//                    }else{
//                        finish();
//                    }
//                    return true;
//            }
//        }
//        return super.onKeyDown(keyCode, event);
//    }
//@Override
//    public void onBackPressed() {
//
//        if(mMainFrame instanceof Backable) {
//            ((Backable) mMainFrame).canGoBack();
//            if(((Backable) mMainFrame).canGoBack()){
//                ((Backable) mMainFrame).goBack();
//
//            }else{
//                super.onBackPressed();
//            }
//        }else{
//            super.onBackPressed();
//    }
//
//}
}
