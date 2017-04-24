package leetcode;

import java.util.ArrayList;

public class Encode_and_Decode_TinyURL_535 {
	ArrayList<String> urLs=new ArrayList<String>();

	 // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        int index=urLs.size();
        urLs.add(longUrl);
    	return String.valueOf(index);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        int index=Integer.parseInt(shortUrl);
    	return urLs.get(index);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
