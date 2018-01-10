package com.shashank.dataStructures;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMapTest {

	public static void main(String arg[]) {

		MyHashMap<Integer, String> map = new MyHashMap<Integer, String>();

		map.put(1, "1");
		map.put(2, "2");
		map.put(3, "3");
		map.put(4, "4");
		map.put(5, "5");
		map.put(6, "6");
		map.put(7, "7");
		map.put(8, "8");
		map.put(9, "9");
		map.put(10, "10");
		map.put(11, "11");
		map.put(12, "12");
		map.put(13, "13");
		map.put(14, "14");
		map.put(15, "15");
		map.put(16, "16");
		map.put(17, "17");
		map.put(18, "18");
		
		map.put(1000, "1000");

		map.put(3, "c_new");
		map.put(6, "6_new");
		map.put(17, "17_new");
		map.put(3, "c_new_new");
		map.put(3, "c_new_new_new");

		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		System.out.println(map.get(4));
		System.out.println(map.get(5));
		System.out.println(map.get(6));
		System.out.println(map.get(7));
		System.out.println(map.get(8));
		System.out.println(map.get(9));
		System.out.println(map.get(10));
		System.out.println(map.get(11));
		System.out.println(map.get(12));
		System.out.println(map.get(13));
		System.out.println(map.get(14));
		System.out.println(map.get(15));
		System.out.println(map.get(16));
		System.out.println(map.get(17));
		System.out.println(map.get(18));
		System.out.println(map.get(1000));
		System.out.println(map.get(0000000000000000));

	}

}

class Entry<K, V> {

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	K key;
	V value;

}

class MyHashMap<K, V> {
	List<LinkedList<Entry<K, V>>> list;

	public MyHashMap() {
		int n = 16; // 16 buckets
		list = new ArrayList<LinkedList<Entry<K, V>>>();
		for (int i = 0; i < n; i++) {
			list.add(new LinkedList<Entry<K, V>>());
		}
	}

	public void put(K key, V value) {
		int hashCode = key.hashCode() % 16;
		// This is a linked list
		LinkedList<Entry<K, V>> linkedList = list.get(hashCode);

		// Iterating Over Linked List to set the value passed.
		//boolean keyFoundInLinkedlist = false;
		for (Entry<K, V> each : linkedList) {
			if (each.key.equals(key)) {
				// keyFoundInLinkedlist = true;
				each.value = value;
				return;
			}
		}

		linkedList.add(new Entry<K, V>(key, value));

	}

	public V get(K key) {

		int hashCode = key.hashCode() % 16;
		LinkedList<Entry<K, V>> linkedList = list.get(hashCode);
		System.out.println("***********************");
		System.out.println("BucketNumber "+hashCode);

		for (Entry<K, V> each : linkedList) {
			if (each.key.equals(key)) {
				return each.value;
			}
		}
		return null;

	}
}