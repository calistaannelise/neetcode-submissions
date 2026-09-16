class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int rowL = 0;
        int rowR = matrix.length - 1;
        int colL = 0;
        int colR = matrix[0].length - 1;

        while (rowL <= rowR) {
            int rowMid = rowL + (rowR - rowL)/2;
            if (matrix[rowMid][colL] == target || matrix[rowMid][colR] == target) {
                return true;
            } else if (matrix[rowMid][colR] < target) {
                rowL = rowMid + 1;
            } else if (matrix[rowMid][colL] > target){
                rowR = rowMid - 1;
            } else {
                while (colL <= colR) {
                    int mid = colL + (colR-colL)/2;
                    if (matrix[rowMid][mid] > target) {
                        colR = mid - 1;
                    } else if (matrix[rowMid][mid] < target) {
                        colL = mid + 1;
                    } else {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
