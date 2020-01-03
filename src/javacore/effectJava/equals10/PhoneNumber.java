package javacore.effectJava.equals10;

public class PhoneNumber {
    private final short areaCode,prefix,lineNum;

    public PhoneNumber(short areaCode, short prefix, short lineNum) {
        this.areaCode = areaCode;
        this.prefix = prefix;
        this.lineNum = lineNum;
    }

    private static short rangeCheck(int val,int max,String arg){
        if (val<0 || val>max)
            throw new IllegalArgumentException(arg+":"+val);
        return (short)val;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) // 诀窍1 使用 == 检查参数是否为这个对象的引用
            return true;
        if (!(obj instanceof  PhoneNumber))//诀窍2 检查参数是否为正确的类型
            return false;
        PhoneNumber pn =(PhoneNumber)obj;
        return pn.lineNum == lineNum && pn.prefix == prefix && pn.areaCode ==areaCode;// 对每个关键域 都要进行比较匹配

    }
}
