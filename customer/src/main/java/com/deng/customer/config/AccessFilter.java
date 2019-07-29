package com.deng.customer.config;

import com.deng.common.config.AccessControlAllowOriginFilter;

import javax.servlet.annotation.WebFilter;

@WebFilter(urlPatterns = "/*", filterName = "accessControlAllowOriginFilter")
public class AccessFilter extends AccessControlAllowOriginFilter {
}
