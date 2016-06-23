package com.sjsu.priteshchandaliya.cmpeginie;

/**
 * Created by Megha on 5/18/2016.
 */


        import android.content.Context;
        import android.graphics.Typeface;

/**
 * Created by priteshchandaliya on 5/18/16.
 */
public class CmpeGenie {

    public static Typeface robotoLight = null, robotoMedium = null, robotoThin = null, robotoRegular = null;
    public static void appInit(Context cx){
        P.read(cx);
    }

    public static final class P{
        public static void read(Context cx)
        {
            try
            {
                if(null == robotoLight)
                {
                    robotoLight = Typeface.createFromAsset(cx.getAssets(),"Roboto-Light.ttf");
                }

                if(null == robotoMedium)
                {
                    robotoMedium = Typeface.createFromAsset(cx.getAssets(),"Roboto-Medium.ttf");
                }

                if(null == robotoThin)
                {
                    robotoThin = Typeface.createFromAsset(cx.getAssets(),"Roboto-Thin.ttf");
                }

                if(null == robotoRegular)
                {
                    robotoRegular = Typeface.createFromAsset(cx.getAssets(),"RobotoCondensed-Regular.ttf");
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

}


