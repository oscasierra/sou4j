package jp.sou4j.util;

import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.*;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;

/**
 * <p>PropertiesUtils クラスのテストケースクラスです。</p>
 * @author OSCA
 *
 */
public class PropertiesUtilsTest {

	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsBoolean_1_001() throws Exception {
		PropertiesUtils.getAttributeAsBoolean(null, null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsBoolean_1_002() throws Exception {
		PropertiesUtils.getAttributeAsBoolean(null, "key");
	}
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsBoolean_1_003() throws Exception {
		PropertiesUtils.getAttributeAsBoolean(new Properties(), null);
	}
	@Test
	public void getAttributeAsBoolean_1_101() throws Exception {
		Properties properties = new Properties();
		properties.put("key", "true");
		Boolean actual = PropertiesUtils.getAttributeAsBoolean(properties, "key");
		Assert.assertThat(actual, is(true));
	}
	@Test
	public void getAttributeAsBoolean_1_102() throws Exception {
		Properties properties = new Properties();
		properties.put("key", "false");
		Boolean actual = PropertiesUtils.getAttributeAsBoolean(properties, "key");
		Assert.assertThat(actual, is(false));
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : null</li>
	 *   <li>引数2 : null</li>
	 *   <li>期待結果 : 引数1の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_1_001() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(null, null);
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : null</li>
	 *   <li>引数2 : "key"</li>
	 *   <li>期待結果 : 引数1の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_1_002() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(null, "key");
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : new Properties()</li>
	 *   <li>引数2 : null</li>
	 *   <li>期待結果 : 引数2の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_1_003() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(new Properties(), null);
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : new Properties()</li>
	 *   <li>引数2 : ""</li>
	 *   <li>期待結果 : 引数2の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_1_004() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(new Properties(), "");
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : properties (キー "email" に値 "sample@osca.jp" が設定されている)</li>
	 *   <li>引数2 : "email"</li>
	 *   <li>期待結果1 : properties から値 "sample@osca.jp" が取得できる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test
	public void getAttributeAsInternetAddressString_1_101() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("email", "sample@osca.jp");
		String actual = PropertiesUtils.getAttributeAsInternetAddressString(properties, "email");
		Assert.assertEquals("sample@osca.jp", actual);
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : null</li>
	 *   <li>引数2 : null</li>
	 *   <li>引数3 : false</li>
	 *   <li>期待結果 : 引数1の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_2_001() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(null, null, false);
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : null</li>
	 *   <li>引数2 : "key"</li>
	 *   <li>引数3 : false</li>
	 *   <li>期待結果 : 引数1の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_2_002() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(null, "key", false);
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : new Properties()</li>
	 *   <li>引数2 : null</li>
	 *   <li>引数3 : false</li>
	 *   <li>期待結果 : 引数2の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_2_003() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(new Properties(), null, false);
	}
	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : new Properties()</li>
	 *   <li>引数2 : ""</li>
	 *   <li>引数3 : false</li>
	 *   <li>期待結果 : 引数2の検証処理で誤りが検知され IllegalArgumentException がスローされる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsInternetAddressString_2_004() throws Exception {
		PropertiesUtils.getAttributeAsInternetAddressString(new Properties(), "", false);
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : properties (キー "email" に値 "sample@osca.jp" が設定されている)</li>
	 *   <li>引数2 : "email"</li>
	 *   <li>引数3 : false</li>
	 *   <li>期待結果1 : properties から値 "sample@osca.jp" が取得できる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test
	public void getAttributeAsInternetAddressString_2_101() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("email", "sample@osca.jp");
		String actual = PropertiesUtils.getAttributeAsInternetAddressString(properties, "email", false);
		Assert.assertEquals("sample@osca.jp", actual);
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : properties (キー "email" に値 "sample@osca.jp" が設定されている)</li>
	 *   <li>引数2 : "email"</li>
	 *   <li>引数3 : true</li>
	 *   <li>期待結果1 : properties から値 "sample@osca.jp" が取得できる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test
	public void getAttributeAsInternetAddressString_2_102() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("email", "sample@osca.jp");
		String actual = PropertiesUtils.getAttributeAsInternetAddressString(properties, "email", true);
		Assert.assertEquals("sample@osca.jp", actual);
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : properties (キー "email" に値 ""(空文字) が設定されている)</li>
	 *   <li>引数2 : "email"</li>
	 *   <li>引数3 : true</li>
	 *   <li>期待結果1 : properties から値 null が取得できる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test
	public void getAttributeAsInternetAddressString_2_103() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("email", "");
		String actual = PropertiesUtils.getAttributeAsInternetAddressString(properties, "email", true);
		Assert.assertNull(actual);
	}

	/**
	 * <p>メソッド getAttributeAsInternetAddressString(Properties, String, boolean) を検証します。</p>
	 * <ul>
	 *   <li>引数1 : new Properties()</li>
	 *   <li>引数2 : "email"</li>
	 *   <li>引数3 : true</li>
	 *   <li>期待結果1 : properties から値 null が取得できる</li>
	 * </ul>
	 * @throws Exception 何らかの例外がスローされた場合
	 */
	@Test
	public void getAttributeAsInternetAddressString_2_104() throws Exception {
		String actual = PropertiesUtils.getAttributeAsInternetAddressString(new Properties(), "email", true);
		Assert.assertNull(actual);
	}

	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsString_001() throws Exception {
		PropertiesUtils.getAttributeAsString(null, null);
	}
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsString_002() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), null);
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_003() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), "");
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_004() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), "key");
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_005() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "");
		PropertiesUtils.getAttributeAsString(properties, "key");
	}
	@Test
	public void getAttributeAsString_006() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "value");
		String actual = PropertiesUtils.getAttributeAsString(properties, "key");
		assertThat(actual, is("value"));
	}
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsString_101() throws Exception {
		PropertiesUtils.getAttributeAsString(null, null, false);
	}
	@Test(expected=IllegalArgumentException.class)
	public void getAttributeAsString_102() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), null, false);
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_103() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), "", false);
	}
	@Test
	public void getAttributeAsString_104() throws Exception {
		String actual = PropertiesUtils.getAttributeAsString(new Properties(), "", true);
		assertThat(actual, is(nullValue()));
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_105() throws Exception {
		PropertiesUtils.getAttributeAsString(new Properties(), "key", false);
	}
	@Test
	public void getAttributeAsString_106() throws Exception {
		String actual = PropertiesUtils.getAttributeAsString(new Properties(), "key", true);
		assertThat(actual, is(nullValue()));
	}
	@Test(expected=PropertiesException.class)
	public void getAttributeAsString_107() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "");
		PropertiesUtils.getAttributeAsString(properties, "key", false);
	}
	@Test
	public void getAttributeAsString_108() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "");
		String actual = PropertiesUtils.getAttributeAsString(properties, "key", true);
		assertNull(actual);
		assertThat(actual, is(nullValue()));
	}
	@Test
	public void getAttributeAsString_109() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "value");
		String actual = PropertiesUtils.getAttributeAsString(properties, "key", false);
		assertThat(actual, is("value"));
	}
	@Test
	public void getAttributeAsString_110() throws Exception {
		Properties properties = new Properties();
		properties.setProperty("key", "value");
		String actual = PropertiesUtils.getAttributeAsString(properties, "key", true);
		assertThat(actual, is("value"));
	}
}
