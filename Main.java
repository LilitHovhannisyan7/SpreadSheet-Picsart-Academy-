import java.util.Scanner;
public class Main
{


    public static void main(String[] args)
    {
        System.out.println("Input row");
        Scanner rowSc = new Scanner(System.in);
        int row = rowSc.nextInt();
        System.out.println("Input column");
        Scanner columnSc = new Scanner(System.in);
        int column = columnSc.nextInt();
        SpreadSheet sh1 = new SpreadSheet(row, column);
        System.out.println("Input the elements");
        for(int i = 0; i < row; ++i)
        {
            for(int j = 0; j < column; ++j)
            {
                Scanner obSc = new Scanner(System.in);

                if (obSc.hasNextInt())
                {
                    int ob = obSc.nextInt();
                    sh1.setValueAt(i,j,ob);
                }
                else if (obSc.hasNextDouble())
                {
                    double ob = obSc.nextDouble();
                    sh1.setValueAt(i,j,ob);
                }

            }
        }


        //sh1.addColumn(1);
        //sh1.addRow(0);
        sh1.setValueAt(1, 1, 177.14);               //  1   2    3
        System.out.println(sh1.getValueAt(1, 1));        //  4 177.14  6
        sh1.setColorAt(0,2,Color.RED);
        System.out.println(sh1.getColorAt(0,2));
        System.out.println(sh1.getColumnSum(1));
        System.out.println(sh1.getRowSum(0));
        System.out.println(sh1.getAreaSum(0, 0, 1, 1));
        System.out.println(sh1.getColumnAverage(1));
        System.out.println(sh1.getRowAverage(0));
        System.out.println(sh1.getAreaAverage(0, 0, 1, 1));
        sh1.resetCellAt(0,0);
        sh1.reset();
    }
}