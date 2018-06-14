package javiermurillo.educattio.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;

import javiermurillo.educattio.R;

import static javiermurillo.educattio.utils.Constants.EMPTY_STRING;
import static javiermurillo.educattio.utils.Constants.HTTPS;
import static javiermurillo.educattio.utils.Constants.REQUEST_CODE;

public class Utils {
    public static void openActivity(Context context, Class clazz) {
        Intent mIntent = new Intent(context, clazz);
        Bundle options = new Bundle();
        ActivityCompat.startActivity(context, mIntent, options);
    }

    public static void openActivityForResult(Activity activity, Class clazz, int requestCode) {
        Intent mIntent = new Intent(activity, clazz);
        Bundle options = new Bundle();
        options.putInt(REQUEST_CODE, requestCode);
        ActivityCompat.startActivityForResult(activity, mIntent, requestCode, options);
    }

    public static void openLink(Activity mActivity, String url) {
        String urlNormal = url.replaceAll(Constants.HTTP, EMPTY_STRING);
        urlNormal = urlNormal.replaceAll(HTTPS, EMPTY_STRING);
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(
                mActivity.getString(R.string.url, urlNormal)));
        Bundle options = new Bundle();
        ActivityCompat.startActivity(mActivity, intent, options);
    }
}
