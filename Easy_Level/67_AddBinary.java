package Easy_Level;
class AddBinary {
    public String addBinary(String s1, String s2) {
        StringBuilder str = new StringBuilder();
        
        int first = s1.length()-1;
        int second = s2.length()-1;
        int carry=0;

        while(first>=0 || second>=0)
        {
            if(first>=0 && second>=0)
            {
                int num = (s1.charAt(first) - '0' )+ (s2.charAt(second) -'0') + carry;
                
                carry = num/2;
                str.append(num%2);
                first--;
                second--;
                
            }
            else if(second>=0 && first<0)
            {
                int num =  (s2.charAt(second) -'0') + carry;
                
                carry = num/2;
                str.append(num%2);
                second--;
                
            }
            else if(first>=0 && second<0)
            {
                
                int num = (s1.charAt(first) - '0' )+ carry;
                
                  carry = num / 2;
                  str.append(num % 2);
                  first--;

            }
        }
        if(carry>0)
        {
            str.append(carry);
        }
        String res =  str.reverse().toString();
        
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }
        res = res.substring(i);

        return res;
        
    }
}
