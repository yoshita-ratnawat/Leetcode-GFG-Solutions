class Solution {
    public List<Integer> findDisappearedNumbers(int[] a) {
        
        List<Integer> list = new LinkedList<Integer>();
        
        for(int i = 0; i < a.length; i++) {
            
            
            while(a[i] != i+1 && a[i] != a[a[i] -1]) {
                
                swap(a, i , a[i]-1);
            }
        }
        
        for(int i = 0; i < a.length; i++) {
            
            if(a[i] != i+1) list.add(i+1);
        }
        
        
        return list;
        
    }
    
    private void swap(int[] a, int i, int j) {
        
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}