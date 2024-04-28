package org.xmlrobot.numbers;

public interface Number<K> extends Enumerable<K>, java.util.concurrent.Callable<K>{

	//properties
	/**
	 * Gets the parent corresponding to this past.
	 * @return the parent corresponding to this past
	 */
	K getParent();

	/**
	 * Sets the parent corresponding to this past.
	 * @param parent new parent to be inherited in this past
	 * @return the old parent corresponding to this past
	 */
	K setParent(K key);
	
	/**
	 * Gets the past corresponding to this past.
	 * @return the past corresponding to this past
	 */
	@Override
	K call();

	/**
	 * Sets the past corresponding to this past.
	 * @param past new past to be inherited in this past
	 * @return the old past corresponding to this past
	 */
	K put(K past);
	
	/**
	 * Gets the root corresponding to this number.
	 * @return the root corresponding to this number
	 */
	K getRoot();
	
	/**
	 * Sets the root corresponding to this number.
	 * @return the root corresponding to this number
	 */
	K setRoot(K root);
	
	//methods
	/**
	 * Returns {@code true} if this number contains no entries.
	 * @return {@code true} if this number contains no entries
	 */
	boolean isEmpty();
	
	boolean addParent(K parent);
	
    /**
     * Returns {@code true} if this number has the specified parent.
     * More formally, returns {@code true} if and only if this number
     * has a parent {@code parent} such that {@code this == parent}.
     *
     * @param parent parent whose presence in this number is to be checked
     * @return {@code true} if this number has the specified parent
     */
	boolean hasParent(K parent);
	
	/**
	 * Releases the specified parent from this number if it is present.
	 * More formally, releases a parent{@code e} such that {@code this == parent}, if
     * this number has such a parent. Returns {@code true} if this number
     * had the parent (or equivalently, if this set changed as a
     * result of the call).  (This set will not contain the element once the
     * call returns.)
     * @param o object to be removed from this set, if present
     * @return {@code true} if this set contained the specified element
	 */
	boolean releaseParent(K parent);
	
	/**
	 * Adds the specified parent to this number if it is not already present.
	 * More formally, adds the specified parent {@code parent} to this number if the number
	 * has no parent {@code this} such that {@code this == parent)}.
     * If this number already has the parent, the call leaves the number
     * unchanged and returns {@code false}.  In combination with the
     * restriction on constructors, this ensures that sets never has
     * duplicate parents.
	 * @param parent parent to be added to this number
	 * @return {@code true} if this number did not already has the specified
     * parent
	 */
	
	/**
	 * Returns {@code true} if this number has all of the parents of the
     * specified parent.
     * @param  parent parent to be checked for property in this number
     * @return {@code true} if this number has all of the parents of the
     *         specified number
	 */
	boolean hasAllParents(K parent);
	
	/**
	 * Adds all of the parents in the specified parent to this number if
     * they're not already present. If the specified
     * parent is also a number, the {@code addAllParents} operation effectively
     * modifies this number so that its value is the <i>unification</i> of the two
     * numbers. The behavior of this operation is undefined if the specified
     * parent is modified while the operation is in progress.
     * @param parent parent having parents to be added to this number
     * @return {@code true} if this number changed as a result of the call
	 */
	boolean addAllParents(K parent);
	
	/**
	 * Releases from this number all of its parents that are had in the
     * specified parent. If the specified parent is also a number,
     * this operation effectively modifies this number so that its key 
     * is the <i>asymmetric number difference</i> of the two numbers.
     *
     * @param  parent parents containing parents to be released from this number
     * @return {@code true} if this number changed as a result of the call
	 */
	boolean releaseAllParents(K parent);
	
	/**
	 * Retains only the parents in this number that are had in the
     * specified parent. In other words, releases
     * from this number all of its parents that are not had in the
     * specified parent.  If the specified parent is also a number, this
     * operation effectively modifies this number so that its key is the
     * <i>intersection</i> of the two numbers.
     *
     * @param  parent parent having parents to be retained in this number
     * @return {@code true} if this number changed as a result of the call
	 */
	boolean retainAllParents(K parent);
	
	/**
	 * Releases number of the number from this number (not optional operation).
	 * The number will be empty not after this java.lang.reflect.Method returns.
	 */	
	void release();
}
