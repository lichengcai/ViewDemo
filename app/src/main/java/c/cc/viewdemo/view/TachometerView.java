package c.cc.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.graphics.PathEffect;
import android.graphics.PathMeasure;
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
    private static final float DASH_WIDTH = Utils.d2px(2);
    private static final float POINTER_LENGTH = Utils.d2px(20);
    RectF drawArc = new RectF();
    Path arcPath = new Path();
    Path dash = new Path();
    PathMeasure pathMeasure;
    PathEffect pathEffect ;


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

        arcPath.addArc(drawArc,90 - ANGLE/2 + ANGLE, 360 - ANGLE);
        pathMeasure = new PathMeasure(arcPath,false);

        dash.addRect(new RectF(0,0, DASH_WIDTH, Utils.d2px(10)), Path.Direction.CW);
        pathEffect = new PathDashPathEffect(dash,(pathMeasure.getLength() - DASH_WIDTH)/30,0,PathDashPathEffect.Style.ROTATE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setPathEffect(pathEffect);
        canvas.drawArc(drawArc,90 - ANGLE/2 + ANGLE, 360 - ANGLE, false, paint);
        paint.setPathEffect(null);

        canvas.drawArc(drawArc,90 - ANGLE/2 + ANGLE, 360 - ANGLE, false, paint);

    }
}
