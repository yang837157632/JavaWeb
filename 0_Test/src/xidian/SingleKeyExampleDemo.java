package xidian;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;

/**
 * 数据加密 通过某种特殊算法改变原有数据
 * 
 * 双向加密 -->对称加密  非对称加密
 * 单项的加密
 * @author Administrator
 * 
 * 双向加密-->对称加密：DES IDEA RC2 RC4 ...
 */
public class SingleKeyExampleDemo {
	
	
	public static void main(String[] args){
		
		String algorthm = "DES"; // 定义加密算法 DES DESede 
		String message  = "21134324234"; // 需要加密的信息
		
		try {
			// 加密
			
			
			KeyGenerator keyGenerator = KeyGenerator.getInstance(algorthm);
			keyGenerator.init(56); // 选择DES算法，长度为56位
			
			Key key = keyGenerator.generateKey(); // 生产密钥
			// 生成 cipher对象
			Cipher cipher = Cipher.getInstance(algorthm);
			
			// 用密钥加密明文(message)，生产密文 (ciphperText)
			cipher.init(Cipher.ENCRYPT_MODE, key); // 第一个参数 操作模式；第二个参数密钥
			byte[] ciphperText = cipher.doFinal(message.getBytes()); // 得到加密后的字节数组
			System.out.println("加密后的信息："+new String(ciphperText));
			
			// 解密
			
			// 用密钥加密明文，生产密文
			cipher.init(Cipher.DECRYPT_MODE, key);
			byte[] sourceText = cipher.doFinal(ciphperText);
			System.out.println("解密后的信息："+new String(sourceText));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
