/**
 * 
 */
package com.novelbio.apple.lang.support;

/**
 * 
 * 
 * @author renyx
 * 
 */
public interface Provider<S, T> {
	S from();
	T to();
}
