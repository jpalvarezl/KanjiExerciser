package project.study.kanjiexerciser;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        drawRectangle();
    }

//    private void drawRectangle() {
//        Paint paint = new Paint();
//        paint.setColor(Color.parseColor("#CD5C5C"));
//
//        DisplayMetrics metrics = new DisplayMetrics();
//        getWindowManager().getDefaultDisplay().getMetrics(metrics);
//
//        int width = Math.round(metrics.widthPixels);
//        int height = width;
//
//        Bitmap bg = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
//        Canvas canvas = new Canvas(bg);
//        canvas.drawRect(0, 0, width, height, paint);
//        LinearLayout ll = (LinearLayout) findViewById(R.id.rect);
//        if(android.os.Build.VERSION.SDK_INT < android.os.Build.VERSION_CODES.JELLY_BEAN) {
//            ll.setBackgroundDrawable(new BitmapDrawable(getApplicationContext().getResources(), bg));
//        } else {
//            ll.setBackground(new BitmapDrawable(getApplicationContext().getResources(), bg));
//        }
//    }
}
