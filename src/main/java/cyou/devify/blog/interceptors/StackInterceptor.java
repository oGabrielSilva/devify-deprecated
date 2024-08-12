package cyou.devify.blog.interceptors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cyou.devify.blog.services.StackService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class StackInterceptor implements HandlerInterceptor {
    @Autowired
    StackService stackService;

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
            ModelAndView modelAndView) throws Exception {
        var stacks = stackService.getAll();

        if (stacks != null) {
            modelAndView.addObject("stacks", stacks);
        }
    }

}
