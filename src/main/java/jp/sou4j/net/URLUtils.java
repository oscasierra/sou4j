package jp.sou4j.net;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import jp.sou4j.util.StringUtils;

/**
 * <p>URLに関する汎用メソッドを提供するクラスです。</p>
 * @author OSCA
 * @Since 1.0.0
 */
public class URLUtils {

	/**
	 * <p>指定したURL文字列に指定した変数名と値のクエリパラメータを追加し、そのURLを返却します。</p>
	 * @param target URL文字列
	 * @param name 変数名
	 * @param value 値
	 * @return クエリパラメータを追加したURL文字列
	 * @since 1.0.0
	 * @throws UnsupportedEncodingException クエリパラメータをURLエンコードする際に例外が発生した場合
	 */
	public static String addQueryParameter(String target, String name, String value) throws UnsupportedEncodingException {
		if (target == null) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if (name   == null) throw new IllegalArgumentException("Method argument 'name' is null.") ;
		if (value  == null) throw new IllegalArgumentException("Method argument 'value' is null.") ;

		URL url;
		try {
			url = new URL(target);
		}
		catch(MalformedURLException exception) {
			throw new IllegalArgumentException("Method argument 'target' is malformed URL. ("+exception.getMessage()+")") ;
		}

		String query = url.getQuery();

		// クエリ文字列を分割する
		Map<String, String> queryMap = splitQuery(query);

		// クエリを追加する
		queryMap.put(name, value);

		// クエリ文字列を作成する
		String newQuery = makeQuery(queryMap);

		// 返却値の作成
		String base = ( query != null ) ? target.replace(query, "") : target+"?" ;
		return base+newQuery;
	}

	/**
	 * <p>指定された Map からクエリ文字列を作成して返却します。</p>
	 * @param map 変数名と値を保持するMap
	 * @return クエリ文字列
	 * @throws UnsupportedEncodingException
	 */
	private static String makeQuery(Map<String, String> map) throws UnsupportedEncodingException {

		StringBuffer buffer = new StringBuffer();
		if( map.size() == 0 ) return buffer.toString() ;

		for (Entry<String, String> entry : map.entrySet()) {
			String key   = URLEncoder.encode(entry.getKey(),"UTF-8");
			String value = URLEncoder.encode(entry.getValue(),"UTF-8");
			buffer.append(key + "=" + value + "&");
		}
		return buffer.toString().substring(0, buffer.toString().length()-1);
	}

	/**
	 * <p>クエリ文字列を分割し、Mapとして返却します。</p>
	 * @param query クエリ文字列
	 * @return 変数名と値を保持したMap
	 */
	private static Map<String, String> splitQuery(String query) {
		Map<String, String> queryMap = new HashMap<String,String>();
		if( StringUtils.isNullOrEmpty(query) ) return queryMap ;

		for( String q : query.split("&") ) {
			String[] keyValue = q.split("=");
			String key   = keyValue[0];
			String value = (keyValue.length == 2) ? keyValue[1] : "" ;

			try {
				key = URLDecoder.decode(key, "UTF-8");
			}
			catch(Exception exception) {}

			try {
				value = URLDecoder.decode(value, "UTF-8");
			}
			catch(Exception exception){}

			queryMap.put(key, value);
		}

		return queryMap;
	}
}
