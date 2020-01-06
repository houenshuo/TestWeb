package javacore.effectJava.a34;

/**
 * 策略枚举
 */
public enum  PayroollDay {
    MONDAY,TUESDAY,WEDNESDAY,THURSDAY,FRIDAY,SATURDAY(PayType.WEEKEND),SUNDAY(PayType.WEEKEND);
    private final PayType payType;
    PayroollDay(PayType payType) {
        this.payType = payType;
    }

    PayroollDay() {
        this(PayType.WEEKDAY);
    }
    int pay(int minutesWorked,int payRate){
        return payType.pay(minutesWorked,payRate);
    }
    /**
     * 只使用一个枚举类 很难扩展
     */
    //    int pay(int minutesWorked,int payRate){
//        int basePay =minutesWorked * payRate;
//        int overtimePay;
//        switch (this){
//            case SATURDAY:case SUNDAY:
//                overtimePay =basePay/2;
//                break;
//            default:
//                overtimePay =minutesWorked<=MINS_PER_SHIFT?0:(minutesWorked-MINS_PER_SHIFT)*payRate/2;
//        }
//        return basePay + overtimePay;
//
//    }
    /**
     * 策略枚举  私有的嵌套枚举实现
     */
    private enum PayType{

        WEEKDAY{
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked<=MINS_PER_SHIFT?0:(minutesWorked-MINS_PER_SHIFT)*payRate/2;
            }
        },
        WEEKEND{
            @Override
            int overtimePay(int minutesWorked, int payRate) {
                return minutesWorked * payRate /2;
            }
        };
        abstract int overtimePay(int mins,int payRate);

        private static final int MINS_PER_SHIFT =8*60;
        int pay(int minutesWorked, int payRate){
            int basePay =minutesWorked * payRate;
            return basePay+overtimePay(minutesWorked, payRate);
        }
    }

}
