package com.example.datastructure.algoexpert.problem.graph.array;

public class WaterfallStream {
    public double[] waterfallStreams(double[][] array, int source) {
        int rowSize = array.length;
        int colSize = array[0].length;
        traverse(array, 0, source, 100.0, true, true);
        double[] arr = new double[colSize];
        for (int i = rowSize - 1; i < rowSize; i++) {
            System.arraycopy(array[i], 0, arr, 0, colSize);
        }
        return arr;
    }

    void traverse(double[][] array, int row, int col, double val, boolean leftMove, boolean rightMove) {
        int rowSize = array.length;
        int colSize = array[0].length;
        if (col < 0 || col > colSize - 1)
            return;
        if (row == rowSize - 1) {
            array[row][col] += val;
            return;
        }
        array[row][col] += val;
        if (array[row + 1][col] == 1) {
            double v = rightMove && leftMove ? val / 2 : val;
            if ((col > 0 && array[row][col - 1] != 1) && leftMove) {
                traverse(array, row, col - 1, v, true, false);
            }
            if ((col < colSize - 1 && array[row][col + 1] != 1) && rightMove) {
                traverse(array, row, col + 1, v, false, true);
            }
        } else {
            traverse(array, row + 1, col, val, true, true);
        }
    }

}
//           0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,11,12,13
//          [0, -, -, -, -, -, -, -, -, -, -, -, -, 0],   //          [0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0],
//          [0, -, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, -, 0],
//          [0, -, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -, -],
//          [0, -, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, -],
//          [-, -, -, -, -, -, 0, 0, 0, 0, 0, 0, 0, -],
//          [-, 1, 1, 1, 1, -, 0, 0, 0, 1, 1, 1, 1, -],
//          [-, 0, -, -, -, -, -, 0, 0, 0, 0, 0, 0, -],
//          [-, 0, -, 1, 1, 1, -, 0, 1, 1, 1, 0, 0, -],
//          [-, 0, -, 0, 0, 0, -, 0, 0, 0, 0, 0, 0, -],
//          [-, 1, -, 0, 0, 0, -, 0, 0, 0, 1, 1, 0, -],
//          [-, 0, -, 0, 0, 1, -, 0, 1, 0, 0, 0, 0, -],
//          [0, 0, -, 0, 0, 0, -, 0, 0, 0, 0, 0, 0, -]
//   25 0,12.5,0,0, 0,12.5                  25