package command;

import command.command.MacroCommand;
import command.drawer.DrawCanvas;
import command.drawer.DrawCommand;

import javax.swing.*;
import java.awt.event.*;

public class Main extends JFrame implements ActionListener, MouseMotionListener, WindowListener {

    //绘制的历史记录
    private MacroCommand history = new MacroCommand();
    //绘制区域
    private DrawCanvas canvas = new DrawCanvas(400,400,history);
    //删除按钮
    private JButton clearButton = new JButton("clear");

    public Main(String title){
        super(title);
        this.addWindowListener(this);
        canvas.addMouseMotionListener(this);
        clearButton.addActionListener(this);

        Box buttonBox = new Box(BoxLayout.X_AXIS);
        buttonBox.add(clearButton);
        Box mainBox = new Box(BoxLayout.Y_AXIS);
        mainBox.add(buttonBox);
        mainBox.add(canvas);
        pack();
        show();
    }

    //ActionListener
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clearButton){
            history.clear();
            canvas.repaint();
        }
    }

    //MouseMotionListener
    @Override
    public void mouseDragged(MouseEvent e) {
        DrawCommand cmd = new DrawCommand(canvas, e.getPoint());
        history.append(cmd);
        cmd.execute();
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //......
    }

    //WindowListener
    @Override
    public void windowOpened(WindowEvent e) {
        //.....
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }

    @Override
    public void windowClosed(WindowEvent e) {
        //.....
    }

    @Override
    public void windowIconified(WindowEvent e) {
        //.....
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        //.....
    }

    @Override
    public void windowActivated(WindowEvent e) {
        //.....
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        //.....
    }

    public static void main(String[] args) {
        new Main("Command Pattern Sample");
    }
}
