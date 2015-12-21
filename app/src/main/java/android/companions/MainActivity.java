package android.companions;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    static int comSizeSetup;
    static int comSize;
    static int statSize;
    //static String[] comName;

    static String[] companion_name;
    static int[] companion_gender;
    static int[] companion_face;
    static Companion[] homies;
    static Companion homie_1;
    static Companion homie_2;
    static Companion homie_3;
    static Companion homie_4;
    static Game party;

    static LinearLayout[] layout_companion =  new LinearLayout[comSize];
    static LinearLayout[] layout_companion_fitter =  new LinearLayout[comSize];
    static LinearLayout[] layout_companion_stats = new LinearLayout[comSize];
    static LinearLayout[] layout_companion_stats_row1 = new LinearLayout[comSize];
    static LinearLayout[] layout_companion_stats_row2 = new LinearLayout[comSize];
    static TextView[] textView_companion_stats_name = new TextView[comSize];
    static LinearLayout[][] layout_companion_stats_stat = new LinearLayout[comSize][statSize];
    static LinearLayout[][] layout_companion_stats_stat_bar = new LinearLayout[comSize][statSize];
    static ImageView[][] image_companion_stats_stat_image = new ImageView[comSize][statSize];
    static LinearLayout[] layout_companion_image_layout =  new LinearLayout[comSize];
    static ImageView[] image_companion_image = new ImageView[comSize];
    static LinearLayout[] layout_gap = new LinearLayout[comSize];
    static TextView[] textView_companion_shadow = new TextView[comSize];
    static TextView[] textView_companion_margin_1 = new TextView[comSize];

    static LinearLayout layout_logo;
    static TextView textView_welcome;
    static ImageView image_logo;
    static TextView textView_logo;
    static TextView textView_logo_add;

    static Button popupButton;
    static PopupMenu popupMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prime);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //LinearLayout[] layout_companion =  new LinearLayout[comSize];
        //LinearLayout[] layout_companion_stats = new LinearLayout[comSize];
        //ImageView[] image_companion_image = new ImageView[comSize];

        comSize = 0; //warning, just scale between 1-4
        statSize = 6; //warning, don't scale this value please
        //comName = new String[] { "Paula", "Michael", "Beate", "Knut"};


        //initialize for the companion constructor
        for (int i = 0; i < comSize; i++) {

            layout_companion[i] =  new LinearLayout(this);
            layout_companion_fitter[i] =  new LinearLayout(this);
            layout_companion_stats[i] = new LinearLayout(this);
            layout_companion_stats_row1[i] = new LinearLayout(this);
            layout_companion_stats_row2[i] = new LinearLayout(this);
            layout_companion_image_layout[i] = new LinearLayout(this);
            image_companion_image[i] = new ImageView(this);
            textView_companion_stats_name[i] = new TextView(this);
            layout_gap[i] = new LinearLayout(this);
            textView_companion_shadow[i] = new TextView(this);
            textView_companion_margin_1[i] = new TextView(this);

            for (int j = 0; j < statSize; j++) {
                layout_companion_stats_stat[i][j] = new LinearLayout(this);
                image_companion_stats_stat_image[i][j] = new ImageView(this);
                layout_companion_stats_stat_bar[i][j] = new LinearLayout(this);
            }
        }
        //initialize for a empty companion site
        layout_logo = new LinearLayout(this);
        textView_welcome = new TextView(this);
        image_logo = new ImageView(this);
        textView_logo = new TextView(this);
        textView_logo_add = new TextView(this);

        popupMenu = new PopupMenu(MainActivity.this, layout_logo);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        //if (id == R.id.action_settings) {
        //    return true;
        //}

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            int status = 1;
            int babble = 2;

            //Calculator, px to dpConverter (use dpConverter * x)
            int converter = 1;
            final float scale = getResources().getDisplayMetrics().density;
            int dpConv = (int) (converter * scale + 0.5f);

            // main Layout of all sites
            LinearLayout layout_main = (LinearLayout) rootView.findViewById(R.id.layout_main);
            layout_main.setGravity(Gravity.CENTER);

            // site constructor V1.1 " like an array ;) , hot! "
            if (getArguments().getInt(ARG_SECTION_NUMBER) == status) { //status site
                if (comSize >= 1) {
                    for (int i = 0; i < comSize; i++) {
                        layout_companion[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                        //layout_companion[i].setBackgroundColor(getResources().getColor(R.color.colorPrimarySoft));
                        //layout_companion[i].setBackgroundResource(R.drawable.rounded_full_stats_buttons_main);
                        layout_companion[i].setGravity(Gravity.CENTER);

                        layout_companion_fitter[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                        layout_companion_fitter[i].setGravity(Gravity.CENTER);
                        layout_companion_fitter[i].setBackgroundResource(R.drawable.rounded_full_stats_buttons_main);
                        //layout_companion_fitter[i].setBackgroundColor(getResources().getColor(R.color.colorPrimarySoft));

                        layout_companion_stats[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height
                        layout_companion_stats[i].setOrientation(LinearLayout.VERTICAL);
                        layout_companion_stats[i].setPadding((4 * dpConv), (4 * dpConv), (4 * dpConv), (4 * dpConv)); //left, top, right, bottom
                        layout_companion_stats[i].setGravity(Gravity.CENTER);
                        layout_companion_stats[i].setWeightSum(2);
                        //layout_companion_stats[i].setBackgroundColor(getResources().getColor(R.color.colorPrimarySoft));

                        layout_companion_stats_row1[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                        layout_companion_stats_row1[i].setGravity(Gravity.CENTER | Gravity.BOTTOM);
                        //layout_companion_stats_row1[i].setPadding(0, 0, 0, (4 * dpConv)); //left, top, right, bottom
                        layout_companion_stats_row2[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                        layout_companion_stats_row2[i].setGravity(Gravity.CENTER | Gravity.TOP);

                        for (int j = 0; j < statSize; j++) {
                            layout_companion_stats_stat[i][j].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                            layout_companion_stats_stat[i][j].setOrientation(LinearLayout.VERTICAL);
                            layout_companion_stats_stat[i][j].setBackgroundResource(R.drawable.rounded_full_stats_buttons_main);
                            layout_companion_stats_stat[i][j].setPadding((4 * dpConv), (4 * dpConv), (4 * dpConv), (4 * dpConv)); //left, top, right, bottom

                            image_companion_stats_stat_image[i][j].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height
                            switch (j) {
                                case 0:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_heart);
                                    break;
                                case 1:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_drink);
                                    break;
                                case 2:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_drop);
                                    break;
                                case 3:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_star);
                                    break;
                                case 4:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_food);
                                    break;
                                case 5:
                                    image_companion_stats_stat_image[i][j].setImageResource(R.drawable.icon_leaf);
                                    break;
                                default:
                                    break;
                            }

                            layout_companion_stats_stat_bar[i][j].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                        }


                        layout_companion_image_layout[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                        layout_companion_image_layout[i].setOrientation(LinearLayout.VERTICAL);
                        layout_companion_image_layout[i].setGravity(Gravity.CENTER);
                        layout_companion_image_layout[i].setPadding((8 * dpConv), (4 * dpConv), (8 * dpConv), (4 * dpConv)); //left, top, right, bottom
                        //layout_companion_image_layout[i].setBackgroundColor(getResources().getColor(R.color.colorPrimarySoft));

                        //image_companion_image[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                        image_companion_image[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                        image_companion_image[i].setImageResource(R.drawable.image_kids_owl);
                        image_companion_image[i].setPadding(0, (4 * dpConv), 0, (4 * dpConv)); //left, top, right, bottom

                        textView_companion_stats_name[i].setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT, 1)); //width, height, weight
                        textView_companion_stats_name[i].setText(companion_name[i]);
                        textView_companion_stats_name[i].setTextColor(getResources().getColor(R.color.colorSoftLight));

                        layout_gap[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                        layout_gap[i].setOrientation(LinearLayout.VERTICAL);

                        textView_companion_shadow[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (7 * dpConv))); //width, height
                        textView_companion_shadow[i].setBackgroundResource(R.drawable.shadow_devider);

                        textView_companion_margin_1[i].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, (9 * dpConv))); //width, height



                        //print view to the main layout
                        (layout_main).addView(layout_companion[i]);

                        if ((i + 1) % 2 != 0) {
                            layout_companion_fitter[i].setGravity(Gravity.CENTER | Gravity.RIGHT);
                        } else {
                            layout_companion_fitter[i].setGravity(Gravity.CENTER | Gravity.LEFT);
                        }

                        (layout_companion[i]).addView(layout_companion_fitter[i]);

                        if ((i + 1) % 2 != 0) {
                            layout_companion_image_layout[i].setGravity(Gravity.CENTER | Gravity.LEFT);
                            (layout_companion_fitter[i]).addView(layout_companion_image_layout[i]);
                            (layout_companion_fitter[i]).addView(layout_companion_stats[i]);
                        } else {
                            layout_companion_image_layout[i].setGravity(Gravity.CENTER | Gravity.RIGHT);
                            (layout_companion_fitter[i]).addView(layout_companion_stats[i]);
                            (layout_companion_fitter[i]).addView(layout_companion_image_layout[i]);
                        }
                        (layout_companion_image_layout[i]).addView(image_companion_image[i]);
                        (layout_companion_image_layout[i]).addView(textView_companion_stats_name[i]);
                        (layout_companion_stats[i]).addView(layout_companion_stats_row1[i]);
                        (layout_companion_stats[i]).addView(layout_companion_stats_row2[i]);

                        for (int j = 0; j < statSize; j++) {
                            if (j < (statSize / 2) ) {
                                (layout_companion_stats_row1[i]).addView(layout_companion_stats_stat[i][j]);
                            } else {
                                (layout_companion_stats_row2[i]).addView(layout_companion_stats_stat[i][j]);
                            }
                            (layout_companion_stats_stat[i][j]).addView(image_companion_stats_stat_image[i][j]);
                            (layout_companion_stats_stat[i][j]).addView(layout_companion_stats_stat_bar[i][j]);
                        }
                        (layout_main).addView(layout_gap[i]);
                        (layout_gap[i]).addView(textView_companion_shadow[i]);
                        (layout_gap[i]).addView(textView_companion_margin_1[i]);
                    }



                } else {

                    layout_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    //layout_logo.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDelight));
                    //layout_logo.setBackgroundResource(R.drawable.rounded_start);
                    layout_logo.setOrientation(LinearLayout.VERTICAL);
                    layout_logo.setGravity(Gravity.CENTER);
                    layout_logo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent setupActivity = new Intent(getContext(),CreateComActivity.class);
                            startActivity(setupActivity);
                            comSizeSetup = 1;
                        }
                    });

                    textView_welcome.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    textView_welcome.setText(R.string.not_found_but_welcome);
                    textView_welcome.setTypeface(null, Typeface.BOLD);

                    image_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    image_logo.setImageResource(R.drawable.image_start);
                    image_logo.setPadding((16 * dpConv), (16 * dpConv), (16 * dpConv), (16 * dpConv)); //left, top, right, bottom

                    textView_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    textView_logo.setText(R.string.not_found);
                    textView_logo.setTypeface(null, Typeface.BOLD);

                    textView_logo_add.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    textView_logo_add.setText(R.string.not_found_add);

                    (layout_main).addView(textView_welcome);
                    (layout_main).addView(layout_logo);
                    (layout_logo).addView(image_logo);
                    (layout_main).addView(textView_logo);
                    (layout_main).addView(textView_logo_add);
                }

            }

            if (getArguments().getInt(ARG_SECTION_NUMBER) == babble) { //babble site
                if (comSize >= 1) {

                } else {

                }
            }


            //freeze build layouts
            return rootView;
        }
    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.section_status);
                case 1:
                    return getString(R.string.section_babble);
                case 2:
                    return "SECTION 3";
            }
            return null;
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.stats) {
            // Handle the camera action
        } else if (id == R.id.guide) {

        } else if (id == R.id.legend) {

        } else if (id == R.id.rest_period) {

        } else if (id == R.id.tutorial) {

        } else if (id == R.id.reset) {

        } else if (id == R.id.sound_and_notification) {

        } else if (id == R.id.style) {

        } else if (id == R.id.about_companions) {

        } else if (id == R.id.bug_report) {

        } else if (id == R.id.what_is_new) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    int getComSizeSetup() {
        return comSizeSetup;
    }

    static public void setNewCompanions(String[] name, int[] gender, int[] face) {
        companion_name = name;
        companion_gender = gender;
        companion_face = face;
        comSize = companion_name.length;

        homie_1 = new Companion(companion_name[0], companion_gender[0], companion_face[0]);

        if (comSize > 1) {
            homie_2 = new Companion(companion_name[1], companion_gender[1], companion_face[1]);
        }
        if (comSize > 2) {
            homie_3 = new Companion(companion_name[2], companion_gender[2], companion_face[2]);
        }
        if (comSize > 3) {
            homie_4 = new Companion(companion_name[3], companion_gender[3], companion_face[3]);
        }

        for (int i = 0; i < comSize; i++) {
            //homies[i] = new Companion(companion_name[i], companion_gender[i], companion_face[i]);
        }

        party = new Game(companion_name.length);

        //getNames();
    }

    static void getNames() {
        if (homies != null && party != null) {
            for (int i = 0; i < party.getComSize(); i++) {
                // need?
            }
        }
    }

}
