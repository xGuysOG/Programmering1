package application.model;

public class P1_3 {
    static double estimate = 1.0;
    static int iteration = 0;

    public static void main(String[] args) {
        while(Math.round(getEstimate() * 1e5) != Math.round(Math.PI * 1e5)){
            iterate();
        }
    }

    public static double getEstimate(){
        return 4 * estimate;
    }

    public static void iterate(){
        double ratio = 1.0/(iteration * 2 + 3);
        if(iteration % 2 == 0){
            estimate -= ratio;
        }else{
            estimate += ratio;
        }
        System.out.println(getEstimate());
        iteration++;
    }
}
