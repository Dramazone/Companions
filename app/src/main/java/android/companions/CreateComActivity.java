package android.companions;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CreateComActivity extends AppCompatActivity {

    int comSize;
    int comMax;

    int[] companion_gender;
    int[] companion_face;
    String[] companion_name;
    boolean[] companion_check;

    LinearLayout[] setup_companion;
    TextView[] setup_devider;
    TextView[] setup_devider_line;
    TextView[][] setup_margin;
    TextView[] setup_text;
    ImageView[] setup_icon;
    LinearLayout[] setup_inner_layout;
    ImageView[] setup_image_gender;
    ImageView[] setup_image_face;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_com);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true); // back button
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        comSize = MainActivity.comSizeSetup;
        comMax = 4;

        companion_gender = new int[comMax];
        companion_face = new int[comMax];
        companion_name = new String[comMax];
        companion_check = new boolean[comMax];

        setup_companion = new LinearLayout[comMax];
        setup_devider = new TextView[comMax];
        setup_devider_line = new TextView[comMax];
        setup_icon = new ImageView[comMax];
        setup_margin = new TextView[comMax][20];
        setup_text = new TextView[comMax];
        setup_inner_layout = new LinearLayout[comMax];
        setup_image_gender = new ImageView[comMax];
        setup_image_face = new ImageView[comMax];


        updateSetup();
    }




    void updateSetup() {

        //Calculator, px to dpConverter (use dpConverter * x)
        int converter = 1;
        final float scale = getResources().getDisplayMetrics().density;
        int dpConv = (int) (converter * scale + 0.5f);

        setup_companion[0] = (LinearLayout) findViewById(R.id.setup_companion_1);
        setup_companion[1] = (LinearLayout) findViewById(R.id.setup_companion_2);
        setup_companion[2] = (LinearLayout) findViewById(R.id.setup_companion_3);
        setup_companion[3] = (LinearLayout) findViewById(R.id.setup_companion_4);

        setup_devider[0] = (TextView) findViewById(R.id.setup_devider_1);
        setup_devider[1] = (TextView) findViewById(R.id.setup_devider_2);
        setup_devider[2] = (TextView) findViewById(R.id.setup_devider_3);
        setup_devider[3] = (TextView) findViewById(R.id.setup_devider_4);

        setup_devider_line[0] = (TextView) findViewById(R.id.setup_devider_line_1);
        setup_devider_line[1] = (TextView) findViewById(R.id.setup_devider_line_2);
        setup_devider_line[2] = (TextView) findViewById(R.id.setup_devider_line_3);
        setup_devider_line[3] = (TextView) findViewById(R.id.setup_devider_line_4);

        if (comSize < 4) {
            setup_companion[3].removeAllViews();
            setup_companion[3].setBackgroundResource(R.drawable.line_setup);
            setup_devider[3].setVisibility(View.INVISIBLE);
            setup_devider_line[3].setVisibility(View.INVISIBLE);
            if (comSize < 3) {
                setup_companion[2].removeAllViews();
                setup_companion[2].setBackgroundResource(R.drawable.line_setup);
                setup_devider[2].setVisibility(View.INVISIBLE);
                setup_devider_line[2].setVisibility(View.INVISIBLE);
                if (comSize < 2) {
                    setup_companion[1].removeAllViews();
                    setup_companion[1].setBackgroundResource(R.drawable.line_setup);
                    setup_devider[1].setVisibility(View.INVISIBLE);
                    setup_devider_line[1].setVisibility(View.INVISIBLE);
                    if (comSize < 1) {
                        setup_companion[0].removeAllViews();
                        setup_companion[0].setBackgroundResource(R.drawable.line_setup);
                        setup_devider[0].setVisibility(View.INVISIBLE);
                        setup_devider_line[0].setVisibility(View.INVISIBLE);
                    }
                }
            }
        }

        for (int i = 0; i < comSize; i++) {
            setup_companion[i].setBackground(null);
            setup_companion[i].setBackgroundColor(getResources().getColor(R.color.colorWhite));

            setup_devider[0].setVisibility(View.VISIBLE);
            setup_devider_line[0].setVisibility(View.VISIBLE);

            setup_icon[i] =  new ImageView(this);
            setup_icon[i].setLayoutParams(new ViewGroup.LayoutParams((28 * dpConv), (28 * dpConv))); //width, height
            setup_icon[i].setImageResource(R.drawable.icon_data);
            setup_icon[i].setPadding((2 * dpConv), (2 * dpConv), (2 * dpConv), (2 * dpConv)); //left, top, right, bottom

            setup_margin[i][0] =  new TextView(this);
            setup_margin[i][0].setLayoutParams(new ViewGroup.LayoutParams((30 * dpConv), (30 * dpConv))); //width, height

            setup_text[i] =  new TextView(this);
            setup_text[i].setLayoutParams(new ViewGroup.LayoutParams((LinearLayout.LayoutParams.WRAP_CONTENT), LinearLayout.LayoutParams.WRAP_CONTENT)); //width, height
            setup_text[i].setTextSize(TypedValue.COMPLEX_UNIT_DIP, 18);
            if (companion_name[0] != null) {
                setup_text[i].setText(companion_name[i]); // datenbankname
            } else {
                setup_text[i].setText("Companion " + (i + 1));
            }

            setup_margin[i][1] =  new TextView(this);
            setup_margin[i][1].setLayoutParams(new ViewGroup.LayoutParams((30 * dpConv), (30 * dpConv))); //width, height

            setup_inner_layout[i] =  new LinearLayout(this);
            setup_inner_layout[i].setLayoutParams(new ViewGroup.LayoutParams((LinearLayout.LayoutParams.MATCH_PARENT), LinearLayout.LayoutParams.WRAP_CONTENT)); //width, height
            setup_inner_layout[i].setGravity(Gravity.RIGHT | Gravity.CENTER_HORIZONTAL);

            setup_image_gender[i] =  new ImageView(this);
            setup_image_gender[i].setLayoutParams(new ViewGroup.LayoutParams((28 * dpConv), (28 * dpConv))); //width, height
            setup_image_gender[i].setPadding((4 * dpConv), (4 * dpConv), (4 * dpConv), (4 * dpConv)); //left, top, right, bottom

            setup_image_face[i] =  new ImageView(this);
            setup_image_face[i].setLayoutParams(new ViewGroup.LayoutParams((38 * dpConv), (38 * dpConv))); //width, height

            setup_margin[i][2] =  new TextView(this);
            setup_margin[i][2].setLayoutParams(new ViewGroup.LayoutParams((38 * dpConv), (1 * dpConv))); //width, height

            setup_companion[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    companion_gender[0] = 1;
                    setup_image_gender[0].setImageResource(R.drawable.icon_male);
                }
            });
        }



        for (int i = 0; i < comSize; i++) {
            (setup_companion[i]).addView(setup_icon[i]);
            (setup_companion[i]).addView(setup_margin[i][0]);
            (setup_companion[i]).addView(setup_text[i]);
            (setup_companion[i]).addView(setup_inner_layout[i]);
            {
                (setup_inner_layout[i]).addView(setup_margin[i][1]);
                (setup_inner_layout[i]).addView(setup_image_gender[i]);
                (setup_inner_layout[i]).addView(setup_image_face[i]);
                (setup_inner_layout[i]).addView(setup_margin[i][2]);
            }

        }

    }

    public void fab(View view) {
        switch (view.getId()) {
            case R.id.fab_add:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            case R.id.fab_sub:
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                break;
            default:
                break;
        }
    }



}
