package semestral_project;

import semestral_project.UI;

public final class PolynomialTools {

    public static void reverse(int[]a) {
        int t;
        for (int i = 0; i < a.length / 2; i++) {
            t = a[a.length - 1 - i];
            a[a.length - 1 - i] = a[0 + i];
            a[i] = t;
        }
    }
    
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
        reverse(sumArray);
        return sumArray;
        
    }
    
    public static int[] makeLengthEqual(int[] array1, int[] array2) {
        boolean checkLength;
        checkLength = array1.length > array2.length;
        if (checkLength) {
            int[] newArray = new int[array1.length];
            System.arraycopy(array2, 0, newArray, 0, array2.length);
            array2 = newArray;
        }
        else  {
            int[] newArray = new int[array2.length];
            System.arraycopy(array1, 0, newArray, 0, array1.length);
            array1 = newArray;
        }
        if (checkLength)
            return array2;
        else return array1;
    }
    
    public static int[] product(int[] coeffs1, int[] coeffs2){
        if (coeffs1.length != coeffs2.length) {
            if (coeffs1.length > coeffs2.length) {
                coeffs2 = makeLengthEqual(coeffs1, coeffs2);
            } else {
                coeffs1 = makeLengthEqual(coeffs1, coeffs2);
            }         
        }
        reverse(coeffs1);
        reverse(coeffs2);
        int[] productArray = new int[coeffs1.length*2 - 1];
        int maxDegree = productArray.length - 1;
        for (int i = 0; i < coeffs1.length; i++) {
            for (int j = 0; j < coeffs2.length; j++) {
                productArray[i+j] += coeffs1[i] * coeffs2[j];                
            }
        }
        return productArray;
    }
    
    
    //testing
    public static void main(String[] args) {
        int[] a = {-1};
//        int[] b = {1};
        int[] c = {-1, 0, 101, 0, 1, -1, 0};
//        a = makeLengthEqual(a, c);
        int[] d = {1, -1, 1, 0, 0, 1};
        int[] e = {-5, 10, 0};
        int[] f = {1, 2, -3};
        int[] m = {3, 1, -10};
        int[] n = {1, -3, 2};
//        writeOutPolynom(a);
//        writeOutPolynom(b);
//        writeOutPolynom(c);
//        writeOutPolynom(d);
//        writeOutPolynom(e);
//        sum(a, c);
//        writeOutPolynom(a);
//        writeOutPolynom(c);
//        writeOutPolynom(sum(e, f));
//        writeOutPolynom(e);
//        writeOutPolynom(f);
        int[] r = product(m, n);
        UI.writeOutPolynom(r);
    }
    
}
