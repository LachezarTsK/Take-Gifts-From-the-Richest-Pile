
import java.util.PriorityQueue;

public class Solution {

    public long pickGifts(int[] gifts, int targetNumberOfSeconds) {
        PriorityQueue<Integer> maxHeapForGift = new PriorityQueue<>((x, y) -> y - x);
        long sumRemainingGiftsAfterTargetTime = 0;
        for (int gift : gifts) {
            maxHeapForGift.add(gift);
            sumRemainingGiftsAfterTargetTime += gift;
        }

        while (targetNumberOfSeconds > 0) {
            int gift = maxHeapForGift.poll();
            int remainingGift = (int) Math.sqrt(gift);
            sumRemainingGiftsAfterTargetTime -= gift - remainingGift;
            maxHeapForGift.add(remainingGift);
            --targetNumberOfSeconds;
        }

        return sumRemainingGiftsAfterTargetTime;
    }
}
