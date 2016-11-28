package com.fengyu.common.web.taglib;

import com.fengyu.common.web.constant.PermissionConstant;
import org.apache.commons.lang.StringUtils;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.util.List;

/**
 * 
 * @描述: 自定义权限权标签 .
 * @版本: 1.0 .
 */
@SuppressWarnings("serial")
public class PermissionTaglib extends BodyTagSupport {
	
	//private static final Log log = LogFactory.getLog(PermissionTaglib.class);

	private String value; //权限值

	@Override
	public int doStartTag() throws JspException {
		//log.info("permission tag value=" + value);
		if (StringUtils.isNotBlank(value)){
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			@SuppressWarnings("unchecked")
			final List<String> permissions = (List<String>) request.getSession().getAttribute(PermissionConstant.ACTIONS_SESSION_KEY);
			if (permissions.contains(value.trim())){ // 拥有此功能点权限
				return EVAL_BODY_INCLUDE;
			}
		}
		return SKIP_BODY;
	}

	public String getValue() {
		return value;
	}
	
	public void setValue(String value) {
		this.value = value;
	} 
}
