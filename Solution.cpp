
#include <cmath>
#include <queue>
#include <vector>
using namespace std;

class Solution {

public:
    long long pickGifts(const vector<int>& gifts, int targetNumberOfSeconds) const {
        priority_queue<int> maxHeapForGift(gifts.begin(),gifts.end());
        long long sumRemainingGiftsAfterTargetTime = 0;
        for (const auto& gift : gifts) {
            sumRemainingGiftsAfterTargetTime += gift;
        }

        while (targetNumberOfSeconds > 0) {
            int gift = maxHeapForGift.top();
            maxHeapForGift.pop();

            int remainingGift = sqrt(gift);
            sumRemainingGiftsAfterTargetTime -= gift - remainingGift;
            maxHeapForGift.push(remainingGift);
            --targetNumberOfSeconds;
        }

        return sumRemainingGiftsAfterTargetTime;
    }
};
