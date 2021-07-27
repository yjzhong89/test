package com.zyj.test.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhongyj
 * @since 2021-03-25 17:43
 */
public class Test1 {
    public static void main(String[] args) {
        List<Map> list= new ArrayList<>();
        Map map  = new HashMap();
        map.put("a", 1);
        list.add(map);
        map.put("b", 2);
    }
}
