package android.companions;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.InputType;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class CreateComActivity extends AppCompatActivity {

    int comSize;
    int comMax;

    int[] companion_gender;
    int[] companion_face;
    String[] companion_name;
    boolean[] companion_editOut;
    boolean[] companion_data_check;
    boolean companion_check;

    FloatingActionButton setup_next_fab;
    LinearLayout setup_master;

    LinearLayout[] setup_companion;
    LinearLayout[] setup_sheet;
    LinearLayout[] setup_dropDown;
    ImageView[] setup_icon;
    ImageView[] setup_image_gender;
    ImageView[] setup_image_face;

    TextView[] setup_name_text;
    EditText[] setup_name_editText;
    RadioButton[] setup_radioButton_female;
    RadioButton[] setup_radioButton_male;
    ImageView[] setup_face_image_1;
    ImageView[] setup_face_image_2;
    ImageView[] setup_face_image_3;
    ImageView[] setup_face_image_4;
    ImageView[] setup_face_image_5;
    ImageView[] setup_face_image_6;
    ImageView[] setup_face_image_7;
    ImageView[] setup_face_image_8;
    ImageView[] setup_face_image_9;
    ImageView[] setup_face_image_10;
    ImageView[] setup_face_image_11;
    ImageView[] setup_face_image_12;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_com);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        //Calculator, px to dpConverter (use dpConverter * x)
        int converter = 1;
        final float scale = getResources().getDisplayMetrics().density;
        int dpConv = (int) (converter * scale + 0.5f);

        comSize = MainActivity.comSizeSetup;
        comMax = 4;

        companion_gender = new int[comMax];
        companion_face = new int[comMax];
        companion_name = new String[comMax];
        companion_data_check = new boolean[comMax];
        companion_editOut = new boolean[comMax];

//        setup_master = new LinearLayout[comMax];
        setup_companion = new LinearLayout[comMax];
        setup_sheet = new LinearLayout[comMax];
        setup_dropDown = new LinearLayout[comMax];
//        setup_devider = new TextView[comMax];
//        setup_devider_line = new TextView[comMax];
        setup_icon = new ImageView[comMax];
//        setup_margin = new TextView[comMax][20];
//        setup_text = new TextView[comMax];
//        setup_inner_layout = new LinearLayout[comMax];
        setup_image_gender = new ImageView[comMax];
        setup_image_face = new ImageView[comMax];
//        setup_save_icon = new ImageView[comMax];

//        setup_scroll_layout = new LinearLayout[comMax];
//        setup_name_layout = new LinearLayout[comMax];
//        setup_name_icon = new ImageView[comMax];
        setup_name_text = new TextView[comMax];
        setup_name_editText = new EditText[comMax];
//        setup_line = new TextView[comMax][10];
//        setup_gender_layout = new LinearLayout[comMax];
//        setup_gender_icon = new ImageView[comMax];
//        setup_gender_text = new TextView[comMax];
//        setup_radioGroup = new RadioGroup[comMax];
        setup_radioButton_female = new RadioButton[comMax];
        setup_radioButton_male = new RadioButton[comMax];
//        setup_face_layout = new LinearLayout[comMax];
//        setup_face_icon = new ImageView[comMax];
//        setup_face_text = new TextView[comMax];
//        setup_face_holder_out_layout = new HorizontalScrollView[comMax];
//        setup_face_holder_inner_layout = new LinearLayout[comMax];
//        setup_face_row_layout_1 = new LinearLayout[comMax];
//        setup_face_row_layout_2 = new LinearLayout[comMax];
        setup_face_image_1 = new ImageView[comMax];
        setup_face_image_2 = new ImageView[comMax];
        setup_face_image_3 = new ImageView[comMax];
        setup_face_image_4 = new ImageView[comMax];
        setup_face_image_5 = new ImageView[comMax];
        setup_face_image_6 = new ImageView[comMax];
        setup_face_image_7 = new ImageView[comMax];
        setup_face_image_8 = new ImageView[comMax];
        setup_face_image_9 = new ImageView[comMax];
        setup_face_image_10 = new ImageView[comMax];
        setup_face_image_11 = new ImageView[comMax];
        setup_face_image_12 = new ImageView[comMax];

//        setup_dropdown_devider = new TextView[comMax];

        companion_check = false;

        for (int i = 0; i < comMax; i++) {
            companion_name[i] = "Companion";
            companion_gender[i] = 99;
            companion_face[i] = 99;
            companion_editOut[i] = false;
            companion_data_check[i] = false;

        }

        setup_next_fab = (FloatingActionButton) findViewById(R.id.fab_next);
        setup_master = (LinearLayout) findViewById(R.id.layout_master);

        setup_companion[0] = (LinearLayout) findViewById(R.id.layout_setup_1);
        setup_companion[1] = (LinearLayout) findViewById(R.id.layout_setup_2);
        setup_companion[2] = (LinearLayout) findViewById(R.id.layout_setup_3);
        setup_companion[3] = (LinearLayout) findViewById(R.id.layout_setup_4);

        setup_sheet[0] = (LinearLayout) findViewById(R.id.setup_layout_datasheet_1);
        setup_sheet[1] = (LinearLayout) findViewById(R.id.setup_layout_datasheet_2);
        setup_sheet[2] = (LinearLayout) findViewById(R.id.setup_layout_datasheet_3);
        setup_sheet[3] = (LinearLayout) findViewById(R.id.setup_layout_datasheet_4);

        setup_dropDown[0] = (LinearLayout) findViewById(R.id.setup_layout_dropDown_1);
        setup_dropDown[1] = (LinearLayout) findViewById(R.id.setup_layout_dropDown_2);
        setup_dropDown[2] = (LinearLayout) findViewById(R.id.setup_layout_dropDown_3);
        setup_dropDown[3] = (LinearLayout) findViewById(R.id.setup_layout_dropDown_4);

        setup_name_text[0] = (TextView) findViewById(R.id.setup_text_name_1);
        setup_name_text[1] = (TextView) findViewById(R.id.setup_text_name_2);
        setup_name_text[2] = (TextView) findViewById(R.id.setup_text_name_3);
        setup_name_text[3] = (TextView) findViewById(R.id.setup_text_name_4);

        setup_name_editText[0] = (EditText) findViewById(R.id.setup_edit_name_1);
        setup_name_editText[1] = (EditText) findViewById(R.id.setup_edit_name_2);
        setup_name_editText[2] = (EditText) findViewById(R.id.setup_edit_name_3);
        setup_name_editText[3] = (EditText) findViewById(R.id.setup_edit_name_4);

        setup_radioButton_female[0] = (RadioButton) findViewById(R.id.setup_gender_female_1);
        setup_radioButton_female[1] = (RadioButton) findViewById(R.id.setup_gender_female_2);
        setup_radioButton_female[2] = (RadioButton) findViewById(R.id.setup_gender_female_3);
        setup_radioButton_female[3] = (RadioButton) findViewById(R.id.setup_gender_female_4);

        setup_radioButton_male[0] = (RadioButton) findViewById(R.id.setup_gender_male_1);
        setup_radioButton_male[1] = (RadioButton) findViewById(R.id.setup_gender_male_2);
        setup_radioButton_male[2] = (RadioButton) findViewById(R.id.setup_gender_male_3);
        setup_radioButton_male[3] = (RadioButton) findViewById(R.id.setup_gender_male_4);

        setup_image_gender[0] = (ImageView) findViewById(R.id.showGender_1);
        setup_image_gender[1] = (ImageView) findViewById(R.id.showGender_2);
        setup_image_gender[2] = (ImageView) findViewById(R.id.showGender_3);
        setup_image_gender[3] = (ImageView) findViewById(R.id.showGender_4);

        setup_image_face[0] = (ImageView) findViewById(R.id.showFace_1);
        setup_image_face[1] = (ImageView) findViewById(R.id.showFace_2);
        setup_image_face[2] = (ImageView) findViewById(R.id.showFace_3);
        setup_image_face[3] = (ImageView) findViewById(R.id.showFace_4);

        if (comSize < 4) {
            setup_master.removeView(setup_companion[3]);
            if (comSize < 3) {
                setup_master.removeView(setup_companion[2]);
                if (comSize < 2) {
                    setup_master.removeView(setup_companion[1]);
                    if (comSize < 1) {
                        setup_master.removeView(setup_companion[0]);
                    }
                }
            }
        }

        for (int i = 0; i < comMax; i++) { //hide sheet
            setup_companion[i].removeView(setup_dropDown[i]);

            setup_companion[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();

                    switch (id) {
                        case R.id.layout_setup_1:
                            if (companion_editOut[0]) { //hide com1 by clicking if it's already out
                                companion_editOut[0] = false;
                                setup_companion[0].removeView(setup_dropDown[0]);
                            } else { //show com1 by clicking if it's hidden
                                companion_editOut[0] = true;
                                setup_companion[0].addView(setup_dropDown[0]);
                            }
                            break;
                        case R.id.layout_setup_2:
                            if (companion_editOut[1]) { //hide com1 by clicking if it's already out
                                companion_editOut[1] = false;
                                setup_companion[1].removeView(setup_dropDown[1]);
                            } else { //show com1 by clicking if it's hidden
                                companion_editOut[1] = true;
                                setup_companion[1].addView(setup_dropDown[1]);
                            }
                            break;
                        case R.id.layout_setup_3:
                            if (companion_editOut[2]) { //hide com1 by clicking if it's already out
                                companion_editOut[2] = false;
                                setup_companion[2].removeView(setup_dropDown[2]);
                            } else { //show com1 by clicking if it's hidden
                                companion_editOut[2] = true;
                                setup_companion[2].addView(setup_dropDown[2]);
                            }
                            break;
                        case R.id.layout_setup_4:
                            if (companion_editOut[3]) { //hide com1 by clicking if it's already out
                                companion_editOut[3] = false;
                                setup_companion[3].removeView(setup_dropDown[3]);
                            } else { //show com1 by clicking if it's hidden
                                companion_editOut[3] = true;
                                setup_companion[3].addView(setup_dropDown[3]);
                            }
                            break;
                    }
                }
            });

            setup_radioButton_female[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();

                    switch (id) {
                        case R.id.setup_gender_female_1:
                            setup_image_gender[0].setImageResource(R.drawable.icon_female);
                            companion_gender[0] = 0;
                            break;
                        case R.id.setup_gender_female_2:
                            setup_image_gender[1].setImageResource(R.drawable.icon_female);
                            companion_gender[1] = 0;
                            break;
                        case R.id.setup_gender_female_3:
                            setup_image_gender[2].setImageResource(R.drawable.icon_female);
                            companion_gender[2] = 0;
                            break;
                        case R.id.setup_gender_female_4:
                            setup_image_gender[3].setImageResource(R.drawable.icon_female);
                            companion_gender[3] = 0;
                            break;
                        default:
                            break;
                    }
                }
            });

            setup_radioButton_male[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();

                    switch (id) {
                        case R.id.setup_gender_male_1:
                            setup_image_gender[0].setImageResource(R.drawable.icon_male);
                            companion_gender[0] = 1;
                            break;
                        case R.id.setup_gender_male_2:
                            setup_image_gender[1].setImageResource(R.drawable.icon_male);
                            companion_gender[1] = 1;
                            break;
                        case R.id.setup_gender_male_3:
                            setup_image_gender[2].setImageResource(R.drawable.icon_male);
                            companion_gender[2] = 1;
                            break;
                        case R.id.setup_gender_male_4:
                            setup_image_gender[3].setImageResource(R.drawable.icon_male);
                            companion_gender[3] = 1;
                            break;
                        default:
                            break;
                    }
                }
            });

            setup_name_editText[i].setOnFocusChangeListener(new View.OnFocusChangeListener() {
                public void onFocusChange(View v, boolean hasFocus) {
                    if (!hasFocus) {
                        int id = v.getId();
                        String tmp;

                        switch (id) {
                            case R.id.setup_edit_name_1:
                                tmp = setup_name_editText[0].getText().toString();
                                if (tmp.equals("")) {
                                    setup_name_text[0].setText("Companion");
                                    companion_name[0] = "Companion";
                                    setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                                    companion_check = false;
                                } else {
                                    setup_name_text[0].setText(setup_name_editText[0].getText());
                                    companion_name[0] = setup_name_text[0].getText() + "";
                                }
                                break;
                            case R.id.setup_edit_name_2:
                                tmp = setup_name_editText[1].getText().toString();
                                if (tmp.equals("")) {
                                    setup_name_text[1].setText("Companion");
                                    companion_name[1] = "Companion";
                                    setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                                    companion_check = false;
                                } else {
                                    setup_name_text[1].setText(setup_name_editText[1].getText());
                                    companion_name[1] = setup_name_text[1].getText() + "";
                                }
                                break;
                            case R.id.setup_edit_name_3:
                                tmp = setup_name_editText[2].getText().toString();
                                if (tmp.equals("")) {
                                    setup_name_text[2].setText("Companion");
                                    companion_name[2] = "Companion";
                                    setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                                    companion_check = false;
                                } else {
                                    setup_name_text[2].setText(setup_name_editText[2].getText());
                                    companion_name[2] = setup_name_text[2].getText() + "";
                                }
                                break;
                            case R.id.setup_edit_name_4:
                                tmp = setup_name_editText[3].getText().toString();
                                if (tmp.equals("")) {
                                    setup_name_text[3].setText("Companion");
                                    companion_name[3] = "Companion";
                                    setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                                    companion_check = false;
                                } else {
                                    setup_name_text[3].setText(setup_name_editText[3].getText());
                                    companion_name[3] = setup_name_text[3].getText() + "";
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }
            });





        }


    }

    public void checkNextFab() {
//        if (comSize == 1) {
//            if (companion_check[0]) {
//
//            }
//        }

    }

    public void onSpiritClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.face00_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_monkey);
                companion_face[0] = 0;
                break;
            case R.id.face00_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_monkey);
                companion_face[1] = 0;
                break;
            case R.id.face00_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_monkey);
                companion_face[2] = 0;
                break;
            case R.id.face00_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_monkey);
                companion_face[3] = 0;
                break;

            case R.id.face01_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_bird);
                companion_face[0] = 1;
                break;
            case R.id.face01_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_bird);
                companion_face[1] = 1;
                break;
            case R.id.face01_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_bird);
                companion_face[2] = 1;
                break;
            case R.id.face01_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_bird);
                companion_face[3] = 1;
                break;

            case R.id.face02_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_pinguin);
                companion_face[0] = 2;
                break;
            case R.id.face02_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_pinguin);
                companion_face[1] = 2;
                break;
            case R.id.face02_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_pinguin);
                companion_face[2] = 2;
                break;
            case R.id.face02_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_pinguin);
                companion_face[3] = 2;
                break;

            case R.id.face03_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_hippo);
                companion_face[0] = 3;
                break;
            case R.id.face03_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_hippo);
                companion_face[1] = 3;
                break;
            case R.id.face03_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_hippo);
                companion_face[2] = 3;
                break;
            case R.id.face03_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_hippo);
                companion_face[3] = 3;
                break;

            case R.id.face04_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_owl);
                companion_face[0] = 4;
                break;
            case R.id.face04_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_owl);
                companion_face[1] = 4;
                break;
            case R.id.face04_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_owl);
                companion_face[2] = 4;
                break;
            case R.id.face04_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_owl);
                companion_face[3] = 4;
                break;

            case R.id.face05_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_lion);
                companion_face[0] = 5;
                break;
            case R.id.face05_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_lion);
                companion_face[1] = 5;
                break;
            case R.id.face05_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_lion);
                companion_face[2] = 5;
                break;
            case R.id.face05_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_lion);
                companion_face[3] = 5;
                break;

            case R.id.face06_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_horse);
                companion_face[0] = 6;
                break;
            case R.id.face06_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_horse);
                companion_face[1] = 6;
                break;
            case R.id.face06_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_horse);
                companion_face[2] = 6;
                break;
            case R.id.face06_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_horse);
                companion_face[3] = 6;
                break;

            case R.id.face07_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_dog);
                companion_face[0] = 7;
                break;
            case R.id.face07_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_dog);
                companion_face[1] = 7;
                break;
            case R.id.face07_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_dog);
                companion_face[2] = 7;
                break;
            case R.id.face07_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_dog);
                companion_face[3] = 7;
                break;

            case R.id.face08_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_cow);
                companion_face[0] = 8;
                break;
            case R.id.face08_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_cow);
                companion_face[1] = 8;
                break;
            case R.id.face08_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_cow);
                companion_face[2] = 8;
                break;
            case R.id.face08_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_cow);
                companion_face[3] = 8;
                break;

            case R.id.face09_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_elephant);
                companion_face[0] = 9;
                break;
            case R.id.face09_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_elephant);
                companion_face[1] = 9;
                break;
            case R.id.face09_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_elephant);
                companion_face[2] = 9;
                break;
            case R.id.face09_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_elephant);
                companion_face[3] = 9;
                break;

            case R.id.face10_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_bear);
                companion_face[0] = 10;
                break;
            case R.id.face10_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_bear);
                companion_face[1] = 10;
                break;
            case R.id.face10_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_bear);
                companion_face[2] = 10;
                break;
            case R.id.face10_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_bear);
                companion_face[3] = 10;
                break;

            case R.id.face11_1:
                setup_image_face[0].setImageResource(R.drawable.image_kids_giraffe);
                companion_face[0] = 11;
                break;
            case R.id.face11_2:
                setup_image_face[1].setImageResource(R.drawable.image_kids_giraffe);
                companion_face[1] = 11;
                break;
            case R.id.face11_3:
                setup_image_face[2].setImageResource(R.drawable.image_kids_giraffe);
                companion_face[2] = 11;
                break;
            case R.id.face11_4:
                setup_image_face[3].setImageResource(R.drawable.image_kids_giraffe);
                companion_face[3] = 11;
                break;

            default:
                break;
        }
    }

    public void fab(View view) {
        switch (view.getId()) {
            case R.id.fab_add:
                if (comSize < 4) {
                    comSize++;
                    setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                    companion_check = false;
                }
                break;
            case R.id.fab_sub:
                if (comSize > 0) {
                    comSize--;
                }
                break;
            case R.id.fab_next:
                setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                String tmp;

                if (companion_check) {



                    Snackbar.make(view, "Du kommst hier nicht weg!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                } else {
                    for (int i = 0; i < comSize; i++) {
                        tmp = setup_name_editText[i].getText().toString();
                        if (tmp.equals("")) {
                            setup_name_text[i].setText("Companion");
                            companion_name[i] = "Companion";
                            setup_next_fab.setImageResource(R.drawable.icon_setup_save);
                            companion_check = false;
                        } else {
                            setup_name_text[i].setText(setup_name_editText[i].getText());
                            companion_name[i] = setup_name_text[i].getText() + "";
                        }
                        if (companion_name[i].equals("Companion")) {
                            Snackbar.make(view, getResources().getString(R.string.error_enterName) + " " + (i+1), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                        }else {
                            if (companion_gender[i] != 99) {
                                if (companion_face[i] != 99) {
                                    companion_data_check[i] = true;
                                } else {
                                    Snackbar.make(view, getResources().getString(R.string.error_enterFace) + " " + (i+1), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                                }
                            } else {
                                Snackbar.make(view, getResources().getString(R.string.error_enterGender) + " " + (i+1), Snackbar.LENGTH_LONG).setAction("Action", null).show();
                            }
                        }
                    }

                    if (comSize == 1 && companion_data_check[0]) {
                        setup_next_fab.setImageResource(R.drawable.icon_next2);
                        companion_check = true;
                    }
                    if (comSize == 2 && companion_data_check[0] && companion_data_check[1]) {
                        setup_next_fab.setImageResource(R.drawable.icon_next2);
                        companion_check = true;
                    }
                    if (comSize == 3 && companion_data_check[0] && companion_data_check[1] && companion_data_check[2]) {
                        setup_next_fab.setImageResource(R.drawable.icon_next2);
                        companion_check = true;
                    }
                    if (comSize == 4 && companion_data_check[0] && companion_data_check[1] && companion_data_check[2] && companion_data_check[3]) {
                        setup_next_fab.setImageResource(R.drawable.icon_next2);
                        companion_check = true;
                    }
                }



                break;
            default:
                break;
        }
//        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
        for (int i = 0; i < comMax; i++) {
            setup_master.removeView(setup_companion[i]);
            setup_companion[i].removeView(setup_dropDown[i]);
            companion_editOut[i] = false;
        }
        for (int i = 0; i < comSize; i++) {
            setup_master.addView(setup_companion[i]);
        }
    }



}
