package com.project.main.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtService {

	public String generateToken(String userName) {
		
		//key value pair ->key(String) key yepavum same ah tha irukanum 
		//					value(Object)value yepavum change agite irukum 
		Map<String,Object> claims=new HashMap<>();
		
		// token yepadi generate panuvangana JWTS class la irunthu panuvanga
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(userName)
				//system oda current time
				.issuedAt(new Date(System.currentTimeMillis()))
				//current date oda (seconds *min* min)
				.expiration(new Date(System.currentTimeMillis()+60*60*30))//(*60*60*30) -> means 30 min ku token valide ah irukanum
				.and()
				//sign in pana secretkey venum athuku aana method keela iruku
				.signWith(getKey())
				//this will generate token 
				.compact();
	}

	/*
	 * how to generate secret key
	 */
	
	private SecretKey getKey() {
		//string to byte convert
		//				ithu BASE64 decoder algorithm ah use pani decode pani kudukum
		byte[] keyBytes=Decoders.BASE64.decode(secretKey);
		//hmacShaKeyFor -> ithu oru algorithm ithuku byte tha argument la venum ,so convert it 
		return Keys.hmacShaKeyFor(keyBytes);
	}

	/*
	 * key ah encode panarom
	 */
	//step 1 :instance variable
	//private String secretKey="d0512g"; ->ithu hard code so ipadi thara kudathu
	private String secretKey="";
	
	//step 2 : constructor ->obj create agum pothu lam new key create aagum
	public JwtService() {
		//getInstance("______") -> inga yena algorithm nu specify pananum
		try {
			KeyGenerator keyGenerator=KeyGenerator.getInstance("HmacSHA256");
			//generateKey() -> "SecretKey" class ah return panum
			SecretKey key=keyGenerator.generateKey();
			//meela BASE64 decoder tha use pani irukarom  so inga yum athan use pananu,apram atha (getEncoder()) ah use pani encode pananum,apram atha string ah change pananum 
			secretKey=Base64.getEncoder().encodeToString(key.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
		
		
		
	}
	
	/*
	 *  in JwtFilter class -> to extract user name in token
	 */

	 public String extractUserName(String token) {
	        // extract the username from jwt token
	        return extractClaim(token, Claims::getSubject);
	    }

	    private <T> T extractClaim(String token, Function<Claims, T> claimResolver) {
	        final Claims claims = extractAllClaims(token);
	        return claimResolver.apply(claims);
	    }

	    private Claims extractAllClaims(String token) {
	        return Jwts.parser()
	                .verifyWith(getKey())
	                .build()
	                .parseSignedClaims(token)
	                .getPayload();
	    }

	    /*
		in JwtFilter class -> to validate token
		*/
	    
	    public boolean validateToken(String token, UserDetails userDetails) {
	        final String userName = extractUserName(token);
	        return (userName.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }

	    private boolean isTokenExpired(String token) {
	        return extractExpiration(token).before(new Date());
	    }

	    private Date extractExpiration(String token) {
	        return extractClaim(token, Claims::getExpiration);
	    }

	
	

}
