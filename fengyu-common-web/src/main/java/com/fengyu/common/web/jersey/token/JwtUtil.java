package com.fengyu.common.web.jersey.token;

import com.alibaba.fastjson.JSONObject;
import com.fengyu.facade.user.login.entity.po.UserPO;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;

@Component
public class JwtUtil {
	
	@Value("${spring.profiles.active}")
    private String profiles;

	//单利模式 线程安全保证唯一性
	private  static Key key =null;
	public synchronized  static Key getKeyInstance() {
		if (key == null) {
			key =  MacProvider.generateKey();
		}
		return key;
	}
	static{
		// TODO Auto-generated method stub
		getKeyInstance();
	}
	
//	/**
//	 * 由字符串生成加密key
//	 * @return
//	 */
//	public SecretKey generalKey(){
//		String stringKey = profiles+Constant.JWT_SECRET;
//		byte[] encodedKey = Base64.decodeBase64(stringKey);
//	    SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//		System.out.println(encodedKey);
//		return key;
//	}

	/**
	 * 创建jwt
	 * @param id
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public String createJWT(String id, String subject, long ttlMillis) throws Exception {
		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		JwtBuilder builder = Jwts.builder()
			.setId(id)
			.setIssuedAt(now)
			.setSubject(subject)
		    .signWith(signatureAlgorithm, key);
		if (ttlMillis >= 0) {
		    long expMillis = nowMillis + ttlMillis;
		    Date exp = new Date(expMillis);
		    builder.setExpiration(exp);
		}
		return builder.compact();
	}
	
	/**
	 * 解密jwt
	 * @param jwt
	 * @return
	 * @throws Exception
	 */
	public Claims parseJWT(String jwt) throws Exception{

		Claims claims = Jwts.parser()
		   .setSigningKey(key)
		   .parseClaimsJws(jwt).getBody();
		System.out.println(key);
		return claims;
	}
	
	/**
	 * 生成subject信息
	 * @param userPO
	 * @return
	 */
	public static String generalSubject(UserPO userPO){
		JSONObject jo = new JSONObject();
		jo.put("id", userPO.getId());
		jo.put("phone", userPO.getPhone());
		return jo.toJSONString();
	}
}
