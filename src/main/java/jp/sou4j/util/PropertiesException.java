package jp.sou4j.util;

/**
 * <p>Propertiesオブジェクトが保持する値の取得に失敗したことを通知します。</p>
 * <p>PropertiesUtilsクラスの各メソッドでスローされます。</p>
 * @since 1.0.0
 * @see jp.sou4j.util.PropertiesUtils
 */
public class PropertiesException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * <p>エラー詳細メッセージとして null を設定して PropertiesException を構築します。</p>
	 */
	public PropertiesException() {
		super();
	}

	/**
	 * <p>指定された詳細メッセージを持つ PropertiesException を構築します。</p>
	 * @param message 詳細メッセージ (あとで Throwable.getMessage() メソッドで取得するために保存される)
	 */
	public PropertiesException( String message ) {
		super(message);
	}

	/**
	 * <p>指定された詳細メッセージと原因を持つ PropertiesException を構築します。</p>
	 * @param message 詳細メッセージ (あとで Throwable.getMessage() メソッドで取得するために保存される)
	 * @param cause 原因 (あとで Throwable.getCause() メソッドで取得するために保存される)。(null 値が許可されており、原因が存在しないか不明であることを示す)
	 */
	public PropertiesException( String message, Throwable cause ) {
		super(message, cause);
	}

	/**
	 * <p>指定された原因と詳細メッセージ (cause==null ? null : cause.toString()) を持つ PropertiesException を構築します (通常、クラスと cause の詳細メッセージを含みます)。</p>
	 * @param cause 原因 (あとで Throwable.getCause() メソッドで取得するために保存される)。(null 値が許可されており、原因が存在しないか不明であることを示す)
	 */
	public PropertiesException( Throwable cause ) {
		super(cause);
	}
}
