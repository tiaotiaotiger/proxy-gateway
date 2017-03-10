package com.bocom.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * ClassName:AccessFilter
 * Function: 
 * Date:     2017年3月9日 下午2:15:07
 * @author   chenzz
 * @since    JDK 1.7
 */

public class AccessFilter extends ZuulFilter {
	private static Logger LOG = LoggerFactory.getLogger(AccessFilter.class);

	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		LOG.info(String.format("%s request to %s", request.getMethod(), request
				.getRequestURL().toString()));
		Object accessToken = request.getParameter("token");
		if (accessToken == null) {
			LOG.warn("access token is empty");
			//ctx.setSendZuulResponse(false);
			//ctx.setResponseStatusCode(401);
			return ctx;
		}
		LOG.info("access token ok");
		return ctx;
	}
}
