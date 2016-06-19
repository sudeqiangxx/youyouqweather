package cn.com.sdq.youyouqweathear.utils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import cn.com.sdq.youyouqweathear.common.HttpCallbackListener;

/**
 * Created by Administrator on 2016/6/19.
 */
public class HttpUtil {
    private static void sendHttpRequest(final String address, final HttpCallbackListener httpCallbackListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpsURLConnection httpsURLConnection=null;
                InputStream in=null;
                BufferedReader bufferedReader;
                StringBuffer sb=null;
                try {
                    URL url=new URL(address);
                    httpsURLConnection= (HttpsURLConnection) url.openConnection();
                    httpsURLConnection.setRequestMethod("GET");
                    httpsURLConnection.setReadTimeout(8000);
                    httpsURLConnection.setConnectTimeout(8000);
                    in=httpsURLConnection.getInputStream();
                    bufferedReader=new BufferedReader(new InputStreamReader(in));
                    sb=new StringBuffer();
                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        sb.append(line);
                    }
                    if (httpCallbackListener!=null){
                        httpCallbackListener.onFinish(sb.toString());
                    }
                } catch (Exception e) {
                    if (httpCallbackListener==null){
                        httpCallbackListener.onError(e);
                    }
                    e.printStackTrace();
                }finally {
                    if (httpsURLConnection!=null){
                        httpsURLConnection.disconnect();
                    }

                }

            }
        }).start();
    }
}
