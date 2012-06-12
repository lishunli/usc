package org.usc.weibo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 *
 * @author Shunli
 */
@Data
@AllArgsConstructor
public class Pair<K, V> {
	public K first;
	public V second;
}
