package cn.com.sdq.youyouqweathear.common;

/**
 * Created by Administrator on 2016/6/26.
 */
public class Weathear {
    /*
    * {"city":"昆山","cityid":"101190404","temp1":"21℃","temp2":"9℃",
"weather":"多云转小雨","img1":"d1.gif","img2":"n7.gif","ptime":"11:00"}
    * */
    private String city;//城市
    private String cityid;//城市id
    private String temp1;//最高气温
    private String temp2; //最低气温
    private String weather;//天气状况
    private String imagurl1;//动态图片1
    private String imagurl2;//动态图片2url
    private String ptime;//发布时间

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityid() {
        return cityid;
    }

    public void setCityid(String cityid) {
        this.cityid = cityid;
    }

    public String getTemp1() {
        return temp1;
    }

    public void setTemp1(String temp1) {
        this.temp1 = temp1;
    }

    public String getTemp2() {
        return temp2;
    }

    public void setTemp2(String temp2) {
        this.temp2 = temp2;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getImagurl1() {
        return imagurl1;
    }

    public void setImagurl1(String imagurl1) {
        this.imagurl1 = imagurl1;
    }

    public String getImagurl2() {
        return imagurl2;
    }

    public void setImagurl2(String imagurl2) {
        this.imagurl2 = imagurl2;
    }

    public String getPtime() {
        return ptime;
    }

    public void setPtime(String ptime) {
        this.ptime = ptime;
    }
}
