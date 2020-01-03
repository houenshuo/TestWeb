package javacore.effectJava.a12clone;

public class PhoneNumber {
    private final int areaCode,prefix,lineNum;
    private int hashcode;// 缓存hashcode

    public PhoneNumber(int areaCode, int prefix, int lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static int rangeCheck(int val,int max,String arg){
        if (val<0 || val>max)
            throw new IllegalArgumentException(arg+":"+val);
        return val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) // 诀窍1 使用 == 检查参数是否为这个对象的引用
            return true;
        if (!(obj instanceof PhoneNumber))//诀窍2 检查参数是否为正确的类型
            return false;
        PhoneNumber pn =(PhoneNumber)obj;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode ==areaCode;// 对每个关键域 都要进行比较匹配
    }

    @Override
    public int hashCode() {

        int result =hashcode;
        if (result ==0){
            result =Integer.hashCode(areaCode);
            result =31 * result+Integer.hashCode(prefix);
            result =31 * result+Integer.hashCode(lineNum);
            hashcode =result;
        }
        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            return (PhoneNumber)super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}
