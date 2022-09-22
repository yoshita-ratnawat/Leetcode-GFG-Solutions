class Solution {
    public int findDuplicate(int[] a) {
        int ans=-1;
        for(int i = 0; i < a.length; i++) {
            
            
            while(a[i] != i+1 && a[i] != a[a[i] -1]) {
                
                swap(a, i , a[i]-1);
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            
            if(a[i] != i+1) ans=a[i];
        }
        
        
        return ans;
        
    }
    
    private void swap(int[] a, int i, int j) {
        
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    } 
    
}