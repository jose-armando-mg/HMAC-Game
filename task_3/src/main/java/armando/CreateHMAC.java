package armando;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class CreateHMAC{
	public String getHMAC(String key, String data) throws Exception{
		Mac mac = Mac.getInstance("HmacSHA256");
		SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(),"HmacSHA256");
		mac.init(secretKey);

		byte[] finalBytes = mac.doFinal(data.getBytes());
		return bytesToHex(finalBytes);
	}

	public static String bytesToHex(byte[] a){
		StringBuilder result = new StringBuilder(a.length*2);
		for(byte b : a){
			result.append(String.format("%02x",b));
		}
		return result.toString();
	}
}
