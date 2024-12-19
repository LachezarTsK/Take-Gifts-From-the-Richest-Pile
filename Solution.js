
// const {PriorityQueue} = require('@datastructures-js/priority-queue');
/*
 PriorityQueue is internally included in the solution file on leetcode.
 So, when running the code on leetcode it should stay commented out. 
 It is mentioned here as a comment, just for information about 
 which external library is applied for this data structure.
 */

/**
 * @param {number[]} gifts
 * @param {number} targetNumberOfSeconds
 * @return {number}
 */
var pickGifts = function (gifts, targetNumberOfSeconds) {
    const maxHeapForGift = new PriorityQueue({compare: (x, y) => y - x});
    let sumRemainingGiftsAfterTargetTime = 0;
    for (let gift of gifts) {
        maxHeapForGift.enqueue(gift);
        sumRemainingGiftsAfterTargetTime += gift;
    }

    while (targetNumberOfSeconds > 0) {
        const gift = maxHeapForGift.dequeue();
        const remainingGift = Math.floor(Math.sqrt(gift));
        sumRemainingGiftsAfterTargetTime -= gift - remainingGift;
        maxHeapForGift.enqueue(remainingGift);
        --targetNumberOfSeconds;
    }

    return sumRemainingGiftsAfterTargetTime;
};
