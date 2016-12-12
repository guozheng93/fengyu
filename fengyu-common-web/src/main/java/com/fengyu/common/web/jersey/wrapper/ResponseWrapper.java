package com.fengyu.common.web.jersey.wrapper;

import com.fengyu.common.page.PageBean;

import java.util.ArrayList;
import java.util.List;

public class ResponseWrapper {
    private static final String WARNING = "[WARNING]: ";
    private static final String ERROR = "[ERROR]: ";

    private List<String> messages = new ArrayList<String>();
    private Integer responseStatus;
    private PageBean responseBody;
    private Boolean hasError = Boolean.FALSE;
    private String returnCode;
    public ResponseWrapper()
    {
        this.responseStatus=200;
        this.returnCode="00000";
    }
    public ResponseWrapper(Integer responseStatus,String returnCode)
    {
        this.responseStatus=responseStatus;
        this.returnCode=returnCode;
    }
    public String getReturnCode() {
        return returnCode;
    }

    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    public Boolean getHasError() {
        return hasError;
    }

    public void setHasError(Boolean hasError) {
        this.hasError = hasError;
    }

    public static ResponseWrapper newInstance() {
        return new ResponseWrapper();
    }

    public List<String> getMessages() {
        return messages;
    }

    public void addWarning(String warning) {
        messages.add(WARNING + warning);
    }

    public void addError(String error) {
        messages.add(ERROR + error);
        hasError = Boolean.TRUE;
    }

    public Boolean hasError() {
        return hasError;
    }

    public PageBean getResponseBody() {
        return responseBody;
    }

    public void setResponseBody(PageBean responseBody) {
        this.responseBody = responseBody;
    }

    public Integer getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(Integer responseStatus) {
        this.responseStatus = responseStatus;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for( String message : messages ) {
            sb.append(message).append("\n");
        }
        sb.append("Status: ").append(responseStatus).append("\n");
        if(null != responseBody) {
            if(responseBody.getClass().getName().endsWith("ObjectNode")){
                sb.append("ResponseEncapsulation Body: ").append(responseBody.toString());
            }
            else {
                sb.append("ResponseEncapsulation Body: ").append(responseBody.getClass().getName());
            }
        }


        return sb.toString();
    }
}
