/**
 * @param {number[]} A
 * @return {number}
 */
var maxRotateFunction = function(A) {
    if(A === null || A.length === 0) return 0;
    var sum = 0;
    var f = 0;
    for(var i = 0; i < A.length; i++) {
        sum += A[i];
        f += i * A[i];
    }
    var max = f;
    for(i = A.length - 1; i >= 1; i--) {
        f = f + sum - A.length * A[i];
        max = Math.max(f, max);
    }
    return max;
};