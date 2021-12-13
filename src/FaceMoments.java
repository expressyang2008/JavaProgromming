/**
 * @program: JavaProgromming
 * @description: * When it is finished, this program will implement a basic social network   management system.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-26 17:41
 */
import acm.program.*;
import acm.graphics.*;
import acm.util.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.*;
public class FaceMoments  extends Program
        implements FaceMomentsConstants{
    /**
     * This method has the responsibility for initializing the
     * interactors in the application, and taking care of any other
     * initialization that needs to be performed.
     */
    public void init() {
        // You fill this in
        this.setSize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
        addFields();
        addActionListeners();
        add(canvas);
    }


    /**
     * This class is responsible for detecting when the buttons are
     * clicked or interactors are used, so you will have to add code
     * to respond to these actions.
     */
    public void actionPerformed(ActionEvent e) {
        // You fill this in as well as add any additional methods
        String cmd = e.getActionCommand();
        if (e.getSource() == statusText || cmd.equals("改变状态")) {
            changeStatus();
        }
        if (e.getSource() == pictureText || cmd.equals("改变照片")) {
            changePicture();
        }
        if (e.getSource() == friendText || cmd.equals("添加好友")) {
            addFriend();
        }
        if (cmd.equals("添加")) {
            addProfile();
        }
        if (cmd.equals("删除")) {
            deleteProfile();
        }
        if (cmd.equals("查找")) {
            lookupProfile();
        }
    }

    /* Method: addProfile() */
    private void addProfile() {
        String text = nameText.getText();
        if (text.length() != 0) {
            FaceMomentsProfile profile = new FaceMomentsProfile(text);
            if (myDatabase.containsProfile(text) == false) {
                myDatabase.addProfile(profile);
                currentProfile = profile;
                printCurrentProfile();
            } else {
                currentProfile = myDatabase.getProfile(text);
                printCurrentProfile();
                msg = "用户 " + text + " 已经存在.";
                canvas.showMessage(msg);
            }
        }
    }

    /* Method: deleteProfile() */
    private void deleteProfile() {
        String text = nameText.getText();
        if (text.length() != 0) {
            if (myDatabase.containsProfile(text) == true) {
                myDatabase.deleteProfile(text);
                updateFriendsList(text);
                currentProfile = null;
                printCurrentProfile();
            } else {
                currentProfile = null;
                printCurrentProfile();
                msg = "用户 " + text + " 不存在";
                canvas.showMessage(msg);
            }
        }
    }

    /* Method: updateFriendsList(String name) */
    /**
     * This method removes name from all associated friends lists.
     * @param name
     */
    private void updateFriendsList(String name) {
        Iterator<String> it = myDatabase.getDatabase().keySet().iterator();
        while (true) {
            if (it.hasNext() == false) {
                break;
            }
            FaceMomentsProfile profile = myDatabase.getProfile(it.next());
            Iterator<String> it2 = profile.getFriends();
            while (true) {
                if (it2.hasNext() == false) {
                    break;
                }
                String friend = it2.next();
                if (name.equals(friend)) {
                    //profile.removeFriend(name); // Can't remove this mapping now. It messes up the iterator.
                    break;
                }
            }
            profile.removeFriend(name);
        }
    }

    /* Method: lookupProfile() */
    private void lookupProfile() {
        String text = nameText.getText();
        if (text.length() != 0) {
            if (myDatabase.containsProfile(text) == true) {
                FaceMomentsProfile profile = myDatabase.getProfile(text);
                currentProfile = profile;
                printCurrentProfile();
            } else {
                currentProfile = null;
                printCurrentProfile();
                msg = "查找: 用户 " + text + " 不存在";
                canvas.showMessage(msg);
            }
        }
    }

    /* Method: changeStatus() */
    private void changeStatus() {
        String text = statusText.getText();
        println(currentProfile);
        if (text.length() != 0) {
            if (currentProfile == null) {
                msg = "无当前用户. 请选择一个用户.";
                canvas.showMessage(msg);
            } else {
                currentProfile.setStatus(text);
                printCurrentProfile();
                msg = "状态更新 " + text;
                canvas.showMessage(msg);
            }
        }
    }

    /* Method: changePicture() */
    private void changePicture() {
        String text = pictureText.getText();
        if (text.length() != 0) {
            if (currentProfile == null) {
                msg = "没有当前用户. " + "请选择一个用户.";
                canvas.showMessage(msg);
            } else {
                GImage image;
                try {
                    image = new GImage(text);
                    currentProfile.setImage(image);
                    printCurrentProfile();
                    msg = "照片更新了";
                    canvas.showMessage(msg);
                } catch (ErrorException ex) {
                    msg = "输入正确的文件名.";
                    canvas.showMessage(msg);
                }
            }
        }
    }

    /* Method: addFriend() */
    private void addFriend() {
        String text = friendText.getText();
        if (text.length() != 0) {
            if (currentProfile == null) {
                msg = "用户不存在. " + "请选择一个用户.";
                canvas.showMessage(msg);
            } else if (text.equals(currentProfile.getName())) {
                msg = "你不能加自己做好友.";
                canvas.showMessage(msg);
            } else {
                if (myDatabase.containsProfile(text) == false) {// If the name is in the database.
                    msg = "用户没找到.";
                    canvas.showMessage(msg);
                } else {// Check if they are already friends.
                    Iterator<String> it = currentProfile.getFriends();
                    if (checkFriends(text, it)) {
                        msg = currentProfile.getName() + " 已经成为朋友 " + text + ".";
                        canvas.showMessage(msg);
                    } else {
                        currentProfile.addFriend(text);
                        myDatabase.getProfile(text).addFriend(currentProfile.getName());
                        printCurrentProfile();
                        msg = text + " 加为好友";
                        canvas.showMessage(msg);
                    }
                }
            }
        }
    }

    /* Method: printCurrentProfile() */
    private void printCurrentProfile() {
        canvas.displayProfile(currentProfile);
    }

    /* Method: checkFriends() */
    private boolean checkFriends(String text, Iterator<String> it) {
        while (true) {
            if (it.hasNext() == false) {
                return false;
            }
            String name = it.next();
            if (text.equals(name)) {
                return true;
            }
        }
    }

    /* Method: addNorthField() */
    /**
     * Add essential text fields and buttons in the north area and the west area.
     */
    private void addFields() {

        // North area.
        add(new JLabel("姓名"), NORTH);
        nameText = new JTextField(TEXT_FIELD_SIZE);
        add(nameText, NORTH);
        nameText.addActionListener(this);
        add(new JButton("添加"), NORTH);
        add(new JButton("删除"), NORTH);
        add(new JButton("查找"), NORTH);

        // South area
        statusText = new JTextField(TEXT_FIELD_SIZE);
        add(statusText, WEST);
        statusText.addActionListener(this);
        add(new JButton("改变状态"), WEST);
        add(new JLabel(EMPTY_LABEL_TEXT), WEST);
        pictureText = new JTextField(TEXT_FIELD_SIZE);
        add(pictureText, WEST);
        pictureText.addActionListener(this);
        add(new JButton("改变照片"), WEST);
        add(new JLabel(EMPTY_LABEL_TEXT), WEST);
        friendText = new JTextField(TEXT_FIELD_SIZE);
        add(friendText, WEST);
        friendText.addActionListener(this);
        add(new JButton("添加好友"), WEST);
        add(new JLabel(EMPTY_LABEL_TEXT), WEST);
    }

    /* Instance variables */
    private JTextField nameText, statusText, pictureText, friendText;
    private FaceMomentsDatabase myDatabase = new FaceMomentsDatabase();
    private FaceMomentsProfile currentProfile;
    private FaceMomentsCanvas canvas = new FaceMomentsCanvas();
    private String msg;
}
