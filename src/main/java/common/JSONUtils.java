package common;

import com.alibaba.fastjson.JSON;
import scala.AnyVal;

/**
 * JSON工具类
 *
 * @author chenwu on 2020.10.31
 */
public class JSONUtils {


    /**
     * 将scala的对象转换为字符串
     *
     * @param object
     * @return {@link String}
     * @author chenwu on 2020.10.31
     */
    public static String fromScalaObjectToJSONString(Object object) {
        return JSON.toJSONString(object);
    }
}
