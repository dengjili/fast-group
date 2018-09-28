package priv.dengjl.base.exception;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
* @ClassName: FrontExceptionHandler 
* @Description: 统一异常处理
* @date 2017-5-5 下午4:33:47 
*
 */
public class WebExceptionHandler implements HandlerExceptionResolver {  
  
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,  
            Exception ex) {  
        Map<String, Object> model = new HashMap<String, Object>();  
        model.put("ex", ex);  
          
        // 根据不同错误转向不同页面  
        if(ex instanceof WebException) {  
            return new ModelAndView("error-business", model);  
        } else {  
            return new ModelAndView("error", model);  
        }  
    }

}
