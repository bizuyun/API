package com.fubt.bzuApiUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;
import java.util.Map;
import java.util.TreeMap;


/**
 * @Description 签名类
 * @auther: wangzh
 * @date: 2019/08/29
 */
public class Sign {

    private static Logger logger =  LoggerFactory.getLogger(Sign.class);

    public static String jsonToString(String json){
        JSONObject jsonObject = JSON.parseObject(json);
        Map<String, Object> treeMap = new TreeMap<>();
        jsonObject.forEach((s, o) -> treeMap.put(s, o));
        StringBuilder result = new StringBuilder();
        treeMap.forEach((s, o) -> {
            StringBuilder stringBuilder = new StringBuilder();
            if (o instanceof JSONArray) {
                JSONArray jsonArray = (JSONArray) o;
                jsonArray.forEach(o1 -> {
                    stringBuilder.append(o1).append(",");
                });
                stringBuilder.deleteCharAt(stringBuilder.length() -1);
            } else if (o instanceof JSONObject) {
                stringBuilder.append(jsonToString(((JSONObject) o).toJSONString()));
            } else {
                stringBuilder.append(o);
            }
            result.append(s).append("=").append(stringBuilder.toString()).append("&");
        });
        result.deleteCharAt(result.length() -1);
        return result.toString();
    }

    /**
     * sha256_HMAC加密
     *
     * @param json 参数信息
     * @param secret 秘钥
     * @return 加密后字符串
     */
    public static String sha256_HMAC(String json, String secret) {
        String hash = "";
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
            SecretKeySpec secret_key = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] bytes = sha256_HMAC.doFinal(json.getBytes());
            hash = Base64.getEncoder().encodeToString(bytes);
        } catch (Exception e) {
            logger.error("Error HmacSHA256 ===========" + e.getMessage(), e);
        }
        return hash;
    }

}
