package Key_questions.PreparedForHuaWei;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

public class ShootCarService {
    public float getAvg(int beginAddress, int endAddress, List<shootCar> shootCars){
        int carnum=0;
        long vtimeAll=0;
        for (int i = 0; i < shootCars.size(); i++) {
            shootCar car=shootCars.get(i);
            for (int j = 0; j <shootCars.size() ; j++) {
                if(i==j){
                    continue;
                }
                shootCar car1=shootCars.get(j);
                if(car.getAdrId()==car1.getAdrId()){
                    carnum++;
                    long time1= car.getShootTime().getTime();
                    long time2=car1.getShootTime().getTime();
                    long vtime=Math.max(time1,time2)-Math.min(time1,time2);
                    vtimeAll+=vtime;
                }
            }
        }
        DecimalFormat df = new DecimalFormat("0.00");

        String result = df.format(vtimeAll/(carnum*60));
        return Float.parseFloat(result);
    }
    public static void main(String[] args) {

    }
}
class shootCar{
    private int adrId;
    private String carNum;
    private Date shootTime;

    public int getAdrId() {
        return adrId;
    }

    public shootCar setAdrId(int adrId) {
        this.adrId = adrId;
        return this;
    }

    public String getCarNum() {
        return carNum;
    }

    public shootCar setCarNum(String carNum) {
        this.carNum = carNum;
        return this;
    }

    public Date getShootTime() {
        return shootTime;
    }

    public shootCar setShootTime(Date shootTime) {
        this.shootTime = shootTime;
        return this;
    }
}
