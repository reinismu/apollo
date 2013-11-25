package org.apollo.game.sync.block;

import java.util.HashMap;
import java.util.Map;

/**
 * A specialized collection of {@link SynchronizationBlock}s.
 * 
 * @author Graham
 */
public final class SynchronizationBlockSet implements Cloneable {

	/**
	 * A {@link Map} of {@link SynchronizationBlock}s.
	 */
	private final Map<Class<? extends SynchronizationBlock>, SynchronizationBlock> blocks = new HashMap<>();

	/**
	 * Adds a {@link SynchronizationBlock}.
	 * 
	 * @param block The block to add.
	 */
	public void add(SynchronizationBlock block) {
		Class<? extends SynchronizationBlock> clazz = block.getClass();
		blocks.put(clazz, block); // this will overwrite old updates. best thing
									// to do?
	}

	/**
	 * Clears the set.
	 */
	public void clear() {
		blocks.clear();
	}

	@Override
	public SynchronizationBlockSet clone() {
		SynchronizationBlockSet copy = new SynchronizationBlockSet();
		copy.blocks.putAll(blocks);
		return copy;
	}

	/**
	 * Checks if this set contains the specified block.
	 * 
	 * @param clazz The block's class.
	 * @return {@code true} if so, {@code false} if not.
	 */
	public boolean contains(Class<? extends SynchronizationBlock> clazz) {
		return blocks.containsKey(clazz);
	}

	/**
	 * Gets a block.
	 * 
	 * @param <T> The type of block.
	 * @param clazz The block's class.
	 * @return The block.
	 */
	@SuppressWarnings("unchecked")
	public <T extends SynchronizationBlock> T get(Class<T> clazz) {
		return (T) blocks.get(clazz);
	}

	/**
	 * Removes a block.
	 * 
	 * @param clazz The block's class.
	 */
	public void remove(Class<? extends SynchronizationBlock> clazz) {
		blocks.remove(clazz);
	}

	/**
	 * Gets the size of the set.
	 * 
	 * @return The size of the set.
	 */
	public int size() {
		return blocks.size();
	}

}