package com.edudigital.demo.util;

import com.edudigital.demo.common.CustomRuntimeException;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.text.SimpleDateFormat;

@Slf4j
public class JsonUtil {

    private static ObjectMapper mapper = new ObjectMapper();

    private JsonUtil() {
    }

    public static <T> String pojoToJson(T pojo) {
        if(pojo == null) {
            return null;
        } else {
            try {
                String e = getMapper().writeValueAsString(pojo);
                return e;
            } catch (IOException var2) {
                throw new CustomRuntimeException("Failed to convert Object2JSONString. ", new Object[]{var2});
            }
        }
    }

    public static <T> T jsonToPojo(String json, Class<T> pojoClass) {
        if(!StringUtils.hasText(json)) {
            return null;
        } else {
            try {
                return getMapper().readValue(json, pojoClass);
            } catch (IOException var3) {
                throw new CustomRuntimeException("Failed to convert JSONString2Object. ", new Object[]{var3});
            }
        }
    }

    public static <T> T jsonToPojo(Reader src, Class<T> pojoClass) throws JsonParseException, JsonMappingException, IOException {
        return getMapper().readValue(src, pojoClass);
    }

    private static ObjectMapper getMapper() {
        if(mapper != null) {
            return mapper;
        } else {
            Class var0 = JsonUtil.class;
            synchronized(JsonUtil.class) {
                if(mapper != null) {
                    return mapper;
                } else {
                    mapper = new ObjectMapper();
                    mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                    return mapper;
                }
            }
        }
    }
}
