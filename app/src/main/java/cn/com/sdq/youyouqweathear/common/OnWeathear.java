package cn.com.sdq.youyouqweathear.common;

/**
 * Created by Administrator on 2016/6/26.
 */
public interface OnWeathear {
    void onSuccess(Weathear weathear);//成功时回调方法
    void onError(Exception e);//失败时回调方法
}
