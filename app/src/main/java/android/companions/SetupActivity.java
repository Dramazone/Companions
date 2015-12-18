package android.companions;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;

import javax.xml.namespace.NamespaceContext;

public class SetupActivity extends AppCompatActivity {

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;

    static int comSize;

    static int[] companion_gender;
    static int[] companion_face;
    static String[] companion_name;
    static boolean[] companion_check;

    static ImageView[] doneShowMinion;
    static LinearLayout[] layout_setup;
    static TextView[] setup_devider_line;
    static TextView[] setup_devider;
    static ScrollView[] setup_head;
    static ImageView[] saveButton;
    static EditText[] setup_editText;
    static RadioButton[] setup_radioButton_female;
    static RadioButton[] setup_radioButton_male;
    static ImageView[] setup_imageView_showGender;
    static ImageView[] setup_imageView_showFace;
    static TextView[] setup_textView_showName;

    static ImageView[] setup_imageView_face00;
    static ImageView[] setup_imageView_face01;
    static ImageView[] setup_imageView_face02;
    static ImageView[] setup_imageView_face03;
    static ImageView[] setup_imageView_face04;
    static ImageView[] setup_imageView_face05;
    static ImageView[] setup_imageView_face06;
    static ImageView[] setup_imageView_face07;
    static ImageView[] setup_imageView_face08;
    static ImageView[] setup_imageView_face09;
    static ImageView[] setup_imageView_face10;
    static ImageView[] setup_imageView_face11;

    //public static final String MY_PREFS_NAME = "MyPrefs";

    public static final String myPreferences = "MYPREFS";
    public static final String name_1 = "NAME_1";
    public static final String name_2 = "NAME_2";
    public static final String name_3 = "NAME_3";
    public static final String name_4 = "NAME_4";
    public static final String genderArray = "GENDER";
    public static final String faceArray = "FACE";

    static SharedPreferences sharedpreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setup);

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

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        sharedpreferences = getSharedPreferences(myPreferences, Context.MODE_PRIVATE);

        comSize = MainActivity.comSizeSetup;

        companion_gender = new int[comSize];
        companion_face = new int[comSize];
        companion_name = new String[comSize];
        companion_check = new boolean[comSize];

        doneShowMinion = new ImageView[comSize];
        layout_setup = new LinearLayout[comSize];
        setup_devider_line = new TextView[comSize];
        setup_devider = new TextView[comSize];
        setup_head = new ScrollView[comSize];
        saveButton = new ImageView[comSize];
        setup_editText = new EditText[comSize];
        setup_radioButton_female = new RadioButton[comSize];
        setup_radioButton_male = new RadioButton[comSize];
        setup_imageView_showGender = new ImageView[comSize];
        setup_imageView_showFace = new ImageView[comSize];
        setup_textView_showName = new TextView[comSize];

        setup_imageView_face00 = new ImageView[comSize];
        setup_imageView_face01 = new ImageView[comSize];
        setup_imageView_face02 = new ImageView[comSize];
        setup_imageView_face03 = new ImageView[comSize];
        setup_imageView_face04 = new ImageView[comSize];
        setup_imageView_face05 = new ImageView[comSize];
        setup_imageView_face06 = new ImageView[comSize];
        setup_imageView_face07 = new ImageView[comSize];
        setup_imageView_face08 = new ImageView[comSize];
        setup_imageView_face09 = new ImageView[comSize];
        setup_imageView_face10 = new ImageView[comSize];
        setup_imageView_face11 = new ImageView[comSize];

        for (int i = 0; i < comSize; i++) {
            doneShowMinion[i] = new ImageView(this);
            layout_setup[i] =  new LinearLayout(this);
            setup_devider_line[i] = new TextView(this);
            setup_devider[i] = new TextView(this);
            setup_head[i] =  new ScrollView(this);
            saveButton[i] =  new ImageView(this);
            setup_editText[i] = new EditText(this);
            setup_radioButton_female[i] = new RadioButton(this);
            setup_radioButton_male[i] = new RadioButton(this);
            setup_imageView_showGender[i] = new ImageView(this);
            setup_imageView_showFace[i] = new ImageView(this);
            setup_textView_showName[i] = new TextView(this);

            setup_imageView_face00[i] = new ImageView(this);
            setup_imageView_face01[i] = new ImageView(this);
            setup_imageView_face02[i] = new ImageView(this);
            setup_imageView_face03[i] = new ImageView(this);
            setup_imageView_face04[i] = new ImageView(this);
            setup_imageView_face05[i] = new ImageView(this);
            setup_imageView_face06[i] = new ImageView(this);
            setup_imageView_face07[i] = new ImageView(this);
            setup_imageView_face08[i] = new ImageView(this);
            setup_imageView_face09[i] = new ImageView(this);
            setup_imageView_face10[i] = new ImageView(this);
            setup_imageView_face11[i] = new ImageView(this);
            companion_check[i] = false;
        }



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_setup, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        //if (id == R.id.action_cancel) {
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
            View rootView = inflater.inflate(R.layout.fragment_setup, container, false);

            //Calculator, px to dpConverter (use dpConverter * x)
            int converter = 1;
            final float scale = getResources().getDisplayMetrics().density;
            int dpConv = (int) (converter * scale + 0.5f);

            int companion_1 = 1;
            int companion_2 = 2;
            int companion_3 = 3;
            int companion_4 = 4;

            if (getArguments().getInt(ARG_SECTION_NUMBER) == companion_1) { // if Companion 1

                if (companion_check[0]) {
            /*        setup_imageView_showGender[0] = (ImageView) rootView.findViewById(R.id.showGender);
                    setup_imageView_showFace[0] = (ImageView) rootView.findViewById(R.id.showFace);

                    setup_imageView_showFace[0].setImageResource(getDrawable(setup_imageView_showFace[0]));*/
                } else {

                } setCompanion_1(rootView);
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == companion_2) { // if Companion 2

                setCompanion_2(rootView);
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == companion_3) { // if Companion 3

                setCompanion_3(rootView);
            }
            if (getArguments().getInt(ARG_SECTION_NUMBER) == companion_4) { // if Companion 4

                setCompanion_4(rootView);
            }





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
            return MainActivity.comSizeSetup;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.section_companion_1);
                case 1:
                    return getString(R.string.section_companion_2);
                case 2:
                    return getString(R.string.section_companion_3);
                case 3:
                    return getString(R.string.section_companion_4);
            }
            return null;
        }
    }

    static void buildCompanions() {
        MainActivity.setNewCompanions(companion_name, companion_gender, companion_face);
    }

    static void setCompanion_1(View rootView) {
        companion_gender[0] = 99;
        companion_face[0] = 99;
        companion_check[0] = false;

        setup_devider_line[0] = (TextView) rootView.findViewById(R.id.setup_devider_line);
        setup_devider[0] = (TextView) rootView.findViewById(R.id.setup_devider);
        setup_head[0] = (ScrollView) rootView.findViewById(R.id.setup_head);
        layout_setup[0] = (LinearLayout) rootView.findViewById(R.id.layout_setup);
        //doneShowMinion[0].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height

        setup_imageView_showGender[0] = (ImageView) rootView.findViewById(R.id.showGender);
        setup_imageView_showFace[0] = (ImageView) rootView.findViewById(R.id.showFace);

        setup_imageView_face00[0] = (ImageView) rootView.findViewById(R.id.face00);
        setup_imageView_face00[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 0;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_monkey);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_monkey);
            }});

        setup_imageView_face01[0] = (ImageView) rootView.findViewById(R.id.face01);
        setup_imageView_face01[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 1;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_bird);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bird);
            }
        });

        setup_imageView_face02[0] = (ImageView) rootView.findViewById(R.id.face02);
        setup_imageView_face02[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 2;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_pinguin);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_pinguin);
            }});

        setup_imageView_face03[0] = (ImageView) rootView.findViewById(R.id.face03);
        setup_imageView_face03[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 3;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_hippo);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_hippo);
            }});

        setup_imageView_face04[0] = (ImageView) rootView.findViewById(R.id.face04);
        setup_imageView_face04[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 4;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_owl);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_owl);
            }});

        setup_imageView_face05[0] = (ImageView) rootView.findViewById(R.id.face05);
        setup_imageView_face05[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 5;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_lion);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_lion);
            }});

        setup_imageView_face06[0] = (ImageView) rootView.findViewById(R.id.face06);
        setup_imageView_face06[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 6;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_horse);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_horse);
            }});

        setup_imageView_face07[0] = (ImageView) rootView.findViewById(R.id.face07);
        setup_imageView_face07[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 7;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_dog);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_dog);
            }});

        setup_imageView_face08[0] = (ImageView) rootView.findViewById(R.id.face08);
        setup_imageView_face08[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 8;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_cow);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_cow);
            }});

        setup_imageView_face09[0] = (ImageView) rootView.findViewById(R.id.face09);
        setup_imageView_face09[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 9;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_elephant);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_elephant);
            }});

        setup_imageView_face10[0] = (ImageView) rootView.findViewById(R.id.face10);
        setup_imageView_face10[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 10;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_bear);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bear);
            }});

        setup_imageView_face11[0] = (ImageView) rootView.findViewById(R.id.face11);
        setup_imageView_face11[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[0] = 11;
                setup_imageView_showFace[0].setImageResource(R.drawable.image_kids_giraffe);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_giraffe);
            }});

        setup_textView_showName[0] = (TextView) rootView.findViewById(R.id.setup_text_datasheet);
        setup_editText[0] = (EditText) rootView.findViewById(R.id.setup_edit_name);
        setup_radioButton_female[0] = (RadioButton) rootView.findViewById(R.id.setup_gender_girl);
        setup_radioButton_female[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[0] = 0; setup_imageView_showGender[0].setImageResource(R.drawable.icon_female);}});
        setup_radioButton_male[0] = (RadioButton) rootView.findViewById(R.id.setup_gender_boy);
        setup_radioButton_male[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[0] = 1;setup_imageView_showGender[0].setImageResource(R.drawable.icon_male);}});
        saveButton[0] = (ImageView) rootView.findViewById(R.id.button_companion);
        saveButton[0].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companion_check[0] == false) {
                    companion_name[0] = setup_editText[0].getText().toString();
                    if (companion_name[0].equals("") || companion_name[0].equals(R.string.companion)) {
                        companion_name[0] = "";
                        setup_textView_showName[0].setText(R.string.companion);
                        Snackbar.make(v, "Enter a name please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        companion_name[0] = setup_editText[0].getText().toString();
                        setup_textView_showName[0].setText(companion_name[0]);
                        if (companion_gender[0] == 0 || companion_gender[0] == 1) {
                            if (companion_face[0] >= 0 && companion_face[0] <= 11) {
                                setup_head[0].setVisibility(View.INVISIBLE);
                                saveButton[0].setImageResource(R.drawable.icon_cancel);
                                setup_devider[0].setBackgroundResource(R.drawable.shadow_devider_up);
                                setup_devider_line[0].setVisibility(View.INVISIBLE);
                                companion_check[0] = true;

                                SharedPreferences.Editor editor = sharedpreferences.edit();
                                editor.putString(name_1, companion_name[0]);
                                editor.commit();

                                if (MainActivity.comSizeSetup == 1) {
                                    if (companion_check[0]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 2) {
                                    if (companion_check[0] && companion_check[1]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 3) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 4) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2] && companion_check[3]) {
                                        buildCompanions();
                                    }
                                }

                            } else {
                                Snackbar.make(v, "Choose a Minion please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        } else {
                            Snackbar.make(v, "Select a gender please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }
                    }
                } else {
                    setup_head[0].setVisibility(View.VISIBLE);
                    saveButton[0].setImageResource(R.drawable.icon_save);
                    setup_devider[0].setBackgroundResource(R.drawable.shadow_devider);
                    setup_devider_line[0].setVisibility(View.VISIBLE);
                    companion_check[0] = false;
                }
            }
        });
    }

    static void setCompanion_2(View rootView) {
        companion_gender[1] = 99;
        companion_face[1] = 99;
        companion_check[1] = false;

        setup_devider_line[1] = (TextView) rootView.findViewById(R.id.setup_devider_line);
        setup_devider[1] = (TextView) rootView.findViewById(R.id.setup_devider);
        setup_head[1] = (ScrollView) rootView.findViewById(R.id.setup_head);
        layout_setup[1] = (LinearLayout) rootView.findViewById(R.id.layout_setup);
        doneShowMinion[1].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height

        setup_imageView_showGender[1] = (ImageView) rootView.findViewById(R.id.showGender);
        setup_imageView_showFace[1] = (ImageView) rootView.findViewById(R.id.showFace);

        setup_imageView_face00[1] = (ImageView) rootView.findViewById(R.id.face00);
        setup_imageView_face00[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 0;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_monkey);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_monkey);
            }});

        setup_imageView_face01[1] = (ImageView) rootView.findViewById(R.id.face01);
        setup_imageView_face01[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 1;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_bird);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bird);
            }
        });

        setup_imageView_face02[1] = (ImageView) rootView.findViewById(R.id.face02);
        setup_imageView_face02[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 2;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_pinguin);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_pinguin);
            }});

        setup_imageView_face03[1] = (ImageView) rootView.findViewById(R.id.face03);
        setup_imageView_face03[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 3;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_hippo);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_hippo);
            }});

        setup_imageView_face04[1] = (ImageView) rootView.findViewById(R.id.face04);
        setup_imageView_face04[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 4;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_owl);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_owl);
            }});

        setup_imageView_face05[1] = (ImageView) rootView.findViewById(R.id.face05);
        setup_imageView_face05[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 5;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_lion);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_lion);
            }});

        setup_imageView_face06[1] = (ImageView) rootView.findViewById(R.id.face06);
        setup_imageView_face06[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 6;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_horse);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_horse);
            }});

        setup_imageView_face07[1] = (ImageView) rootView.findViewById(R.id.face07);
        setup_imageView_face07[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 7;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_dog);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_dog);
            }});

        setup_imageView_face08[1] = (ImageView) rootView.findViewById(R.id.face08);
        setup_imageView_face08[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 8;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_cow);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_cow);
            }});

        setup_imageView_face09[1] = (ImageView) rootView.findViewById(R.id.face09);
        setup_imageView_face09[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 9;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_elephant);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_elephant);
            }});

        setup_imageView_face10[1] = (ImageView) rootView.findViewById(R.id.face10);
        setup_imageView_face10[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 10;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_bear);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bear);
            }});

        setup_imageView_face11[1] = (ImageView) rootView.findViewById(R.id.face11);
        setup_imageView_face11[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[1] = 11;
                setup_imageView_showFace[1].setImageResource(R.drawable.image_kids_giraffe);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_giraffe);
            }});

        setup_textView_showName[1] = (TextView) rootView.findViewById(R.id.setup_text_datasheet);
        setup_editText[1] = (EditText) rootView.findViewById(R.id.setup_edit_name);
        setup_radioButton_female[1] = (RadioButton) rootView.findViewById(R.id.setup_gender_girl);
        setup_radioButton_female[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[1] = 0; setup_imageView_showGender[1].setImageResource(R.drawable.icon_female);}});
        setup_radioButton_male[1] = (RadioButton) rootView.findViewById(R.id.setup_gender_boy);
        setup_radioButton_male[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[1] = 1;setup_imageView_showGender[1].setImageResource(R.drawable.icon_male);}});
        saveButton[1] = (ImageView) rootView.findViewById(R.id.button_companion);
        saveButton[1].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companion_check[1] == false) {
                    companion_name[1] = setup_editText[1].getText().toString();
                    if (companion_name[1].equals("") || companion_name[1].equals(R.string.companion)) {
                        companion_name[1] = "";
                        setup_textView_showName[1].setText(R.string.companion);
                        Snackbar.make(v, "Enter a name please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        companion_name[1] = setup_editText[1].getText().toString();
                        setup_textView_showName[1].setText(companion_name[1]);
                        if (companion_gender[1] == 0 || companion_gender[1] == 1) {
                            if (companion_face[1] >= 0 && companion_face[1] <= 11) {
                                setup_head[1].setVisibility(View.INVISIBLE);
                                saveButton[1].setImageResource(R.drawable.icon_cancel);
                                setup_devider[1].setBackgroundResource(R.drawable.shadow_devider_up);
                                setup_devider_line[1].setVisibility(View.INVISIBLE);
                                companion_check[1] = true;
                                if (MainActivity.comSizeSetup == 2) {
                                    if (companion_check[0] && companion_check[1]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 3) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 4) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2] && companion_check[3]) {
                                        buildCompanions();
                                    }
                                }

                            } else {
                                Snackbar.make(v, "Choose a Minion please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        } else {
                            Snackbar.make(v, "Select a gender please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }
                    }
                } else {
                    setup_head[1].setVisibility(View.VISIBLE);
                    saveButton[1].setImageResource(R.drawable.icon_save);
                    setup_devider[1].setBackgroundResource(R.drawable.shadow_devider);
                    setup_devider_line[1].setVisibility(View.VISIBLE);
                    companion_check[1] = false;
                }
            }
        });
    }

    static void setCompanion_3(View rootView) {
        companion_gender[2] = 99;
        companion_face[2] = 99;
        companion_check[2] = false;

        setup_devider_line[2] = (TextView) rootView.findViewById(R.id.setup_devider_line);
        setup_devider[2] = (TextView) rootView.findViewById(R.id.setup_devider);
        setup_head[2] = (ScrollView) rootView.findViewById(R.id.setup_head);
        layout_setup[2] = (LinearLayout) rootView.findViewById(R.id.layout_setup);
        doneShowMinion[2].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height

        setup_imageView_showGender[2] = (ImageView) rootView.findViewById(R.id.showGender);
        setup_imageView_showFace[2] = (ImageView) rootView.findViewById(R.id.showFace);

        setup_imageView_face00[2] = (ImageView) rootView.findViewById(R.id.face00);
        setup_imageView_face00[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 0;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_monkey);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_monkey);
            }});

        setup_imageView_face01[2] = (ImageView) rootView.findViewById(R.id.face01);
        setup_imageView_face01[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 1;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_bird);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bird);
            }
        });

        setup_imageView_face02[2] = (ImageView) rootView.findViewById(R.id.face02);
        setup_imageView_face02[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 2;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_pinguin);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_pinguin);
            }});

        setup_imageView_face03[2] = (ImageView) rootView.findViewById(R.id.face03);
        setup_imageView_face03[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 3;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_hippo);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_hippo);
            }});

        setup_imageView_face04[2] = (ImageView) rootView.findViewById(R.id.face04);
        setup_imageView_face04[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 4;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_owl);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_owl);
            }});

        setup_imageView_face05[2] = (ImageView) rootView.findViewById(R.id.face05);
        setup_imageView_face05[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 5;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_lion);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_lion);
            }});

        setup_imageView_face06[2] = (ImageView) rootView.findViewById(R.id.face06);
        setup_imageView_face06[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 6;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_horse);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_horse);
            }});

        setup_imageView_face07[2] = (ImageView) rootView.findViewById(R.id.face07);
        setup_imageView_face07[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 7;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_dog);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_dog);
            }});

        setup_imageView_face08[2] = (ImageView) rootView.findViewById(R.id.face08);
        setup_imageView_face08[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 8;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_cow);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_cow);
            }});

        setup_imageView_face09[2] = (ImageView) rootView.findViewById(R.id.face09);
        setup_imageView_face09[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 9;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_elephant);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_elephant);
            }});

        setup_imageView_face10[2] = (ImageView) rootView.findViewById(R.id.face10);
        setup_imageView_face10[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 10;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_bear);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bear);
            }});

        setup_imageView_face11[2] = (ImageView) rootView.findViewById(R.id.face11);
        setup_imageView_face11[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[2] = 11;
                setup_imageView_showFace[2].setImageResource(R.drawable.image_kids_giraffe);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_giraffe);
            }});

        setup_textView_showName[2] = (TextView) rootView.findViewById(R.id.setup_text_datasheet);
        setup_editText[2] = (EditText) rootView.findViewById(R.id.setup_edit_name);
        setup_radioButton_female[2] = (RadioButton) rootView.findViewById(R.id.setup_gender_girl);
        setup_radioButton_female[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[2] = 0; setup_imageView_showGender[2].setImageResource(R.drawable.icon_female);}});
        setup_radioButton_male[2] = (RadioButton) rootView.findViewById(R.id.setup_gender_boy);
        setup_radioButton_male[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[2] = 1;setup_imageView_showGender[2].setImageResource(R.drawable.icon_male);}});
        saveButton[2] = (ImageView) rootView.findViewById(R.id.button_companion);
        saveButton[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companion_check[2] == false) {
                    companion_name[2] = setup_editText[2].getText().toString();
                    if (companion_name[2].equals("") || companion_name[2].equals(R.string.companion)) {
                        companion_name[2] = "";
                        setup_textView_showName[2].setText(R.string.companion);
                        Snackbar.make(v, "Enter a name please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        companion_name[2] = setup_editText[2].getText().toString();
                        setup_textView_showName[2].setText(companion_name[2]);
                        if (companion_gender[2] == 0 || companion_gender[2] == 1) {
                            if (companion_face[2] >= 0 && companion_face[2] <= 11) {
                                setup_head[2].setVisibility(View.INVISIBLE);
                                saveButton[2].setImageResource(R.drawable.icon_cancel);
                                setup_devider[2].setBackgroundResource(R.drawable.shadow_devider_up);
                                setup_devider_line[2].setVisibility(View.INVISIBLE);
                                companion_check[2] = true;
                                if (MainActivity.comSizeSetup == 3) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2]) {
                                        buildCompanions();
                                    }
                                }
                                if (MainActivity.comSizeSetup == 4) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2] && companion_check[3]) {
                                        buildCompanions();
                                    }
                                }

                            } else {
                                Snackbar.make(v, "Choose a Minion please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        } else {
                            Snackbar.make(v, "Select a gender please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }
                    }
                } else {
                    setup_head[2].setVisibility(View.VISIBLE);
                    saveButton[2].setImageResource(R.drawable.icon_save);
                    setup_devider[2].setBackgroundResource(R.drawable.shadow_devider);
                    setup_devider_line[2].setVisibility(View.VISIBLE);
                    companion_check[2] = false;
                }
            }
        });
    }

    static void setCompanion_4(View rootView) {
        companion_gender[3] = 99;
        companion_face[3] = 99;
        companion_check[3] = false;

        setup_devider_line[3] = (TextView) rootView.findViewById(R.id.setup_devider_line);
        setup_devider[3] = (TextView) rootView.findViewById(R.id.setup_devider);
        setup_head[3] = (ScrollView) rootView.findViewById(R.id.setup_head);
        layout_setup[3] = (LinearLayout) rootView.findViewById(R.id.layout_setup);
        doneShowMinion[3].setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)); //width, height

        setup_imageView_showGender[3] = (ImageView) rootView.findViewById(R.id.showGender);
        setup_imageView_showFace[3] = (ImageView) rootView.findViewById(R.id.showFace);

        setup_imageView_face00[3] = (ImageView) rootView.findViewById(R.id.face00);
        setup_imageView_face00[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 0;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_monkey);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_monkey);
            }});

        setup_imageView_face01[3] = (ImageView) rootView.findViewById(R.id.face01);
        setup_imageView_face01[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 1;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_bird);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bird);
            }
        });

        setup_imageView_face02[3] = (ImageView) rootView.findViewById(R.id.face02);
        setup_imageView_face02[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 2;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_pinguin);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_pinguin);
            }});

        setup_imageView_face03[3] = (ImageView) rootView.findViewById(R.id.face03);
        setup_imageView_face03[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 3;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_hippo);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_hippo);
            }});

        setup_imageView_face04[3] = (ImageView) rootView.findViewById(R.id.face04);
        setup_imageView_face04[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 4;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_owl);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_owl);
            }});

        setup_imageView_face05[3] = (ImageView) rootView.findViewById(R.id.face05);
        setup_imageView_face05[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 5;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_lion);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_lion);
            }});

        setup_imageView_face06[3] = (ImageView) rootView.findViewById(R.id.face06);
        setup_imageView_face06[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 6;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_horse);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_horse);
            }});

        setup_imageView_face07[3] = (ImageView) rootView.findViewById(R.id.face07);
        setup_imageView_face07[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 7;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_dog);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_dog);
            }});

        setup_imageView_face08[3] = (ImageView) rootView.findViewById(R.id.face08);
        setup_imageView_face08[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 8;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_cow);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_cow);
            }});

        setup_imageView_face09[3] = (ImageView) rootView.findViewById(R.id.face09);
        setup_imageView_face09[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 9;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_elephant);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_elephant);
            }});

        setup_imageView_face10[3] = (ImageView) rootView.findViewById(R.id.face10);
        setup_imageView_face10[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 10;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_bear);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_bear);
            }});

        setup_imageView_face11[3] = (ImageView) rootView.findViewById(R.id.face11);
        setup_imageView_face11[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                companion_face[3] = 11;
                setup_imageView_showFace[3].setImageResource(R.drawable.image_kids_giraffe);
                //doneShowMinion[0].setImageResource(R.drawable.image_kids_giraffe);
            }});

        setup_textView_showName[3] = (TextView) rootView.findViewById(R.id.setup_text_datasheet);
        setup_editText[3] = (EditText) rootView.findViewById(R.id.setup_edit_name);
        setup_radioButton_female[3] = (RadioButton) rootView.findViewById(R.id.setup_gender_girl);
        setup_radioButton_female[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[3] = 0; setup_imageView_showGender[3].setImageResource(R.drawable.icon_female);}});
        setup_radioButton_male[3] = (RadioButton) rootView.findViewById(R.id.setup_gender_boy);
        setup_radioButton_male[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {companion_gender[3] = 1;setup_imageView_showGender[3].setImageResource(R.drawable.icon_male);}});
        saveButton[3] = (ImageView) rootView.findViewById(R.id.button_companion);
        saveButton[3].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (companion_check[3] == false) {
                    companion_name[3] = setup_editText[3].getText().toString();
                    if (companion_name[3].equals("") || companion_name[3].equals(R.string.companion)) {
                        companion_name[3] = "";
                        setup_textView_showName[3].setText(R.string.companion);
                        Snackbar.make(v, "Enter a name please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                    } else {
                        companion_name[3] = setup_editText[3].getText().toString();
                        setup_textView_showName[3].setText(companion_name[3]);
                        if (companion_gender[3] == 0 || companion_gender[3] == 1) {
                            if (companion_face[3] >= 0 && companion_face[3] <= 11) {
                                setup_head[3].setVisibility(View.INVISIBLE);
                                saveButton[3].setImageResource(R.drawable.icon_cancel);
                                setup_devider[3].setBackgroundResource(R.drawable.shadow_devider_up);
                                setup_devider_line[3].setVisibility(View.INVISIBLE);
                                companion_check[3] = true;
                                if (MainActivity.comSizeSetup == 4) {
                                    if (companion_check[0] && companion_check[1] && companion_check[2] && companion_check[3]) {
                                        buildCompanions();
                                    }
                                }

                            } else {
                                Snackbar.make(v, "Choose a Minion please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        } else {
                            Snackbar.make(v, "Select a gender please.", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }
                    }
                } else {
                    setup_head[3].setVisibility(View.VISIBLE);
                    saveButton[3].setImageResource(R.drawable.icon_save);
                    setup_devider[3].setBackgroundResource(R.drawable.shadow_devider);
                    setup_devider_line[3].setVisibility(View.VISIBLE);
                    companion_check[3] = false;
                }
            }
        });
    }
}
