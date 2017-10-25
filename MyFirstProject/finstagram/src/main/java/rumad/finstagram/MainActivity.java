package rumad.finstagram;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TabHost;

public class MainActivity extends AppCompatActivity {

    ViewPager mPager;
    ScreenSlidePagerAdapter mPagerAdapter;
    TabLayout mTabLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTabLayout=(TabLayout) findViewById(R.id.tab_host);

        mTabLayout.addTab(mTabLayout.newTab().setText("Feed"));
        mTabLayout.addTab(mTabLayout.newTab().setText("Profile"));

        mPager=(ViewPager)findViewById(R.id.view_pager);
        mPagerAdapter = new ScreenSlidePagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(mPagerAdapter);

        /*TabHost.TabSpec spec=mTabHost.newTabSpec("Feed");

        View v=getLayoutInflater().inflate(R.layout.fragment_home_screen,null);
        spec.setIndicator(v);
        spec.setContent(R.layout.fragment_home_screen);
        mTabHost.addTab(spec);

        View v2=getLayoutInflater().inflate(R.layout.cardlayout,null);
        TabHost.TabSpec spec2=mTabHost.newTabSpec("Profile");
        spec2.setIndicator(v2);
        spec2.setContent(R.layout.cardlayout);
        mTabHost.addTab(spec2);*/


    }

    class ScreenSlidePagerAdapter extends FragmentStatePagerAdapter{

        public ScreenSlidePagerAdapter(FragmentManager fragmentManager){
            super(fragmentManager);
        }
        @Override
        public Fragment getItem(int position) {
            return new HomeScreen();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }




}
