//package com.fengyu.web.util.token;
//
//import io.jsonwebtoken.JwtBuilder;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import javax.crypto.spec.SecretKeySpec;
//import javax.xml.bind.DatatypeConverter;
//import java.util.Date;
//
///**
// * @author admin
// * @version V1.0
// * @date 2016/12/2
// */
//public class JwtUtil {
//
//
//    public static final String JWT_SECRET = "7786df7fc3a34e26a61c034d5ec8245d";
//
//    /**
//     * 由字符串生成加密key
//     * @return
//     */
//    public SecretKey generalKey(){
//        String stringKey = JWT_SECRET;
//        byte[] encodedKey = Base64.decodeBase64(stringKey);
//        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//        return key;
//    }
//
//    //Sample method to construct a JWT
//    private String createJWT(String id, String issuer, String subject, long ttlMillis) {
//
//        //The JWT signature algorithm we will be using to sign the token
//        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
//
//        long nowMillis = System.currentTimeMillis();
//        Date now = new Date(nowMillis);
//
//        //We will sign our JWT with our ApiKey secret
//        byte[] apiKeySecretBytes = DatatypeConverter.parseBase64Binary(apiKey.getSecret());
//        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());
//
//        //Let's set the JWT Claims
//        JwtBuilder builder = Jwts.builder().setId(id)
//                .setIssuedAt(now)
//                .setSubject(subject)
//                .setIssuer(issuer)
//                .signWith(signatureAlgorithm, signingKey);
//
//        //if it has been specified, let's add the expiration
//        if (ttlMillis >= 0) {
//            long expMillis = nowMillis + ttlMillis;
//            Date exp = new Date(expMillis);
//            builder.setExpiration(exp);
//        }
//
//        //Builds the JWT and serializes it to a compact, URL-safe string
//        return builder.compact();
//    }
//
//}
