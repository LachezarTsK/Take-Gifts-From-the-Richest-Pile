
package main

import (
    "container/heap"
    "fmt"
    "math"
)

func pickGifts(gifts []int, targetNumberOfSeconds int) int64 {
    maxHeapForGift := make(PriorityQueue, 0)
    var sumRemainingGiftsAfterTargetTime int64 = 0
    for _, gift := range gifts {
        heap.Push(&maxHeapForGift, &gift)
        sumRemainingGiftsAfterTargetTime += int64(gift)
    }

    for targetNumberOfSeconds > 0 {
        gift := heap.Pop(&maxHeapForGift).(*int)
        remainingGift := int(math.Sqrt(float64(*gift)))
        sumRemainingGiftsAfterTargetTime -= int64(*gift) - int64(remainingGift)
        heap.Push(&maxHeapForGift, &remainingGift)
        targetNumberOfSeconds--
    }

    return sumRemainingGiftsAfterTargetTime
}

type PriorityQueue []*int

func (pq PriorityQueue) Len() int {
    return len(pq)
}

func (pq PriorityQueue) Less(first int, second int) bool {
    return *pq[first] > *pq[second]
}

func (pq PriorityQueue) Swap(first int, second int) {
    pq[first], pq[second] = pq[second], pq[first]
}

func (pq *PriorityQueue) Push(object any) {
    *pq = append(*pq, object.(*int))
}

func (pq *PriorityQueue) Pop() any {
    class := (*pq)[pq.Len()-1]
    (*pq)[pq.Len() - 1] = nil
    *pq = (*pq)[0 : pq.Len() - 1]
    return class
}
