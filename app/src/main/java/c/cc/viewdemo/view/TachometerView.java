package c.cc.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import c.cc.viewdemo.Utils;

/**
 * @author lichengcai
 * @class name：c.cc.viewdemo.view
 * @date 2019/4/29 14:43
 * @desc ${描述类实现的功能}
 */
public class TachometerView extends View{
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private static final float RADIUS = Utils.d2px(150);
    private static final float ANGLE = 120;
    RectF drawArc = new RectF();
    Path dash = new Path();
    PathEffect pathEffect = new PathDashPathEffect(dash,Utils.d2px(20),0,PathDashPathEffect.Style.MORPH);


    {
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(Utils.d2px(2));

    }

    public TachometerView(Context context) {
        super(context);
    }

    public TachometerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public TachometerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        drawArc.set(getWidth()/2 - RADIUS, getHeight()/2 - RADIUS, getWidth()/2 + RADIUS, getHeight()/2 + RADIUS);
        dash.addRect(new RectF(0,0,Utils.d2px(2),Utils.d2px(10)), Path.Direction.CW);
        paint.setPathEffect(pathEffect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawArc(drawArc,90 - ANGLE/2 + ANGLE, 360 - ANGLE, false, paint);
    }
}
