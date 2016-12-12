package com.fengyu.common.utils;

import com.alibaba.fastjson.JSON;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 对象转换，应用于相似对象之间的转换复制
 *
 * @author junz
 * @create 2016 12 04 16:08
 */
@Component
public class ObjectTransformer {
    /**
     * 由程序员自己提供一个回调方法
     * @param transformCallBack 转换实现
     * @return
     */
    public Object execute(TransformCallBack transformCallBack){
        return transformCallBack.transformImpl();
    }

    /**
     * 由程序员自己提供一个回调方法
     * @param batchTransformCallBack 转换实现
     * @return
     */
    public List executeBatch(BatchTransformCallBack batchTransformCallBack){
        return batchTransformCallBack.transformImpl();
    }

    /**
     * 将源对象转换为目标对象
     * @param source    回调对象
     * @param target    目标对象
     * @return
     */
    public Object defaultExcute(final Object source,final Object target) {

        return this.execute(new TransformCallBack() {
            @Override
            public Object transformImpl() {
                BeanUtils.copyProperties(source ,target);
                return target;
            }
        });
    }

    /**
     * 将源对象转换为目标对象
     * @param source    回调对象
     * @param targetClass    目标对象
     * @return
     */
    public List defaulBatchtExcute(final List source,final Class targetClass) {

        return this.executeBatch(new BatchTransformCallBack() {
            @Override
            public List transformImpl() {
                List targetList=new ArrayList();
                if(source instanceof List)
                {
                    for (int i = 0; i <source.size() ; i++) {
                        Object ob=null;
                        try {
                            ob=targetClass.newInstance();
                            Map map=BeanUtils.transDataMap2BeanMap4FiledName((Map)source.get(i));
                            ob=JSON.parseObject(JSON.toJSONString(map),targetClass);
                            //BeanUtils.copyProperties4Map2Bean(map,ob);
                        } catch (InstantiationException e) {
                            e.printStackTrace();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        targetList.add(ob);
                    }
                }else
                {
                    //异常处理
                }
                return targetList;
            }
        });
    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("EEE_NBB", "111");
        map.put("EEE_NBB111", "222");
        map = BeanUtils.transDataMap2BeanMap4FiledName(map);
        System.out.println(111);
    }
}
