boolean tripletSum(int x, int[] a) {
    Arrays.sort(a);
    int n = a.length;
    for(int first = 0; a[first] <= x/2; first++){
        int sum = x-a[first];
        int second = first+1;
        int third = n-1;
        while(second < third){
            int s = a[second] + a[third];
            if(s == sum)
                return true;
            if(s < sum)
                second++;
            else
                third--;
        }
    }
    return false;
}
