package com.fengyu.facade.order.enums;

import com.fengyu.common.enums.BaseEnum;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2016 12 09 17:42
 */
public class OrderEnum {
    public static enum OrderStatus implements BaseEnum{

        ORDER_STATUS_PAIDED("paided","已支付"),
        ORDER_STATUS_NOTPAID("notpaid","未支付"),
        ORDER_STATUS_CANNEL("cannel","取消"),
        ORDER_STATUS_DELETE("delete","删除"),
        ORDER_STATUS_TIMEOUT("timeout","超时");
        /** 描述 */
        public String desc="";
        /** 枚举值 */
        public String code = "";



        OrderStatus(String code, String desc) {
            this.code=code;
            this.desc=desc;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }
    }



}
