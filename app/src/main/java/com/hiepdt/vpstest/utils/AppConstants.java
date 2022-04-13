package com.hiepdt.vpstest.utils;

/**
 * Created by hiepdt on 21/08/2021.
 */

public final class AppConstants {

    private AppConstants() {
        // This utility class is not publicly instantiable
    }

    public static final String STATUS_CODE_SUCCESS = "success";
    public static final String STATUS_CODE_FAILED = "failed";

    public static final int API_STATUS_CODE_LOCAL_ERROR = 0;

    public static final String DB_NAME = "mindorks_mvp.db";
    public static final String PREF_NAME = "congkhai_pref";

    public static final long NULL_INDEX = -1L;

    public static final String SEED_DATABASE_OPTIONS = "seed/options.json";
    public static final String SEED_DATABASE_QUESTIONS = "seed/questions.json";

    public static final String TIMESTAMP_FORMAT = "yyyyMMdd_HHmmss";

    public static final int RESPONSE_SUCCESS_CODE = 200;

    public static final int NEW_PRODUCT_DAY_DURATION = 30;

    public static final int REDUCE_IMAGE_SIZE = 60000;

    public static final long REFRESH_DELAY = 3000L;

    public static final long MIN_PRICE = 0L;
    public static final long MAX_PRICE = 50_000_000L;

    public static final int PASTER = 0;
    public static final int MONASTERY = 1;
    public static final int OTHER = 2;

    public static final int SORT_POPULAR = 1;
    public static final int SORT_NEWEST = 2;
    public static final int SORT_ASCENDING = 3;
    public static final int SORT_DESCENDING = 4;

    public static final long DIALOG_TIMEOUT = 20000L;


    public interface SQLITE_DB {
        int DATABASE_VERSION = 1;
        String DATABASE_NAME = "resources.db";

        interface CATEGORY_TABLE {
            String TABLE_NAME = "categories";

            //Todo: Column
            String CATEGORY_ID_COLUMN = "category_id";
            String CATEGORY_NAME_COLUMN = "category_name";
            String ORDER_NUMBER_COLUMN = "order_number";

            //Todo: Create query
            String CREATE_CATEGORY_TABLE = "CREATE TABLE " + TABLE_NAME + "( " +
                    CATEGORY_ID_COLUMN + " VARCHAR(255) " + " NOT NULL PRIMARY KEY, " +
                    CATEGORY_NAME_COLUMN + " VARCHAR(255), " +
                    ORDER_NUMBER_COLUMN + " INTEGER(4))";
        }

        interface PRODUCT_TABLE {
            String TABLE_NAME = "products";

            //Todo: Column
            String PRODUCT_ID_COLUMN = "product_id";
            String PRODUCT_CODE_COLUMN = "product_code";
            String PRODUCT_NAME_COLUMN = "product_name";
            String COLOR_CODE_COLUMN = "color_code";
            String COLOR_NAME_COLUMN = "color_name";
            String IMAGE_COLUMN = "image";
            String CATEGORY_ID_COLUMN = "category_id";

            //Todo: Create query
            String CREATE_PRODUCT_TABLE = "CREATE TABLE " + TABLE_NAME + "( " +
                    PRODUCT_ID_COLUMN + " VARCHAR(255) " + " NOT NULL PRIMARY KEY, " +
                    PRODUCT_CODE_COLUMN + " VARCHAR(255)," +
                    PRODUCT_NAME_COLUMN + " VARCHAR(255), " +
                    COLOR_CODE_COLUMN + " INTEGER(4), " +
                    COLOR_NAME_COLUMN + " VARCHAR(30), " +
                    IMAGE_COLUMN + " VARCHAR(255), " +
                    CATEGORY_ID_COLUMN + " VARCHAR(255))";
        }
    }
}