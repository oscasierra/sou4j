package jp.sou4j.util;

import java.util.Comparator;

import jp.sou4j.lang.NullPointerOrEmptyException;
import jp.sou4j.util.StringUtils;

public class Objects {

	public static <T> int compare(T a, T b, Comparator<? super T> c) {
		return java.util.Objects.compare(a, b, c);
	}

	public static boolean deepEquals(Object a, Object b) {
		return java.util.Objects.deepEquals(a, b);
	}

	public static boolean equals(Object a, Object b) {
		return java.util.Objects.equals(a, b);
	}

	public static int hashCode(Object o) {
		return java.util.Objects.hashCode(o);
	}

	public static int hash(Object... values) {
		return java.util.Objects.hashCode(values);
	}

	public static boolean isNull(Object obj) {
		return java.util.Objects.isNull(obj);
	}

	public static <T> T requireNonNull(T obj) {
		return java.util.Objects.requireNonNull(obj);
	}

	public static <T> T requireNonNull(T obj, String message) {
		return java.util.Objects.requireNonNull(obj, message);
	}

	public static <T> T requireNonNullOrEmpty(T obj) {
		if( obj == null || StringUtils.isNullOrEmpty(obj.toString()) ) {
			throw new NullPointerOrEmptyException();
		}
		return obj;
	}

	public static <T> T requireNonNullOrEmpty(T obj, String message) {
		if( obj == null || StringUtils.isNullOrEmpty(obj.toString()) ) {
			throw new NullPointerOrEmptyException(message);
		}
		return obj;
	}

	public static String toString(Object o) {
		return java.util.Objects.toString(o);
	}

	public static String toString(Object o, String nullDefault) {
		return java.util.Objects.toString(o, nullDefault);
	}
}
