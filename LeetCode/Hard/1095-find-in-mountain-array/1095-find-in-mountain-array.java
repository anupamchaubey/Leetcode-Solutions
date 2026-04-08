/**
 * // This is MountainArray's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface MountainArray {
 *     public int get(int index) {}
 *     public int length() {}
 * }
 */

class Solution {
    public int findInMountainArray(int target, MountainArray mountainArr) {
        int n = mountainArr.length();
        int l = 1, r = n - 2;
        int peak = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = mountainArr.get(mid);
            if (x > mountainArr.get(mid - 1) && x > mountainArr.get(mid + 1)) {
                peak = mid;
                break;
            }
            if (x >= mountainArr.get(mid + 1)) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        if (peak == -1)
            return -1;
        l = 0;
        r = peak;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = mountainArr.get(mid);
            if (target == x)
                return mid;
            if (target < x) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        l = peak;
        r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int x = mountainArr.get(mid);
            if (target == x)
                return mid;
            if (target < x) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return -1;
    }
}