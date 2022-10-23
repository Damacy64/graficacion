package graficacion;

/**
 *
 * @author pzx64
 */
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.ImageIcon;
import java.lang.Math;

public class Bezier extends JFrame implements ActionListener {

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    LienzoB lienzo = new LienzoB();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Bezier i = new Bezier();//se llama al constructor del frame
    }

    public Bezier() throws IOException//crear el constructor del frame
    {
        super("Bezier");//Asi se llama al constructor de una clase extendida
        maxX = 1000;
        maxY = 500;
        setJMenuBar(menu);//Agrega la barra de menu al frame
        menu.add(menu1);//agrega los menus 1 y 3 a la barra de menu
        menu1.add(it1);// agrega items al menu 1 y 
        menu1.add(it2);//un submenu 2

        icon = new ImageIcon("mia.jpg").getImage();//crear un icono con el archivo de entrada 
        //organiza componentes en paneles
        JPanel p1 = new JPanel(new BorderLayout());
        p1.add(lienzo, BorderLayout.CENTER);
        getContentPane().add(p1);
        //declara los objetos que escuchara el manejador de eventos
        it1.addActionListener(this);
        it2.addActionListener(this);
        //mueve el frame a la posicion indicada y establece el tamaño
        setBounds(100, 100, maxX, maxY);
        setIconImage(icon);//Agrega icono a la barra de menu
        setVisible(true);//Hace visible al frame
    }

    //manejador de eventos
    public void actionPerformed(ActionEvent event) {
        Object object = event.getSource();
        //si se elige el menu 1-1
        if (object == it1) {
            dibuja(lienzo.getGraphics());
        }
        //si se elige el menu 1-2
        if (object == it2) {
        }
    }

    public void dibuja(Graphics g) {
        //g.clearRect(0,0,maxX,maxY);
        //Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));  
        int np = 10;
        Point p[] = new Point[np];
        p[0] = new Point(50, 400);
        p[1] = new Point(100, 350);
        p[2] = new Point(150, 310);
        p[3] = new Point(200, 250);
        p[4] = new Point(250, 100);
        p[5] = new Point(300, 50);
        p[6] = new Point(350, 200);
        p[7] = new Point(400, 250);
        p[8] = new Point(450, 310);
        p[9] = new Point(500, 350);

        Point bz[] = new Point[20];
        int cont = 0;
        g.setColor(Color.BLACK);
        for (int i = 0; i < np - 1; i++) {
            g.drawLine(p[i].x, p[i].y, p[i + 1].x, p[i + 1].y);
            int X = (int) ((p[i].x + p[i + 1].x) / 2);
            int Y = (int) ((p[i].y + p[i + 1].y) / 2);
            bz[cont++] = new Point(X, Y);
        }

        Point bz2[] = new Point[20];
        int cont2 = 0;
        g.setColor(Color.RED);
        for (int i = 0; i < cont - 1; i++) {
            g.drawLine(bz[i].x, bz[i].y, bz[i + 1].x, bz[i + 1].y);
            int X = (int) ((bz[i].x + bz[i + 1].x) / 2);
            int Y = (int) ((bz[i].y + bz[i + 1].y) / 2);
            bz2[cont2++] = new Point(X, Y);

        }
        
        Point bz3[] = new Point[20];
        int cont3 = 0;
        g.setColor(Color.CYAN);
        for(int i=0;i<cont2-1;i++){
            g.drawLine(bz2[i].x, bz2[i].y, bz2[i+1].x, bz2[i+1].y);
            int X = (int) ((bz2[i].x + bz2[i + 1].x) / 2);
            int Y = (int) ((bz2[i].y + bz2[i + 1].y) / 2);
            bz3[cont3++] = new Point(X, Y);
        }
        
        Point bz4[] = new Point[20];
        int cont4 = 0;
        g.setColor(Color.MAGENTA);
        for(int i=0;i<cont3-1;i++){
            g.drawLine(bz3[i].x, bz3[i].y, bz3[i+1].x, bz3[i+1].y);
            int X = (int) ((bz3[i].x + bz3[i + 1].x) / 2);
            int Y = (int) ((bz3[i].y + bz3[i + 1].y) / 2);
            bz4[cont4++] = new Point(X, Y);
        }
        
        Point bz5[] = new Point[20];
        int cont5 = 0;
        g.setColor(Color.ORANGE);
        for(int i=0;i<cont4-1;i++){
            g.drawLine(bz4[i].x, bz4[i].y, bz4[i+1].x, bz4[i+1].y);
            int X = (int) ((bz4[i].x + bz4[i + 1].x) / 2);
            int Y = (int) ((bz4[i].y + bz4[i + 1].y) / 2);
            bz5[cont5++] = new Point(X, Y);
        }
        
        g.setColor(Color.BLUE);
        for (int i = 0; i < cont5; i++) {
            g.drawLine(bz5[i].x, bz5[i].y, bz5[i + 1].x, bz5[i + 1].y);
        }
    }

    //manejador de eventos de ventanas windows
    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);
    }
};

class LienzoB extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}
