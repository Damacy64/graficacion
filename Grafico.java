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

public class Grafico extends JFrame
        implements ActionListener //PaolaNeri ClaseGraficacion 2020
{

    JMenuBar menu = new JMenuBar(); //crea una barra de menu
    JMenu menu1 = new JMenu("Entramado", true);//Submenu	
    JMenuItem it1 = new JMenuItem("Iniciar");
    JMenuItem it2 = new JMenuItem("Pausar");

    Lienzo lienzo = new Lienzo();
    Image icon;//Declara un objeto de imagen tipo icono
    int maxX, maxY;//Determina las coordenadas maximas del frame

    public static void main(String[] args) throws IOException {
        System.out.println("La practica entramado esta corriendo..");
        Grafico i = new Grafico();//se llama al constructor del frame
    }

    public Grafico() throws IOException//crear el constructor del frame
    {
        super("Entramado");//Asi se llama al constructor de una clase extendida
        maxX = 1250;
        maxY = 800;
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
    @Override
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
        g.clearRect(0, 0, maxX, maxY);
        g.setColor(Color.pink);
        int xP [] = {100,200,350,500,600,600,500,200,100,100};
        int yP [] = {50,150,50,150,50,300,400,400,300,50};
        g.fillPolygon(xP, yP, 10);
        int trianguloX [] = {300,400,350};
        int trianguloY [] = {400,400,450};
        g.setColor(Color.GREEN);
        g.fillPolygon(trianguloX, trianguloY, 3);
        g.drawLine(350,450,350,750);
        int hojaIzqX [] = {350,350,300,250,250,300,350};
        int hojaIzqY [] = {600,550,500,500,550,600,600};
        g.fillPolygon(hojaIzqX, hojaIzqY, 7);
        int hojaDerX [] = {350,400,500,500,450,350,350};
        int hojaDerY [] = {650,650,550,500,500,600,650};
        g.fillPolygon(hojaDerX, hojaDerY, 7);
        g.setColor(Color.BLACK);
        g.drawLine(250, 500, 350, 600);
        g.drawLine(350, 650, 500, 500);
        
    }

    //manejador de eventos de ventanas windows
    @Override
    public boolean handleEvent(Event e) {	//en caso de dar clic en el tache de la ventana 	
        //finaliza la aplicacion	
        if (e.id == Event.WINDOW_DESTROY) {
            System.exit(0);
        }
        return super.handleEvent(e);
    }
};

class Lienzo extends Canvas {

    public Graphics getGraphics(Graphics g) {
        return g;
    }
}

