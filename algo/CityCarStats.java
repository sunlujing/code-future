package com.afterpay;

import java.util.*;

/**
 * Input,   city-1 : time: cars [100, 1] [110, 3], [120, 8]
 * city-2 : time: cars [110, 4], [115, 8]
 * city-3 : time: cars [100, 1] [110, 3], [130, 11]
 * city-n: .....
 *  多个城市呼叫中心，时间序列统计汽车数量，需要对齐各个城市的timer adn cars，并统计。
 * output:
 *    100, 1+1,  110 3+4+3, 115 8 +3 +3, 120 8+8+3,  130 11 + 8 + 8
 *
 */

public class CityCenter {


    public List<CityTimer> aggCarsForCity(List<List<CityTimer>> cities){
        List<CityTimer> res = new ArrayList<CityTimer>();
        Set<Integer> calced  = new HashSet<Integer>();


        for(int i= 0 ; i < cities.size() ; i ++){

            List<CityTimer> bench = cities.get(i);
            for (int k=0; k < bench.size() ; k ++){
                CityTimer current = bench.get(k);
                if(! calced.contains(current.getTimer())) {
                    for (int j = 0; j < cities.size(); j++) {
                        if (j != i) {
                            current = getLatestTimerNode(current, cities.get(j));
                        }
                    }
                    res.add(current);
                    calced.add(current.getTimer());
                }
            }

        }
        return res;
    }


    public CityTimer getLatestTimerNode(CityTimer timer ,List<CityTimer> city ){
        CityTimer pres = null;
        CityTimer res = new CityTimer(timer.getTimer(),timer.getCar());
        boolean flag = false;
        for (int k=0; k < city.size() ; k ++){
            CityTimer smallest = city.get(k);
            if(timer.getTimer() < smallest.getTimer()){
                if(pres !=null){
                    res.setCar(timer.getCar() + pres.getCar());
                }
                flag =true;
                break;
            }else if(timer.getTimer() == smallest.getTimer()){
                res.setCar(timer.getCar() + smallest.getCar());
                flag = true;
                break;
            }else{
                pres = smallest;
            }
        }
        if(!flag){
            //latest
            res.setCar(timer.getCar()+ city.get(city.size()-1).getCar());
        }

        return res;
    }


    public static void main(String[]args){

        List<CityTimer> city_1 = new ArrayList<CityTimer>();
        city_1.add(new CityTimer(100,1));
        city_1.add(new CityTimer(110,3));
        city_1.add(new CityTimer(120,8));

        List<CityTimer> city_2 = new ArrayList<CityTimer>();
        city_2.add(new CityTimer(80,1));
        city_2.add(new CityTimer(110,4));
        city_2.add(new CityTimer(115,8));


        List<CityTimer> city_3 = new ArrayList<CityTimer>();
        city_3.add(new CityTimer(100,1));
        city_3.add(new CityTimer(115,3));
        city_3.add(new CityTimer(131,3));
        city_3.add(new CityTimer(140,8));

        List< List<CityTimer>> input = new ArrayList<List<CityTimer>>();
        input.add(city_1); input.add(city_2); input.add(city_3);

        CityCenter cityCenter = new CityCenter();

        List<CityTimer> res = cityCenter.aggCarsForCity(input);

        for (CityTimer re : res) {
            System.out.println("timer "+ re.getTimer() +", cars "+ re.getCar());
        }

    }



    static class CityTimer {

        int timer;
        int car;

        public CityTimer(int timer, int car){
            this.timer = timer;
            this.car = car;
        }

        public int getTimer() {
            return timer;
        }

        public void setTimer(int timer) {
            this.timer = timer;
        }

        public int getCar() {
            return car;
        }

        public void setCar(int car) {
            this.car = car;
        }
    }


}
