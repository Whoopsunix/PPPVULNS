package com.example.versioncheck;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

/**
 * @author Whoopsunix
 */

public class versionCheck {
    @Test
    public void fastjson1_2_80() {
        String poc = "";
        JSONObject jsonObject = JSON.parseObject(poc);
        System.out.println(jsonObject.toString());
    }
}
