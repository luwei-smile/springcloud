package com.microserivers.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

import com.netflix.loadbalancer.AvailabilityFilteringRule;
import com.netflix.loadbalancer.BestAvailableRule;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RetryRule;
import com.netflix.loadbalancer.RoundRobinRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import com.netflix.loadbalancer.ZoneAvoidanceRule;

/**
 * @Auther 卢伟
 * 
 * @Time 2020年3月11日下午3:05:33
 * 
 * @Todo: TODO
 */
@Configuration
public class Configbean {

	@Bean
	@LoadBalanced // 客户端实现负载均衡的工具
	public RestTemplate getrestTemplate() {
		return new RestTemplate();
	}

	@Bean
	public IRule Loadbalanced() {
		new RandomRule();
		new AvailabilityFilteringRule();
		new WeightedResponseTimeRule();
		new RetryRule();
		new BestAvailableRule();
		new ZoneAvoidanceRule();
		return new RoundRobinRule();
	}

}
