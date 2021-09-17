package gfg.arrays;

class ReverseArrays {
    public void reverse(int [] arr) {
        int i = 0,j = arr.length - 1;
        while(i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++; j--;
        }
    }
}