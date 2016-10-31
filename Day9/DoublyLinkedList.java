class DoublyLinkedList<T> {
	protected DoublyLinkedNode<T> first = null;
	protected DoublyLinkedNode<T> current = null;

	public void add(T t) {
		DoublyLinkedNode<T> newNode = new DoublyLinkedNode<T>();
		newNode.data = t;
		newNode.next = first;

		if (first != null) {
			first.prev = newNode;
		}
		first = newNode;
	}

	public boolean delete(T t) {
		if (first == null) {
			return false;
		} else {
			if (first.data.equals(t)) {
				first = first.next;
				first.prev = null;
				return true;
			}
			DoublyLinkedNode<T> current = first;

			while (current != null) {
				if (current.data.equals(t)) {
					if (current.next != null) {
						current.next.prev = current.prev;
					}
					if (current.prev != null) {
						current.prev.next = current.next;
					}
					return true;
				}

				current = current.next;
			}
		}
		return false;
	}

	/**
	 * Return the next item in the list, or null if at the end of the list.
	 */
	public T next() {
		if (first == null) {
			return null;
		}
		if (current == null) {
			current = first;
			return current.data;
		}
		if (current.next == null) {
			return null;
		}
		current = current.next;
		return current.data;
	}

	/**
	 * "Rewind" the list back to the beginning, i.e., subsequent calls to "next()" will return values
	 * from the beginning of the list.
	 */
	public void rewind() {
		current = null;
	}
}