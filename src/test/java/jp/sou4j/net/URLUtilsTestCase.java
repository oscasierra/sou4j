package jp.sou4j.net;

import org.junit.Assert;
import org.junit.Test;

public class URLUtilsTestCase {

	@Test
	public void addQueryParameter_101() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz", "key1", "value1");
		Assert.assertEquals("http://www.abc.xyz?key1=value1", actual);
	}
	@Test
	public void addQueryParameter_102() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz?", "key1", "value1");
		Assert.assertEquals("http://www.abc.xyz?key1=value1", actual);
	}
	@Test
	public void addQueryParameter_103() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz?key1=value1", "key2", "value2");
		Assert.assertEquals("http://www.abc.xyz?key1=value1&key2=value2", actual);
	}
	@Test
	public void addQueryParameter_104() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz?key1=value1&", "key2", "value2");
		Assert.assertEquals("http://www.abc.xyz?key1=value1&key2=value2", actual);
	}
	@Test
	public void addQueryParameter_201() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz", "key1", "あ");
		Assert.assertEquals("http://www.abc.xyz?key1=%E3%81%82", actual);
	}
	@Test
	public void addQueryParameter_202() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz", "key1", "あ");
		       actual = URLUtils.addQueryParameter(actual, "key2", "あ");
		Assert.assertEquals("http://www.abc.xyz?key1=%E3%81%82&key2=%E3%81%82", actual);
	}
	@Test
	public void addQueryParameter_203() throws Exception {
		String actual = URLUtils.addQueryParameter("http://www.abc.xyz", "key1", "");
		       actual = URLUtils.addQueryParameter(actual, "key2", "あ");
		Assert.assertEquals("http://www.abc.xyz?key1=&key2=%E3%81%82", actual);
	}
}
