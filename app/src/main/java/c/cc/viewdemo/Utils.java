package c.cc.viewdemo;

import android.content.res.Resources;
import android.util.TypedValue;

/**
 * @author lichengcai
 * @class name：c.cc.viewdemo
 * @date 2019/4/29 14:46
 * @desc ${描述类实现的功能}
 */
public class Utils {
    public static float d2px(int dp) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,dp, Resources.getSystem().getDisplayMetrics());
    }
}
