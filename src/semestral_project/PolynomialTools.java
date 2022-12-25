package semestral_project;

import java.util.Arrays;

public final class PolynomialTools {

    /**
     * This method swaps the elements symmetrically about the center
     *
     * @param a
     */
    public static void reverse(int[] a) {
        int t;
        for (int i = 0; i < a.length / 2; i++) {
            t = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[0 + i];
            a[i] = t;
        }
    }

    /**
     * This method counts a sum of two arrays element by element. If the arrays
     * have different lengths, then the smaller one is complemented with zeros,
     * and only then their sum will be counted
     *
     * @param coeffs1 first array
     * @param coeffs2 second array
     * @return array, contained sums of each couple of elements on the same
     * index
     */
    public static int[] sum(int[] coeffs1, int[] coeffs2) {
        if (coeffs1.length != coeffs2.length) {
            if (coeffs1.length > coeffs2.length) {
                coeffs2 = makeLengthEqual(coeffs1, coeffs2);
            } else {
                coeffs1 = makeLengthEqual(coeffs1, coeffs2);
            }
        }
        int[] sumArray = new int[coeffs1.length];
        for (int i = 0; i < coeffs1.length; i++) {
            sumArray[i] = coeffs1[i] + coeffs2[i];
        }
        return sumArray;

    }

    /**
     * This method works by appending zeros to a smaller of the given arrays, so
     * that the lengths of the two given arrays will be the same. Important:
     * arrays must be unequal. How this works: the contents of the old array are
     * copied to the beginning of the new one, and the missing number of
     * elements stays as zeros.
     *
     * @param array1 first array
     * @param array2 second array
     * @return an array appending by zeros
     */
    public static int[] makeLengthEqual(int[] array1, int[] array2) {
        boolean checkLength;
        checkLength = array1.length > array2.length;
        if (checkLength) {
            int[] newArray = new int[array1.length];
            System.arraycopy(array2, 0, newArray, 0, array2.length);
            array2 = newArray;
        } else {
            int[] newArray = new int[array2.length];
            System.arraycopy(array1, 0, newArray, 0, array1.length);
            array1 = newArray;          
            System.arraycopy(array2, 0, array2, 0, 0);
        }
        if (checkLength) {
            return array2;
        } else {
            return array1;
        }
    }

    /**
     * This method multiplies two arrays with each other. Multiplication is
     * performed according to the principle of polynomial multiplication. Each
     * element of the first array is multiplied by each element of the second
     * array, and then the coefficients at the same degrees are added and
     * assigned to the new array in place of the resulting indexes (in this case
     * a degree is an element index)
     *
     * @param coeffs1 fisrt array
     * @param coeffs2 second array
     * @return new array, which has a length as a sum of highest degrees
     * (indexes) of two arrays
     */
    public static int[] product(int[] coeffs1, int[] coeffs2) {        
        int[] productArray = new int[coeffs1.length + coeffs2.length - 1];
        for (int i = 0; i < coeffs1.length; i++) {
            for (int j = 0; j < coeffs2.length; j++) {
                productArray[i + j] += coeffs1[i] * coeffs2[j];
            }
        }
        return productArray;
    }

    // testing main
//    public static void main(String[] args) {
//        /* Test <reserve()>:
//        in: [1, 2, 3, 4, 5, 6]
//        expected out: [6, 5, 4, 3, 2, 1]
//        */
//        int[] a = {1, 2, 3, 4, 5, 6};
//        reverse(a);
//        System.out.println(Arrays.toString(a));
//        
//        /* Test <sum()>:
//        1) in: [2, 2, 2, 2, 2] and [4, 4, 4]
//           expected out: [6, 6, 6, 2, 2]
//        2) in: [2, 2, 2, 2, 2] and [4, 4, 4, 4, 4]
//           expected out: [6, 6, 6, 6, 6]
//        */
//        int[] b1 = {2, 2, 2, 2, 2};
//        int[] b2 = {4, 4, 4};
//        int[] b3 = {4, 4, 4, 4, 4};
//        System.out.println(Arrays.toString(sum(b1, b2)));
//        System.out.println(Arrays.toString(sum(b1, b3)));
//        
//        /* Test <makeLengthEqual()>:
//        1) in: [1, 2, 3, 4, 5] and [1, 2, 3]
//           expected out: [ 1, 2, 3, 0, 0]
//        2) in: [1, 2, 3] and [1, 2, 3, 4, 5, 6, 7, 8]
//           expected out: [1, 2, 3, 0, 0, 0, 0, 0]
//        */
//        int[] c1 = {1, 2, 3, 4, 5};
//        int[] c2 = {1, 2, 3};   
//        int[] c3 = {1, 2, 3, 4, 5, 6, 7, 8};
//        System.out.println(Arrays.toString(makeLengthEqual(c1, c2)));
//        System.out.println(Arrays.toString(makeLengthEqual(c2, c3)));
//        
//        /* Test <product()>:
//        1) in: [1, 2, 3] and [2, 3, 4] 
//                          0  1  2   3   4        0        1            2            3        4 - indexes
//           expected out: [2, 7, 16, 17, 12] ~ [(1*2), (1*3+2*2), (1*4+2*3+3*2), (2*4+3*3), (3*4)]
//        
//                0  1  2       0   1 - indexes
//        2) in: [1, 2, 3] and [5, 10] 
//                          0  1   2   3   4       0         1           2           3        4 - indexes
//           expected out: [5, 20, 35, 30, 0] ~ [(1*5), (1*10+2*5), (2*10+3*5), (3*10+2*0), (3*0)]
//        
//                0  1  2       0  1  2 - indexes
//        
//        */
//        int[] d1 = {1, 2, 3};
//        int[] d2 = {2, 3, 4};
//        int[] d3 = {5, 10};        
//        System.out.println(Arrays.toString(product(d1, d2)));
//        System.out.println(Arrays.toString(product(d1, d3)));
//    }
}
