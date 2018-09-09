package com.practice.ds.linkedlist;

class Node<T> implements Comparable<T> {

	// data carried by this node
	private T data;

	// reference to the next node in the chain
	private Node<T> next;

	public Node(T dataValue) {
		this.next = null;
		this.data = dataValue;
	}
	
	public Node(T dataValue, Node<T> nextValue) {
		this.next = nextValue;
		this.data = dataValue;
	}

	public T getValue() {
		return data;
	}

	public void setValue(T value) {
		this.data = value;
	}

	public Node<T> getNext() {
		return next;
	}

	public void setNext(Node<T> next) {
		this.next = next;
	}

	@Override
	public int compareTo(T arg) {
		if (arg == this.data) {
			return 0;
		} else {
			return 1;
		}
	}
}