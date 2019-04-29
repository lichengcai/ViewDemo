package c.cc.viewdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

/**
 * @author lichengcai
 * @class name：c.cc.viewdemo.view
 * @date 2019/4/29 11:30
 * @desc ${描述类实现的功能}
 */
public class CircleImageView extends android.support.v7.widget.AppCompatImageView {
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    Xfermode xfermode = new PorterDuffXfermode(PorterDuff.Mode.SRC_IN);

    {
        paint.setColor(Color.BLACK);
    }

    public CircleImageView(Context context) {
        super(context);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleImageView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int saved = canvas.saveLayer(null,null,Canvas.ALL_SAVE_FLAG);
        super.onDraw(canvas);
        paint.setXfermode(xfermode);
        canvas.drawCircle(getWidth()/2,getHeight()/2,500,paint);

        paint.setXfermode(null);
        canvas.restoreToCount(saved);
    }
}
