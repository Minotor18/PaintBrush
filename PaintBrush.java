
import java.awt.*;
import java.awt.event.*;
import java.sql.Time;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;


public  class  PaintBrush extends JFrame{
    JPanel canvas = new JPanel();
    JPanel boyalar = new JPanel();
    cizim drw = new cizim(600,500);
    JPanel ekran = new JPanel(new BorderLayout());
    JPanel tuslar = new JPanel();
        JPanel cizgi = new JPanel();
         JButton Dikdortgen = new JButton("Dikdortgen Ciz");
          JButton Oval= new JButton("Oval Ciz");
          JButton kalem= new JButton("Kalemle Ciz");
          JButton Tasi= new JButton("Tasi");
          
          
          
          
          static JPanel mavi = new JPanel();
          static JPanel kirmizi = new JPanel();
          static JPanel yesil = new JPanel();
          static  JPanel sari = new JPanel();
          static  JPanel turuncu = new JPanel();
          static   JPanel mor = new JPanel();
          static   JPanel siyah = new JPanel();
            
            
           
    public PaintBrush() {
      
        setSize(600,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
         setResizable(true);
        cizgi.setLayout(null);
        cizgi.setBounds(0, 95, 10000000, 5);
        cizgi.setBackground(Color.CYAN);
      
         
          tuslar.add(Dikdortgen);
          tuslar.add(Oval);
          tuslar.add(kalem);
          tuslar.add(Tasi);
          Dikdortgen.addActionListener((actionEvent)-> {
            drw.dikdortgen = true;
            drw.kalem = false;
            drw.oval = false;
            drw.tasi = false;
            
        });
           kalem.addActionListener((actionEvent)-> {
            drw.dikdortgen = false;
            drw.kalem = true;
            drw.oval = false;
            drw.tasi = false;
        });
            Oval.addActionListener((actionEvent)-> {
            drw.dikdortgen = false;
            drw.kalem = false;
            drw.oval = true;
            drw.tasi = false;
            
        });
             Tasi.addActionListener((actionEvent)-> {
            drw.dikdortgen = false;
            drw.kalem = false;
            drw.oval = false;
            drw.tasi = true;
        });
         
          
          
          
          
          
         canvas.setLayout(new BorderLayout());
        drw.setBackground(Color.WHITE);
        drw.setPreferredSize(new Dimension(600,500));
        canvas.setPreferredSize(new Dimension(600, 100));
        canvas.add(boyalar,BorderLayout.NORTH);
        canvas.add(tuslar,BorderLayout.CENTER);
        canvas.addMouseListener(drw);
        
        mavi.addMouseListener(drw);
        kirmizi.addMouseListener(drw);
        yesil.addMouseListener(drw);
        sari.addMouseListener(drw);
        turuncu.addMouseListener(drw);
        mor.addMouseListener(drw);
        siyah.addMouseListener(drw);
        
        ekran.add(cizgi);
        ekran.add(drw,BorderLayout.CENTER);
        ekran.add(canvas,BorderLayout.NORTH);
        add(ekran);
        
        
        
        
        mavi.setBackground(Color.blue);
        mavi.setPreferredSize(new Dimension(60, 30));
         kirmizi.setBackground(Color.red);
         kirmizi.setPreferredSize(new Dimension(60, 30));
          yesil.setBackground(Color.green);
          yesil.setPreferredSize(new Dimension(60, 30));
           sari.setBackground(Color.yellow);
           sari.setPreferredSize(new Dimension(60, 30));
            turuncu.setBackground(Color.orange);
            turuncu.setPreferredSize(new Dimension(60, 30));
             mor.setBackground(Color.magenta);
             mor.setPreferredSize(new Dimension(60, 30));
              siyah.setBackground(Color.black);
              siyah.setPreferredSize(new Dimension(60, 30));
                boyalar.add(mavi);
                boyalar.add(kirmizi);
                boyalar.add(yesil);
                boyalar.add(sari);
                boyalar.add(turuncu);
                boyalar.add(mor);
                boyalar.add(siyah);
                pack();
                
                
               
        
    }

    
 
    

 

  
    public static void main(String[] args) {
        new PaintBrush();
    }

    


 
    public static class cizim extends JPanel implements MouseInputListener{
     
     
   
  
        
       boolean dikdortgen = false, kalem = false, oval = false , tasi = false,rmavi=false,rkirmizi=false,ryesil=false,rsari=false,rturuncu=false,rmor=false,rsiyah=false,OvalcizimBasladiMi=false,DikdortgenCizim=false;
       Color yeniC;
       boolean Omu=false,Dmi=false;
        int  startx,starty,endx,endy,old_x, old_y,mx,my,yeniW,yeniH;
         ArrayList<Oval> SilinecekOvaller = new ArrayList<>();
        ArrayList<Dikdortgen> Silinecekdikdortgenler = new ArrayList<>();
           ArrayList<Dikdortgen> dikdortgenler = new ArrayList<>();
          ArrayList<Oval> ovaller = new ArrayList<>();
           ArrayList<Object> TumSekiller = new ArrayList<Object>();
            ArrayList<kalemCiz> kalemler = new ArrayList<>();
           ;
        
	int yeniA,yeniB;

        public boolean within_box = false;
           public class kalemCiz {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private long time;
    public kalemCiz(int x, int y, int width, int height, Color color,long time) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.time=time;
    }
           } 
          
          
           public class Oval {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
    private long time;
    public Oval(int x, int y, int width, int height, Color color,long time) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.time=time;
    }
           }
   public class Dikdortgen {
    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;
 private long time;
    public Dikdortgen(int x, int y, int width, int height, Color color ,long time) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.time=time;
    }
           }
        
 
   
 
   

        
       public void paint(Graphics g){
         super.paint(g);
         
           if (dikdortgen) {
     int x = Math.min(startx, endx);
     int y = Math.min(starty, endy);
     int w = Math.abs(startx-endx);
     int h = Math.abs(starty-endy);
           
          
          g.setColor(colorS());
         g.fillRect(x, y, w, h);
        
       
           }
           else if (oval) {
               
      int x = Math.min(startx, endx);
     int y = Math.min(starty, endy);
     int w = Math.abs(startx-endx);
     int h = Math.abs(starty-endy);
      g.setColor(colorS());
         g.fillOval(x, y, w, h);     
   
           }
               else if (tasi) {
                   if (Omu) {
                     g.setColor(yeniC);
              g.fillOval(yeniA, yeniB, yeniW, yeniH);
                  
               }
                   else if(Dmi){
                    g.setColor(yeniC);
              g.fillRect(yeniA, yeniB, yeniW, yeniH);
                      
                   
                   }
            
            
                 
                    
                }
            
                
                
          
          

   



    Comparator<Object> sortByTime = new Comparator<Object>() {
    @Override
    public int compare(Object o1, Object o2) {
        if (o1 instanceof Dikdortgen && o2 instanceof Dikdortgen) {
            long time1 = ((Dikdortgen) o1).time;
            long time2 = ((Dikdortgen) o2).time;
            return Long.compare(time1, time2);
            
        }
        else if(o1 instanceof Oval && o2 instanceof Dikdortgen) {
        long time1 = ((Oval) o1).time;
            long time2 = ((Dikdortgen) o2).time;
            return Long.compare(time1, time2);
        
        
        }
        else if(o1 instanceof Dikdortgen && o2 instanceof Oval){
         long time1 = ((Dikdortgen) o1).time;
            long time2 = ((Oval) o2).time;
            return Long.compare(time1, time2);
        
        
        }
        else if (o1 instanceof Oval && o2 instanceof Oval){
        
        long time1 = ((Oval) o1).time;
            long time2 = ((Oval) o2).time;
            return Long.compare(time1, time2);
        }
        else if (o1 instanceof kalemCiz && o2 instanceof kalemCiz) {
             long time1 = ((kalemCiz) o1).time;
            long time2 = ((kalemCiz) o2).time;
            return Long.compare(time1, time2);
            
        }
         else if (o1 instanceof kalemCiz && o2 instanceof Oval) {
             long time1 = ((kalemCiz) o1).time;
            long time2 = ((Oval) o2).time;
            return Long.compare(time1, time2);
            
        }
                 else if (o1 instanceof Oval && o2 instanceof kalemCiz) {
             long time1 = ((Oval) o1).time;
            long time2 = ((kalemCiz) o2).time;
            return Long.compare(time1, time2);
            
        }
          else if (o1 instanceof Dikdortgen && o2 instanceof kalemCiz) {
             long time1 = ((Dikdortgen) o1).time;
            long time2 = ((kalemCiz) o2).time;
            return Long.compare(time1, time2);
            
        }
          else if (o1 instanceof kalemCiz && o2 instanceof Dikdortgen) {
             long time1 = ((kalemCiz) o1).time;
            long time2 = ((Dikdortgen) o2).time;
            return Long.compare(time1, time2);
            
        }
        

        return 0;
    }
};
for(Dikdortgen d:Silinecekdikdortgenler){

TumSekiller.remove(d);
}
for(Oval o:SilinecekOvaller){

TumSekiller.remove(o);
}
TumSekiller.addAll(ovaller);
TumSekiller.addAll(dikdortgenler);
TumSekiller.addAll(kalemler);
for(Dikdortgen d:Silinecekdikdortgenler){

TumSekiller.remove(d);
}
for(Oval o:SilinecekOvaller){

TumSekiller.remove(o);
}

    Collections.sort(TumSekiller, sortByTime);
          
    for (Object obj : TumSekiller) {
    if (obj instanceof Dikdortgen) {
        g.setColor(((Dikdortgen) obj).color);
        g.fillRect(((Dikdortgen) obj).x, ((Dikdortgen) obj).y, ((Dikdortgen) obj).width, ((Dikdortgen) obj).height);
           } else if (obj instanceof Oval) {
                g.setColor(((Oval) obj).color);
        g.fillOval(((Oval) obj).x, ((Oval) obj).y, ((Oval) obj).width, ((Oval) obj).height);
           }
        else if (obj instanceof kalemCiz) {
                g.setColor(((kalemCiz) obj).color);
             g.drawLine(((kalemCiz) obj).x, ((kalemCiz) obj).y, ((kalemCiz) obj).width, ((kalemCiz) obj).height);

}
    }
}
   
       
       public Color colorS(){
           if (rmavi) {
                  return (Color.BLUE);
                }
                else if(rkirmizi){
                  return (Color.RED);
                    
                }
                else if(rmor){
                return (Color.magenta);
                    
                }
                else if(rsari){
                  return (Color.YELLOW);
                  
                }
                else if(rturuncu){
                 return (Color.orange);
                    
                }
                else if(ryesil){
                 return (Color.GREEN);
                    
                }
                else if(rsiyah){
                 return (Color.BLACK);
                    
                }
                else{
                return (Color.BLACK);
               
                }
       }

        public cizim(int width, int height) {       
        super();     
        addMouseListener(this);
        addMouseMotionListener(this); 
        
        }
      
        @Override
        public void mouseClicked(MouseEvent e) {
            if(e.getSource()==mavi){
                rmavi =true;
                rkirmizi=false;
                ryesil=false;
                rsari=false;
                rturuncu=false;
                rmor=false;
                rsiyah=false;
               
            }
            else if (e.getSource()==kirmizi) {
                rkirmizi=true;
                rmavi=false;
                ryesil=false;
                rsari=false;
                rturuncu=false;
                rmor=false;
                rsiyah=false;
            }
             else if (e.getSource()==yesil) {
                rkirmizi=false;
                rmavi=false;
                ryesil=true;
                rsari=false;
                rturuncu=false;
                rmor=false;
                rsiyah=false;
            }
             else if (e.getSource()==sari) {
                rkirmizi=false;
                rmavi=false;
                ryesil=false;
                rsari=true;
                rturuncu=false;
                rmor=false;
                rsiyah=false;
            }
             else if (e.getSource()==turuncu) {
                rkirmizi=false;
                rmavi=false;
                ryesil=false;
                rsari=false;
                rturuncu=true;
                rmor=false;
                rsiyah=false;
            }
             else if (e.getSource()==mor) {
                rkirmizi=false;
                rmavi=false;
                ryesil=false;
                rsari=false;
                rturuncu=false;
                rmor=true;
                rsiyah=false;
            }
             else if (e.getSource()==siyah) {
                rkirmizi=false;
                rmavi=false;
                ryesil=false;
                rsari=false;
                rturuncu=false;
                rmor=false;
                rsiyah=true;
            }
            OvalcizimBasladiMi=false;
            DikdortgenCizim=false;
          within_box=false;
	  
      
        }

        @Override
        public void mousePressed(MouseEvent e) {
          
                
                
                if (kalem) {
                    old_x = e.getX();
                    old_y = e.getY();
                    Graphics g=getGraphics();
                     OvalcizimBasladiMi=false;
        
                
            }
              else if (dikdortgen||oval) {
                  startx = e.getX();
                starty = e.getY();
                 OvalcizimBasladiMi=false;
                 DikdortgenCizim=false;
                
            }  else if (tasi){
                Dikdortgen silinecekDikdortgen = null;
                 Oval silinecekOval = null;
                for(Object a :TumSekiller){
                   if (a instanceof Dikdortgen) {
                       Dikdortgen d = (Dikdortgen) a;
                   if(e.getX() >= d.x && e.getX() <= (d.x+d.width) &&
		   e.getY() >= d.y && e.getY() <= (d.y+d.height) ){
                     yeniW = d.width;
                     yeniH = d.height;
                     yeniC=d.color;
                     yeniA=d.x;
                     yeniB=d.y;
                     silinecekDikdortgen=d;
                     within_box = true;
                     Dmi=true;
                     Omu=false;
                     break;
                     
  	
                }
                        
                    }
                    if (a instanceof Oval) {
                      Oval d = (Oval) a;
                   if(e.getX() >= d.x && e.getX() <= (d.x+d.width) &&
		   e.getY() >= d.y && e.getY() <= (d.y+d.height) ){
                     yeniW = d.width;
                     yeniH = d.height;
                     yeniC=d.color;
                     yeniA=d.x;
                     yeniB=d.y;
                     silinecekOval=d;
                     within_box = true;
                      Dmi=false;
                     Omu=true;
                     break;
  	
                }
                        
                    }

                }
                if (silinecekDikdortgen != null) {
                   Silinecekdikdortgenler.add(silinecekDikdortgen);
                   
                    
                    }
                 if (silinecekOval != null) {
                   SilinecekOvaller.add(silinecekOval);
                
                     
                    }

              
               }
             }  
      
				
	
            
	  
            
	  
     
                
        
        @Override
        public void mouseReleased(MouseEvent e) {
            if (dikdortgen) {
                if (DikdortgenCizim) {
                       int x = Math.min(startx, endx);
                    int y = Math.min(starty, endy);
                    int w = Math.abs(startx-endx);
                    int h = Math.abs(starty-endy);
                Graphics g = getGraphics();
                endx = e.getX();
                endy = e.getY();
              Dikdortgen d = new Dikdortgen(x, y, w, h, colorS(),System.currentTimeMillis());
                dikdortgenler.add(d);
                OvalcizimBasladiMi=false;
                DikdortgenCizim=false;
                within_box=false;
                    repaint();
                }
       
                
            }    
            else if (oval) {
                if (OvalcizimBasladiMi) {
                      int x = Math.min(startx, endx);
                    int y = Math.min(starty, endy);
                    int w = Math.abs(startx-endx);
                    int h = Math.abs(starty-endy);
           
            Graphics g = getGraphics();
                endx = e.getX();
                endy = e.getY();
               Oval o = new Oval(x, y, w, h, colorS(),System.currentTimeMillis());
                ovaller.add(o);
                OvalcizimBasladiMi=false;
                    DikdortgenCizim=false;
                    within_box=false;
                    repaint();
                }  
            }
            else if (tasi) {
                if (Omu) {
                    Graphics g = getGraphics();
                        yeniA = e.getX();
			yeniB = e.getY();
                         Oval d = new Oval(yeniA, yeniB, yeniW, yeniH, yeniC,System.currentTimeMillis());
                        
                         ovaller.add(d);
                within_box=false;
                 Dmi=false;
                     Omu=false;
                repaint();
                    
                }
                else if (Dmi) {
                    Graphics g = getGraphics();
                        yeniA = e.getX();
			yeniB = e.getY();
                         Dikdortgen d = new Dikdortgen(yeniA, yeniB, yeniW, yeniH, yeniC,System.currentTimeMillis());
                         
                         dikdortgenler.add(d);
                within_box=false;
                    Dmi=false;
                     Omu=false;
                repaint();
                    
                }
                    for(Dikdortgen d:Silinecekdikdortgenler){

                                TumSekiller.remove(d);
                            }
                                for(Oval o:SilinecekOvaller){

                            TumSekiller.remove(o);
                                }
                
                
            }
            
        }

        @Override
        public void mouseEntered(MouseEvent e) {}
        @Override
        public void mouseExited(MouseEvent e) {}

        @Override
        public void mouseDragged(MouseEvent e) {
             Graphics g = getGraphics();
               if (oval) {
                    
                endx = e.getX();
                endy = e.getY();
                repaint(); 
                OvalcizimBasladiMi=true;
                DikdortgenCizim=false;
                
            }
               else if (dikdortgen){
                endx = e.getX();
                endy = e.getY();
                repaint(); 
               OvalcizimBasladiMi=false;
               DikdortgenCizim=true;
               
               }
            else if (kalem) {
                g.setColor(colorS());
              
                int nx = e.getX();
                int ny = e.getY();
                kalemCiz k = new kalemCiz(nx, ny, old_x, old_y, colorS(),System.currentTimeMillis());
                kalemler.add(k);
                 g.drawLine(nx,ny,old_x,old_y);
                 old_x = nx;
                 old_y = ny;
                 kalemCiz ka = new kalemCiz(nx, ny, old_x, old_y, colorS(),System.currentTimeMillis());
                 kalemler.add(ka);
                
            }
            else if (tasi){
                    if(within_box) {
                       g=getGraphics();
			yeniA = e.getX();
			yeniB = e.getY();
			repaint();
                        
                        for(Dikdortgen d:Silinecekdikdortgenler){

                                TumSekiller.remove(d);
                            }
                                for(Oval o:SilinecekOvaller){

                            TumSekiller.remove(o);
                                }

		}
              
            
            }
               
       
        }

        @Override
        public void mouseMoved(MouseEvent e) {}
    }
   
}