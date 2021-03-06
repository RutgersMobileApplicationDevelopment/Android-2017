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
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import rumad.finstagram.retrofit.PokemonService;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="MainActivity";

    static final String PIC_URL="https://pi.tedcdn.com/r/pe.tedcdn.com/images/ted/2534551796ee0a2638b462ce82e33b65091b1d42_1600x1200.jpg?w=1200";
    static final String POKE_URL="http://pokeapi.co/api/v2/";
    ViewPager mPager;
    ScreenSlidePagerAdapter mPagerAdapter;
    TabLayout mTabLayout;
    Retrofit mRetrofit;
    PokemonService mPokemonService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRetrofit=new Retrofit.Builder().baseUrl(POKE_URL).build();
        mPokemonService=mRetrofit.create(PokemonService.class);
        Call<ResponseBody> pokeResponse=mPokemonService.getPokemon();
        pokeResponse.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try{
                    Log.d(TAG,response.body().string());
                }catch(IOException e){
                    Log.d(TAG,e.toString());
                }

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });











        Toolbar toolbar =(Toolbar)findViewById(R.id.toolbar_home);
        ImageView profileImage=(ImageView)findViewById(R.id.image_view_profile);
        Picasso.with(this).load(PIC_URL).resize(50,50).centerCrop().into(profileImage);

        setSupportActionBar(toolbar);
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
            return 1;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId()){
            case R.id.item_show_popup:{
                Toast toast=Toast.makeText(this,"This is a popup",Toast.LENGTH_LONG);
                toast.show();
                break;
            }
            case R.id.item_sign_out:{
                finish();
                break;
            }
        }
        return true;
    }
}
