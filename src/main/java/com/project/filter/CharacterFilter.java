package com.project.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * Created by zyczyc on 2017/6/16.
 */
public class CharacterFilter implements Filter {




    String encoding = null;  //字符编码

    public String getEncoding() {
        return encoding;
    }

    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    public void destroy() {
        encoding = null;

    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        if(encoding != null){
            request.setCharacterEncoding(encoding);  //设置request的编码格式
            response.setContentType("text/html;charset="+encoding); //设置response字符编码
            response.setCharacterEncoding(encoding);
        }
        chain.doFilter(request, response);  //传递给下一个过滤器
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        encoding = filterConfig.getInitParameter("encoding"); //获取初始化参数

    }
}
