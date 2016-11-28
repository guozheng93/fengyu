package com.fengyu.common.web.controller;

import com.fengyu.common.page.PageBean;
import com.fengyu.common.page.PageParam;
import com.fengyu.common.utils.json.JSONObject;
import com.fengyu.common.utils.string.StrUtil;
import com.fengyu.common.web.utils.UdpGetClientMacAddr;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.*;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.net.URLDecoder;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 */
public class BaseController {

    private static final Log LOG = LogFactory.getLog(BaseController.class);

    public PageBean pageBean;

    public Integer pageNum;

    /**
     * 编码类型 ISO-8859-1.
     */
    // private static final String ISO8859_1 = "iso8859-1";
    /**
     * 编码类型 UTF-8.
     */
    private static final String UTF_8 = "utf-8";


    /**
     * pageBean.
     *
     * @return the pageBean
     */
    public PageBean getPageBean() {
        return pageBean;
    }

    /**
     * @param pageBean
     *            the pageBean to set
     */
    public void setPageBean(PageBean pageBean) {
        this.pageBean = pageBean;
    }

    /**
     * 如果没有值则默认返回1.
     *
     * @author WuShuicheng.
     */
    private int getPageNum(HttpServletRequest req) {
        // 当前页数
        String pageNumStr = req.getParameter("pageNum");
        int pageNum = 1;
        if (StringUtils.isNotBlank(pageNumStr)) {
            pageNum = Integer.valueOf(pageNumStr);
        }
        return pageNum;
    }
    /**
     * 获取每页记录数（DWZ-UI分页查询参数）.<br/>
     * 如果没有值则默认返回15.
     *
     * @author WuShuicheng.
     */
    private int getNumPerPage(HttpServletRequest req) {
        String numPerPageStr = req.getParameter("numPerPage");
        int numPerPage = 20;
        if (StringUtils.isNotBlank(numPerPageStr)) {
            numPerPage = Integer.parseInt(numPerPageStr);
        }
        return numPerPage;
    }

    /**
     * 获取分页参数，包含当前页、每页记录数.
     *
     * @return PageParam .
     */
    public PageParam getPageParam(HttpServletRequest req) {
        return new PageParam(getPageNum(req), getNumPerPage(req));
    }


    /**
     * 取得当前web应用的根路径
     *
     * @return
     */
    public String getWebRootPath(HttpServletRequest req) {
        return req.getServletContext().getRealPath("/");
    }

    /**
     * 添加cookie
     *
     * @param path
     * @param key
     * @param value
     * @param maxAge
     */
    public void addCookie(HttpServletResponse res,String path, String key, String value, int maxAge) {
        Cookie cookie = new Cookie(key, value);
        if (path != null) {
            cookie.setPath(path);
        }
        cookie.setMaxAge(maxAge);
        res.addCookie(cookie);
    }
    /**
     * 添加cookie
     *
     * @param key
     * @param value
     */
    public void addCookie(HttpServletResponse res,String key, String value) {
        Cookie cookie = new Cookie(key, value);
        res.addCookie(cookie);
    }

    /**
     * 根据参数名从HttpRequest中获取Double类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return DoubleValue or null .
     */
    public Double getDouble(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Double.parseDouble(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取Integer类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return IntegerValue or null .
     */
    public Integer getInteger(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Integer.parseInt(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取Long类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return LongValue or null .
     */
    public Long getLong(HttpServletRequest req,String key) {
        String value = req.getParameter(key);
        if (StringUtils.isNotBlank(value)) {
            return Long.parseLong(value);
        }
        return null;
    }

    /**
     * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return String or null .
     */
    public String getString(HttpServletRequest req,String key) {
        return req.getParameter(key);
    }

    /**
     * 根据参数名从HttpRequest中获取String类型的参数值，无值则返回"" .
     *
     * @param key
     *            .
     * @return String .
     */
    public String getString_UrlDecode_UTF8(HttpServletRequest req,String key) {
        try {
            return URLDecoder.decode(this.getString(req,key), UTF_8);
        } catch (Exception e) {
            return "";
        }

    }

    public String getString_UrlDecode_GBK(HttpServletRequest req,String key) {
        try {
            return new String(getString(req,key.toString()).getBytes("GBK"), "UTF-8");
        } catch (Exception e) {
            return "";
        }

    }
    /**
     * 根据参数名从HttpRequest中获取String[] 类型的参数值 有 返回字符串数组 无 返回null;
     *
     * @param key
     *            .
     * @return String[] or null .
     */
    public String[] getStringArr(HttpServletRequest req,String key) {
        return req.getParameterValues(key);
    }

    /**
     * 根据参数名从HttpRequest中获取Integer[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Integer[] or null .
     */
    public Integer[] getIntegerArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Integer[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Integer[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Integer.parseInt(values[i]);
            }
        }
        return returnArr;
    }

    /**
     * 根据参数名从HttpRequest中获取Long[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Long[] or null .
     */
    public Long[] getLongArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Long[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Long[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Long.parseLong(values[i]);
            }
        }
        return returnArr;
    }

    /**
     * 根据参数名从HttpRequest中获取Long[] 类型的参数值，无值则返回null .
     *
     * @param key
     *            .
     * @return Long[] or null .
     */
    public Double[] getDoubleArr(HttpServletRequest req,String key) {
        String[] values = req.getParameterValues(key);
        Double[] returnArr = null;
        if (values != null) {
            int valueLength = values.length;
            returnArr = new Double[valueLength];
            for (int i = 0; i < valueLength; i++) {
                returnArr[i] = Double.parseDouble(values[i]);
            }
        }
        return returnArr;
    }

    /**
     *
     * @param propertyName
     *            要校验的属性中文名称，如“登录名”.
     * @param property
     *            要校验的属性值，如“gzzyzz”.
     * @param isRequire
     *            是否必填:true or false.
     * @param minLength
     *            最少长度:大于或等于0，如果不限制则可请设为0.
     * @param maxLength
     *            最大长度:对应数据库字段的最大长度，如不限制则可设为0.
     * @return 校验结果消息，校验通过则返回空字符串 .
     */
    protected String lengthValidate(String propertyName, String property, boolean isRequire, int minLength, int maxLength) {
        int propertyLenght = StrUtil.strLengthCn(property);
        if (isRequire && propertyLenght == 0) {
            return propertyName + "不能为空，"; // 校验不能为空
        } else if (isRequire && minLength != 0 && propertyLenght < minLength) {
            return propertyName + "不能少于" + minLength + "个字符，"; // 必填情况下校验最少长度
        } else if (maxLength != 0 && propertyLenght > maxLength) {
            return propertyName + "不能多于" + maxLength + "个字符，"; // 校验最大长度
        } else {
            return ""; // 校验通过则返回空字符串 .
        }
    }

    /**
     * 获取客户端的IP地址
     *
     * @return
     */
    public String getIpAddr(HttpServletRequest req) {
        String ipAddress = null;
        ipAddress = req.getHeader("x-forwarded-for");
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
            ipAddress = req.getRemoteAddr();
            if (ipAddress.equals("127.0.0.1") || ipAddress.equals("0:0:0:0:0:0:0:1")) {
                // 根据网卡取本机配置的IP
                InetAddress inet = null;
                try {
                    inet = InetAddress.getLocalHost();
                } catch (UnknownHostException e) {
                    e.printStackTrace();
                }
                ipAddress = inet.getHostAddress();
            }

        }

        // 对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割
        if (ipAddress != null && ipAddress.length() > 15) {
            if (ipAddress.indexOf(",") > 0) {
                ipAddress = ipAddress.substring(0, ipAddress.indexOf(","));
            }
        }
        return ipAddress;
    }
    /**
     * 获取客户端MAC地址
     *
     * @return
     */
    public String getClientMacAddr(HttpServletRequest req) {
        try {
            return new UdpGetClientMacAddr(this.getIpAddr(req)).GetRemoteMacAddr();
        } catch (SocketTimeoutException e) {
            return "00:00:00:00";
        } catch (Exception e) {
            return "00:00:00:00";
        }

    }
    /**
     * 获取请求中的参数值
     *
     * @return
     */
    public Map<String, Object> getParamMap(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString(req,key.toString()));
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值，如果参数值为null刚转为空字符串""
     *
     * @return
     */
    public Map<String, Object> getParamMap_NullStr(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            String value = this.getString(req,key.toString());
            if (value == null){
                value = "";
            }
            parameters.put(key.toString(), value);
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getParamMap_Utf8(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString_UrlDecode_UTF8(req,key.toString()));
        }
        return parameters;
    }

    /**
     * 获取请求中的参数值
     *
     * @return
     */
    @SuppressWarnings("rawtypes")
    public Map<String, Object> getParamMap_GBK(HttpServletRequest req) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        Map map = req.getParameterMap();
        Set keys = map.keySet();
        for (Object key : keys) {
            parameters.put(key.toString(), this.getString_UrlDecode_GBK(req,key.toString()));
        }
        return parameters;
    }
    /**
     * 获取refererUrl
     */
    public String getRefererUrl(HttpServletRequest req) {
        return req.getHeader("referer");
    }

    /**
     * 获取字符串的编码
     *
     * @param str
     * @return
     */
    public static String getEncoding(String str) {
        String encode = "GB2312";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s = encode;
                return s;
            }
        } catch (Exception exception) {
        }
        encode = "ISO-8859-1";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s1 = encode;
                return s1;
            }
        } catch (Exception exception1) {
        }
        encode = "UTF-8";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s2 = encode;
                return s2;
            }
        } catch (Exception exception2) {
        }
        encode = "GBK";
        try {
            if (str.equals(new String(str.getBytes(encode), encode))) {
                String s3 = encode;
                return s3;
            }
        } catch (Exception exception3) {
        }
        return "";
    }


}
