public class Solution {
    public boolean isStrobogrammatic(String num) {
          
          for (int i = 0; i <= num.length() / 2; i++){
              char a = num.charAt(i);
              char b = num.charAt(num.length() - 1 -i);
              if(!isValid(a, b)) return false;
          }
          return true;
    }
          public boolean isValid(char c, char b){
              switch(c){
                  case '1':
                      return b == '1';
              case '6':
                      return b == '9';
              case '9':
                      return b == '6';
              case '8':
                      return b == '8';
                      case '0':
                      return b == '0';
                      default:
                      return false;
              }
          }
          
          
          
          
          
          
          
          
          
    
}
