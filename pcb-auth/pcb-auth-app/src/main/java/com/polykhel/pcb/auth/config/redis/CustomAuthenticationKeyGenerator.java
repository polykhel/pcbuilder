package com.polykhel.pcb.auth.config.redis;

import org.springframework.security.oauth2.common.util.OAuth2Utils;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.OAuth2Request;
import org.springframework.security.oauth2.provider.token.AuthenticationKeyGenerator;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeSet;

public class CustomAuthenticationKeyGenerator implements AuthenticationKeyGenerator {

    @Override
    public String extractKey(OAuth2Authentication authentication) {
        Map<String, String> values = new LinkedHashMap<>();
        OAuth2Request oAuth2Request = authentication.getOAuth2Request();
        if (!authentication.isClientOnly()) {
            values.put("username", authentication.getName());
        }
        values.put("client_id", oAuth2Request.getClientId());
        if (oAuth2Request.getScope() != null) {
            values.put("scope", OAuth2Utils.formatParameterList(new TreeSet<>(oAuth2Request.getScope())));
        }

        String deviceId = authentication.getOAuth2Request().getRequestParameters().get("device_id");
        if (deviceId != null) {
            values.put("device_id", deviceId);
        }
        return generateKey(values);
    }

    private String generateKey(Map<String, String> values) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("MD5");
            byte[] bytes = digest.digest(values.toString().getBytes(StandardCharsets.UTF_8));
            return String.format("%032x", new BigInteger(1, bytes));
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("MD5 algorithm not available. Fatal (should be in the JDK).", e);
        }
    }
}
