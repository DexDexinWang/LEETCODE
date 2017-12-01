/**
 *  Copyright 2017 Dex`s Studio
 *  All right reserved.
 *  Created on Aug 26, 2017 10:45:46 AM
 *  @author Dex
 *  @email  Edgar_wdx@hotmail.com
 */

/*
Given a picture consisting of black and white pixels, find the number of black lonely pixels.

The picture is represented by a 2D char array consisting of 'B' and 'W', which means black and white pixels respectively.

A black lonely pixel is character 'B' that located at a specific position where the same row and same column don't have any other black pixels.

Example:
Input: 
[['W', 'W', 'B'],
 ['W', 'B', 'W'],
 ['B', 'W', 'W']]

Output: 3
Explanation: All the three 'B's are black lonely pixels.
 */

public class Solution531 {

	public static void main(String[] args) {
		char[][] input = {{'W'},{'B'},{'W'}};
		System.out.println(findLonelyPixel(input));
	}
    public static int findLonelyPixel(char[][] picture) {
        if (picture == null || picture.length == 0 || picture[0].length == 0) return 0;

        int n = picture.length, m = picture[0].length;
        int[] row = new int[n];
        int[] column = new int[m];
        for (int i=0;i<n;i++) 
        {
            for (int j=0;j<m;j++) 
            {
                if(picture[i][j]=='B')
                {
                    row[i]++;
                    column[j]++;
                }
            }
        }
        
        int result=0;
        for(int i=0; i<n; i++)
        {
            for(int j =0 ; j<m; j++)
            {
                if(picture[i][j] == 'B' && row[i] == 1 && column[j] == 1)
                {
                    result++;
                }
            }
        }
        return result;
    }
}
