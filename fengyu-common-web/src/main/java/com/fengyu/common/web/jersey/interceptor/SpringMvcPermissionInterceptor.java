package com.fengyu.common.web.jersey.interceptor;

import com.fengyu.common.web.jersey.annotation.Permission;
import com.fengyu.common.web.jersey.constant.PermissionConstant;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 自定义的细粒度权限拦截.
 * @author WuShuicheng(吴水成).
 * @version 1.0, 2013-4-2,上午3:58:26.
 */
public class SpringMvcPermissionInterceptor implements MethodInterceptor {

	private static final Log log = LogFactory.getLog(SpringMvcPermissionInterceptor.class);
	
	public Object invoke(MethodInvocation invocation) throws Throwable {

		// 判断该方法是否加了@Permission注解
		if (invocation.getMethod().isAnnotationPresent(Permission.class)) {
			log.info("=== invoke PermissionInterceptor");
			// 得到方法上的Permission注解
			final Permission pm = invocation.getMethod().getAnnotation(Permission.class);
			
			// 获取被注解方法中的request参数，要求方法中一定要有HttpServletRequest参数
			@SuppressWarnings("unchecked")
			RequestAttributes ra = RequestContextHolder.getRequestAttributes();
			HttpServletRequest request = ((ServletRequestAttributes)ra).getRequest();
			final List<String> permissions = (List<String>)request.getSession().getAttribute(PermissionConstant.ACTIONS_SESSION_KEY);
			//final List<String> permissions = (List<String>) ActionContext.getContext().getSession().get(PermissionConstant.ACTIONS_SESSION_KEY);
			if (permissions.contains(pm.value())){ // 拥有此功能点权限
				// 执行被拦截的方法，如果此方法不调用，则被拦截的方法不会被执行
				log.info("== contain permission:" + pm.value());
				return invocation.proceed();
			}
			// 没有此功能点权限
			log.warn("=== 您没有执行此操作的权限:" + pm.value());
			return "permissionError"; // 跳转到错误提示页面.
		}
		// 没加@Permission注解的方法可直接执行
		// 执行被拦截的方法，如果此方法不调用，则被拦截的方法不会被执行
		return invocation.proceed();
	}
}
