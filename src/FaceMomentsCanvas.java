/**
 * @program: JavaProgromming
 * @description: This class represents the canvas on which the profiles in the social
 * network are displayed.  NOTE: This class does NOT need to update the
 * display when the window is resized.
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-11-26 17:45
 */
import acm.graphics.*;
import java.awt.*;
import java.util.*;
public class FaceMomentsCanvas extends GCanvas
        implements FaceMomentsConstants{
    /**
     * Constructor
     * This method takes care of any initialization needed for
     * the display
     */
    public FaceMomentsCanvas() {
        // You fill this in
    }


    /**
     * This method displays a message string near the bottom of the
     * canvas.  Every time this method is called, the previously
     * displayed message (if any) is replaced by the new message text
     * passed in.
     */
    public void showMessage(String msg) {
        // You fill this in
        message.setLabel(msg);
        message.setFont(MESSAGE_FONT);
        message.setLocation((this.getWidth() - message.getWidth()) / 2, this.getHeight() - BOTTOM_MESSAGE_MARGIN);
        add(message);
    }


    /**
     * This method displays the given profile on the canvas.  The
     * canvas is first cleared of all existing items (including
     * messages displayed near the bottom of the screen) and then the
     * given profile is displayed.  The profile display includes the
     * name of the user from the profile, the corresponding image
     * (or an indication that an image does not exist), the status of
     * the user, and a list of the user's friends in the social network.
     */
    public void displayProfile(FaceMomentsProfile profile) {
        // You fill this in
        removeAll();
        if (profile == null) {
            message.setLabel("用户资料被删除.");
            message.setFont(MESSAGE_FONT);
            message.setLocation((this.getWidth() - message.getWidth()) / 2, this.getHeight() - BOTTOM_MESSAGE_MARGIN);
            add(message);
        } else {

            // Print message.
            message.setLabel("显示 " + profile.getName());
            message.setFont(MESSAGE_FONT);
            message.setLocation((this.getWidth() - message.getWidth()) / 2, this.getHeight() - BOTTOM_MESSAGE_MARGIN);
            add(message);

            // Print name.
            GLabel name = new GLabel(profile.getName());
            name.setFont(PROFILE_NAME_FONT);
            name.setLocation(LEFT_MARGIN, TOP_MARGIN);
            add(name);

            // Print image.
            if (profile.getImage() == null) {
                printNoImage();
            } else {
                GImage image = profile.getImage();
                image.setLocation(LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN);
                image.setSize(IMAGE_WIDTH, IMAGE_HEIGHT);
                add(image);
            }

            // Print status.
            if (profile.getStatus() == null) {
                GLabel status = new GLabel("没有当前状态");
                status.setFont(PROFILE_STATUS_FONT);
                status.setLocation(LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN);
                add(status);
            } else {
                GLabel status = new GLabel(profile.getName() + " is " + profile.getStatus());
                status.setFont(PROFILE_STATUS_FONT);
                status.setLocation(LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT + STATUS_MARGIN);
                add(status);
            }

            // Print friends
            GLabel header = new GLabel("好友列表:");
            header.setFont(PROFILE_FRIEND_LABEL_FONT);
            header.setLocation(this.getWidth() / 2, IMAGE_MARGIN + TOP_MARGIN);
            add(header);
            Iterator<String> it = profile.getFriends();
            int i = 0; // For printing list of friends purpose.
            while (true) {
                if (it.hasNext() == false) {
                    break;
                }
                GLabel friend = new GLabel(it.next());
                friend.setFont(PROFILE_FRIEND_FONT);
                friend.setLocation(this.getWidth() / 2, IMAGE_MARGIN + TOP_MARGIN + header.getHeight() + i * friend.getHeight());
                add(friend);
                i++;
            }
        }

    }

    /* Method: printNoImage() */
    private void printNoImage() {
        GLine topLine = new GLine(LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN, LEFT_MARGIN + IMAGE_WIDTH, IMAGE_MARGIN + TOP_MARGIN);
        GLine rightLine = new GLine(LEFT_MARGIN + IMAGE_WIDTH, IMAGE_MARGIN + TOP_MARGIN, LEFT_MARGIN + IMAGE_WIDTH, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT);
        GLine bottomLine = new GLine(LEFT_MARGIN + IMAGE_WIDTH, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT, LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT);
        GLine leftLine = new GLine(LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT, LEFT_MARGIN, IMAGE_MARGIN + TOP_MARGIN);
        add(topLine);
        add(rightLine);
        add(bottomLine);
        add(leftLine);
        GLabel label = new GLabel("没有照片");
        label.setFont(PROFILE_IMAGE_FONT);
        label.setLocation(LEFT_MARGIN + (IMAGE_WIDTH - label.getWidth()) / 2, IMAGE_MARGIN + TOP_MARGIN + IMAGE_HEIGHT / 2);
        add(label);
    }

    /* Instance variables */
    private GLabel message = new GLabel("");
}
