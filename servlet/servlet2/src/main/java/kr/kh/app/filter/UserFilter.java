package kr.kh.app.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;

import kr.kh.app.model.vo.UserVO;


// 아래 해당하는 url 접속시 필터 작동 "" , 식으로 콤마로 이어가도록 함
@WebFilter({"/comm/insert", "/comm/update"})
public class UserFilter extends HttpFilter implements Filter {
       

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 세션에서 유저정보 가져옴
		// 유저형식도 맞춰주어야하고 requset 형식도 맟춰 주어야 함 무슨 리퀘스트가 있는지 확인 해 볼것
		// 없으면 return;
		UserVO user = (UserVO)((HttpServletRequest)request).getSession().getAttribute("user");
		
		if (user==null) {
			request.setAttribute("msg", "로그인이 필요한 서비스입니다.");
			request.setAttribute("url", "/login");
			request.getRequestDispatcher("/WEB-INF/views/common/msg.jsp").forward(request, response);
			return;
		}
		
		// 세션에서 유저정보 가져옴
		
		
		chain.doFilter(request, response);
	}


}
