package com.ty.dagger2project.util;

import com.google.gson.Gson;

import java.util.Map;

import okhttp3.RequestBody;

/**
 * Created by Lavender on 2018/1/19.
 */

public class JsonUtil {

    /**
     * Map转String
     *
     * @return String
     */
    public static RequestBody mapToRequestBody(Map<String, Object> field8583) {
        field8583.put("appid", "10000001");
        Gson gson = new Gson();
        String jsonStr = gson.toJson(field8583);
        return RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"), jsonStr);
    }

}
