class ZigZag {
    public String convert(String s, int numRows) {
        
        if (numRows == 1) return s;
        
        ArrayList<String> stringRecord = new ArrayList<String>();
        int i=0;
        boolean forward = true;
        for(Character c : s.toCharArray() ) {
            if(stringRecord.size() > i){
                stringRecord.set(i,stringRecord.get(i) + c);  
            } else {
                stringRecord.add(c.toString());
            }
            if(i<numRows-1 && forward){
                i++;
            } else if(i>0 && !forward) {
                i--;
            } else if( i == numRows-1 ) {
                i--;
                forward = false;
            } else if( i == 0 ) {
                i++;
                forward = true;
            } 
        }
        String result = "";
        for (String rec: stringRecord) {
            result = result +rec;
        }
        return result;
        
    }
}
