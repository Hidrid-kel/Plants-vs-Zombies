import javax.swing.*;
import java.awt.event.ActionEvent;

public class GameWindow extends JFrame {

    enum PlantType{
        None,
        Sunflower,
        Peashooter,
        FreezePeashooter,
        Nut
    }

    //PlantType activePlantingBrush = PlantType.None;
    
    public GameWindow(){
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLayout(null);
        
        
        
        JLabel sun = new JLabel("SUN");
        sun.setLocation(30,80);
        sun.setSize(60,20);

        GamePanel gp = new GamePanel(sun);
        gp.setLocation(0,0);
        getLayeredPane().add(gp,new Integer(0));
        
        PlantCard sunflower = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/1 (1).png")).getImage());
        sunflower.setLocation(100,8);
        sunflower.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Sunflower;
        });
        getLayeredPane().add(sunflower,new Integer(3));

        PlantCard peashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/2 (1).png")).getImage());
        peashooter.setLocation(170,8);
        peashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Peashooter;
        });
        getLayeredPane().add(peashooter,new Integer(3));

        PlantCard freezepeashooter = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/4 (1).png")).getImage());
        freezepeashooter.setLocation(240,8);
        freezepeashooter.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.FreezePeashooter;
        });
        getLayeredPane().add(freezepeashooter,new Integer(3));
        
        PlantCard Nut = new PlantCard(new ImageIcon(this.getClass().getResource("images/cards/5.png")).getImage());
        Nut.setLocation(310,8);
        Nut.setAction((ActionEvent e) -> {
            gp.activePlantingBrush = PlantType.Nut;
        });
        getLayeredPane().add(Nut,new Integer(3));


        getLayeredPane().add(sun,new Integer(2));
        setResizable(false);
        setVisible(true);
    }
    public GameWindow(boolean b) {
        Menu menu = new Menu();
        menu.setLocation(0,0);
        setSize(1012,785);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        getLayeredPane().add(menu,new Integer(0));
        menu.repaint();
        setResizable(false);
        setVisible(true);
        
        
    }
    static GameWindow gw;
    public static void begin() {
        gw.dispose();
       gw = new GameWindow();
    }
    public static void main(String[] args) {
          gw = new GameWindow(true);
    }

}
