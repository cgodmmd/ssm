package cn.ssm.cwg.controller;

import cn.ssm.cwg.domain.SysLog;
import cn.ssm.cwg.service.ISysLogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;
import java.util.Date;

/**
 * @author hz
 * @date 2020/4/10 20:05
 */

@Component
@Aspect
public class LogAop {

    @Autowired
    private HttpServletRequest request;

    @Autowired
    private ISysLogService sysLogService;

    private Date visitTime;  // 系统访问开始时间
    private Class clazz;     // 访问的类
    private Method method;   // 访问的方法

    //前置通知  主要是获取开始时间、执行的类是哪一个、执行的是哪一个方法
    @Before("execution(* com.hz.controller.*.*(..))")
    public void doBefore(JoinPoint joinPoint) throws NoSuchMethodException {
        visitTime = new Date();   // 系统开始访问时间

        clazz = joinPoint.getTarget().getClass();   // 具体要让问的类

        String methodName = joinPoint.getSignature().getName();  // 获取访问的方法名称

        Object[] args = joinPoint.getArgs();

        // 获取具体执行的方法的 Method 对象
        if (args == null || args.length == 0) {
            // 获取无参数的方法
            method = clazz.getMethod(methodName);
        } else {
            Class[] calssArgs = new Class[args.length];
            for (int i = 0; i < args.length; i++) {
                calssArgs[i] = args[i].getClass();
            }
            clazz.getMethod(methodName, calssArgs);
        }
    }

    // 后置通知
    @After("execution(* com.hz.controller.*.*(..))")
    public void doAfter(JoinPoint joinPoint) throws Exception {
        // 获取访问时长
        long time =new Date().getTime() - visitTime.getTime();

        // 获取 url
        String url = "";
        if (clazz != null && method != null && clazz != SysLog.class) {
            // 1.获取类上的RequestMapping("/product")
            RequestMapping classAnntation = (RequestMapping) clazz.getAnnotation(RequestMapping.class);
            if (classAnntation != null) {
                String [] calssValue = classAnntation.value();

                // 2.获取方法上的RequestMapping("/findAll.do")
                RequestMapping methodAnnotation = method.getAnnotation(RequestMapping.class);
                if (methodAnnotation != null) {
                    String [] methodValue = methodAnnotation.value();

                    url = calssValue[0] + methodValue[0];

                    // 获取访问的IP
                    String ip = request.getRemoteAddr();

                    // 获取当前操作的用户
                    SecurityContext context = SecurityContextHolder.getContext();   // 从上下文中获取当前登录的用户对象
                    User user =(User)context.getAuthentication().getPrincipal();
                    String userName = user.getUsername();

                    // 将日志相关信息封装在SysLog 对象
                    SysLog sysLog = new SysLog();
                    sysLog.setExecutionTime(time);
                    sysLog.setIp(ip);
                    sysLog.setMethod("[类名] " + clazz.getName() + " [方法名] " + method.getName());
                    sysLog.setUrl(url);
                    sysLog.setUsername(userName);
                    sysLog.setVisitTime(visitTime);

                    System.out.println("sysLog: " + sysLog);

                    // 调用Service完成操作
                    if (clazz.getName() != "com.hz.controller.SysLogController") {
                        sysLogService.save(sysLog);
                    }
                }
            }
        }

    }
}
