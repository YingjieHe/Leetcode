public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        if(len1 > len2) return findMedianSortedArrays(nums2, nums1);
        int i = 0, j = 0, idmin = 0, idmax = len1;
        int half = (len1 + len2 + 1) / 2;
        while(idmin <= idmax){
            i = idmin + (idmax - idmin) / 2;
            j = half - i;
            if(i < len1 && j > 0 && nums2[j - 1] > nums1[i]) idmin = i + 1;
            else if(i > 0 && j < len2 && nums1[i - 1] > nums2[j]) idmax = i - 1;
            else break;
        }
        int num1 = 0, num2 = 0;
        if(i == 0) num1 = nums2[j - 1];
        else if(j == 0) num1 = nums1[i - 1];
        else num1 = Math.max(nums1[i - 1], nums2[j - 1]);
        if((len1 + len2) % 2 == 1) return num1;
        if(i == len1) num2 =nums2[j];
        else if(j == len2) num2 = nums1[i];
        else num2 = Math.min(nums2[j], nums1[i]);
        return (num1 + num2) / 2.0;
    }
}