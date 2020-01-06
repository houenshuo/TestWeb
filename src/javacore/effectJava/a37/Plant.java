package javacore.effectJava.a37;

import java.util.*;

public class Plant {
    enum LifeCycle {ANNUAL , PERENNIAL,BIENNIAL}
    final String name;
    final LifeCycle lifeCycle;

    public Plant(String name, LifeCycle lifeCycle) {
        this.name = name;
        this.lifeCycle = lifeCycle;
    }

    @Override
    public String toString() {
        return "Plant{" +
                "name='" + name + '\'' +
                ", lifeCycle=" + lifeCycle +
                '}';
    }
    public static void main(String[] args) {
        Plant[] garden =new Plant[]{new Plant("ANNUAL",LifeCycle.ANNUAL)};
        Set<Plant> [] plants = new Set[LifeCycle.values().length];// 泛型和数组不能兼容new Set<Plant>[LifeCycle.values().length].必须去掉new后的泛型
        plants[0] = new HashSet<>();
        for (int i=0;i<plants.length;i++){
            plants[i] =new HashSet<>();
        }
        for (Plant p:garden){
            plants[p.lifeCycle.ordinal()].add(p);//lifeCycle.ordinal() 不可控制
        }
        for (int i=0;i<plants.length;i++){
            System.out.printf("%s:%s%n",Plant.LifeCycle.values()[i],plants[i]);
        }

        /**
         * 使用EnumMap
         */
        Map<Plant.LifeCycle,Set<Plant>> map =new EnumMap<>(Plant.LifeCycle.class);
        for (Plant.LifeCycle lifeCycle:Plant.LifeCycle.values()){
            map.put(lifeCycle,new HashSet<>());
        }
        for (Plant p:garden){
            map.get(p.lifeCycle).add(p);
        }
        System.out.println(map);
    }
}
