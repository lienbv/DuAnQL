package accessfacebook.common;

public class Constans {
	// class này dùng để khai báo id và redirect uri
	public static String FACEBOOK_APP_ID = "1036349233816178";
	public static String FACEBOOK_APP_SECRET = "499260e132876947cce07f664965d8cd";
	public static String FACEBOOK_REDIRECT_URL = "http://localhost:8080/QL_Dat_Ban_NH/login-facebook";
	public static String FACEBOOK_LINK_GET_TOKEN = "https://graph.facebook.com/oauth/access_token?client_id=%s&client_secret=%s&redirect_uri=%s&code=%s";
}
