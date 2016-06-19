package cn.com.sdq.youyouqweathear.common;

/**
 * Created by Administrator on 2016/6/19.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);

}
