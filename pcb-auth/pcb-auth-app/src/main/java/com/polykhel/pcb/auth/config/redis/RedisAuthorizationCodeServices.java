package com.polykhel.pcb.auth.config.redis;

import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.code.RandomValueAuthorizationCodeServices;
import org.springframework.security.oauth2.provider.token.store.redis.JdkSerializationStrategy;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStoreSerializationStrategy;

import java.util.List;

public class RedisAuthorizationCodeServices extends RandomValueAuthorizationCodeServices {

    private static final String AUTH_CODE = "auth_code:";

    private final RedisConnectionFactory connectionFactory;

    private final RedisTokenStoreSerializationStrategy serializationStrategy = new JdkSerializationStrategy();

    /**
     * Default constructor.
     *
     * @param connectionFactory the connection factory which should be used to obtain a connection to Redis
     */
    public RedisAuthorizationCodeServices(RedisConnectionFactory connectionFactory) {
        this.connectionFactory = connectionFactory;
    }

    @Override
    protected void store(String code, OAuth2Authentication authentication) {
        byte[] key = serializeKey(AUTH_CODE + code);
        byte[] auth = serializeKey(authentication);

        try (RedisConnection connection = getConnection()) {
            connection.set(key, auth);
        }
    }

    @Override
    protected OAuth2Authentication remove(String code) {
        byte[] key = serializeKey(AUTH_CODE + code);

        List<Object> results;
        try (RedisConnection connection = getConnection()) {
            connection.openPipeline();
            connection.get(key);
            connection.del(key);
            results = connection.closePipeline();
        }

        byte[] bytes = (byte[]) results.get(0);
        return deserialize(bytes);
    }

    private RedisConnection getConnection() {
        return connectionFactory.getConnection();
    }

    private OAuth2Authentication deserialize(byte[] bytes) {
        return serializationStrategy.deserialize(bytes, OAuth2Authentication.class);
    }

    private byte[] serializeKey(String object) {
        String prefix = "";
        return serializationStrategy.serialize(prefix + object);
    }

    private byte[] serializeKey(Object object) {
        return serializationStrategy.serialize(object);
    }
}
