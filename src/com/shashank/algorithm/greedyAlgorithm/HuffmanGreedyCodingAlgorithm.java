package com.shashank.algorithm.greedyAlgorithm;

import java.util.Comparator;
import java.util.PriorityQueue;





class HuffmanNode {
	int frequency;
	char character;
	HuffmanNode leftHuffmanNode;
	HuffmanNode rightHuffmanNode;
}

class MyComparator implements Comparator<HuffmanNode> {
	@Override
	public int compare(HuffmanNode h1, HuffmanNode h2) {
		return h1.frequency - h2.frequency;
	}
}

public class HuffmanGreedyCodingAlgorithm {

	public static void main(String arg[]) {

		int n = 6;
		char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
		int[] charfreq = { 5, 9, 12, 13, 16, 45 };

		PriorityQueue<HuffmanNode> priorityQueue = new PriorityQueue<HuffmanNode>(n, new MyComparator());

		// Add character and frequency in priority queue
		for (int i = 0; i < n; i++) {
			HuffmanNode h = new HuffmanNode();
			h.frequency = charfreq[i];
			h.character = charArray[i];
			priorityQueue.add(h);
		}

		HuffmanNode root = null;

		while (priorityQueue.size() > 1) {
			HuffmanNode leftNode = priorityQueue.poll();
			HuffmanNode rightNode = priorityQueue.poll();
			HuffmanNode h = new HuffmanNode();
			h.character = '-';
			h.frequency = leftNode.frequency + rightNode.frequency;
			h.leftHuffmanNode = leftNode;
			h.rightHuffmanNode = rightNode;
			root = h;
			priorityQueue.add(h);
		}
		printHuffManTre(root, "");
	}

	
	private static void printHuffManTre(HuffmanNode root, String string) {

		if (root.leftHuffmanNode == null && root.rightHuffmanNode == null) {
			System.out.println(root.character + ":" + string);
			return;
		}
		printHuffManTre(root.leftHuffmanNode, string + "0");
		printHuffManTre(root.rightHuffmanNode, string + "1");

	}

}
