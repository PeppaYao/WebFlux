package com.bytedance.config;



import com.bytedance.mapper.UserMapper;
import com.bytedance.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;

import java.util.Collection;

//路由器函数

@Configuration
public class RouterFunctionConfig {
    /**
     * Servlet
     *  请求接口：ServletRequest 或者 HttpServletRequest
     *  响应接口：ServletResponse 或者 HttpServletResponse
     * WebFlux
     *  请求接口：ServerRequest
     *  响应接口：ServerResponse
     *  既可以支持servlet规范，又可以支持自定义，比如Netty
     *
     * 本例：
     *  定义Get请求，返回所有的用户对象 URI：/person/find/all
     *
     *  Flux或者Mono是异步即非阻塞 都是Pulisher
     */

    @Bean
    @Autowired
    public RouterFunction<ServerResponse> personFindAll(UserMapper userMapper){

        return RouterFunctions.route(RequestPredicates.GET("/query/find/all"),
                request ->{
                    //返回所有用户的对象
                    Collection<User>  users = userMapper.queryUserList();
                    Flux<User> userFlux = Flux.fromIterable(users);
                    return ServerResponse.ok().body(userFlux, User.class);
                }
        );
    }
}
