package cn.com.sdq.youyouqweathear.utils;

import android.text.TextUtils;

import cn.com.sdq.youyouqweathear.data.City;
import cn.com.sdq.youyouqweathear.data.County;
import cn.com.sdq.youyouqweathear.data.Province;
import cn.com.sdq.youyouqweathear.data.YouyouWeatherDB;

/**
 * Created by Administrator on 2016/6/19.
 */
public class Utility {
    /*解析和处理服务器返回来的省级数据*/
    public synchronized static boolean handleProvincesResponse(YouyouWeatherDB youyouWeatherDB,

                                                               String response){
        if (!TextUtils.isEmpty(response)){
            String[] allProvinces=response.split(",");
            if (allProvinces!=null&&allProvinces.length>0){
                for (String p:allProvinces){
                    String[] array=p.split("\\|");
                    Province province=new Province();
                    province.setProvinceCode(array[0]);
                    province.setProvinceName(array[1]);
                    youyouWeatherDB.savaProvince(province);
                }
                return  true;
            }
        }
        return false;

    }
    /*解析和处理服务器返回来的城市级数据*/
    public synchronized static boolean handleCitysResponse(YouyouWeatherDB youyouWeatherDB,

                                                               String response,int provinceId){
        if (!TextUtils.isEmpty(response)){
            String[] allCityes=response.split(",");
            if (allCityes!=null&&allCityes.length>0){
                for (String c:allCityes){
                    String[] array=c.split("\\|");
                    City city=new City();
                    city.setCityCode(array[0]);
                    city.setCityName(array[1]);
                    city.setProvinceId(provinceId);
                    youyouWeatherDB.savaCity(city);
                }
                return  true;
            }
        }
        return false;

    }
    /*解析和处理服务器返回来的县级数据*/
    public synchronized static boolean handleCountysResponse(YouyouWeatherDB youyouWeatherDB,

                                                               String response,int citysId){
        if (!TextUtils.isEmpty(response)){
            String[] allcountys=response.split(",");
            if (allcountys!=null&&allcountys.length>0){
                for (String c:allcountys){
                    String[] array=c.split("\\|");
                    County county=new County();
                    county.setCounCode(array[0]);
                    county.setCountyName(array[1]);
                    county.setCityId(citysId);
                    youyouWeatherDB.savaCounty(county);
                }
                return  true;
            }
        }
        return false;

    }
}
