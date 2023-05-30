import javax.swing.*;


public class Zombie {

    public int health = 1000;
    public int speed = 1;

    GamePanel gp;

    public int posX = 1000;
    public int myLane;
    public boolean isMoving = true;
 

    public Zombie(GamePanel parent,int lane){
        this.gp = parent;
        myLane = lane;
    }

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
                    posX -= 1; // nếu không bị làm chậm và không va chạm thì posx zombie -1
                }
            } else {
                collided.assignedPlant.health -= 10; // máu của plant -10
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
    
    public void kill(){
        if (health > 0 ){
            health = 0;
        }
        
        if (gp != null){
            gp.laneZombies.get(posX).remove(this);
        }
    }
    
    
    int slowInt = 0; // biến slowint lúc đầu 
    public void slow(){ //phương thức slow khi frezze pea được bắn dính zombie
        slowInt = 1000; // mỗi lần bắn dính zombie biến slowint =1000
    }
    public static Zombie getZombie(String type,GamePanel parent, int lane) {
        Zombie z = new Zombie(parent,lane);
       switch(type) {
            case "NormalZombie" : z = new NormalZombie(parent,lane);
                                 break;
            case "ConeHeadZombie" : z = new ConeHeadZombie(parent,lane);
                                 break;
            case "RunZombie" : z = new RunZombie(parent,lane);
                                 break;
    }
       return z;
    }

}
