package javacore.effectJava.a12clone;

public class HashTable implements Cloneable {
    private Entry[] buckets =null;
    private static class Entry{
        final Object key;
        Object value;
        Entry next;

        public Entry(Object key, Object value, Entry next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
        Entry deepCopy(){// 深度copy
            // 这种方式容易导致stack溢出
            //return new Entry(key,value,next == null?null:next.deepCopy());//next.deepCopy() 深度克隆链表
            Entry entry =new Entry(key,value,next);// next 会在for中重新赋值
            for (Entry p =entry;p.next !=null;p =p.next){
                p.next =new Entry(p.next.key,p.next.value,p.next.next);
            }
            return entry;
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        try {
            HashTable result =(HashTable)super.clone();
            result.buckets =new Entry[buckets.length];
            for (int i=0;i<buckets.length;i++){
                if(buckets[i]!=null)
                    result.buckets[i] =buckets[i].deepCopy();
            }
            return result;
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }

    }
}
