package View;

import Models.Recipe;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by User on 4/25/2018.
 */
public class DisplayLog implements View {
    private JPanel foodPanel;
    private JPanel exercisePanel;
    private JPanel totalsPanel;
    private JPanel placeholder;
    private JPanel view;
    private String title = "Overview for ";
    private String date;
    private ArrayList<JButton> buttons = new ArrayList<>();


    public DisplayLog(String date){
        title+= date;
        this.date = date;
        view = new JPanel();
        view.setLayout(new GridLayout(1,2));


        totalsPanel = new JPanel();
        totalsPanel.setLayout(new GridLayout(1,3));

        foodPanel = new JPanel();
        foodPanel.setLayout(new GridLayout(0,1));

        exercisePanel = new JPanel();
        exercisePanel.setLayout(new GridLayout(0,1));


        placeholder = new JPanel();
        placeholder.setLayout(new GridLayout(3,1));



        view.add(placeholder);
    }

    private void createFoods(ArrayList<Object[]> foodEaten){
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1,4));

        header.add(new JLabel("Name"));
        header.add(new JLabel("Calories"));
        header.add(new JLabel("Servings"));
        header.add(new JLabel(""));

        foodPanel.add(header);

        addData(foodPanel,foodEaten,"f");
    }

    private void createExercises(ArrayList<Object[]> exercisesPerformed){
        JPanel header = new JPanel();
        header.setLayout(new GridLayout(1,4));

        header.add(new JLabel("Name"));
        header.add(new JLabel("Calories burned"));
        header.add(new JLabel("Duration"));
        header.add(new JLabel(""));

        exercisePanel.add(header);

        addData(exercisePanel,exercisesPerformed,"e");
    }


    private void createTotalsPanel(double[] data){
        JPanel intake = new JPanel();
        intake.add(new JLabel("Total Calorie Intake"));
        intake.add(new JLabel(data[0]+""));

        JPanel expenditure = new JPanel();
        expenditure.add(new JLabel("Total Calories Expended"));
        expenditure.add(new JLabel(data[1]+""));

        JPanel netTotal = new JPanel();
        netTotal.add(new JLabel("Net Calories"));
        netTotal.add(new JLabel(data[2]+""));

        totalsPanel.add(intake);
        totalsPanel.add(expenditure);
        totalsPanel.add(netTotal);
    }

    private void addData(JPanel panel,ArrayList<Object[]> data,String type){
        for(int i=0; i< data.size(); i++){
            Object[] aData = data.get(i);

            JPanel entry = new JPanel();
            entry.setLayout(new GridLayout(1,3));

            entry.add(new JLabel((String)aData[0]));
            entry.add(new JLabel((double)aData[1]+""));
            entry.add(new JLabel((double)aData[2]+""));

            JButton b = new JButton("Delete");
            b.setActionCommand("DeleteLog_"+type+"_"+ date +"_"+data.indexOf(aData));
            entry.add(b);
            buttons.add(b);

            panel.add(entry);
        }

    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public JPanel getView() {
        return view;
    }

    @Override
    public void registerListeners(ActionListener listener) {
        for(JButton button: buttons){
            button.addActionListener(listener);
        }
    }

    @Override
    public String[] getData() {
        return new String[0];
    }

    @Override
    public void setData(Object[] model) {
        ArrayList<Object[]> foodData = (ArrayList<Object[]>)model[0];
        ArrayList<Object[]> exerciseData = (ArrayList<Object[]>)model[1];
        double[] totals = (double[])model[2];
        String labels[] = new String[]{"Fat","Carbs","Protein"};
        double values[] = (double[])model[3];
        createFoods(foodData);
        createExercises(exerciseData);
        createTotalsPanel(totals);

        placeholder.add(totalsPanel);
        JScrollPane foodScroll = new JScrollPane(foodPanel);
        JScrollPane exerciseScroll = new JScrollPane(exercisePanel);

        foodScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        foodScroll.setSize(600,400);

        exerciseScroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        exerciseScroll.setSize(600,400);

        placeholder.add(foodScroll);
        placeholder.add(exerciseScroll);
        view.add(new BarChart(labels,values));
    }


    public class BarChart extends JPanel {

        int xLeft,xRight,yTop,yBottom;
        private String[] descendingLabels;
        private double[] descendingValues;
        private double stepPercentage;

        private int xOffset = 40;
        private int yOffset = 10;

        int labelHeight = 20;
        int labelGap = 40;

        int size = 3 * labelHeight + 4 * labelGap;


        public BarChart(String[] labels, double[] values){


            setGraphStartPoints();
            descendingLabels = new String[labels.length];
            descendingValues = new double[labels.length];

            sortLabelsByValue(labels, values);
            stepPercentage = setPercentage();
            this.setSize(xRight + 15,yBottom + 15);
        }



        private void draw(Graphics g){
            drawAxes(g);
            drawLabels(g);
            drawValues(g);
            drawBars(g);

        }

        @Override
        public void paint(Graphics g){
            draw(g);
        }

        private void setGraphStartPoints(){
            int startX = this.getX();
            int startY = this.getY();

            xLeft = startX + xOffset;
            xRight = xLeft + size;

            yTop = startY + yOffset;
            yBottom = yTop + size;

            this.setSize(xRight + xOffset,yBottom + yOffset);
        }

        private void drawAxes(Graphics g){
            g.drawLine(xLeft,yBottom,xRight,yBottom);        //x axis
            g.drawLine(xLeft,yTop,xLeft,yBottom);            //y axis
        }

        private void sortLabelsByValue(String labels[], double[] values){
            for(int i=values.length-1; i > 0; i--){
                if(i > 0){
                    if(values[i] > values[i-1]){
                        double lesser = values[i-1];
                        values[i-1] = values[i];
                        values[i] = lesser;

                        String loser = labels[i-1];
                        labels[i-1] = labels[i];
                        labels[i] = loser;
                    }
                }
            }

            descendingValues = values;
            descendingLabels = labels;
        }

        private double setPercentage(){

            return (xRight-xLeft)/descendingValues[0];
        }

        private void drawLabels(Graphics g){
            int current = 15;
            for(String label: descendingLabels){
                g.drawString(label,1,current + labelGap);
                current += labelHeight + labelGap;
            }
        }

        private void drawValues(Graphics g){
            for(int i = descendingValues.length-1; i >-1; i-- ){
                int xLoc = (int)(descendingValues[i] * stepPercentage);
                g.drawString(descendingValues[i]+"",xOffset + xLoc,yBottom + 15);
            }
        }

        private void drawBars(Graphics g){
            int currentPos = labelGap;
            for(int i=0; i< descendingLabels.length; i++){
                Color c = null;
                switch(descendingLabels[i]){
                    case "Fat": c = Color.RED;
                        break;

                    case "Carb": c = Color.GREEN;
                        break;

                    case "Protein": c = Color.BLUE;
                        break;
                }

                g.setColor(c);
                int length = (int)(descendingValues[i] * stepPercentage);
                g.drawRect(xOffset,currentPos,length,labelHeight);
                currentPos += labelGap+labelHeight;
            }
        }
    }

}
