    

package carrace;


import javax.swing.*; 
import java.awt.* ; 
import java.util.Random; 
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.net.MalformedURLException;
import java.net.URL;
public class CarRace extends  JPanel implements ActionListener , KeyListener  {
    static JFrame  j ;
    Timer tm ;
    Random rCar = new Random(); // Random number  
    int RandCar =rCar.nextInt(3); 
    int x =250 , y =570 , vx = 0 , vy =0 , changecount= 0,d=0 , set=0; 
    boolean crash =false  ;
    int randcarx,randcary , count=0; 
    int[] rand = {90,270,440};
    int[] rand2 = {0,-200,-400};
    int[] xobs ={90,90,90};
    int[] yobs =new int[3];
    int c = 0 , ms=100 ;
    Color clr = Color.red ;
    Icon startico = new ImageIcon("images/start.png");
    Icon closeico = new ImageIcon("images/close.png");
    Icon restartico = new ImageIcon("images/restart.png");
    
    JButton startbtn = new JButton(startico);
    JButton closebtn = new JButton(closeico);
    JButton restartbtn = new JButton(restartico);
    


    JLabel picCar  ;//تعريف العربية الأساسية 
    JLabel[] carobs =new JLabel[3]  ;//تعريف العربيات كلها العوائق 
    JLabel pic  ; //تعريف الخلفية 
    JLabel gopic ;
    String car = "images/car.png"; //مكان العربية الأساسية  
    String[] list = { 
        "images/road_car_race 0.png",
        "images/road_car_race 1.png",
        "images/road_car_race 2.png",
        "images/road_car_race 3.png"
                    }; // قايمة صور الخلفية المتحركة 
    String[] listobs = {
      "images/car0.png",  
      "images/car1.png",  
      "images/car2.png"  
    }; // قايمة صور العوائق 
    String[] goname ={ "images/goFrames/Game Over1.png",
        "images/goFrames/Game Over2.png",
        "images/goFrames/Game Over3.png",
        "images/goFrames/Game Over4.png",
        "images/goFrames/Game Over5.png",
        "images/goFrames/Game Over6.png",
        "images/goFrames/Game Over7.png",
        "images/goFrames/Game Over8.png",
        "images/goFrames/Game Over9.png",
        "images/goFrames/Game Over10.png",
        "images/goFrames/Game Over11.png",
        "images/goFrames/Game Over12.png",
        "images/goFrames/Game Over13.png",
        "images/goFrames/Game Over14.png",
        "images/goFrames/Game Over15.png",
        "images/goFrames/Game Over16.png",
    };
    
    
            
    
    
    public static void main(String[] args)   {
        CarRace r =new CarRace() ;
        j = new JFrame();
        j.setTitle("Car Race 1.0 | copyright © ");
        j.setSize(600,700); 
        j.setLocation(300, 0);
        j.setVisible(true);
        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        
        j.add(r); 
        
        
    }
    public CarRace ()
    {
        
        addKeyListener(this); 
        setFocusable(true); 
        setFocusTraversalKeysEnabled(false);
        picCar = new JLabel() ;
        gopic = new JLabel ();
        
                
        add(startbtn);
        add(closebtn);
        add(restartbtn);
        startbtn.setVisible(true);
        closebtn.setVisible(true);
        restartbtn.setVisible(false);
        gopic.setBounds(0, 0, 580, 650);
        
        
        gopic.setVisible(false);
        add(gopic);
        
        for (int i =0 ; i <3 ; i++)
        {
        carobs[i] = new JLabel(); 
        add(carobs[i]); 
        
        }
        pic= new JLabel() ;
        picCar.setBounds(x, y, 55, 70);
        pic.setBounds(2, 2,580,650);
        picCar.setVisible(true);
        SetImageSize(3) ;
        
        tm = new Timer (10,this);
               
        ImageIcon icon = new ImageIcon(car); // العربية الأساسية و تحديد مقاساتها 
        Image img = icon.getImage();
        Image newImg = img.getScaledInstance(picCar.getWidth(), picCar.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newImc = new ImageIcon(newImg);
        picCar.setIcon(newImc);                                                                                                
        add(picCar);     //اضافة العربية الأساسية
        add(pic); // اضافة صورة الخلفية 
        tm.start();
        
    }
     public void SetImageSize(int i) // تحديد مقاسات الخلفية 
    {
        ImageIcon icon = new ImageIcon (list[i]); 
        Image img = icon.getImage() ; 
        Image newimg = img.getScaledInstance(pic.getWidth(), pic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newimc = new ImageIcon(newimg); 
        pic.setIcon(newimc);
    }
     public void SetgoSize(int i) // تحديد مقاسات الخلفية 
    {
        ImageIcon icon = new ImageIcon (goname[i]); 
        Image img = icon.getImage() ; 
        Image newimg = img.getScaledInstance(gopic.getWidth(), gopic.getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newimc = new ImageIcon(newimg); 
        gopic.setIcon(newimc);
    }
    
        public void Setobstacle(int i , int j ) // للعوائق أو السيارات الأخرى و هو تحديد مقاسات 
    {
        ImageIcon icon = new ImageIcon (listobs[i]); 
        Image img = icon.getImage() ; 
        Image newimg = img.getScaledInstance(carobs[j].getWidth(), carobs[j].getHeight(), Image.SCALE_SMOOTH);
        ImageIcon newimc = new ImageIcon(newimg); 
        carobs[j].setIcon(newimc);
        
        
        
    }
        public void clicks ()
        {
            startbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent m) {
                set = 1 ;

            }
            
        }
                
        );
        closebtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent m) {
                set = 2 ;

            }
            
        }
                
        );
        restartbtn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent m) {
                set = 3 ;

            }
            
        }
                
        );
        }
   
    @Override
    
    
    public void paintBorder( Graphics m )
    {
                startbtn.setBounds( 190,120, 200,110 );
                closebtn.setBounds( 190,300, 200,110);
                restartbtn.setBounds(190,120, 200,110);
                super.paintBorder(m);               
                picCar.setBounds(x, y, 55, 70);
                for (int i =0 ; i <3 ; i++)
                {
                     
                     carobs[i].setBounds(xobs[i],yobs[i],55,70) ;
                     
                  }
                Setobstacle(changecount,changecount);
                pic.setBounds(2, 2,580,650);
                gopic.setBounds(0, 0, 580, 650);
                
                



    }

   
    

   
    @Override
    public void actionPerformed(ActionEvent e) {
        clicks ();
        
        if(set==1)
        {
        startbtn.setVisible(false);
        closebtn.setVisible(false);

         count++;
         
         if(count==10)
         {
             
             Setobstacle(changecount,changecount);
             changecount++;
             if(changecount==3)
                 changecount=0;
         count=0;
         
         }
        
        for (int k=0; k<3;k++ )
        {
         
         yobs[k]=yobs[k]+10;
         randcarx =rCar.nextInt(3);
         randcary =rCar.nextInt(3);
         if( yobs[k] >= 650)
            {
                yobs[k]=rand2[randcarx];
                xobs[k]=rand[randcarx];
                
            }
         
        }    
     
        
        
        
                
        SetImageSize(c) ; 
                c++; 
                if(c >= list.length)
                {
                    c=0 ; 
                }
        
          y = y+vy;
          x = x+vx;
          
        if(y <= 3 )
        {
        vy=0; 
        y = 3 ; 
        }
        if( y >= 570)
        {
            vy=0 ; 
            y = 570 ; 
        } 
         
        
        if(x <= 55 )
        {
        vx=0; 
        x = 55 ; 
        }
        if( x >= 478)
        {
            vx=0 ; 
            x = 478 ; 
        }
        for(int i=0;i<3;i++){
         if(((x>=xobs[i])&&(x<=xobs[i]+55))&&((y>=yobs[i])&&(y<=yobs[i]+65))
                 ||((x+55>=xobs[i])&&(x+55<=xobs[i]+55))&&((y+65>=yobs[i])&&(y+65<=yobs[i]+65))){
            
             crash = true ;
              
         }
         
         stop();
         
         
        }
       
        
        }
        else if(set==2 )
                    {
                        j.dispose();
                        tm.stop();
                    }
        else if(set==3 )
                    {
                       reSet();
                    }
        
        repaint(); 
        
    }
    private void stop()
    {
        
        if(crash)
         {
             gopic.setVisible(true);
             
                  SetgoSize(d);
                  c=0 ;
                  
                  if(d<15)
                  {
                  d++ ; 
                  }
                  if(d>14)
                  {                      
                      d=15; 
                      
                      
                      
                      restartbtn.setVisible(true);
                      closebtn.setVisible(true);
                      
                      
                    
                      
                      
                  }
                  for (int k=0; k<3;k++ )
                {
            
                 yobs[k]=0;
                 }
                  
         }
    }
    
    public void reSet()
    {
             x =250 ;
             y =570 ;
             Random t = new Random(); 
             int randj ;
             for(int i = 0 ; i<3;i++)
             {
                 randj = t.nextInt(3);
                 yobs[i]=rand2[randj] ;
             }
             gopic.setVisible(false);
             restartbtn.setVisible(false);
             closebtn.setVisible(false);
             crash = false ;
             set=1;
             d=0;
             tm.start();
             
             
             
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    

    @Override
    public void keyReleased(KeyEvent e) {
        int c =e.getKeyCode(); 
        if(c==KeyEvent.VK_SPACE)
        {
            if(clr ==Color.red)
            {
            clr = Color.decode("#A0A0A0") ;
            }
            else {clr = Color.red ;}
             //x =250 ;
             y =570 ;
        }
        vx=0; 
        vy=0; 
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int c =e.getKeyCode();
        if (c== KeyEvent.VK_F5)
        {
             reSet();
        }
        if(c== KeyEvent.VK_LEFT)
        {
            vx=-10;
            vy=0; 
            //System.out.println(x+" , "+ y );
        }
        if(c== KeyEvent.VK_RIGHT)
        {
            vx=10;
            vy=0; 
            //System.out.println(x+" , "+ y );

        }
        if(c== KeyEvent.VK_UP)
        {
            vx=0;
            vy=-10; 
        }
        if(c== KeyEvent.VK_DOWN)
        {
            vx=0;
            vy=10; 
        }    
        if(c== KeyEvent.VK_SPACE)
        {
            vx=0;
            vy=-1; 
        }
        if(c== KeyEvent.VK_X)
        {
            ms-=100;
        }
        if(c== KeyEvent.VK_Z)
        {
           ms+=100;
        }
    }

   
    
    
}

