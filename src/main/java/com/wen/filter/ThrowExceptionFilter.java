package com.wen.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author awlwen
 * @since 2017/5/17.
 */
public class ThrowExceptionFilter extends ZuulFilter{
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
        RequestDispatcher dispatcher = request.getRequestDispatcher(
                "/json");
        if (dispatcher != null) {
            ctx.set("sendErrorFilter.ran", true);
            if (!ctx.getResponse().isCommitted()) {
                try {
                    dispatcher.forward(request, ctx.getResponse());
                } catch (ServletException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    private void doSomething() {
        throw new RuntimeException("Exist some errors.......");
    }
}
