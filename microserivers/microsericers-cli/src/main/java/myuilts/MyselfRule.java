package myuilts;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月16日下午12:57:00
 * 
 * @Todo: 负载均衡自定义算法
 */
@Configuration
public class MyselfRule {

	@Bean
	public IRule Loadbalanced() {
		// 定义自己的算法
		return new RandomRule();

	}

}
