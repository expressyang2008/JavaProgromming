/**
 * @program: JavaProgromming
 * @description: The subClass of CollegeStudetn
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-20 09:58
 */
public class FreshMan extends CollegeStudent {
    public FreshMan(String name, int id) {
        super(name, id);
        setUnits(0);
    }

    public String toString() {
        return ("FreshMan:" + getName() + " ID:" + getID() + " score:" + getUnits());
    }
}
