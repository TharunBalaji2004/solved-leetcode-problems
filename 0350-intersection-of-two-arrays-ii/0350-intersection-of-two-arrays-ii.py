class Solution:
    def intersect(self, nums1: List[int], nums2: List[int]) -> List[int]:
        d = dict()
        for num in nums1:
            if (num not in d):
                d[num] = 1
            else:
                d[num] += 1
        
        res = []
        for num in nums2:
            if (num in d and d[num] > 0):
                d[num] -= 1
                res.append(num)
        
        return res

