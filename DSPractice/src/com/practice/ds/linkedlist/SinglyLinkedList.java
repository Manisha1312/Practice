package com.practice.ds.linkedlist;

public class SinglyLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private static int counter;

	private static int getCounter() {
		return counter;
	}

	private static void incrementCounter() {
		counter++;
	}

	private void decrementCounter() {
		counter--;
	}

	// Add at the end of the list
	public void addEnd(T element) {

		Node<T> newNode = new Node<T>(element);
		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			tail.setNext(newNode);
			tail = newNode;
		}
		incrementCounter();
	}

	// Add after a given element
	public void addAfter(T element, T after) {

		Node<T> cursorNode = head;
		Node<T> tempNode = null;

		while (true) {
			if (cursorNode == null) {
				break;
			}
			if (cursorNode.compareTo(after) == 0) {
				tempNode = cursorNode;
				break;
			}
			cursorNode = cursorNode.getNext();
		}
		if (tempNode != null) {
			Node<T> newNode = new Node<T>(element, cursorNode.getNext());
			if (cursorNode == tail) {
				tail = newNode;
			}
			cursorNode.setNext(newNode);
			incrementCounter();
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	// inserts the specified element at the specified position in this list
	public void addAtIndex(T element, int index) {
		if (index <= 0 || index > size()) {
			System.out.println("Invalid index");
			return;
		} else if (index > counter) {
			System.out.println("Invalid index");
			return;
		} else {
			Node<T> newNode = new Node<T>(element);
			Node<T> cursorNode = head;

			if (cursorNode != null) {
				for (int i = 2; i < index && cursorNode.getNext() != null; i++) {
					cursorNode = cursorNode.getNext();
				}
			}

			newNode.setNext(cursorNode.getNext());
			cursorNode.setNext(newNode);
			incrementCounter();
		}
	}

	// Delete from the starting of the link list
	public void deleteFront() {

		if (head == null) {
			System.out.println("Underflow...");
			return;
		}
		Node<T> tempNode = head;
		head = tempNode.getNext();
		if (head == null) {
			tail = null;
		}
		System.out.println("Deleted: " + tempNode.getValue());
		decrementCounter();
	}

	// Delete after an element of a given list
	public void deleteAfter(T after) {

		Node<T> cursorNode = head;
		Node<T> tempNode = null;
		while (true) {
			if (cursorNode == null) {
				break;
			}
			if (cursorNode.compareTo(after) == 0) {
				tempNode = cursorNode;
				break;
			}
			cursorNode = cursorNode.getNext();
		}
		if (tempNode != null) {
			cursorNode = tempNode.getNext();
			tempNode.setNext(cursorNode.getNext());
			if (tempNode.getNext() == null) {
				tail = tempNode;
			}
			System.out.println("Deleted: " + cursorNode.getValue());
			decrementCounter();
		} else {
			System.out.println("Unable to find the given element...");
		}
	}

	// removes the element at the specified position in this list.
	public boolean deleteAtIndex(int index) {

		if (index < 1 || index > size())
			return false;

		Node<T> cursorNode = head;
		if (head != null) {
			for (int i = 1; i < index; i++) {
				if (cursorNode.getNext() == null)
					return false;
				cursorNode = cursorNode.getNext();
			}
			cursorNode.setNext(cursorNode.getNext().getNext());
			decrementCounter();
			return true;
		}
		return false;
	}

	// returns the element at the specified position in this list.
	public T get(int index) {
		if (index < 0)
			return null;
		Node<T> cursorNode = null;
		if (head != null) {
			cursorNode = head.getNext();
			for (int i = 0; i < index; i++) {
				if (cursorNode.getNext() == null)
					return null;

				cursorNode = cursorNode.getNext();
			}
			return cursorNode.getValue();
		}
		return null;

	}

	public void traverse() {
		String output = "";
		Node<T> tempNode = head;
		while (true) {
			if (tempNode == null) {
				break;
			}
			output += "[" + tempNode.getValue().toString() + "]";
			tempNode = tempNode.getNext();
		}
		System.out.println(output);
	}

	// returns the number of elements in this list.
	public int size() {
		return getCounter();
	}
}
