package pl.pomoku.algorithmservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import pl.pomoku.algorithmservice.serializer.JsonToBinaryRedisSerializer;

@Configuration
@EnableRedisRepositories
public class RedisConfig {
//    @Bean
//    public RedisTemplate<String, BinSearchOutput> redisTemplate(
//            RedisConnectionFactory connectionFactory,
//            RedisSerializer<BinSearchOutput> redisSerializer
//    ) {
//        RedisTemplate<String, BinSearchOutput> template = new RedisTemplate<>();
//        template.setConnectionFactory(connectionFactory);
//        template.setDefaultSerializer(redisSerializer);
//        return template;
//    }
//
//    @Bean
//    public RedisSerializer<BinSearchOutput> redisSerializer() {
//        return new JsonToBinaryRedisSerializer<>();
//    }

//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        RedisStandaloneConfiguration config = new RedisStandaloneConfiguration();
//        config.setHostName("localhost");
//        config.setPort(6379);
//        return new JedisConnectionFactory(config);
//    }

    @Bean
    public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, Object> template = new RedisTemplate<>();
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new StringRedisSerializer());
        template.setHashKeySerializer(new JdkSerializationRedisSerializer());
        template.setValueSerializer(new JsonToBinaryRedisSerializer<>());
        template.setEnableTransactionSupport(true);
        template.afterPropertiesSet();
        return template;
    }
}
