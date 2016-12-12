package com.fengyu.common.exception.Constant;

/**
 * 异常枚举父类
 *
 * @author Administrator
 * @create 2016 12 06 14:13
 */
public class BaseExceptionType {

     enum ExcetionType{
        UNKNOWNEXCEPTION("函数不存在","00001");

        /** 描述 */
        private String desc;
        /** 枚举值 */
        private String code;

        private ExcetionType(String desc,String code){
            this.desc = desc;
            this.code = code;
        }

        @Override
        public String toString() {
            return this.desc;
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
