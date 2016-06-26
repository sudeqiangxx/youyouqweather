package cn.com.sdq.youyouqweathear.moduleHome.activity.viewInterface;

import cn.com.sdq.youyouqweathear.common.Weathear;

/**
 * Created by Administrator on 2016/6/26.
 */
public interface WeatherView {
    void showLoading();
    void hideLoading();
    void showError();
    void setWeatherInfo(Weathear weathear);
}
