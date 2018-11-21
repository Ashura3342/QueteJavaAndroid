package fr.wildcodeschool.quetejavaui;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout mainLinearLayout = findViewById(R.id.mainLinearLayout);
        addTextViewWelcome(mainLinearLayout);
        addCheckBoxIsWilder(mainLinearLayout);
        addEditFirstName(mainLinearLayout);
        addEditLastName(mainLinearLayout);
        addButtonAccept(mainLinearLayout);
    }

    private int convertDpToPixel(float dp) {
        Resources resources = this.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        return (int) (dp * (metrics.densityDpi / 160f));
    }

    private LinearLayout setWidthToMiddle(Context context, View view) {
        LinearLayout horizontal = new LinearLayout(context);
        horizontal.setWeightSum(2);
        horizontal.setOrientation(LinearLayout.HORIZONTAL);

        horizontal.addView(view, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT,
                1
        ));
        horizontal.addView(new Space(context), new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT, 0, 1
        ));
        return horizontal;
    }


    private void addTextViewWelcome(LinearLayout layout) {
        int dp10 = convertDpToPixel(10);
        int dp5 = convertDpToPixel(5);

        TextView txWelcome = new TextView(this);
        txWelcome.setText(R.string.welcome_msg);
        txWelcome.setBackgroundColor(getResources().getColor(R.color.welcomeColor));
        txWelcome.setTextColor(getResources().getColor(R.color.welcomeTextColor));
        txWelcome.setTextSize(TypedValue.COMPLEX_UNIT_SP, 20);
        txWelcome.setPadding(dp10, dp5, dp10, dp5);
        LinearLayout.LayoutParams layoutTxWelcome = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutTxWelcome.setMargins(0, dp10, 0, dp10);
        layout.addView(txWelcome, layoutTxWelcome);

    }

    private void addCheckBoxIsWilder(LinearLayout layout) {
        CheckBox chIsWilder = new CheckBox(this);
        chIsWilder.setText(R.string.is_wilder_msg);
        LinearLayout.LayoutParams layoutChIsWilder = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        );
        layoutChIsWilder.gravity = Gravity.CENTER_HORIZONTAL;
        layout.addView(chIsWilder, layoutChIsWilder);
    }

    private void addEditFirstName(LinearLayout layout) {
        EditText editFirstName = new EditText(this);
        editFirstName.setHint(R.string.first_name);
        editFirstName.setEms(10);
        layout.addView(setWidthToMiddle(this, editFirstName), new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
    }

    private void addEditLastName(LinearLayout layout) {
        EditText editLastName = new EditText(this);
        editLastName.setHint(R.string.last_name);
        editLastName.setEms(10);
        layout.addView(setWidthToMiddle(this, editLastName), new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
    }

    private void addButtonAccept(LinearLayout layout) {
        Button btAccept = new Button(this);
        btAccept.setText(R.string.accept_text);
        layout.addView(btAccept, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
    }
}
