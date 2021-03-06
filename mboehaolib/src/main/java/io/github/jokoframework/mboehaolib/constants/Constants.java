package io.github.jokoframework.mboehaolib.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by joaquin on 10/08/17.
 * @author joaquin
 * @author afeltes
 */
public class Constants {

    public static final long CRON_INTERVAL = (60 * 60 * 1000);
    public static final long FIRST_TIME = (12 * 1000);


    public static final double DATABASE_VERSION = 1.0;
    public static final String DATABASE_NAME = String.format("mboehao-v%s.db", DATABASE_VERSION);
    public static final int VERSION_CODE = 33;

    /**
     * Constantes de tiempos comúnmente utilizadas, en milisegundos
     */
    public static final long ONE_SECOND = 1000L;
    public static final long ONE_MINUTE = ONE_SECOND * 60L;
    public static final long ONE_HOUR = ONE_MINUTE * 60L;
    public static final long ONE_DAY = ONE_HOUR * 24L;

    public static final Map<String, String> errors = new HashMap<>();


    /**
     * Si tiene este valor, quiere decir que no hay al menos 4 muestras de dailyTests disponibles
     * para calcular el promedio. Cambiamos a este valor, debido a una incompatibilidad con el cliente
     * iOS que no soportaba el Double.MIN_VALUE
     */
    public static final double HD_VERTICAL_RESOLUTION = 1280;
    public static final double TABLET_VERTICAL_RESOLUTION = 1920;
    public static final double HVGA_VERTICAL_RESOLUTION = 480;


    //Miscelaneos
    public static final String DATE_TIME_FORMAT_ISO_8601 = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'";

    public static final String API_URL = "/joko/api";

    // Para pruebas en servidores de Testing
    public static final String SERVER_NAME = "testing.sodep.com.py";
    public static final String SERVER_PORT = "443";
    public static final String BASE_URL = "https://" + SERVER_NAME + ":" + SERVER_PORT;

    //Firebase Configuration...
    public static final String SENDER_ID = "1037867417276";
    public static final String CURRENT_MBOEHAO_VERSION = "1.0";
    public static Integer msgId = 0;

    public static final String FACEBOOK_PROFILE_DATA = "FACEBOOK_PROFILE_INFO";


    public static final String FROM_BACKGROUND_SERVICE = "FROM_BACKGROUND_SERVICE";
    public static final String APP_NEWS = "appNews";
    public static final String USER_PREFERENCE_APP_NEWS = "_appNews";
    public static final String USER_PREFERENCE_APP_NEWS_SHOWED_TIME = "_appNewsShowed";


    public static final String PREF_USER_LEARNED_DRAWER = "navigation_drawer_learned";

    public static final String HEADER_AUTH = "X-JOKO-AUTH";
    public static final String HEADER_VERSION = "X-JOKO-SECURITY-VERSION";

    public static final String KEY_REFRESH_TOKEN = "REFRESH_TOKEN";
    public static final String KEY_EXPIRATION = "EXPIRATION_TOKEN";
    public static final String KEY_USERNAME = "USERNAME";
    public static final String KEY_ACTIVE = "ACTIVE";
    public static final String KEY_FIRST_NAME = "FIRSTNAME";
    public static final String KEY_SURNAME = "SURNAME";
    public static final String KEY_CLIENT_REFERENCE_NUMBER = "CLIENT_REFERENCE_NUMBER";
    public static final String KEY_REMEMBER_ME = "REMEMBER_ME";
    public static final String KEY_SHOW_TAG_MESSAGE = "SHOW_TAG_MESSAGE";
    public static final String KEY_USER_ID = "USER_ID";
    public static final String USER_PREFS_USER = "U";
    public static final String USER_PREFS_PW = "P";

    //Referentes al parse
    public static final String PARSE_PARAMETER = "Parameter";
    public static final String PARSE_PARAMETER_DESCRIPTION = "description";
    public static final String PARSE_PARAMETER_VALUE = "value";
    public static final String PARSE_CLASS_REMOTE_LOG = "RemoteLog";
    public static final String PARSE_ATTRIBUTE_LEVEL = "level";
    public static final String IMAGE_PNG = "image/png";
    public static final String PARSE_ATTRIBUTE_LOG_TAG = "logTag";
    public static final String PARSE_ATTRIBUTE_MESSAGE = "message";
    public static final String PARSE_ATTRIBUTE_OBJECT_ID = "objectId";
    public static final String PARSE_ATTRIBUTE_SAVED_AT = "savedAt";
    public static final String PARSE_ATTRIBUTE_STACKTRACE = "stackTrace";
    public static final String PARSE_ATTRIBUTE_APP_VERSION = "appVersion";
    public static final String PARSE_ATTRIBUTE_USERNAME = "username";
    public static final String PARSE_ATTRIBUTE_USER_AS_USERNAME = "user";
    public static final int PASSWORD_MIN_LENGTH = 4;
    public static final int MIN_PASSWORD_LENGTH = 8;
    public static final String HTML_SCALED_FONT_SIZE = "3";
    public static final String SHARED_MBOEHAO_PREF = "MboehaoPref";
    public static final int NOTIFICATION_ID = 13;
    public static final String SIMBOLO_GUARANI = "Gs. ";
    public static final String CURRENCY_SYMBOL = Constants.SIMBOLO_GUARANI;
    public static final String SECRET = "0Twrt564w1rb56GhIJa3ur53VjYF2wkewegwernglkmergECfIZcLzT1MGYNO4hia_HsoVxpU7vp0sFNix3_JgK4ZHEwrthL3dmaTIrIMkdI2u3wethwQ1AvHPoU58X2H3w0Kf";
    public static final int SECONDS_TO_REFRESH = 3600; // 1 hora
    public static final int SECONDS_TO_RESET = 300; // 5 minutos
    public static final String PREFERENCE_ATTRIBUTE_NOTIFICATION_CHECKED = "preference_attribute_notification_checked";
    public static final String LOGIN_PROVIDER_FACEBOOK = "FACEBOOK";
    public static final String LOGIN_PROVIDER = "loginProvider";
    public static final String ACCESS_TOKEN = "accessToken";
    public static final String PREFERENCES_ATTRIBUTES = "prefereces_attributes";
    public static final String DEVICE_TYPE = "ANDROID";

    private Constants() {
         /*Porque los constructores no tienen que tener instancias...
         Y menos esta clase de constantes...*/
    }

    //Startup Result
    public enum StartUpKeys {
        LOGGED,
        EXPIRED,
        NOT_LOGGED,
        LOGGED_ELSEWHERE,
        LOGIN_ERROR,
        LOGIN_ERROR_MSG
    }


}
