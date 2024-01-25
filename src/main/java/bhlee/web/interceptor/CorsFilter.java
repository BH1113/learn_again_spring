package bhlee.web.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
public class CorsFilter extends HandlerInterceptorAdapter {
    private String allowOrigin = "http://localhost:3001";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String reqHeaderOrigin = request.getHeader("Origin");
        if (allowOrigin.equals(reqHeaderOrigin)) {
            response.setHeader("Access-Control-Allow-Origin", reqHeaderOrigin);
            response.setHeader("Access-Control-Allow-Credentials", "true"); //쿠키 요청을 허용
            response.setHeader("Access-Control-Allow-Methods","POST, GET"); //허용할 HTTP 메서드
            response.setHeader("Access-Control-Allow-Headers", "*"); //요청을 허용할 헤더
            log.info(response.getHeader("Access-Control-Allow-Headers"));
            log.info(response.getHeader("Access-Control-Allow-Origin"));
            return true;
        }
        log.info(String.valueOf(response.getStatus()));
        log.info(response.getHeader("Access-Control-Allow-Headers"));
        return false;
    }
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
    }
}
