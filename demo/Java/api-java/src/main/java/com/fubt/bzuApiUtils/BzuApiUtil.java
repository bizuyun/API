package com.fubt.bzuApiUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description 币族云API工具类
 * @auther: wangzh
 * @date: 2019/08/29
 */
public class BzuApiUtil {

    private final static Logger logger = LoggerFactory.getLogger(BzuApiUtil.class);

    public static final String URL_PREFIX = "http://127.0.0.1:8081";//api基础地址  https://api.fubt.co/v1

    /**
     * 获取json内容(统一加密)
     *
     * @param jsonObject
     * @param method
     * @param secretKey
     * @return
     */
    public static String getJsonPost(JSONObject jsonObject, String method,String secretKey) {
        String url = URL_PREFIX+method.trim();
        String signString = Sign.jsonToString(jsonObject.toJSONString());
        String signature = Sign.sha256_HMAC(signString, secretKey);
        jsonObject.put("signature",signature);
        String json = "";
        try {
            json = sendPost(url, jsonObject);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return json;
    }

    /**
     * 发送POST方法的请求
     *
     * @param url   发送请求的URL
     * @param param 请求参数
     * @return result 响应结果
     */
    public static String sendPost(String url, JSONObject param) {
        OutputStreamWriter out = null;
        BufferedReader in = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            URLConnection conn = realUrl.openConnection();
            // 设置通用的请求属性
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");

            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            // 获取URLConnection对象对应的输出流
            out = new OutputStreamWriter(conn.getOutputStream(), "UTF-8");
            // 发送请求参数
            out.write(param.toString());
            // flush输出流的缓冲
            out.flush();
            // 定义BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    conn.getInputStream(),"UTF-8"));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！"+e);
            e.printStackTrace();
        } finally{
            try{
                if(out!=null){
                    out.close();
                }
                if(in!=null){
                    in.close();
                }
            }
            catch(IOException ex){
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送GET方法的请求
     *
     * @param method   发送请求的方法
     * @param param 请求参数
     * @return result 响应结果
     */
    public static String sendGet(String method, String param) {
        String result = "";
        BufferedReader in = null;
        try {
            String urlNameString = URL_PREFIX+method.trim()+"?"+param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            URLConnection connection = realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result;
    }
}
