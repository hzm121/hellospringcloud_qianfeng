package com.hzm.hellospringcloud.zuul.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;
import sun.misc.Request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author : hzm
 * @date : 2020-02-07 19:32
 */
@Component
public class LoginFilter extends ZuulFilter {
    /**
     * 路由类型：包括："pre"、"routing"、"post"、"error"
     * 上面四个字符串依次代表为路由之前、路由之时、路由之后、发射错误调用
     *
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    /**
     * 收否开启过滤器
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String token = request.getParameter("token");
        if (token == null) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(401);
            ObjectMapper objectMapper = new ObjectMapper();
            Map<String, Object> map = new HashMap<>();
            HttpServletResponse response = currentContext.getResponse();
            response.setContentType("text/html;charset=utf-8");
            map.put("message", "非法请求");
            try {

                currentContext.getResponse().getWriter().write(objectMapper.writeValueAsString(map));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
