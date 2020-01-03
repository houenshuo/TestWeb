import java.util.List;

public class Test {
        public static void main(String[] args) {
            System.out.println("正整数6的整数划分有"+q(5,5)+"种");
        }
        public static int q(int n,int m) {
            if(n==1 || m==1) {
                return 1;
            } else if(n<m) {
                return q(n,n);
            } else if(n==m) {
                return q(n,n-1)+1;
            } else if(n>m) {
                return  q(n,m-1) + q(n-m,m);
            }
            return -1;
        }
        public static void pp(List<?> t){}
}
