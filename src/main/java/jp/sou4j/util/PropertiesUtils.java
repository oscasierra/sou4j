package jp.sou4j.util;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

/**
 * <p>Propertiesクラスに関する汎用メソッドを提供するクラスです。</p>
 * @author OSCA
 * @since 1.0.0
 */
public class PropertiesUtils {

	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を String 型として取得します。<br/>
	 *   取得した値がインターネットアドレスとして妥当でない場合は例外をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return インターネットアドレス
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な場合
	 */
	public static String getAttributeAsInternetAddressString(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( StringUtils.isNullOrEmpty(key) ) throw new IllegalArgumentException("Method argument 'key' is null or empty.") ;
		return getAttributeAsInternetAddressString(properties, key, false);
	}
	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を String 型として取得します。<br/>
	 *   取得した値がインターネットアドレスとして妥当でない場合は例外をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return インターネットアドレス
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な場合
	 */
	public static String getAttributeAsInternetAddressString(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( StringUtils.isNullOrEmpty(key) ) throw new IllegalArgumentException("Method argument 'key' is null or empty.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && StringUtils.isNullOrEmpty(property) ) return null ;
		if( !isInternetAddress(property) ) throw new PropertiesException("Value of Key '" + key + "' in properties is invalid internet address.") ;
		return property;
	}

	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を String 型として取得します。<br>
	 *   値がNULLもしくは空文字の場合は例外をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない場合
	 */
	public static String getAttributeAsString(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;
		return getAttributeAsString(properties, key, false);
	}
	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を String 型として取得します。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @param nullable NULLもしくは空文字を許可するか否か
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない場合
	 */
	public static String getAttributeAsString(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && StringUtils.isNullOrEmpty(property) ) return null ;
		return property;
	}

	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を Integer型として取得します。<br/>
	 *   値がNULLもしくは空文字の場合も例外をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または正の数として不適切な場合
	 */
	public static Integer getAttributeAsInteger(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key        == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;
		return getAttributeAsInteger(properties, key, false);
	}
	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を Integer型として取得します。<br/>
	 *   なお、Integer型に変換可能であっても、値がマイナスの場合は例外がスローされます。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @param nullable NULLもしくは空文字を許可するか否か
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または正の数として不適切な場合
	 */
	public static Integer getAttributeAsInteger(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key        == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && property == null ) return null ;
		if( !property.matches("^[-]?[0-9]*$") ) throw new PropertiesException("Value of key '" + key + "' in properties is not numerical string.") ;

		return new Integer(property);
	}

	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を Integer型として取得します。<br/>
	 *   なお、Integer型に変換可能であっても、値がマイナスの場合は例外がスローされます。
	 *   値がNULLもしくは空文字の場合も例外をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または正の数として不適切な場合
	 */
	public static Integer getAttributeAsPositiveInteger(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;
		return getAttributeAsPositiveInteger(properties, key, false);
	}
	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を Integer型として取得します。<br/>
	 *   なお、Integer型に変換可能であっても、値がマイナスの場合は例外がスローされます。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @param nullable NULLもしくは空文字を許可するか否か
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または正の数として不適切な場合
	 */
	public static Integer getAttributeAsPositiveInteger(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && property == null ) return null ;
		if( !property.matches("^[0-9]{1,}") ) throw new PropertiesException("Value of key '" + key + "' in properties is not numerical string.") ;

		return new Integer(property);
	}

	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を boolean 型として取得します。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な場合
	 */
	public static Boolean getAttributeAsBoolean(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;
		return getAttributeAsBoolean(properties, key, false);
	}
	/**
	 * <p>
	 *   引数 properties から、指定したキー key の値を boolean 型として取得します。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @param nullable NULLもしくは空文字を許可するか否か
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な場合
	 */
	public static Boolean getAttributeAsBoolean(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && property == null ) return null ;
		if( !isBooleanString(property) ) throw new PropertiesException("Value of key '" + key + "' in properties is not 'true' or 'false'.") ;

		return new Boolean(property.equals("true"));
	}

	/**
	 * <p>
	 * 	引数で指定された properties から、指定されたキー key の値を URL 文字列として返却します。
	 * 	取得を試みた文字列が URL として正しくない場合は PropertiesException をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な値の場合
	 */
	public static String getAttributeAsURLString(Properties properties, String key) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key        == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;
		return getAttributeAsURLString(properties, key, false);
	}

	/**
	 * <p>
	 * 	引数で指定された properties から、指定されたキー key の値を URL 文字列として返却します。
	 * 	取得を試みた文字列が URL として正しくない場合は PropertiesException をスローします。
	 * </p>
	 * @param properties プロパティ
	 * @param key キー
	 * @param nullable NULLもしくは空文字を許可するか否か
	 * @return プロパティの値
	 * @since 1.0.0
	 * @throws PropertiesException 値が取得できない、または不適切な値の場合
	 */
	public static String getAttributeAsURLString(Properties properties, String key, boolean nullable) throws PropertiesException {
		if( properties == null ) throw new IllegalArgumentException("Method argument 'properties' is null.") ;
		if( key        == null ) throw new IllegalArgumentException("Method argument 'key' is null.") ;

		String property = properties.getProperty(key);
		validateNullable(property, key, nullable);
		if( nullable && property == null ) return null ;

		try {
			new URL(property);
			return property;
		}
		catch(MalformedURLException exception) {
			throw new PropertiesException(exception.getMessage());
		}
	}

	/**
	 * <p>引数で指定した複数の Properties クラスのインスタンスを結合し、1つの Properties として返却します。</p>
	 * @param propertiesArray 結合する対象の Properties インスタンス
	 * @return 結合した値を持つ Properties クラスのインスタンス
	 * @since 1.0.0
	 */
	public static Properties marge(Properties... propertiesArray) {
		Properties result = new Properties();

		for( Properties properties : propertiesArray ) {
			for( Object key : properties.keySet() ) {
				Object value = properties.get(key);
				result.put(key, value);
			}
		}

		return result;
	}

	/**
	 * <p>指定されたファイル名 fileName のプロパティファイルをクラスパス上から読み取り、Properties クラスのインスタンスとして返却します。</p>
	 * @param fileName ファイル名
	 * @return Propertiesクラスのインスタンス
	 * @since 1.0.0
	 * @throws PropertiesException ファイルが存在しない場合
	 * @throws IOException ファイルの読込みの際に何らかのエラーが発生した場合
	 */
	public static Properties load(String fileName) throws PropertiesException, IOException {
		Properties  properties  = new Properties();
		try( InputStream inputStream = PropertiesUtils.class.getClassLoader().getResourceAsStream(fileName) ) {
			if(inputStream == null) throw new PropertiesException("Maybe, file " + fileName + " does not exists.");
			properties.load(inputStream);
		}
		catch(PropertiesException e) {
			throw e;
		}
		catch(IOException e ) {
			throw e;
		}

		return properties;
	}

	/**
	 * <p>インターネットアドレスとして妥当な文字列かを検証します。</p>
	 * @param target インターネットアドレス文字列
	 * @return 検証結果
	 */
	private static boolean isInternetAddress( String target ) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;

		String atom      = "[!#$%&`*+/0-9=?A-Z^_'a-z{|}~-]+";
		String localpart = atom + "(\\.|" + atom + ")*";
		String subdomain = atom;
		String domain    = subdomain + "(\\." + subdomain + "|" + subdomain + ")*";
		String addrspec  = "^" + localpart + "@" + domain +  "$";

		return target.matches(addrspec);
	}

	/**
	 * <p>
	 *   指定した文字列が "true" もしくは "false" かを検証します。
	 * </p>
	 * @param target 検証対象文字列
	 * @return 指定した文字列が"true"もしくは"false"の場合にtrueを返却します
	 */
	private static boolean isBooleanString( String target ) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		return ( target.equals("true") || target.equals("false") );
	}

	private static void validateNullable( String property, String key, boolean nullable ) throws PropertiesException {
		if( (StringUtils.isNullOrEmpty(property)) && !nullable ) throw new PropertiesException("Value of key '" + key + "' in properties is null or empty.") ;
	}
}
