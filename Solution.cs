
using System;
using System.Collections.Generic;

public class Solution
{
    public long PickGifts(int[] gifts, int targetNumberOfSeconds)
    {
        PriorityQueue<int,int> maxHeapForGift = new PriorityQueue<int,int>(Comparer<int>.Create((x, y) => y - x));
        long sumRemainingGiftsAfterTargetTime = 0;
        foreach (int gift in gifts)
        {
            maxHeapForGift.Enqueue(gift, gift);
            sumRemainingGiftsAfterTargetTime += gift;
        }

        while (targetNumberOfSeconds > 0) 
        {
            int gift = maxHeapForGift.Dequeue();
            int remainingGift = (int) Math.Sqrt(gift);
            sumRemainingGiftsAfterTargetTime -= gift - remainingGift;
            maxHeapForGift.Enqueue(remainingGift, remainingGift);
            --targetNumberOfSeconds;
        }

        return sumRemainingGiftsAfterTargetTime;
    }
}
