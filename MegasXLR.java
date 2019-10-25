package MegasXLR;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * MegasXLR - a robot by (Javão)
 */
public class MegasXLR extends RateControlRobot
{
	
    int turnCounter;
	int turnDirection = 1;

	public void run() {	
	
		setBodyColor(Color.blue);
		setGunColor(Color.yellow);
		setRadarColor(Color.red);
		setBulletColor(Color.black);
		setScanColor(Color.red);
		
		turnCounter = 0;
		setGunRotationRate(4);
		
		while (true) {
		
			if (turnCounter % 64 == 0) {
				setTurnRate(0);
				setVelocityRate(7);
			}
			if (turnCounter % 64 == 32) {
				setVelocityRate(-4);
			}
			turnCounter++;
			execute();
		}
	}

	/**
	 * onScannedRobot: What to do when you see another robot
	 */
	public void onScannedRobot(ScannedRobotEvent e) {
		
			setTurnRate(5);
			setGunRotationRate(2);			

			if(getEnergy() >= 70){
			fire(3);
			}
			
			if(getEnergy() >= 50){
			fire(2);
			}
			
			else{
			fire(1);
			
			}
		
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		setVelocityRate(10);
		setTurnRate(10);
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		setVelocityRate(-1 * getVelocityRate());
		setTurnRate(5);
	}
	
	public void onBulletMissed(BulletMissedEvent event){
		setVelocityRate(-1 * getVelocityRate());
		setTurnRate(5);
		resume();
	}
	
	public void onHitRobot(HitRobotEvent e) {
      		setGunRotationRate(0);
			if (e.getBearing() > -10 && e.getBearing() < 10) {
				for(int i = 0; i<5; i++){
				fire(2);
				}
			}
		
			if (e.isMyFault()) {
				turnRight(10);
			}
	}
		
	public void onBulletHitBullet(BulletHitBulletEvent event){
		setVelocityRate(10);
		setTurnRate(5);
		resume();
	}
		
	public void onBulletHit(BulletHitEvent event){
		for(int i = 0; i<5; i++){
			fire(1);
		}
		resume();
	}
		
	public void onWin(WinEvent e) {
	    int uhuu = 1;
	    while (true) {
	 	   turnRight(360 * uhuu);
	       uhuu = uhuu * -1;
	    }
	}		
}
