
import javax.swing.JOptionPane;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ADMIN
 */
public class RunZombie extends Zombie{
    
    
    public RunZombie(GamePanel parent,int lane){
        super(parent,lane);
        health = 2000;
    }
    @Override
    public void advance(){
        if(isMoving) { //kiểm tra zombie có di chuyển không nếu là true thì tiếp tục 
            boolean isCollides = false; // va chạm false 
            Collider collided = null;   // tạo một đối tượng va chạm 
            for (int i = myLane * 9; i < (myLane + 1) * 9; i++) { //đoạn mã code này kiểm tra có trong vùng va chạm không 
                if (gp.colliders[i].assignedPlant != null && gp.colliders[i].isInsideCollider(posX)) {
                    isCollides = true;
                    collided = gp.colliders[i]; // đối tượng collider được gán cho biến collided
                }
            }
            if (!isCollides) { // không va chạm 
                if(slowInt>0){ // bị bắn đạn frezze
                    if(slowInt % 2 == 0) { // nếu biến slowint là số chẵn thì zombie được di chuyển 
                        posX--; // nếu là số lẽ thì sẽ không di chuyển 
                    }
                    slowInt--; // sau khi thực hiện xong hết slowint sẽ tự trừ đi 1 
                }else {
                    if (health >= 1000){
                        posX-= 2;
                    }
                    else if (health < 1000){
                        posX -=4;
                    }// nếu không bị làm chậm và không va chạm thì posx zombie -1
                }
            } else {
                collided.assignedPlant.health -= 100; // máu của plant -10
                if (collided.assignedPlant.health < 0){ // nếu máu của plant bé hơn 0 thì remove plant 
                    collided.removePlant();
                }
            }
            if (posX < 0) { // zombie đi hết đường đi         
                isMoving = false;
                JOptionPane.showMessageDialog(gp,"ZOMBIES KILLED THE GUARDIANS !" + '\n' + "Starting the level again");// trình một cửa sổ thông báo kết thúc game 
                GameWindow.gw.dispose();
                GameWindow.gw = new GameWindow();
            }
        }
    }   
}   
