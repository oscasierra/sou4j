package jp.sou4j.util;

public class StringUtils {

	/**
	 * <p>指定した文字列がNULLもしくは空文字("")かを検証します。</p>
	 * @param str 検証対象文字列
	 * @return 指定した文字列がNULLもしくは空文字("")である場合にtrueを返却します。
	 */
	public static boolean isNullOrEmpty(String str) {
		return ( str == null || str.equals("") );
	}

	/**
	 * <p>指定した文字列が空文字("")である場合にNULLに変換して返却します。</p>
	 * @param str 変換対象文字列
	 * @return 指定した文字列がNULLもしくは空文字("")である場合にNULLを返却します。 それ以外の場合は、指定した文字列をそのまま返却します。
	 */
	public static String convertEmptyToNull(String str) {
		return ( isNullOrEmpty(str) ) ? null : str ;
	}

	/**
	 * <p>指定された文字列からHTMLタグを取り除いた文字列を返却します。</p>
	 * @param target 対象文字列
	 * @return 結果文字列
	 */
	public static String removeHtmlTags(String target) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		return target.replaceAll("<(\".*?\"|'.*?'|[^'\"])*?>", "");
	}
}
