package jp.sou4j.util.validator;

import java.net.MalformedURLException;
import java.net.URL;

import jp.sou4j.util.StringUtils;

/**
 * <p>文字列を検証するクラスです。</p>
 * @author OSCA
 *
 */
public class Validator {

	/**
	 * <p>文字列の検証結果</p>
	 */
	public static enum Result {
		/**
		 * <p>検証対象文字列が空であることを表す</p>
		 */
		EMPTY("EMPTY"),

		/**
		 * <p>検証対象文字列が指定した必要最小文字数に達していないことを表す</p>
		 */
		TOO_SHORT("TOO_SHORT"),

		/**
		 * <p>検証対象文字列が指定した最大文字数を超過していることを表す</p>
		 */
		TOO_LONG("TOO_LONG"),

		/**
		 * <p>検証対象文字列が指定したフォーマットに反していることを表す</p>
		 */
		INVALID_FORMAT("INVALID_FORMAT"),

		/**
		 * <p>検証対象文字列に誤りがないことを表す</p>
		 */
		VALID("VALID");

		private String resultString;
		private Result(String resultString) {
			this.resultString = resultString;
		}
		public String getResultString() {
			return this.resultString;
		}
	}

	/**
	 * <p>文字列を検証します</p>
	 * @param target 検証対象文字列
	 * @param minLength 最小文字列長
	 * @param maxLength 最大文字列長
	 * @return
	 */
	public Result validate(String target, int minLength, int maxLength) {
		if( target    == null     ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( minLength <  0        ) throw new IllegalArgumentException("Method argument 'minLength' is less than zero.") ;
		if( maxLength <  0        ) throw new IllegalArgumentException("Method argument 'maxLength' is less than zero.") ;
		if( minLength > maxLength ) throw new IllegalArgumentException("Method argument 'maxLength' is less than 'minLength'.") ;

		if( StringUtils.isNullOrEmpty(target) && minLength == 0 ) {
			return Result.VALID;
		}
		else if( StringUtils.isNullOrEmpty(target) ) {
			return Result.EMPTY;
		}
		else if( target.length() < minLength ) {
			return Result.TOO_SHORT;
		}
		else if( target.length() > maxLength ) {
			return Result.TOO_LONG;
		}

		return Result.VALID;
	}

	/**
	 * <p>文字列を検証します</p>
	 * @param target 検証対象文字列
	 * @param minLength 最小文字列長
	 * @param maxLength 最大文字列長
	 * @param regex 正規表現
	 * @return 検証結果
	 */
	public Result validate(String target, int minLength, int maxLength, String regex) {
		if( target    == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( minLength <  0    ) throw new IllegalArgumentException("Method argument 'minLength' less than zero.") ;
		if( maxLength <  0    ) throw new IllegalArgumentException("Method argument 'maxLength' less than zero.") ;
		if( regex     == null ) throw new IllegalArgumentException("Method argument 'regex' is null.") ;

		Result result = this.validate(target, minLength, maxLength);
		if( result != Result.VALID ) {
			return result;
		}
		else if( !target.matches(regex) ) {
			return Result.INVALID_FORMAT;
		}
		else {
			return Result.VALID;
		}
	}

	/**
	 * <p>指定した文字列がIntegerの正数として正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @return 検証結果
	 */
	public Result validateAsPositiveIntegerValue(String target) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		try {
			long value = Integer.parseInt(target);
			if( value < 0 ) return Result.INVALID_FORMAT;
			return Result.VALID;
		}
		catch( NumberFormatException exception ) {
			return Result.INVALID_FORMAT;
		}
	}

	/**
	 * <p>指定した文字列がLongの正数として正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @return 検証結果
	 */
	public Result validateAsPositiveLongValue(String target) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		try {
			long value = Long.parseLong(target);
			if( value < 0 ) return Result.INVALID_FORMAT;
			return Result.VALID;
		}
		catch( NumberFormatException exception ) {
			return Result.INVALID_FORMAT;
		}
	}

	/**
	 * <p>指定した文字列がURLとして正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @return 検証結果
	 */
	public Result validateAsUrl(String target) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( target.length() == 0 ) return Result.EMPTY ;

		try {
			new URL(target);
		}
		catch (MalformedURLException e) {
			return Result.INVALID_FORMAT;
		}

		return Result.VALID;
	}

	/**
	 * <p>指定した文字列がURLとして正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @param minLength 最小文字列長
	 * @param maxLength 最大文字列用
	 * @return 検証結果
	 */
	public Result validateAsUrl(String target, int minLength, int maxLength) {
		if( target    == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( minLength <  0    ) throw new IllegalArgumentException("Method argument 'minLength' less than zero.") ;
		if( maxLength <  0    ) throw new IllegalArgumentException("Method argument 'maxLength' less than zero.") ;

		// NULLの検証/文字数の検証を行い、誤りがあれば結果を返却します
		Result result = this.validate(target, minLength, maxLength);
		if( result != Result.VALID ) {
			return result;
		}

		// URL文字列としての検証結果を返却します
		return this.validateAsUrl(target);
	}

	/**
	 * <p>指定した文字列がInternetAddressとして正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @return 検証結果
	 */
	public Result validateAsInternetAddress(String target) {
		if( target == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( target.length() == 0 ) return Result.EMPTY ;

		String atom      = "[!#$%&`*+/0-9=?A-Z^_'a-z{|}~-]+";
		String localpart = atom + "(\\.|" + atom + ")*";
		String subdomain = atom;
		String domain    = subdomain + "(\\." + subdomain + "|" + subdomain + ")*";
		String addrspec  = "^" + localpart + "@" + domain +  "$";

		return (target.matches(addrspec)) ? Result.VALID : Result.INVALID_FORMAT ;
	}

	/**
	 * <p>指定した文字列がInternetAddressとして正しい書式の文字列かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @param minLength 最小文字列長
	 * @param maxLength 最大文字列長
	 * @return 検証結果
	 */
	public Result validateAsInternetAddress(String target, int minLength, int maxLength) {
		if( target    == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( minLength <  0    ) throw new IllegalArgumentException("Method argument 'minLength' less than zero.") ;
		if( maxLength <  0    ) throw new IllegalArgumentException("Method argument 'maxLength' less than zero.") ;

		// NULLの検証/文字数の検証を行い、誤りがあれば結果を返却します
		Result result = this.validate(target, minLength, maxLength);
		if( result != Result.VALID ) return result;

		// インターネットアドレスとしての検証結果を返却します
		return this.validateAsInternetAddress(target);
	}

	/**
	 * <p>指定した文字列が数字だけで構成される正しい文字列か否かを検証して結果を返却します。</p>
	 * @param target 検証対象文字列
	 * @param minLength 最小文字列長
	 * @param maxLength 最大文字列長
	 * @return 検証結果
	 */
	public Result validateAsNumericString(String target, int minLength, int maxLength) {
		if( target    == null ) throw new IllegalArgumentException("Method argument 'target' is null.") ;
		if( minLength <  0    ) throw new IllegalArgumentException("Method argument 'minLength' less than zero.") ;
		if( maxLength <  0    ) throw new IllegalArgumentException("Method argument 'maxLength' less than zero.") ;

		Result result = this.validate(target, minLength, maxLength, "^[0-9]{"+ minLength + "," + maxLength  + "}$");

		return result;
	}
}
