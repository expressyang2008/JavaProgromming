/**
 * @program: JavaProgromming
 * @description: 该程序在屏幕上画GFaces，用户可选择脸的正面|背面、尺寸、颜色
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-10-21 22:51
 */
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class InteractiveDrawFace extends GraphicsProgram {

    public void init() {
        add(new JButton("清除"), SOUTH);
        checkbox = new JCheckBox("正面");
        checkbox.setSelected(true);
        add(checkbox, SOUTH);

        initRadioButtons();
        initColorChooser();
        addMouseListeners();
        addActionListeners();
    }

    private void initRadioButtons() {
        ButtonGroup sizeBG = new ButtonGroup();

        smallRB = new JRadioButton("小号");
        medRB = new JRadioButton("中号");
        largeRB = new JRadioButton("大号");

        sizeBG.add(smallRB);
        sizeBG.add(medRB);
        sizeBG.add(largeRB);

        medRB.setSelected(true);

        add(smallRB, SOUTH);
        add(medRB, SOUTH);
        add(largeRB, SOUTH);
    }

    private void initColorChooser() {
        pickColor = new JComboBox();

        pickColor.addItem("黑色");
        pickColor.addItem("蓝色");
        pickColor.addItem("绿色");
        pickColor.addItem("红色");

        pickColor.setEditable(false);

        pickColor.setSelectedItem("黑色");

        add(new JLabel(" 颜色"), SOUTH);
        add(pickColor, SOUTH);
    }

    private double getDiamSize() {
        double size = 0;
        if (smallRB.isSelected()) {
            size = SMALL_DIAM;
        } else if (medRB.isSelected()) {
            size = MED_DIAM;
        } else if (largeRB.isSelected()) {
            size = LARGE_DIAM;
        }
        return size;
    }

    private Color getCurrentColor() {
        String name = (String) pickColor.getSelectedItem();

        if (name.equals("蓝色")) {
            return Color.BLUE;
        } else if (name.equals("绿色")) {
            return Color.GREEN;
        } else if (name.equals("红色")) {
            return Color.RED;
        } else return Color.BLACK;
    }

    public void mouseClicked(MouseEvent e) {
        GObject obj;
        double diam = getDiamSize();

        if (checkbox.isSelected()) {
            obj = new GFace(diam, diam);
        } else {
            obj = new GOval(diam, diam);
        }

        obj.setColor(getCurrentColor());

        add(obj, e.getX(), e.getY());
    }


    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("清除")) {
            removeAll();
        }
    }

    /* 实例常量*/
    private static final double SMALL_DIAM = 20;
    private static final double MED_DIAM = 40;
    private static final double LARGE_DIAM = 60;

    /* 实例变量*/
    private JCheckBox checkbox;
    private JRadioButton smallRB;
    private JRadioButton medRB;
    private JRadioButton largeRB;
    private JComboBox pickColor;
}


