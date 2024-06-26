package com.spring.mvc.interceptor;

import com.spring.mvc.util.LoginUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import java.io.PrintWriter;

import static com.spring.mvc.util.LoginUtils.isLogin;

@Configuration
public class AfterLoginInterceptor implements HandlerInterceptor {

    // 로그인 한 이후 비회원만 접근할 수 있는 페이지 접근 차단.

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        // 세션 받아오기
        HttpSession session = request.getSession();

        // 세션 데이터 중 login이라는 이름의 데이터가 있는 지 확인한 후에
        // 존재한다면 요청이 컨트롤러로 들어가지 못하게 하겠다.
        if (isLogin(session)) {
//            response.sendRedirect("/");

            response.setContentType("text/html; charset=UTF-8");
            PrintWriter w = response.getWriter();
            String htmlCode = "<script>\n" +
                    "        alert('이미 로그인한 회원입니다.');\n" +
                    "        location.href='/';\n" +
                    "    </script>";
            w.write(htmlCode);
            w.flush();

            return false; // 컨트롤러로 들어가는 요청을 막음.
        }
        
        return true; // 로그인 안했으면 통과

    }
}
