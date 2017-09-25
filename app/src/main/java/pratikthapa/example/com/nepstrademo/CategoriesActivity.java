package pratikthapa.example.com.nepstrademo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.BottomBarTab;
import com.roughike.bottombar.OnTabSelectListener;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;


public class CategoriesActivity extends AppCompatActivity  {
    Spinner spinnerStates;
    CarouselView carouselview;
    ArrayAdapter<CharSequence> adapter;
    BottomBar bottomBar;
    ViewPager viewPager;
    int[] images = {R.drawable.nepstrab, R.drawable.nepstraa, R.drawable.nepstrac};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

    /*    spinnerStates = (Spinner) findViewById(R.id.spinner_states);
        adapter = ArrayAdapter.createFromResource(this, R.array.states_names, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerStates.setAdapter(adapter);*/

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
     /*   ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();



     /*   TabLayout tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.addTab(tabLayout.newTab().setText("Products"));
        tabLayout.addTab(tabLayout.newTab().setText("Search"));
//
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        viewPager = (ViewPager) findViewById(R.id.pager);
        final PagerrAdapter adapter = new PagerrAdapter(getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(adapter);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

*/


        bottomBar = (BottomBar) findViewById(R.id.bottomBarcategories);
        BottomBarTab dummy = bottomBar.getTabWithId(R.id.tab_home1);
        dummy.setVisibility(View.GONE);

        bottomBar.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelected(@IdRes int tabId) {
                switch (tabId) {
                    case R.id.tab_home1:
                        break;

                    case R.id.tab_home:
                       Intent home = new Intent(CategoriesActivity.this, MainActivity.class);
                       startActivity(home);


                    case R.id.tab_products:
                        Toast.makeText(CategoriesActivity.this, "Products", Toast.LENGTH_SHORT).show();
                 //       Intent ij = new Intent(CategoriesActivity.this, OrderActivity.class);
                 //       startActivity(ij);

                        break;
                    case R.id.tab_order:
                        Intent order = new Intent(CategoriesActivity.this, OrderActivity.class);
                        startActivity(order);


                    case R.id.tab_account:
                        Intent iin = new Intent(CategoriesActivity.this, LoginActivity.class);
                        startActivity(iin);
                        break;
                    default:
                        break;

                }
            }
        });



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_search, menu);

        MenuItem search = menu.findItem(R.id.search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(search);
        return true;
    }
    ImageListener imagelistener = new ImageListener() {
        @Override
        public void setImageForPosition(int position, ImageView imageView) {
            imageView.setImageResource(images[position]);
        }
    };



    }




