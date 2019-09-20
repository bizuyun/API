package com.fubt.bzuApiUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

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

    public static final String URL_PREFIX = "https://api.fubt.co/v1";//api基础地址

    /**
     * 获取json内容(统一加密)
     *
     * @param jsonObject
     * @param method
     * @param secretKey
     * @return
     */
    public static String getJsonPost(JSONObject jsonObject, String method, String secretKey) {
        String url = URL_PREFIX + method.trim();
        String signString = Sign.jsonToString(jsonObject.toJSONString());
        String signature = Sign.sha256_HMAC(signString, secretKey);
        jsonObject.put("signature", signature);
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
        BufferedReader br = null;
        String result = "";
        InputStream is = null;
        try {
            URL realUrl = new URL(url);
            // 打开和URL之间的连接
            HttpURLConnection conn = (HttpURLConnection) realUrl.openConnection();
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
            if (conn.getResponseCode() == 200) {
                is = conn.getInputStream();
            } else if (conn.getResponseCode() == 401) {
                is = conn.getErrorStream();
            }
            br = new BufferedReader(new InputStreamReader(
                    is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送 POST 请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (null != out) {
                    out.close();
                }
                if (null != br) {
                    br.close();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        return result;
    }

    /**
     * 发送GET方法的请求
     *
     * @param method 发送请求的方法
     * @param param  请求参数
     * @return result 响应结果
     */
    public static String sendGet(String method, String param) {
        String result = "";
        BufferedReader br = null;
        InputStream is = null;
        try {
            String urlNameString = URL_PREFIX + method.trim() + "?" + param;
            URL realUrl = new URL(urlNameString);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
//          Map<String, List<String>> map = connection.getHeaderFields();// 获取所有响应头字段
            // 定义 BufferedReader输入流来读取URL的响应
            if (connection.getResponseCode() == 200) {
                is = connection.getInputStream();
            } else if (connection.getResponseCode() == 401) {
                is = connection.getErrorStream();
            }
            br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
            String line;
            while ((line = br.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            logger.info("发送GET请求出现异常！" + e);
            e.printStackTrace();
        } finally {
            try {
                if (null != br) {
                    br.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }

            if (null != is) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
        return result;
    }

}
