package io.github.jokoframework.mboehaolib.util;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

import de.keyboardsurfer.android.widget.crouton.Configuration;
import de.keyboardsurfer.android.widget.crouton.Crouton;
import de.keyboardsurfer.android.widget.crouton.Style;
import io.github.jokoframework.mboehaolib.constants.Constants;

public class Utils {
    private static final String LOG_TAG = Utils.class.getName();

    private static Random random = new Random();

    private Utils() {
        Utils.random.setSeed(System.currentTimeMillis());
    }

    public static void throwToast(String msg, Context context) {
        Toast toast = Toast.makeText(context, msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.show();
    }

    public static void showStickyMessage(Activity activity, String message, Style style) {
        showMessage(activity, message, style, Configuration.DURATION_INFINITE, Boolean.TRUE);
    }

    public static void showStickyMessage(Activity activity, String message) {
        showInfoMessage(activity, message, Configuration.DURATION_INFINITE, Boolean.TRUE);
    }

    public static void showMessage(Activity activity, String message, Style style, Integer duration, Boolean sticky) {
        final Configuration configuration = new Configuration.Builder()
                .setDuration(duration)
                .build();
        final Crouton crouton = Crouton.makeText(activity, message, style)
                .setConfiguration(configuration);
        if (sticky) {
            crouton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Crouton.hide(crouton);
                }
            });
        }
        crouton.show();
    }

    public static void showInfoMessage(final Activity activity, final String message,
                                       final Integer duration, final Boolean sticky) {
        if (activity != null) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    final Configuration configuration = new Configuration.Builder()
                            .setDuration(duration)
                            .build();
                    // Define custom styles for crouton
                    Style style = new Style.Builder().build();
                    // Display notice with custom style and configuration
                    final Crouton crouton = Crouton.makeText(activity, message, style)
                            .setConfiguration(configuration);
                    if (sticky) {
                        crouton.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Crouton.hide(crouton);
                            }
                        });
                    }
                    crouton.show();
                }
            });
        }
    }

    public static boolean isValidPassword(String password) {
        return password.length() >= Constants.PASSWORD_MIN_LENGTH;
    }

    public static String getPrefs(Context context, String id) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            return prefs.getString(id, "");
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. getPrefs)");
            return "";
        }
    }

    public static Boolean getBooleanPrefs(Context context, String id) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            return prefs.getBoolean(id, false);
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. getBooleanPrefs)");
            return false;
        }
    }

    //BEGIN-IGNORE-SONARQUBE
    private static SharedPreferences getSharedPreferences(Context context) {
        // afeltes - 2017-01-23
        //Para revisar con más cuidado, no sabemos si antes del mboehaolib se usaba el "id" para algo
        return context.getSharedPreferences("SimplePref", Context.MODE_MULTI_PROCESS);
    }
    //BEGIN-IGNORE-SONARQUBE

    public static boolean getBoolPrefs(Context context, String id) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            return prefs.getBoolean(id, false);
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. getBoolPrefs)");
            return false;
        }
    }

    public static int getIntPrefs(Context context, String id) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            return prefs.getInt(id, 0);
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. getInt)");
            return 0;
        }
    }

    public static long getLongPrefs(Context context, String id) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            long myLongValue = 0;
            return prefs.getLong(id, myLongValue);
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. getLong)");
            return 0L;
        }
    }

    public static void addPrefs(Context context, String id, String value) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            SharedPreferences.Editor edit = prefs.edit();
            edit.putString(id, value);
            edit.commit();
        } else {
            Log.e(LOG_TAG, "El Context que se desea utilizar es nulo. addPrefs(..String)");
        }
    }

    public static void addPrefs(Context context, String id, Boolean value) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(id, value);
            edit.commit();
        } else {
            Log.e(LOG_TAG, "El Context que se desea utilizar es nulo. addPrefs(..Boolean)");
        }
    }

    public static void addPrefs(Context context, String id, long value) {
        if (context != null) {
            SharedPreferences prefs = getSharedPreferences(context);
            SharedPreferences.Editor edit = prefs.edit();
            edit.putLong(id, value);
            edit.commit();
        } else {
            Log.e(LOG_TAG, "Se intentó guardar una preferencia con el context null. addPrefs(... long)");
        }
    }


    public static boolean isNetworkAvailable(Activity activity) {
        return isNetworkAvailable((Context) activity);
    }

    public static String getShareableImageName(String suffix) {
        return String.format("mboehao-linechart-%s-%s.png", StringUtils.isBlank(suffix) ? "test" : suffix, Utils.getFormattedDate(new Date()));
    }

    public static String getFormattedDate(Date savedAt) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yy");
        return sdf.format(savedAt);
    }

    public static boolean isNetworkAvailable(Context context) {
        boolean isNetworkAvailable = false;
        if (context != null) {
            ConnectivityManager connectivityManager
                    = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            isNetworkAvailable = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        }
        return isNetworkAvailable;
    }

    public static boolean isParseSessionActive() {
        return ParseUtils.getCurrentUser() != null && ParseUtils.getCurrentUser().isAuthenticated();
    }

    public static File getShareImagesFolder() {
        return new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM) + "/Mboehao/");
    }

    public static void showToast(final Context context, final String message) {
        if (context != null) {
            Handler handler = new Handler(Looper.getMainLooper());
            handler.post(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    public static void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            Log.e(LOG_TAG, "Error durmiendo thread", e);
        }
    }
}
