/**
 * @program: JavaProgromming
 * @description: How to use college student class
 * @version: 0.1.0
 * @author: Shawn Yang
 * @create: 2021-09-20 01:52
 */

import acm.program.ConsoleProgram;

import java.beans.FeatureDescriptor;

public class Cdu extends ConsoleProgram {
    public void run() {
        setFont("Times new Roman-20");
        CollegeStudent stud = new CollegeStudent("Shawn young", 1001);
//        stud.setUnits(162.0);
//        println(stud.getName() + " has " + stud.getUnits() + " units");
//        println(stud.getName() + " can graduate:" + stud.hasEnoughUnits());
//        println(stud.getName() + " takes OOP");
//        stud.incrementUnits(5);
//        println(stud.getName() + " can graduate:" + stud.hasEnoughUnits());
//
//        if (stud.hasEnoughUnits()) {
//            println("congratulations! "+stud.toString());
//        }
        print(stud.toString());

        FreshMan fm1 = new FreshMan("zs", 1001);
        print(fm1.toString());
    }

}
