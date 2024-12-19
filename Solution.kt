
import java.util.PriorityQueue
import kotlin.math.sqrt

class Solution {

    fun pickGifts(gifts: IntArray, targetNumberOfSeconds: Int): Long {
        val maxHeapForGift = PriorityQueue<Int>() { x, y -> y - x }
        var sumRemainingGiftsAfterTargetTime: Long = 0
        for (gift in gifts) {
            maxHeapForGift.add(gift)
            sumRemainingGiftsAfterTargetTime += gift
        }

        var targetNumberOfSeconds = targetNumberOfSeconds
        while (targetNumberOfSeconds > 0) {
            val gift = maxHeapForGift.poll()
            val remainingGift = sqrt(gift.toDouble()).toInt()
            sumRemainingGiftsAfterTargetTime -= gift - remainingGift
            maxHeapForGift.add(remainingGift)
            --targetNumberOfSeconds
        }

        return sumRemainingGiftsAfterTargetTime
    }
}
