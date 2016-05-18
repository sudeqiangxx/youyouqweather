package cn.com.sdq.youyouqweathear.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Administrator on 2016/5/18.
 */
public class YouyouWeatherOpenHelper extends SQLiteOpenHelper{
    /***
     * province 表创建语句
     * @param
     */
    public static final String  CREATE_PROVINCE="create table Province " +
            "( "+"id integer primary key autoincrement, "
                +"province_name text, "
                +"province_code text "
                + ")";
    /***
     * 创建城市的表的sql语句
     */
    public static final String  CREATE_CITY="create table City "+
            "( "+ "id integer primary key autoincrement, "
                +"city_name text, "
                +"city_code text, "
                +"province_id integer "
                +")";
    /***
     * 创建县表的数据库表的sql语句
     */
    public static final String CREATE_COUNTY="create table County "+
            "( "+"id integer primary key autoincrement,"
                +"county_name text, "
                +"county_code text, "
                +"city_id integer "
                +")";

    public YouyouWeatherOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PROVINCE);//创建省表
        db.execSQL(CREATE_CITY);//创建城市表
        db.execSQL(CREATE_COUNTY); //创建县表


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
