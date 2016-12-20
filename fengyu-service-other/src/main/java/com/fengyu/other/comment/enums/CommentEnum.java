package com.fengyu.other.comment.enums;

import com.fengyu.common.enums.BaseEnum;

/**
 * ${DESCRIPTION}
 *
 * @author Administrator
 * @create 2016 12 09 17:42
 */
public class CommentEnum {
    public static enum CrowdFundingStatus implements BaseEnum{
        
        CROWDFUNDINGSTATUS_FUNDING("funding","募集中"),
        CROWDFUNDINGSTATUS_SUBMIT("submit","提交"),
        CROWDFUNDINGSTATUS_END("end","募集结束，到期"),
        CROWDFUNDINGSTATUS_REPAY("repay","回报中"),
        CROWDFUNDINGSTATUS_INITIALAUDIT("initial_audit","初次审核"),
        CROWDFUNDINGSTATUS_FINALAUDIT("final_audit","终审"),
        CROWDFUNDINGSTATUS_INITIALLENGING("initial_lending","第一次放款"),
        CROWDFUNDINGSTATUS_FINALLENGING("final_lending","尾款"),
        CROWDFUNDINGSTATUS_FUNDED("funded","募集结束，项目结束"),
        CROWDFUNDINGSTATUS_EDIT("edit","编辑中");
        /** 描述 */
        public String desc="";
        /** 枚举值 */
        public String code = "";

        

        CrowdFundingStatus(String code, String desc) {
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

    public static enum CrowdFundingRaiseType implements BaseEnum{

        CROWDFUNDINGRAISETYPE_MONEY("money","钱"),
        CROWDFUNDINGRAISETYPE_ENTITY("entity","实物");
        /** 描述 */
        public String desc="";
        /** 枚举值 */
        public String code = "";



        CrowdFundingRaiseType(String code, String desc) {
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
