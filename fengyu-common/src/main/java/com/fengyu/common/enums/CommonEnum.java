package com.fengyu.common.enums;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2016 12 09 17:42
 */
public class CommonEnum {
    public static enum RespnoseReturnCode implements BaseEnum{

        RESPNOSE_RETURN_CODE_NORMAL("00000","正常");
        /** 描述 */
        public String desc="";
        /** 枚举值 */
        public String code = "";



        RespnoseReturnCode(String code, String desc) {
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
