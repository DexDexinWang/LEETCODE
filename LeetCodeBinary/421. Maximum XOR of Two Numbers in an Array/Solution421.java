/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on May 23, 2017 9:04:08 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

import java.util.Arrays;

public class Solution421 {
	public static void main(String[] args) {
		int[] input = {8,10,2};
		System.out.println(Arrays.toString(input));
		System.out.println(findMaximumXOR(input));
	}
	

    
    public static int findMaximumXOR(int[] nums) {
        Node root = new Node();
        int re = 0;
        for (int num : nums) {
            int digit = num;
            int tmp = 0;
            Node setNode = root;
            Node findNode = root;
            int pos = 30;
            while (pos >= 0) {
                digit = (num >> pos) & 1;
                setNode = setNode.set(digit);
                if (digit == 1) {
                    if (findNode.one != null) {
                        tmp = tmp | (1 << pos);
                        findNode = findNode.one;
                    } else {
                        findNode = findNode.zero;
                    }
                } else {
                    if (findNode.zero != null) {
                        tmp = tmp | (1 << pos);
                        findNode = findNode.zero;
                    } else {
                        findNode = findNode.one;
                    }
                }
                pos--;
            }
            re = Math.max(re, tmp);
        }
        return re;
    }
}

class Node {
    Node one;
    Node zero;
    Node() {
        this.one = null;
        this.zero = null;
    }
    Node set(int n) {
        if (n == 0) {
            if (this.one == null) this.one = new Node();
            return this.one;
        }
        if (this.zero == null) this.zero = new Node();
        return this.zero;
    }
}