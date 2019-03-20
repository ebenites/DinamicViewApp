package pe.edu.tecsup.dinamicviewapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    LinearLayout list1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list1 = findViewById(R.id.list1);
    }

    public int dipToPixel(float dip) {
        int pixel = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dip, getResources().getDisplayMetrics());
        return pixel;
    }

    public void agregarFila1(View v) {
        RelativeLayout relativeLayout = new RelativeLayout(this);
        relativeLayout.setLayoutParams(new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        relativeLayout.setPadding(dipToPixel(16), dipToPixel(16), dipToPixel(16), dipToPixel(16));

        EditText editText = new EditText(this);
        editText.setId(View.generateViewId());
        RelativeLayout.LayoutParams layoutParamsEditText = new RelativeLayout.LayoutParams(dipToPixel(80), ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsEditText.addRule(RelativeLayout.ALIGN_PARENT_END);
        editText.setLayoutParams(layoutParamsEditText);
        relativeLayout.addView(editText);

        TextView textView = new TextView(this);
        RelativeLayout.LayoutParams layoutParamsTextView = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParamsTextView.addRule(RelativeLayout.START_OF, editText.getId());
        textView.setLayoutParams(layoutParamsTextView);
        textView.setText("Practca 1");
        relativeLayout.addView(textView);

        list1.addView(relativeLayout);
    }

    public void eliminarFila1(View v) {
        if(list1.getChildCount() > 0) {
            list1.removeViewAt(list1.getChildCount() - 1);
        }
    }

    public void agregarFila2(View v) {
        View view = LayoutInflater.from(this).inflate(R.layout.item_practica, list1, false);

        TextView textView = view.findViewById(R.id.title_text);
        // TODO...

        list1.addView(view);
    }
}
