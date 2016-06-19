package cn.com.sdq.youyouqweathear.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/18.
 */
public class YouyouWeatherDB {
    public static final String DB_NAME="youyou_weather";
    public static final int VERSION=1;
    private static YouyouWeatherDB youyouWeatherDB;
    private SQLiteDatabase db;

    /***
     * 私有化构造方法
     * @param
     */
    private YouyouWeatherDB(Context context){
        YouyouWeatherOpenHelper dbOpenHelper=new YouyouWeatherOpenHelper(context,DB_NAME,null,VERSION);
        db=dbOpenHelper.getWritableDatabase();
    }

    /***
     * 获得数据库操作实例
     * @param
     * @return
     */
    public synchronized static YouyouWeatherDB getInstance(Context context){
        if (youyouWeatherDB==null){
            youyouWeatherDB=new YouyouWeatherDB(context);
        }
        return youyouWeatherDB;
    }

    /***
     * 保存省份信息
     * @param province
     */
    public void savaProvince(Province province){
        if (province!=null){
            ContentValues values=new ContentValues();
            values.put("province_name",province.getProvinceName());
            values.put("province_code",province.getProvinceCode());
            db.insert("Province",null,values);
        }
    }

    /***
     * 查询省份信息
     * @return
     */
    public List<Province> getProvinces(){
        List<Province> provinces=new ArrayList<Province>();
        String[] selection=null;
        String selectionArgs=null;
        String[] groupBy=null;
        String having=null;
        String orderBy=null;
        Cursor cursor=db.query("Province",null,null,null, null,null,null);
        if(cursor.moveToFirst()){
            do{
                Province province=new Province();
                province.setId(cursor.getInt(cursor.getColumnIndex("id")));
                province.setProvinceName(cursor.getString(cursor.getColumnIndex("province_name")));
                province.setProvinceCode(cursor.getString(cursor.getColumnIndex("province_code")));
                provinces.add(province);
            }while (cursor.moveToNext());
        }

        return provinces;

    }

    /**
     * 保存城市信息
     * @param city
     */
    public void savaCity(City city){
        if(city!=null){
            ContentValues values=new ContentValues();
            values.put("city_name",city.getCityName());
            values.put("city_code",city.getCityCode());
            values.put("province_id",city.getProvinceId());
            db.insert("City",null,values);
        }
    }

    /**
     * 获得城市列表
     * @return
     */
    public List<City> getCitys(int provinceId){
        List<City> citys=new ArrayList<City>();
        String[] selectionArgs=new String[]{String.valueOf(provinceId)};
        Cursor cursor=db.query("City",null,"province_id=?",selectionArgs,null,null,null);
        if(cursor.moveToFirst()){
            do {
                City city=new City();
                city.setId(cursor.getInt(cursor.getColumnIndex("id")));
                city.setCityName(cursor.getString(cursor.getColumnIndex("city_name")));
                city.setCityCode(cursor.getString(cursor.getColumnIndex("city_code")));
                city.setProvinceId(provinceId);
                citys.add(city);
            }while (cursor.moveToNext());
        }
        return citys;

    }

    /***
     * 保存县信息
     * @param county
     */
    public void savaCounty(County county){
        if(county!=null){
            ContentValues values=new ContentValues();
            values.put("county_name",county.getCountyName());
            values.put("county_code",county.getCounCode());
            values.put("city_id",county.getCityId());
            db.insert("County",null,values);
        }

    }

    /***
     * 获取县名列表
     * @return
     */
    public List<County> getCountys(int cityId){
        List<County> countys=new ArrayList<County>();
        String[] seletctionArgs=new String[]{String.valueOf(cityId)};
        String seletio="city_id=?";
        Cursor cursor=db.query("County",null,seletio,seletctionArgs,null,null,null);
        if(cursor.moveToFirst()){
            do {
                County county=new County();
                county.setCityId(cityId);
                county.setCountyName(cursor.getString(cursor.getColumnIndex("city_name")));
                county.setCounCode(cursor.getString(cursor.getColumnIndex("city_code")));
                countys.add(county);
            }while (cursor.moveToNext());
        }
        return countys;

    }


}
