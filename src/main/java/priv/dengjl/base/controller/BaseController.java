package priv.dengjl.base.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import priv.dengjl.base.exception.WebException;


/**
 * @ClassName: BaseController
 * @Description: 控制层的基类
 * @Date 
 */
@Controller
public class BaseController {
	private static Logger logger = Logger.getLogger(BaseController.class.getName());

	// 用于js提示

	/**
	 * @Title: toPage
	 * @Description: 跳转到WEB-INF/content/下的某个文件夹下的jsp页面
	 * @param folder
	 *            文件夹名
	 * @param jspPage
	 *            目标jsp页面名，不带扩展名
	 * @return 参数 String 返回类型
	 * @throws
	 */
	protected String toPage(String folder, String jspPage) {
		return (folder + '/' + jspPage);
	}

	/**
	 * @Title: toForwardController
	 * @Description: 将请求转发到另外一个action 具体例子请参照@BetContorller 类的@initPageTest 方法
	 * @param action
	 *            转发的action
	 * @param param
	 *            参数
	 * @return 参数 String 返回类型
	 * @throws
	 */
	protected String toForwardController(String action, Map<String, Object> param) {
		if (param == null || param.isEmpty()) {
			return ("forward:/" + action);
		}
		String params = "?_=1";
		for (Entry<String, Object> p : param.entrySet()) {
			params = params + "&" + p.getKey() + "=" + p.getValue();
		}
		return ("forward:/" + action + params);
	}

	/**
	 * @Title: toRedirectController
	 * @Description: 重定向到另外一个controller 具体例子请参照@BetContorller 类的 initPageTest 方法
	 * @param action
	 *            路径
	 * @param param
	 *            参数
	 * @return 参数 String 返回类型
	 * @throws
	 */
	protected String toRedirectController(String action, Map<String, Object> param) {
		if (param == null || param.isEmpty()) {
			return ("redirect:/" + action);
		}

		String params = "?_=1";
		for (Entry<String, Object> p : param.entrySet()) {
			params = params + "&" + p.getKey() + "=" + p.getValue();
		}
		return ("redirect:/" + action + params);
	}

	/**
	 * @Title: jsonToPage
	 * @Description: 将json输出到页面上
	 * @param jsonResult
	 * @param response
	 *            参数 void 返回类型
	 * @throws
	 */
	protected void jsonToPage(String jsonResult, HttpServletResponse response) {

		response.setContentType("application/json;charset=UTF-8");
		// 获取jsonResult并发送响应
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(jsonResult);
			out.flush();
			out.close();
		} catch (IOException e) {
			logger.error("输出失败", e);
		}
	}

	/**
	* @Title: toJspPage 
	*  @Description: 直接跳到content文件夹下某个二级文件夹下的jsp页面
	* http://localhost/fast-group/base/test.index.do
	* @return    参数 
	* String  返回类型 
	* @throws
	 */
	@RequestMapping(value="/{contentName}.{jspName}.jsp", method=RequestMethod.GET)
	public String toJspPage(@PathVariable String contentName, @PathVariable String jspName) {
		return toPage(contentName, jspName);
	}
	
	/**
	 * @Title: exp
	 * @Description: 错误处理
	 * @param request
	 * @param ex
	 * @return 参数 String 返回类型
	 * @throws
	 */
	@ExceptionHandler
	public String exp(HttpServletRequest request, Exception ex) {

		request.setAttribute("ex", ex);
		logger.info(ex.getMessage(), ex);
		// 根据不同错误转向不同页面
		if (ex instanceof WebException) {
			return toPage("exception", "error-business");
		} else {
			return toPage("exception", "error");
		}
	}	
}
