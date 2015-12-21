package android.companions;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.graphics.Typeface;
import android.support.design.widget.Snackbar;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    static int comSizeSetup;
    static int comSize;
    static int comMax;
    static int statSize;

    static String[] companion_name;
    static int[] companion_gender;
    static int[] companion_face;

    static LinearLayout[] layout_companion;
    static LinearLayout[] layout_stat_holder;
    static LinearLayout[] layout_extra;
    static TextView[] text_name;
    static ImageView[] image_gender;
    static ImageView[] image_face;




//    static Companion[] homies;
//    static Companion homie_1;
//    static Companion homie_2;
//    static Companion homie_3;
//    static Companion homie_4;
//    static Game party;

//    static LinearLayout[] layout_companion;
//    static LinearLayout[] layout_companion_fitter;
//    static LinearLayout[] layout_companion_stats;
//    static LinearLayout[] layout_companion_stats_row1;
//    static LinearLayout[] layout_companion_stats_row2;
//    static TextView[] textView_companion_stats_name;
//    static LinearLayout[][] layout_companion_stats_stat;
//    static LinearLayout[][] layout_companion_stats_stat_bar;
//    static ImageView[][] image_companion_stats_stat_image;
//    static LinearLayout[] layout_companion_image_layout;
//    static ImageView[] image_companion_image;
//    static LinearLayout[] layout_gap;
//    static TextView[] textView_companion_shadow;
//    static TextView[][] companion_margin;

    static LinearLayout layout_logo;
    static TextView textView_welcome;
    static ImageView image_logo;
    static TextView textView_logo;
    static TextView textView_logo_add;

//    static Button popupButton;
//    static PopupMenu popupMenu;

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

        SQLiteDatabase companionDB = openOrCreateDatabase("CompanionsDB", MODE_PRIVATE, null);
        companionDB.execSQL("CREATE TABLE IF NOT EXISTS Companions(id INT,name TEXT, gender INT, face INT, active_status INT);");
        companionDB.execSQL("CREATE TABLE IF NOT EXISTS Stats(id INT,health INT, joy INT, hunger INT, thirst INT, bladder INT, manky INT, full INT);");

        SQLiteStatement countCompanions = companionDB.compileStatement("select count(*) from Companions");
        comSize = (int)countCompanions.simpleQueryForLong();
//        comSize = 1;
        comMax = 4;

        //LinearLayout[] layout_companion =  new LinearLayout[comSize];
        //LinearLayout[] layout_companion_stats = new LinearLayout[comSize];
        //ImageView[] image_companion_image = new ImageView[comSize];

//        comSize = 1; //warning, just scale between 1-4
        statSize = 6; //warning, don't scale this value please

        companion_gender = new int[comMax];
        companion_face = new int[comMax];
        companion_name = new String[comMax];

        layout_companion =  new LinearLayout[comMax];
        text_name =  new TextView[comMax];
        image_gender =  new ImageView[comMax];
        image_face =  new ImageView[comMax];

//        layout_stat_holder =  new LinearLayout[comMax];
//        layout_extra =  new LinearLayout[comMax];

//        layout_companion =  new LinearLayout[comSize];
//        layout_companion_fitter =  new LinearLayout[comSize];
//        layout_companion_stats = new LinearLayout[comSize];
//        layout_companion_stats_row1 = new LinearLayout[comSize];
//        layout_companion_stats_row2 = new LinearLayout[comSize];
//        textView_companion_stats_name = new TextView[comSize];
//        layout_companion_stats_stat = new LinearLayout[comSize][statSize];
//        layout_companion_stats_stat_bar = new LinearLayout[comSize][statSize];
//        image_companion_stats_stat_image = new ImageView[comSize][statSize];
//        layout_companion_image_layout =  new LinearLayout[comSize];
//        image_companion_image = new ImageView[comSize];
//        layout_gap = new LinearLayout[comSize];
//        textView_companion_shadow = new TextView[comSize];
//        companion_margin = new TextView[comSize][20];



        //initialize for the companion constructor
//        for (int i = 0; i < comSize; i++) {
//
//            companion_name[i] = "";
//            companion_gender[i] = 99;
//            companion_face[i] = 99;
//
////            layout_companion[i] =  new LinearLayout(this);
////            layout_companion_fitter[i] =  new LinearLayout(this);
////            layout_companion_stats[i] = new LinearLayout(this);
////            layout_companion_stats_row1[i] = new LinearLayout(this);
////            layout_companion_stats_row2[i] = new LinearLayout(this);
////            layout_companion_image_layout[i] = new LinearLayout(this);
////            image_companion_image[i] = new ImageView(this);
////            textView_companion_stats_name[i] = new TextView(this);
////            layout_gap[i] = new LinearLayout(this);
////            textView_companion_shadow[i] = new TextView(this);
////
////            for (int j = 0; j < 20; j++) {
////                companion_margin[i][j] = new TextView(this);
////            }
////
////            for (int j = 0; j < statSize; j++) {
////                layout_companion_stats_stat[i][j] = new LinearLayout(this);
////                image_companion_stats_stat_image[i][j] = new ImageView(this);
////                layout_companion_stats_stat_bar[i][j] = new LinearLayout(this);
////            }
//        }

        //initialize for a empty companion site
        layout_logo = new LinearLayout(this);
        textView_welcome = new TextView(this);
        image_logo = new ImageView(this);
        textView_logo = new TextView(this);
        textView_logo_add = new TextView(this);

//        popupMenu = new PopupMenu(MainActivity.this, layout_logo);



        for (int i = 0; i < comSize; i++) {
            SQLiteStatement fillNameArrays = companionDB.compileStatement("select name from Companions where id="+i+"");
            companion_name[i] = fillNameArrays.simpleQueryForString();

            SQLiteStatement fillGenderArrays = companionDB.compileStatement("select gender from Companions where id="+i+"");
            companion_gender[i] = (int)fillGenderArrays.simpleQueryForLong();

            SQLiteStatement fillFaceArrays = companionDB.compileStatement("select face from Companions where id="+i+"");
            companion_face[i] = (int)fillFaceArrays.simpleQueryForLong();
        }
        companionDB.close();
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

            layout_companion[0] = (LinearLayout) rootView.findViewById(R.id.layout_companion_1);
            layout_companion[1] = (LinearLayout) rootView.findViewById(R.id.layout_companion_2);
            layout_companion[2] = (LinearLayout) rootView.findViewById(R.id.layout_companion_3);
            layout_companion[3] = (LinearLayout) rootView.findViewById(R.id.layout_companion_4);

            text_name[0] = (TextView) rootView.findViewById(R.id.text_name_companion_1);
            text_name[1] = (TextView) rootView.findViewById(R.id.text_name_companion_2);
            text_name[2] = (TextView) rootView.findViewById(R.id.text_name_companion_3);
            text_name[3] = (TextView) rootView.findViewById(R.id.text_name_companion_4);

            image_gender[0] = (ImageView) rootView.findViewById(R.id.image_gender_companion_1);
            image_gender[1] = (ImageView) rootView.findViewById(R.id.image_gender_companion_2);
            image_gender[2] = (ImageView) rootView.findViewById(R.id.image_gender_companion_3);
            image_gender[3] = (ImageView) rootView.findViewById(R.id.image_gender_companion_4);

            image_face[0] = (ImageView) rootView.findViewById(R.id.image_face_companion_1);
            image_face[1] = (ImageView) rootView.findViewById(R.id.image_face_companion_2);
            image_face[2] = (ImageView) rootView.findViewById(R.id.image_face_companion_3);
            image_face[3] = (ImageView) rootView.findViewById(R.id.image_face_companion_4);

//            layout_stat_holder[0] = (LinearLayout) rootView.findViewById(R.id.layout_stat_holder_companion_1);
//            layout_extra[0] = (LinearLayout) rootView.findViewById(R.id.layout_extra_companion_1);



            // site constructor V1.1 " like an array ;) , hot! "
            if (getArguments().getInt(ARG_SECTION_NUMBER) == status) { //status site

                if (comSize >= 1) {

                    for (int i = 0; i < comSize; i++) {

                        if (comSize <= 3) {
                            layout_main.removeView(layout_companion[3]);
                            if (comSize <= 2) {
                                layout_main.removeView(layout_companion[2]);
                                if (comSize == 1) {
                                    layout_companion[1].removeAllViews();
                                    layout_companion[1].setBackgroundResource(0);
                                }
                            }
                        }


                        text_name[i].setText(companion_name[i]);

                        if (companion_gender[i] == 0) {
                            image_gender[i].setImageResource(R.drawable.icon_female);
                        } else {
                            image_gender[i].setImageResource(R.drawable.icon_male);
                        }

                        switch (companion_face[i]) {
                            case 0:
                                image_face[i].setImageResource(R.drawable.image_kids_monkey);
                                break;
                            case 1:
                                image_face[i].setImageResource(R.drawable.image_kids_bird);
                                break;
                            case 2:
                                image_face[i].setImageResource(R.drawable.image_kids_pinguin);
                                break;
                            case 3:
                                image_face[i].setImageResource(R.drawable.image_kids_hippo);
                                break;
                            case 4:
                                image_face[i].setImageResource(R.drawable.image_kids_owl);
                                break;
                            case 5:
                                image_face[i].setImageResource(R.drawable.image_kids_lion);
                                break;
                            case 6:
                                image_face[i].setImageResource(R.drawable.image_kids_horse);
                                break;
                            case 7:
                                image_face[i].setImageResource(R.drawable.image_kids_dog);
                                break;
                            case 8:
                                image_face[i].setImageResource(R.drawable.image_kids_cow);
                                break;
                            case 9:
                                image_face[i].setImageResource(R.drawable.image_kids_elephant);
                                break;
                            case 10:
                                image_face[i].setImageResource(R.drawable.image_kids_bear);
                                break;
                            case 11:
                                image_face[i].setImageResource(R.drawable.image_kids_giraffe);
                                break;
                            default:
                                break;
                        }



                    }


                } else {
                    layout_main.removeAllViews();

                    layout_logo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height
                    //layout_logo.setBackgroundColor(getResources().getColor(R.color.colorPrimaryDelight));
                    //layout_logo.setBackgroundResource(R.drawable.rounded_start);
                    layout_logo.setOrientation(LinearLayout.VERTICAL);
                    layout_logo.setGravity(Gravity.CENTER);
                    layout_logo.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            comSizeSetup = 1;
                            Intent setupActivity = new Intent(getContext(),CreateComActivity.class);
                            setupActivity.setAction(Intent.ACTION_VIEW);
                            setupActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                            setupActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                            startActivity(setupActivity);
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
                layout_main.removeAllViews();

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
            comSizeSetup = 1;
            Intent setupActivity = new Intent(this, CreateComActivity.class);
            setupActivity.setAction(Intent.ACTION_VIEW);
            setupActivity.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            setupActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
            startActivity(setupActivity);

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



}
