package binarySearch.twoD;

import java.util.Arrays;

public class FindPeakElement {

    // doesn't run for some reason

    /*public static int isPeakTop(int[][] mat, int midTop, int midLeft) {
        if (midTop == 0) {
            if (mat[midTop][midLeft] < mat[midTop + 1][midLeft]) {
                return -1;
            } else {
                return 0;
            }
        }
        if (midTop == mat.length - 1) {
            if (mat[midTop][midLeft] > mat[midTop - 1][midLeft]) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (mat[midTop][midLeft] > mat[midTop - 1][midLeft] && mat[midTop][midLeft] > mat[midTop + 1][midLeft]) {
                return 0;
            } else if (mat[midTop][midLeft] < mat[midTop - 1][midLeft]) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static int isPeakLeft(int[][] mat, int midTop, int midLeft) {
        if (midLeft == 0) {
            if (mat[midTop][midLeft] < mat[midTop][midLeft+1]) {
                return -1;
            } else {
                return 0;
            }
        }
        if (midLeft == mat[0].length - 1) {
            if (mat[midTop][midLeft] > mat[midTop][midLeft - 1]) {
                return 0;
            } else {
                return 1;
            }
        } else {
            if (mat[midTop][midLeft] > mat[midTop][midLeft-1] && mat[midTop][midLeft] > mat[midTop][midLeft+1]) {
                return 0;
            } else if (mat[midTop][midLeft] < mat[midTop][midLeft - 1]) {
                return 1;
            } else {
                return -1;
            }
        }
    }
    public static int[] findPeakGrid(int[][] mat) {
        int top = 0, bottom = mat.length - 1;
        int left = 0, right = mat[0].length - 1;
        while (top <= bottom && left <= right) {
            int midTop = (top + bottom) / 2;
            int midLeft = (left + right) / 2;

            if (isPeakLeft(mat, midTop, midLeft) == 0 && isPeakTop(mat, midTop, midLeft) == 0) {
                return new int[]{midTop, midLeft};
            }

            if (isPeakTop(mat, midTop, midLeft) == 1) {
                bottom = midTop - 1;
            } else if (isPeakTop(mat, midTop, midLeft) == -1) {
                top = midTop + 1;
            }

            midTop = (top + bottom) / 2;

            if (isPeakLeft(mat, midTop, midLeft) == 0 && isPeakTop(mat, midTop, midLeft) == 0) {
                return new int[]{midTop, midLeft};
            }

            if (isPeakLeft(mat, midTop, midLeft) == 1) {
                right = midLeft - 1;
            } else if (isPeakLeft(mat, midTop, midLeft) == -1) {
                left = midLeft + 1;
            }

            midLeft = (left + right) / 2;

            if (isPeakLeft(mat, midTop, midLeft) == 0 && isPeakTop(mat, midTop, midLeft) == 0) {
                return new int[]{midTop, midLeft};
            }
        }
        return new int[]{-1, -1};
    }*/

    /*public static int findMaxElementIndex(int[] x) {
        int max = Integer.MIN_VALUE, maxIndex = -1;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > max) {
                maxIndex = i;
                max = x[i];
            }
        }
        return maxIndex;
    }
    public static int[] findPeakGrid(int[][] x) {
        int top = 0, bottom = x.length - 1;
        while (top <= bottom) {
            int mid = (top + bottom) / 2;
            int index = findMaxElementIndex(x[mid]);
            //top row
            if (mid == 0) {
                if (x[mid][index] > x[mid + 1][index]) {
                    return new int[]{index, mid};
                } else {
                    top = mid + 1;
                }
            } else if (mid == x.length - 1) {
                if (x[mid][index] > x[mid - 1][index]) {
                    return new int[]{index, mid};
                } else {
                    bottom = mid - 1;
                }
            } else {
                if (x[mid][index] > x[mid - 1][index] && x[mid][index] > x[mid + 1][index]) {
                    return new int[]{index, mid};
                } else if (x[mid][index] > x[mid - 1][index]) {
                    bottom = mid - 1;
                } else {
                    top = mid + 1;
                }
            }
        }
        return new int[]{-1, -1};
    }*/

    public static int[] findPeakGrid(int[][] mat) {
        int startRow = 0;
        int endRow = mat.length-1;


        while(endRow >= startRow) {
            int middleRow = startRow + (endRow - startRow)/2;

            //System.out.println("startRow : "+startRow+"   endRow : "+endRow+"  middleRow:"+middleRow);

            // will get max element position for that row
            int rowmax = maxRowElementPosition(mat[middleRow], mat[middleRow].length-1);

            // middle row is the first row
            if (middleRow == 0) {
                if (mat[middleRow][rowmax] > mat[middleRow + 1][rowmax]) {
                    return new int[]{middleRow, rowmax};
                }
            }

            //middle row is the last row
            if (middleRow == mat.length - 1) {
                if (mat[middleRow][rowmax] > mat[middleRow - 1][rowmax]) {
                    return new int[]{middleRow, rowmax};
                }
            }

            //  checking max element of the row with it's upper and lower row
            if (mat[middleRow][rowmax] > mat[middleRow + 1][rowmax] && mat[middleRow][rowmax] > mat[middleRow - 1][rowmax]) {
                return new int[]{middleRow, rowmax};
            }

            // if max is lesser than next rows same column element, will move startRow to the nextRow
            if (mat[middleRow][rowmax] < mat[middleRow + 1][rowmax]) {
                startRow = middleRow+1;
            } else {                             // otherwise move the endRow to current row -1
                endRow = middleRow -1;
            }
        }

        // we didn't find peak element in matrix
        return new int[]{-1, -1};

    }

    private static int maxRowElementPosition(int[] arr, int end) {
        int max = 0;


        for ( int i = 0; i <= end; i++){
            if (arr[i] > arr[max]){
                max = i;
            }
        }

        return max;
    }

    public static void main(String[] args) {
        int[][] x = {{1, 4}, {3, 2}};
//        int[][] x = {
//                {10, 2, 3},
//                {4, 9, 6},
//                {3, 8, 1}};

//        int[][] x = {{5485, 7056, 9739, 2231, 4923, 5254, 9884, 3291, 7849, 5148, 2911, 6525, 5229, 4776, 8045, 9436, 3972, 5340, 6162, 4593, 6438, 5981, 1866, 9239, 3274, 9704, 8940, 2948, 9013, 441, 7564, 3435, 7184, 4774, 1134, 6704, 8181, 2281, 4962, 3966, 4140, 2526, 6933, 6177, 1212, 7358, 9797, 7852, 9540, 6567, 8756, 8301, 6854, 8908, 603, 5891, 8797, 9730, 1393, 1792}, {4068, 5817, 2726, 726, 9228, 6548, 5433, 7053, 1736, 173, 1616, 4240, 3638, 8367, 8500, 9143, 9512, 9425, 3622, 7304, 6130, 6409, 7587, 9644, 8200, 2470, 5652, 403, 7910, 1713, 4841, 6816, 1407, 1902, 2322, 5708, 5111, 5621, 7461, 3390, 8538, 7913, 5707, 7802, 1600, 7179, 7413, 5226, 1101, 4920, 733, 1886, 371, 5621, 1792, 2693, 3997, 8455, 2859, 9043}, {
//                2624, 5423, 9173, 6986, 7571, 3799, 6637, 3023, 3054, 7081, 6482, 479, 3233, 7366, 9703, 7038, 6371, 73, 3520, 3372, 4561, 1026, 9460, 1668, 8797, 3064, 5994, 5341, 3229, 7497, 1868, 4299, 8020, 8647, 5135, 9781, 6368, 6432, 9618, 1872, 5701, 5767, 7502, 2827, 4874, 9670, 1389, 2195, 5132, 1932, 3909, 5004, 1917, 3000, 6117, 2317, 8370, 6365, 6853, 9772}, {2259, 9418, 6287, 6932, 3044, 7974, 8805, 2839, 9092, 2734, 8023, 4733, 2299, 3066, 5155, 7390, 879, 5883, 158, 7940, 2237, 3197, 6291, 9201, 8282, 8110, 6704, 8057, 6810, 7273, 8007, 2741, 1355, 9264, 506, 3614, 4786, 536, 4504, 3684, 8809, 4730, 2756, 7493, 9268, 8116, 9007, 8370, 1855, 9384, 1872, 4390, 8899, 6011, 8881, 682, 7232, 8952, 3581, 6966}, {1678, 4056, 4878, 529, 7369, 4306, 5712, 1426, 7194, 1924, 3883, 3439, 9633, 5745, 9999, 7016, 2720, 2282, 3386, 3391, 973, 9341, 5748, 8721, 4606, 9779, 8828, 2759, 5303, 4795, 4741, 9384, 4381, 8429, 1561, 2222, 6744, 972, 4544, 2079, 2175, 4091, 2397, 5278, 4056, 6435, 8020, 2330, 9461, 4403, 6787, 6147, 7406, 1238, 1526, 6601, 8448, 4559, 6047, 7450}, {7997, 5363, 9535, 41, 1527, 7512, 5870, 1038, 8757, 6517, 3569, 7040, 3471, 8106, 4400, 5290, 4647, 5534, 8968, 9469, 2140, 9276, 7952, 5632, 794, 753, 1632, 7530, 267, 2036, 2589, 7231, 7480, 12, 7010, 3315, 2162, 4946, 2605, 4490, 1530, 5906, 4103, 1351, 6093, 2712, 849, 6494, 5006, 3837, 7033, 1495, 1560, 18, 3497, 7813, 1277, 2175, 9727, 3706}, {8511, 7292, 153, 133, 5630, 1976, 6920, 2166, 7827, 1161, 3752, 6277, 1464, 1679, 1691, 5134, 6023, 4903, 2247, 6271, 2182, 2341, 1121, 8692, 9229, 139, 10000, 2689, 7211, 5754, 3491, 2481, 6746, 7249, 3560, 1421, 1647, 2294, 2018, 9660, 6292, 5760, 7036, 5153, 2291, 4060, 4538, 1381, 4066, 9067, 9847, 9831, 9955, 4669, 440, 4943, 3367, 8483, 9944, 8349}, {3091, 6419, 4843, 895, 3922, 8109, 6323, 1848, 3950, 8186, 9731, 1164, 8656, 198, 5917, 5186, 2163, 6338, 9313, 6896, 5987, 8952, 2831, 7718, 1196, 274, 9624, 1107, 226, 4296, 3535, 653, 991, 6521, 8301, 4694, 8210, 6807, 6940, 6591, 1351, 8792, 8809, 2502, 4547, 1370, 5078, 1295, 8378, 3330, 2546, 8789, 5354, 6402, 9609, 1084, 5082, 7168, 3910, 949}, {4006, 1413, 7119, 1901, 7429, 9976, 902, 5068, 2878, 1957, 208, 2249, 186, 2685, 8134, 5681, 8569, 8475, 4248, 2736, 6093, 2080, 4404, 1935, 481, 5489, 7035, 4457, 8583, 1047, 4309, 9448, 1263, 8129, 7458, 8369, 5901, 909, 8186, 9288, 2735, 6025, 2578, 4180, 1686, 9403, 1890, 3743, 8337, 43, 722, 202, 4007, 754, 7730, 5964, 6275, 2459, 2933, 580}, {9059, 6871, 3679, 5273, 4068, 6820, 5242, 4445, 1277, 9365, 6109, 1957, 8226, 863, 2939, 3657, 8451, 753, 6569, 1130, 7621, 4626, 5091, 5363, 1416, 9062, 7484, 131, 6045, 3288, 4778, 9238, 4980, 3975, 7601, 6034, 9695, 8084, 3202, 8955, 4017, 2467, 105, 6719, 392, 3818, 8873, 5676, 158, 5489, 24, 6165, 5039, 1704, 3362, 8681, 3903, 6879, 8062, 982}, {2333, 4585, 1525, 720, 3793, 8516, 6768, 6103, 7512, 1392, 9516, 1566, 8281, 2188, 6462, 1227, 9698, 9304, 1021, 7127, 2142, 3880, 4779, 4277, 5162, 6439, 5346, 5212, 7418, 4456, 3828, 1224, 3322, 2231, 9580, 1786, 2547, 1732, 2694, 7366, 7636, 5146, 6661, 1979, 8781, 5871, 3402, 7405, 5052, 7592, 4342, 1965, 1482, 2583, 4985, 9885, 661, 3523, 5371, 2431}, {1495, 4067, 5829, 6493, 8413, 803, 4897, 4263, 2849, 510, 6626, 7409, 9109, 9014, 4094, 1552, 7571, 1670, 2291, 1990, 196, 1011, 3642, 2142, 3247, 6564, 6099, 1377, 9541, 9603, 4241, 1229, 358, 1057, 3240, 7266, 2111, 1507, 5433, 2008, 700, 7553, 830, 2753, 9403, 7097, 6472, 8129, 484, 6271, 6991, 2832, 5800, 3518, 3067, 4506, 4586, 7308, 2436, 568}, {4027, 4836, 8174, 6751, 9023, 7849, 1000, 1438, 4584, 6276, 2249, 6869, 3268, 8615, 4083, 8908, 320, 6267, 5884, 7860, 8922, 7941, 5637, 9268, 8232, 5270, 6364, 4431, 2947, 428, 5225, 9784, 3589, 481, 4603, 960, 7729, 8675, 5857, 9569, 3814, 2616, 1641, 4061, 3952, 4367, 8744, 917, 3595, 9433, 6364, 5814, 2847, 2886, 3876, 9708, 5211, 5879, 9693, 463}, {5762, 9301, 9235, 2329, 9226, 3085, 8065, 8883, 5064, 2877, 8036, 622, 1479, 921, 3812, 9858, 3585, 327, 8626, 7832, 12, 5436, 3301, 2138, 5583, 2908, 5302, 976, 360, 2421, 9612, 2321, 1818, 8623, 5979, 1189, 6121, 6482, 9602, 1656, 5515, 4945, 5286, 2236, 2581, 7158, 7983, 5199, 2855, 9208, 5847, 3658, 9650, 2873, 6200, 5027, 4826, 2087, 2912, 30}, {9386, 6416, 9298, 531, 2984, 9870, 5214, 3620, 9266, 1706, 8130, 2305, 5426, 1275, 3900, 5683, 5235, 2751, 1454, 5501, 7318, 187, 4346, 3436, 4089, 1111, 5743, 4206, 1771, 21, 789, 6324, 7180, 6876, 2726, 6784, 8079, 6205, 5755, 8947, 6150, 1662, 7856, 9471, 3696, 2665, 7394, 1208, 548, 4832, 329, 5222, 4279, 1716, 1216, 5601, 2788, 6152, 2637, 1229}, {8963, 1526, 5537, 9733, 7910, 508, 7067, 2704, 9951, 7114, 2574, 878, 1660, 5425, 3368, 3113, 6706, 9079, 8850, 4347, 4613, 4873, 3892, 1572, 814, 6438, 9368, 9006, 8044, 2517, 894, 5912, 63, 7006, 1436, 4826, 9834, 7870, 3272, 1590, 422, 3391, 2799, 4782, 1343, 7759, 1893, 5053, 6513, 7716, 8014, 4342, 1494, 8915, 6350, 3030, 6079, 6250, 6053, 3057}, {7304, 732, 4314, 7205, 7620, 4316, 3707, 4401, 9245, 1010, 2477, 1585, 1405, 5633, 8872, 6783, 9663, 3728, 9071, 1000, 6343, 8562, 6859, 8774, 7780, 9384, 3861, 7804, 4897, 1294, 6469, 569, 8227, 9359, 8468, 9364, 2416, 1971, 7358, 2833, 2739, 3472, 3158, 2068, 700, 6937, 1284, 7134, 3309, 2423, 9750, 4226, 5239, 1098, 1426, 6359, 9116, 6511, 9045, 5344}, {4526, 8515, 7507, 203, 9627, 8562, 6875, 1844, 6791, 2452, 2429, 9284, 9633, 9547, 1642, 1731, 9220, 1655, 4688, 8776, 5634, 6733, 4328, 6276, 7956, 9373, 9978, 7751, 614, 2822, 4513, 6603, 2357, 9973, 6582, 636, 6485, 5432, 3893, 808, 7786, 4401, 6103, 332, 5536, 4966, 5095, 4594, 8055, 1610, 3735, 2202, 4924, 7260, 5258, 4415, 6829, 9912, 1463, 3080}, {7238, 3464, 6672, 7938, 8463, 6127, 921, 8443, 2605, 1076, 5098, 8304, 6610, 2223, 8590, 9318, 475, 2847, 3159, 3289, 945, 4088, 542, 7479, 829, 5905, 3263, 4489, 6036, 7606, 8276, 6504, 2030, 501, 3964, 6103, 8009, 9733, 7309, 2910, 7776, 9616, 9034, 5731, 5641, 2680, 4238, 1481, 4671, 450, 6334, 814, 2670, 9376, 3512, 3627, 3689, 3388, 4409, 6710}, {8410, 329, 146, 7768, 2168, 2838, 9850, 139, 3667, 4136, 9968, 5005, 4512, 6944, 6169, 5714, 7521, 4129, 3576, 7647, 4951, 8531, 6507, 9577, 1677, 121, 8381, 6132, 9199, 9729, 9979, 4632, 4891, 1772, 7893, 1046, 5510, 4530, 5328, 4537, 4279, 4896, 3087, 2457, 8476, 3938, 931, 9831, 6621, 5237, 2293, 418, 8149, 4844, 4251, 6858, 6629, 6362, 579, 9553}, {9373, 3112, 5623, 3644, 8760, 7795, 5874, 8312, 4919, 2786, 9147, 2968, 4814, 1600, 7714, 2097, 4238, 9160, 3000, 5500, 1464, 3642, 5821, 3660, 5032, 6890, 5429, 6090, 4270, 9594, 4818, 7599, 1930, 7710, 880, 9562, 9508, 1167, 7737, 3188, 8200, 1964, 6254, 8681, 4889, 6769, 886, 2471, 2251, 3282, 5615, 6705, 9330, 7497, 2347, 5184, 2955, 1325, 7989, 5450}, {2898, 5135, 951, 78, 7407, 4482, 3431, 2763, 9442, 2596, 8022, 1443, 2121, 7106, 7036, 6610, 7030, 7822, 6281, 77, 619, 8746, 3268, 6113, 231, 5280, 8701, 3123, 294, 68, 4077, 3708, 5642, 5114, 2113, 1683, 6285, 8247, 9645, 5016, 2737, 1070, 750, 4886, 4765, 7470, 8525, 9771, 8588, 5536, 7106, 2193, 5616, 8032, 5886, 3088, 2702, 6610, 314, 3743}, {3676, 2150, 3461, 360, 9662, 8268, 2769, 2018, 6007, 613, 6148, 4191, 8762, 797, 9731, 786, 1772, 324, 791, 1898, 6829, 7280, 6231, 2025, 8967, 4141, 7773, 2509, 3367, 153, 4934, 6896, 1655, 8525, 4424, 9923, 2248, 6863, 1719, 8382, 1929, 4632, 1868, 1742, 8155, 3255, 9978, 3273, 4309, 8572, 3305, 5865, 6714, 4840, 2628, 646, 8981, 8133, 3403, 7876}, {5417, 3843, 45, 209, 1459, 1810, 9407, 8096, 2444, 1476, 8384, 1230, 1660, 4193, 3788, 7484, 4851, 4328, 7607, 821, 1636, 2863, 647, 4761, 5902, 5124, 6980, 1899, 1557, 752, 159, 2268, 2794, 5385, 5858, 7172, 4396, 1523, 6106, 5616, 2997, 1866, 6567, 6558, 7480, 4454, 6320, 7836, 6910, 2733, 1853, 2172, 961, 2612, 1700, 6817, 9679, 7909, 9322, 7179}, {2970, 6222, 5876, 473, 2141, 7915, 7998, 1851, 6739, 7221, 754, 1038, 4287, 5149, 203, 8599, 9448, 9258, 3670, 5543, 8505, 8571, 1561, 7092, 4073, 7896, 5665, 6306, 2436, 9148, 895, 191, 2572, 8284, 7689, 8124, 2710, 1227, 8056, 5254, 3947, 5422, 4558, 825, 8306, 3649, 9020, 6204, 6608, 3851, 1292, 7522, 7278, 9389, 7342, 1443, 8167, 7325, 5179, 1945}, {8149, 292, 1682, 6610, 6756, 588, 9129, 8997, 3, 1490, 9900, 4991, 8329, 9214, 3390, 7475, 5585, 5954, 890, 3653, 7446, 5440, 9178, 9830, 7752, 5953, 7415, 1869, 1597, 3634, 36, 5593, 5819, 4784, 8974, 8553, 6126, 1742, 751, 2690, 8068, 2302, 6705, 1753, 4167, 3210, 3073, 1979, 6438, 3533, 7489, 3123, 5537, 1766, 6791, 762, 9648, 2019, 7382, 7494}, {9656, 8261, 2206, 8173, 72, 8690, 796, 9065, 7092, 9587, 7913, 8329, 2904, 9480, 2846, 2104, 1697, 6348, 9840, 9932, 5274, 8260, 6303, 6860, 9978, 4068, 4483, 6519, 5618, 4820, 7420, 2186, 2264, 6763, 9872, 8394, 4898, 8976, 5144, 9070, 3561, 3292, 3436, 4761, 5658, 2174, 2914, 8256, 8889, 5282, 1891, 5772, 9213, 7871, 9549, 9350, 6840, 8748, 4685, 6921}, {210, 8565, 1745, 415, 6241, 2382, 870, 928, 3276, 4375, 2637, 4696, 4106, 2400, 1017, 4836, 3343, 8867, 530, 5877, 7416, 1680, 9206, 3676, 9196, 6372, 3893, 8371, 4713, 770, 6252, 6350, 6826, 5123, 9047, 882, 213, 4118, 3328, 7260, 3696, 6026, 9641, 8956, 9886, 3219, 3171, 4820, 7354, 2907, 1221, 3064, 2848, 8419, 1956, 6181, 666, 7021, 4573, 9120}, {4330, 2132, 2637, 9569, 4179, 93, 5416, 7641, 2537, 655, 2519, 5286, 9780, 834, 4935, 8038, 9383, 9014, 5867, 1195, 5208, 8609, 3604, 3013, 8530, 1118, 8277, 2612, 6815, 8898, 8799, 6610, 1507, 5725, 3625, 3496, 5438, 5425, 5912, 4810, 3580, 8692, 7781, 9197, 145, 1880, 5669, 7302, 3938, 3995, 654, 5259, 6249, 1858, 6323, 4204, 8852, 4634, 405, 8469}, {6144, 8427, 8336, 7301, 7976, 719, 4857, 3155, 5249, 8420, 1350, 1573, 2743, 8815, 8737, 121, 1073, 3454, 3493, 6951, 1703, 3369, 8811, 7131, 1182, 2520, 390, 7524, 5435, 621, 1434, 1201, 890, 2917, 4128, 9144, 1155, 9421, 3730, 4238, 6679, 6358, 7392, 6627, 7095, 5184, 277, 6382, 1939, 8763, 97, 1037, 9595, 746, 1190, 5861, 8239, 1739, 4749, 4938}, {9938, 1418, 4613, 7171, 6250, 6474, 505, 7766, 2562, 8741, 3603, 2235, 6407, 8942, 4833, 2361, 4884, 6114, 183, 9069, 9095, 2317, 2020, 685, 83, 9384, 9776, 6457, 8801, 8971, 1395, 4993, 3442, 5634, 3470, 6761, 8398, 2334, 2638, 3015, 3618, 4141, 3184, 1878, 2972, 9295, 892, 8993, 7558, 9006, 1199, 4763, 1104, 4108, 1609, 3235, 9513, 7983, 5421, 5852}, {2101, 3843, 1640, 4672, 1144, 3171, 5207, 7961, 7384, 5380, 5009, 9572, 2497, 9267, 9288, 5972, 5183, 7018, 2763, 80, 5132, 4034, 3630, 7146, 4534, 5890, 2201, 5433, 7864, 7584, 7297, 5878, 5005, 7979, 9039, 1784, 2880, 9939, 1344, 4598, 2294, 8825, 3219, 4313, 1253, 1236, 306, 8310, 512, 9534, 9485, 6638, 9668, 3486, 601, 9038, 4270, 8905, 8843, 7735}, {2436, 5994, 6431, 3659, 9661, 4768, 2194, 7614, 8211, 8363, 1484, 6501, 5962, 8228, 174, 3914, 2718, 8424, 2300, 7311, 2609, 2936, 9280, 9271, 2396, 7922, 5879, 663, 3586, 7990, 3797, 1030, 4332, 6053, 3835, 702, 3388, 8486, 5919, 6359, 7696, 7449, 761, 654, 5310, 1692, 8543, 4481, 4315, 9481, 8919, 9342, 2849, 6172, 6202, 5986, 9629, 1276, 8466, 4122}, {6166, 3652, 8461, 6650, 5782, 5654, 7977, 7899, 9900, 109, 8223, 2277, 7208, 2714, 3769, 1264, 8431, 4601, 3466, 2462, 3063, 2579, 5935, 9864, 1939, 3774, 6794, 5411, 1857, 7890, 7845, 7849, 3453, 9680, 2642, 6733, 368, 3993, 707, 2096, 9397, 9706, 2640, 2208, 8400, 643, 9377, 2407, 917, 2726, 4232, 2950, 8465, 6643, 9820, 9235, 306, 4645, 1405, 3549}, {7360, 9938, 7724, 7892, 2795, 3595, 6731, 9845, 2339, 9547, 2980, 8370, 4334, 2748, 5615, 7430, 9774, 9677, 1128, 3766, 6197, 6316, 2167, 1779, 272, 3316, 8565, 8264, 6878, 2451, 9921, 1578, 2907, 7797, 9828, 640, 8707, 8247, 1926, 1527, 7902, 2136, 9888, 8836, 20, 7070, 8554, 6893, 6069, 712, 8681, 7029, 3760, 7900, 6247, 5743, 9651, 9440, 1601, 6972}, {2194, 4171, 7818, 3810, 1374, 4642, 9803, 8909, 6696, 4224, 3097, 90, 117, 9470, 8562, 1931, 8516, 118, 6145, 3366, 5176, 6699, 5936, 1747, 2536, 6981, 9591, 4156, 4282, 8784, 6940, 9252, 5991, 4515, 6512, 3338, 6771, 9046, 9136, 7905, 2929, 6066, 9161, 9092, 7926, 4158, 5025, 9465, 5642, 6523, 2263, 1952, 3765, 7318, 2651, 1643, 3514, 8329, 6563, 5545}, {9021, 853, 2634, 6376, 87, 1493, 2382, 7728, 9835, 7134, 1445, 1050, 4311, 3634, 6076, 1312, 9979, 619, 6297, 6565, 8537, 4694, 9789, 942, 2872, 8100, 7193, 176, 3305, 8490, 4686, 3191, 551, 9823, 8365, 8452, 3796, 2777, 591, 5894, 3920, 5, 2580, 1423, 4521, 6545, 5786, 6475, 6643, 9603, 3282, 8483, 252, 1125, 1478, 9005, 4662, 9161, 9551, 5704}, {5694, 4531, 3708, 9935, 3188, 7451, 6619, 9420, 77, 4278, 2868, 6671, 8295, 1745, 9153, 1186, 8244, 4822, 5571, 1918, 8410, 4223, 8814, 9420, 4099, 7255, 6179, 9227, 7924, 3986, 5566, 7518, 7549, 9615, 449, 7897, 1905, 4225, 1107, 6270, 3611, 3768, 5173, 6758, 5786, 8463, 8777, 160, 4315, 4068, 4707, 1524, 6537, 5604, 1246, 9086, 2925, 7808, 5143, 5793}, {3581, 9400, 4409, 2995, 3116, 8176, 3272, 3848, 3966, 4349, 3388, 3756, 3323, 4092, 5834, 2556, 1748, 1965, 1286, 8072, 109, 8872, 693, 7902, 6082, 5168, 8067, 9413, 4502, 8042, 2997, 8375, 4592, 6519, 3639, 9449, 2102, 888, 8614, 6934, 7837, 8860, 534, 8233, 5690, 6451, 2864, 7491, 1973, 8491, 7538, 5172, 138, 194, 3453, 6217, 9520, 1651, 5332, 5925}, {4255, 3067, 8988, 4307, 3886, 4414, 7723, 5622, 5996, 3014, 8172, 6946, 3450, 6867, 6100, 5982, 6564, 4582, 7385, 2948, 9362, 2149, 9436, 3745, 1637, 4423, 3864, 9099, 7082, 6241, 3213, 2390, 2451, 7750, 160, 2894, 6907, 8186, 2204, 8471, 8749, 5173, 7973, 4916, 4112, 9211, 9304, 782, 6528, 1622, 2677, 984, 3531, 4167, 7808, 1578, 7371, 5484, 4257, 5915}, {5904, 9181, 9134, 4223, 5639, 325, 6747, 1987, 5753, 9922, 3260, 9452, 9436, 8822, 2860, 4664, 5819, 5327, 8364, 7988, 7323, 1285, 6244, 4695, 7599, 2374, 2746, 5528, 6912, 9366, 6632, 1169, 1297, 2655, 5630, 3740, 5137, 5192, 4774, 4383, 9919, 6480, 4445, 7290, 5951, 9617, 8536, 7378, 6783, 2742, 3013, 379, 2049, 3845, 4123, 1312, 3451, 2735, 6506, 1688}, {1566, 1046, 7753, 8986, 882, 432, 6505, 8585, 1364, 1703, 4301, 2545, 1382, 6388, 5069, 3758, 4054, 4656, 7261, 2072, 2151, 8631, 2796, 469, 576, 5847, 5329, 7802, 7655, 8857, 4464, 8988, 7289, 2214, 8836, 2901, 9681, 9791, 7481, 9241, 7127, 8577, 8746, 5074, 5689, 7892, 8842, 3722, 1468, 7240, 5045, 5993, 6754, 4257, 2552, 4974, 173, 2, 8575, 2234}, {5635, 4699, 7688, 8768, 137, 8060, 7817, 4909, 150, 7053, 4800, 9782, 3789, 119, 8982, 6122, 3090, 6746, 9185, 7162, 6468, 4095, 2676, 6386, 6200, 3615, 4309, 1298, 6918, 3925, 8465, 4455, 4665, 8716, 4405, 6766, 3081, 1122, 2989, 2239, 4745, 1809, 7461, 7419, 4459, 8061, 3077, 5254, 318, 2493, 814, 8765, 363, 3047, 1676, 4623, 4411, 2049, 7184, 135}, {3815, 1478, 2469, 242, 8087, 3559, 5602, 6886, 5105, 8166, 6085, 7598, 520, 5411, 1315, 2394, 919, 4367, 6430, 1170, 8900, 7703, 2976, 3149, 4098, 6252, 207, 1999, 4079, 6305, 7258, 4050, 550, 3264, 7551, 1540, 8539, 3416, 7747, 6376, 5114, 5294, 2599, 692, 9005, 8535, 2002, 4151, 7885, 4896, 3256, 5906, 854, 3569, 1851, 3867, 7114, 5317, 247, 2743}, {4524, 9580, 1961, 6485, 3983, 147, 689, 9521, 7787, 9769, 2540, 6085, 1467, 4076, 2584, 8191, 1498, 5545, 984, 980, 5825, 2522, 8788, 1760, 2062, 7993, 3813, 5190, 9149, 5691, 7188, 3162, 350, 6190, 5869, 2208, 4108, 647, 7952, 7169, 9160, 4829, 8893, 8030, 3110, 9285, 3058, 8907, 5697, 5304, 7675, 4511, 9809, 9086, 2628, 1129, 8703, 2540, 7363, 4845}, {4315, 8874, 6015, 7440, 12, 8290, 6211, 3040, 307, 5966, 3913, 5255, 1038, 8831, 6349, 3111, 8587, 8152, 9036, 2526, 4639, 5286, 6715, 5277, 1810, 1578, 8573, 1093, 718, 2127, 2927, 513, 3311, 1754, 7953, 3140, 1618, 522, 9356, 6367, 8027, 8616, 9672, 4194, 805, 6003, 3617, 9928, 1162, 215, 3420, 8052, 1311, 7669, 995, 5914, 9143, 6815, 6047, 956}};

        
        System.out.println(Arrays.toString(findPeakGrid(x)));
    }
}
