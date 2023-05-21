
import java.util.Random;

public class Game {

    /**
     * @param score the score to set
     */
    public void setScore(double score) {
        this.score = score;
    }

    /**
     * @return the pic2
     */
    public int getPic2() {
        return pic2;
    }

    /**
     * @return the pic3
     */
    public int getPic3() {
        return pic3;
    }

    /**
     * @return the pic4
     */
    public int getPic4() {
        return pic4;
    }

    /**
     * @return the pic5
     */
    public int getPic5() {
        return pic5;
    }

    /**
     * @return the pic6
     */
    public int getPic6() {
        return pic6;
    }

    /**
     * @return the pic1
     */
    public int getPic1() {
        return pic1;
    }


    /**
     * @return the score
     */
    public double getScore() {
        return score;
    }
    
    private double score = 0;
    private Random rand = new Random();
    private int pic1 = 0;
    private int pic2 = 0;
    private int pic3 = 0;
    private int pic4 = 0;
    private int pic5 = 0;
    private int pic6 = 0;

    public int random1(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic1 = 1;
            return getPic1();
        }
        else if (pc){
            pic1 = 2;
            return getPic1();
        }
        else if (blank){
            pic1 = 3;
            return getPic1();
        }
        return getPic1();
    }
    public int random2(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic2 = 1;
            return getPic2();
        }
        else if (pc){
            pic2 = 2;
            return getPic2();
        }
        else if (blank){
            pic2 = 3;
            return getPic2();
        }
        return getPic2();
    }
    public int random3(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic3 = 1;
            return getPic3();
        }
        else if (pc){
            pic3 = 2;
            return getPic3();
        }
        else if (blank){
            pic3 = 3;
            return getPic3();
        }
        return getPic3();
    }
    public int random4(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic4 = 1;
            return getPic4();
        }
        else if (pc){
            pic4 = 2;
            return getPic4();
        }
        else if (blank){
            pic4 = 3;
            return getPic4();
        }
        return getPic4();
    }
    public int random5(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic5 = 1;
            return getPic5();
        }
        else if (pc){
            pic5 = 2;
            return getPic5();
        }
        else if (blank){
            pic5 = 3;
            return getPic5();
        }
        return getPic5();
    }
    public int random6(){
        int a = rand.nextInt(5);
        boolean bd = (a == 0|a == 1);
        boolean pc = (a == 2);
        boolean blank = (a==3|a==4);
        if (bd){
            pic6 = 1;
            return getPic6();
        }
        else if (pc){
            pic6 = 2;
            return getPic6();
        }
        else if (blank){
            pic6 = 3;
            return getPic6();
        }

        return getPic6();
    }
    public void bandit(int time){
        setScore(score + (10 * time));
    }
    
    public void princess(){
        setScore(score - 100);
    }
   

}
